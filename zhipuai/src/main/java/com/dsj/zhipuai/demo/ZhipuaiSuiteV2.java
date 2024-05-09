package com.dsj.zhipuai.demo;

import com.alibaba.fastjson.JSON;
import com.dsj.zhipuai.demo.models.ResultChoice;
import com.dsj.zhipuai.demo.net.ZhiPuAiAdapter;
import com.dsj.zhipuai.demo.util.DataUtil;
import com.zhipu.oapi.service.v4.model.*;

import java.util.ArrayList;
import java.util.List;

public class ZhipuaiSuiteV2 {

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

        // 创建智谱AI请求封装对象
        ZhiPuAiAdapter zhiPuAiAdapter = new ZhiPuAiAdapter(messages, chatToolList);
        // 创建智谱AI请求对象
        ChatCompletionRequest chatCompletionRequest = zhiPuAiAdapter.buildRequest();
        // 开始调用
        ModelApiResponse sseModelApiResp = zhiPuAiAdapter.invokeModelApi(chatCompletionRequest);

        // 请求是否成功
        if (sseModelApiResp.isSuccess()) {

            // 根据结果创建返回选择信息
            ResultChoice resultChoice = zhiPuAiAdapter.createResultChoice(sseModelApiResp, messages);

            messages = resultChoice.getMessages();
            ModelData modelData = resultChoice.getData();
            sseModelApiResp.setData(modelData);

            // 整理message，重新查询
            ChatCompletionRequest chatChoiceRequest = zhiPuAiAdapter.buildRequest(messages, chatToolList);
            ModelApiResponse choicesResp = zhiPuAiAdapter.invokeModelApi(chatChoiceRequest);

            ResultChoice recommendChoice = zhiPuAiAdapter.createResultChoice(choicesResp, messages);
            choicesResp.setData(recommendChoice.getData());

            System.out.println(recommendChoice.getRecommendResp());
            System.out.println(111);
        }

    }




}
