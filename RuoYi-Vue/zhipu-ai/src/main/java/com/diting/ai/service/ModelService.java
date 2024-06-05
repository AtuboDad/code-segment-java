package com.diting.ai.service;

import com.diting.ai.domain.QuestionDomainQuery;
import com.zhipu.oapi.service.v4.model.ModelApiResponse;

public interface ModelService {

    ModelApiResponse reply(QuestionDomainQuery questionDomainQuery);

}
