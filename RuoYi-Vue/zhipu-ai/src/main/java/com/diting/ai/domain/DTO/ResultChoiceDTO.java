package com.diting.ai.domain.DTO;

import com.zhipu.oapi.service.v4.model.ChatMessage;
import com.zhipu.oapi.service.v4.model.ModelData;
import lombok.Data;

import java.util.List;

@Data
public class ResultChoiceDTO {

    private List<ChatMessage> messages;

    private String recommendResp;

    private String requestId;

    private ModelData data;

    public ResultChoiceDTO() {

    }

    public ResultChoiceDTO(List<ChatMessage> messages, String recommendResp, ModelData data) {
        this.messages = messages;
        this.recommendResp = recommendResp;
        this.data = data;
    }

}
