package com.dsj.zhipuai.demo.net;

import com.alibaba.fastjson.JSON;
import com.dsj.zhipuai.demo.constants.ZhipuaiConstants;
import com.dsj.zhipuai.demo.data.DataSerialization;
import com.dsj.zhipuai.demo.mock.MockData;
import com.dsj.zhipuai.demo.models.ResultChoice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhipu.oapi.ClientV4;
import com.zhipu.oapi.Constants;
import com.zhipu.oapi.service.v4.model.*;
import io.reactivex.Flowable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZhiPuAiAdapter {

    private List<ChatMessage> messages;

    private List<ChatTool> chatToolList;

    private String requestId;

    private static ClientV4 client;

    private static final ObjectMapper mapper = DataSerialization.defaultObjectMapper();

    static {
        synchronized (ZhiPuAiAdapter.class) {
            if (client == null) {
                client = new ClientV4.Builder(ZhipuaiConstants.API_SECRET_KEY).build();
            }
        }
    }

    public ZhiPuAiAdapter(List<ChatMessage> messages, List<ChatTool> chatToolList) {
        this.messages = messages;
        this.chatToolList = chatToolList;
    }

    public ChatCompletionRequest buildRequest(List<ChatMessage> messages, List<ChatTool> chatToolList) {
        this.messages = messages;
        this.chatToolList = chatToolList;
        return this.buildRequest();
    }
    public ChatCompletionRequest buildRequest() {

        // 生成请求ID
        String requestId = String.format(ZhipuaiConstants.REQUEST_ID_TEMPLATE, System.currentTimeMillis());

        return ChatCompletionRequest.builder()
                .model(Constants.ModelChatGLM4)
                .stream(Boolean.TRUE)
                .messages(messages)
                .requestId(requestId)
                .tools(chatToolList)
                .toolChoice("auto")
                .build();
    }

    public ModelApiResponse invokeModelApi(ChatCompletionRequest request) {
        this.requestId = request.getRequestId();
        return client.invokeModelApi(request);
    }

    public ResultChoice createResultChoice(ModelApiResponse sseModelApiResp, List<ChatMessage> messages) {

        StringBuilder recommendResp = new StringBuilder();
        ChatMessageAccumulator chatMessageAccumulator = mapStreamToAccumulator(sseModelApiResp.getFlowable())
                .doOnNext(accumulator -> {
                    {
                        if (accumulator.getDelta() != null && accumulator.getDelta().getTool_calls() != null) {
                            String jsonString = mapper.writeValueAsString(accumulator.getDelta().getTool_calls());
                            List<HashMap> hashMaps = JSON.parseArray(jsonString, HashMap.class);
                            HashMap resultItem = JSON.parseObject(hashMaps.get(0).get("function").toString(), HashMap.class);

                            if (resultItem.get("name").toString().equalsIgnoreCase("get_flight_number")) {
                                HashMap<String, String> resultContent = JSON.parseObject(resultItem.get("arguments").toString(), HashMap.class);
                                Map<String, String> flightNumber = MockData.getFlightNumber(resultContent.get("departure"), resultContent.get("destination"));

                                ChatMessage toolMessage = new ChatMessage("tool", JSON.toJSONString(flightNumber), null, hashMaps.get(0).get("id").toString());
                                messages.add(toolMessage);
                            }
                        }
                        if (accumulator.getDelta() != null && accumulator.getDelta().getContent() != null) {
                            recommendResp.append(accumulator.getDelta().getContent());
                        }
                    }
                })
                .doOnComplete(System.out::println)
                .lastElement()
                .blockingGet();

        Choice choiceParent = new Choice(chatMessageAccumulator.getChoice().getFinishReason(), 0L, chatMessageAccumulator.getDelta());
        List<Choice> choicesP = new ArrayList<>();
        choicesP.add(choiceParent);
        ModelData data = new ModelData();
        data.setChoices(choicesP);
        data.setUsage(chatMessageAccumulator.getUsage());
        data.setId(chatMessageAccumulator.getId());
        data.setCreated(chatMessageAccumulator.getCreated());
        data.setRequestId(this.requestId);

        return new ResultChoice(messages, recommendResp.toString(), data);
    }

    public static Flowable<ChatMessageAccumulator> mapStreamToAccumulator(Flowable<ModelData> flowable) {
        return flowable.map(chunk -> {
            return new ChatMessageAccumulator(chunk.getChoices().get(0).getDelta(), null, chunk.getChoices().get(0), chunk.getUsage(), chunk.getCreated(), chunk.getId());
        });
    }

}
