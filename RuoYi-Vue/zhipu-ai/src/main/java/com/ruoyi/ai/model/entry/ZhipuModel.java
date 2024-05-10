package com.ruoyi.ai.model.entry;

import com.ruoyi.ai.constants.ZhipuaiConstants;
import com.ruoyi.ai.data.DataSerialization;
import com.ruoyi.ai.service.ModelService;
import com.diting.common.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhipu.oapi.ClientV4;
import com.zhipu.oapi.Constants;
import com.zhipu.oapi.service.v4.model.*;

import java.util.ArrayList;
import java.util.List;

public class ZhipuModel implements Model{

    private List<ChatMessage> messages = new ArrayList<>();

    private List<ChatTool> chatToolList = new ArrayList<>();

    private String requestId;

    private static ClientV4 client;

    private static final ObjectMapper mapper = DataSerialization.defaultObjectMapper();

    static {
        synchronized (ModelService.class) {
            if (client == null) {
                client = new ClientV4.Builder(ZhipuaiConstants.API_SECRET_KEY).build();
            }
        }
    }
    @Override
    public ModelApiResponse reply(String message, String requestId) {
        ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), message);
        this.messages.add(userMessage);

        // 预先定义好的chat tool列表 TODO 还需完善列表
        //        ChatTool chatTool = DataUtil.createTool(ChatToolFunctions.TOOL_FUNCTION_BILL, new ZhiPuAiToolItem("bill", "账单"));
        //        ChatTool chatTool2 = DataUtil.createTool(ChatToolFunctions.TOOL_FUNCTION_CAL_LENGTH, new ZhiPuAiToolItem("bridge", "计算桥梁长度"));
        //        chatToolList.add(chatTool);
        //        chatToolList.add(chatTool2);

        if (StringUtils.isEmpty(requestId)) {
            // 生成请求ID
            requestId = String.format(ZhipuaiConstants.REQUEST_ID_TEMPLATE, System.currentTimeMillis());
        }
        return this.doRequest(requestId);
    }

    public ModelApiResponse doRequest(String requestId) {

        ChatCompletionRequest chatCompletionRequest = this.buildRequest(requestId);
        return this.invokeModelApi(chatCompletionRequest);

    }

    private ChatCompletionRequest buildRequest(String requestId) {

        // 是否有自定义函数列表
        if (null == chatToolList || chatToolList.isEmpty()) {
            return ChatCompletionRequest.builder()
                    .model(Constants.ModelChatGLM4)
                    .stream(Boolean.TRUE)
                    .messages(this.messages)
                    .requestId(requestId)
                    .topP(0.7F)
                    .temperature(0.95F)
                    .maxTokens(1024)
                    .stream(Boolean.TRUE)
                    .build();
        }
        return ChatCompletionRequest.builder()
                .model(Constants.ModelChatGLM4)
                .stream(Boolean.TRUE)
                .messages(this.messages)
                .requestId(requestId)
                .tools(this.chatToolList)
                .toolChoice(ZhipuaiConstants.TOOL_CHOICE_AUTO)
                .build();
    }

    public ModelApiResponse invokeModelApi(ChatCompletionRequest request) {
        this.requestId = request.getRequestId();
        return client.invokeModelApi(request);
    }

}
