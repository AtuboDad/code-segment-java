package com.mundo.netty.demo.handler;

import cn.hutool.json.JSONUtil;
import com.mundo.netty.demo.models.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getMethod() != null;
        // 只拦截返回结果为 Result 类型
//        return returnType.getMethod().getReturnType() == Result.class;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            return body;
        }
        if (body instanceof String) {
            return JSONUtil.toJsonStr(Result.success(body));
        }
        return Result.success(body);
    }
}
