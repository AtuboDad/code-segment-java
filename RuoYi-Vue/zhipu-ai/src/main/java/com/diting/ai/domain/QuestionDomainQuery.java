package com.diting.ai.domain;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class QuestionDomainQuery {

    private String question;

    @Getter
    private String requestId;

    @NotBlank(message = "参数名称不能为空")
    @Size(min = 0, max = 250, message = "问题长度不能超过250个字符")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "QuestionDomainQuery{" +
                "question='" + question + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
