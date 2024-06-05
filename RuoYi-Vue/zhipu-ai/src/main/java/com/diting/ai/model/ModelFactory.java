package com.diting.ai.model;

import com.diting.ai.constants.ZhipuaiConstants;
import com.diting.ai.model.entry.BaiduModel;
import com.diting.ai.model.entry.Model;
import com.diting.ai.model.entry.ZhipuModel;

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
