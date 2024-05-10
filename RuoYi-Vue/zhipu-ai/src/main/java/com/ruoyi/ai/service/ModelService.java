package com.ruoyi.ai.service;

import com.ruoyi.ai.domain.QuestionDomainQuery;
import com.zhipu.oapi.service.v4.model.ModelApiResponse;

public interface ModelService {

    ModelApiResponse reply(QuestionDomainQuery questionDomainQuery);

}
