package com.dsj.zhipuai.demo.models;

import com.zhipu.oapi.service.v4.model.ChatMessage;
import com.zhipu.oapi.service.v4.model.ModelData;
import lombok.Data;

import java.util.List;

@Data
public class ResultChoice {

    private List<ChatMessage> messages;

    private String recommendResp;

    private ModelData data;

    public ResultChoice (List<ChatMessage> messages, String recommendResp, ModelData data) {
        this.messages = messages;
        this.recommendResp = recommendResp;
        this.data = data;
    }

}
