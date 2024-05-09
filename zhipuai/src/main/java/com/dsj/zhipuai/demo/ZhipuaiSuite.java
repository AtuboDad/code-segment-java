package com.dsj.zhipuai.demo;

import com.alibaba.fastjson.JSON;
import com.dsj.zhipuai.demo.data.DataSerialization;
import com.dsj.zhipuai.demo.mock.MockData;
import com.dsj.zhipuai.demo.net.ZhiPuAiAdapter;
import com.dsj.zhipuai.demo.util.DataUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhipu.oapi.service.v4.model.*;
import io.reactivex.Flowable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ZhipuaiSuite {

    private static final ObjectMapper mapper = DataSerialization.defaultObjectMapper();

    public static void main(String[] args) {

        List<ChatMessage> messages = new ArrayList<>();
//        ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "不要假设或猜测传入函数的参数值。如果用户的描述不明确，请要求用户提供必要信息");
//        messages.add(systemMessage);
        ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), "帮我查询4月25日，北京到广州的航班");
        messages.add(userMessage);

        List<ChatTool> chatToolList = new ArrayList<>();

        ChatTool chatToolFlightNumber = DataUtil.createGetFlightNumber("", "");
        ChatTool chatToolTicketPrice = DataUtil.createGetTicketPrice("", "");
        chatToolList.add(chatToolFlightNumber);
        chatToolList.add(chatToolTicketPrice);

        // 创建智谱AI请求对象
        ZhiPuAiAdapter zhiPuAiAdapter = new ZhiPuAiAdapter(messages, chatToolList);
        ChatCompletionRequest chatCompletionRequest = zhiPuAiAdapter.buildRequest();
        ModelApiResponse sseModelApiResp = zhiPuAiAdapter.invokeModelApi(chatCompletionRequest);
        System.out.println("model output:" + JSON.toJSONString(sseModelApiResp));

        if (sseModelApiResp.isSuccess()) {
            AtomicBoolean isFirst = new AtomicBoolean(true);
            ChatMessageAccumulator chatMessageAccumulator = mapStreamToAccumulator(sseModelApiResp.getFlowable())
                    .doOnNext(accumulator -> {
                        {
                            if (isFirst.getAndSet(false)) {
                                System.out.print("Response: ");
                            }
                            if (accumulator.getDelta() != null && accumulator.getDelta().getTool_calls() != null) {
                                String jsonString = mapper.writeValueAsString(accumulator.getDelta().getTool_calls());
                                System.out.println("tool_calls: " + jsonString);
                                List<HashMap> hashMaps = JSON.parseArray(jsonString, HashMap.class);
                                HashMap resultItem = JSON.parseObject(hashMaps.get(0).get("function").toString(), HashMap.class);
                                System.out.println(resultItem);

                                if (resultItem.get("name").toString().equalsIgnoreCase("get_flight_number")) {
                                    HashMap<String, String> resultContent = JSON.parseObject(resultItem.get("arguments").toString(), HashMap.class);
                                    Map<String, String> flightNumber = MockData.getFlightNumber(resultContent.get("departure"), resultContent.get("destination"));

                                    ChatMessage toolMessage = new ChatMessage("tool", JSON.toJSONString(flightNumber), null, hashMaps.get(0).get("id").toString());
                                    messages.add(toolMessage);
                                }
                            }
                            if (accumulator.getDelta() != null && accumulator.getDelta().getContent() != null) {
                                System.out.print(accumulator.getDelta().getContent());
                            }
                        }
                    })
                    .doOnComplete(System.out::println)
                    .lastElement()
                    .blockingGet();


            ChatCompletionRequest chatChoiceRequest = zhiPuAiAdapter.buildRequest(messages, chatToolList);
            ModelApiResponse choicesResp = zhiPuAiAdapter.invokeModelApi(chatChoiceRequest);
            System.out.println("model output choice:" + JSON.toJSONString(choicesResp));

            ChatMessageAccumulator choiceAccumulator = mapStreamToAccumulator(choicesResp.getFlowable())
                    .doOnNext(accumulator -> {
                        {
                            if (isFirst.getAndSet(false)) {
                                System.out.print("Choice response: ");
                            }
                            if (accumulator.getDelta() != null && accumulator.getDelta().getTool_calls() != null) {
                                String jsonString = mapper.writeValueAsString(accumulator.getDelta().getTool_calls());
                                System.out.println("Choice tool_calls: " + jsonString);
                            }
                            if (accumulator.getDelta() != null && accumulator.getDelta().getContent() != null) {
                                System.out.print(accumulator.getDelta().getContent());
                            }
                        }
                    })
                    .doOnComplete(System.out::println)
                    .lastElement()
                    .blockingGet();

            Choice choice = new Choice(choiceAccumulator.getChoice().getFinishReason(), 0L, choiceAccumulator.getDelta());
            List<Choice> choices = new ArrayList<>();
            choices.add(choice);
            ModelData data = new ModelData();
            data.setChoices(choices);
            data.setUsage(choiceAccumulator.getUsage());
            data.setId(choiceAccumulator.getId());
            data.setCreated(choiceAccumulator.getCreated());
            data.setRequestId(chatChoiceRequest.getRequestId());
            choicesResp.setFlowable(null);
            choicesResp.setData(data);
            System.out.println("model output:" + JSON.toJSONString(choicesResp));

            Choice choiceParent = new Choice(chatMessageAccumulator.getChoice().getFinishReason(), 0L, chatMessageAccumulator.getDelta());
            List<Choice> choicesP = new ArrayList<>();
            choicesP.add(choiceParent);
            ModelData dataP = new ModelData();
            dataP.setChoices(choicesP);
            dataP.setUsage(chatMessageAccumulator.getUsage());
            dataP.setId(chatMessageAccumulator.getId());
            dataP.setCreated(chatMessageAccumulator.getCreated());
            dataP.setRequestId(chatCompletionRequest.getRequestId());
            sseModelApiResp.setFlowable(null);
            sseModelApiResp.setData(data);
        }

    }


    public static Flowable<ChatMessageAccumulator> mapStreamToAccumulator(Flowable<ModelData> flowable) {
        return flowable.map(chunk -> {
            return new ChatMessageAccumulator(chunk.getChoices().get(0).getDelta(), null, chunk.getChoices().get(0), chunk.getUsage(), chunk.getCreated(), chunk.getId());
        });
    }

}
