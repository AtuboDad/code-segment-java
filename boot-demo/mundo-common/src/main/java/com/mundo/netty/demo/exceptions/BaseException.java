package com.mundo.netty.demo.exceptions;

import com.mundo.netty.demo.spring.SpringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException(String module, Integer code, Object[] args, String defaultMessage)
    {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String module, Integer code, Object[] args)
    {
        this(module, code, args, null);
    }

    public BaseException(Integer code, String defaultMessage)
    {
        this(null, code, null, defaultMessage);
    }

    public BaseException(Integer code, Object[] args)
    {
        this(null, code, args, null);
    }

    public BaseException(String defaultMessage)
    {
        this(null, null, null, defaultMessage);
    }

    @Override
    public String getMessage()
    {
        String message = null;
        if (null == code)
        {
            MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
            message = messageSource.getMessage(String.valueOf(code), args, LocaleContextHolder.getLocale());
        }
        if (message == null)
        {
            message = defaultMessage;
        }
        return message;
    }

    public String getModule()
    {
        return module;
    }

    public Integer getCode()
    {
        return code;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public String getDefaultMessage()
    {
        return defaultMessage;
    }

}
