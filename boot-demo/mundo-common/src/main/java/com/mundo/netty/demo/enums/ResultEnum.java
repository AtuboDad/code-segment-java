package com.mundo.netty.demo.enums;

import lombok.Getter;

@Getter
//常用结果的枚举
public enum ResultEnum implements IResult {

    SUCCESS(1000, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),  
    COMMON_FAILED(2003, "接口调用失败"),  
    FORBIDDEN(2004, "没有权限访问资源");  
  
    private Integer code;  
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


}