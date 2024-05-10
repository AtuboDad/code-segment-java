package com.ruoyi.ai.service;

import com.ruoyi.ai.constants.ZhipuaiConstants;
import com.ruoyi.ai.domain.QuestionDomainQuery;
import com.ruoyi.ai.model.ModelFactory;
import com.ruoyi.ai.model.entry.Model;
import com.zhipu.oapi.service.v4.model.ModelApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    public ModelApiResponse reply(QuestionDomainQuery questionDomainQuery) {
        ModelFactory modelFactory = new ModelFactory();

        // TODO 后期需要改成数据库配置，从数据库中查询配置的模型平台
        Model model = modelFactory.getModel(ZhipuaiConstants.MODEL_TYPE_GLM4);
        return model.reply(questionDomainQuery.getQuestion(), questionDomainQuery.getRequestId());

    }

}
