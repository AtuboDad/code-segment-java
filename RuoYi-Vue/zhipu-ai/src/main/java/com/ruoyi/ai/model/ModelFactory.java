package com.ruoyi.ai.model;

import com.ruoyi.ai.constants.ZhipuaiConstants;
import com.ruoyi.ai.model.entry.BaiduModel;
import com.ruoyi.ai.model.entry.Model;
import com.ruoyi.ai.model.entry.ZhipuModel;

public class ModelFactory {

    public Model getModel(String modelType) {
        if (modelType == null) {
            return null;
        }
        if (modelType.equalsIgnoreCase(ZhipuaiConstants.MODEL_TYPE_GLM4)) {
            return new ZhipuModel();
        }
        if (modelType.equalsIgnoreCase(ZhipuaiConstants.MODEL_TYPE_BAIDU)) {
            return new BaiduModel();
        }
        return null;
    }


}
