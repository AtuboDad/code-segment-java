package com.diting.ai.model.entry;

import com.zhipu.oapi.service.v4.model.ModelApiResponse;

public interface Model {

    ModelApiResponse reply(String message, String requestId);
}
