package com.ruoyi.ai.domain.VO;

import lombok.Getter;

@Getter
public class QuestionReplyVO {

    private String answer;

    private String requestId;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
