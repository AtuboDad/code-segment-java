package com.mundo.netty.demo.handler;

import com.mundo.netty.demo.enums.ResultEnum;
import com.mundo.netty.demo.exceptions.BusinessException;
import com.mundo.netty.demo.exceptions.ForbiddenException;
import com.mundo.netty.demo.models.Result;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//统一拦截异常
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 捕获 {@code BusinessException} 异常
     */
    @ExceptionHandler({BusinessException.class})
    public Result handleBusinessException(BusinessException ex) {
        return Result.error(ex.getMessage());
    }

    /**
     * 捕获 {@code ForbiddenException} 异常
     */
    @ExceptionHandler({ForbiddenException.class})
    public Result handleForbiddenException(ForbiddenException ex) {
        return Result.error(ResultEnum.FORBIDDEN.getMessage());
    }

    /**
     * {@code @RequestBody} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        if (StringUtils.hasText(msg)) {
            return Result.error(ResultEnum.VALIDATE_FAILED.getCode(), msg);
        }
        return Result.error(ResultEnum.VALIDATE_FAILED.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e, HttpServletRequest request)
    {
        return Result.error(e.getMessage());
    }

    /**
     * 顶级异常捕获并统一处理，当其他异常无法处理时候选择使用
     */
    @ExceptionHandler({Exception.class})
    public Result handleException(Exception ex) {
        return Result.error(ex.getMessage());
    }

}  