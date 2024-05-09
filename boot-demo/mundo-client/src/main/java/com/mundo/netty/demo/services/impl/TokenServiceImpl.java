package com.mundo.netty.demo.services.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.mundo.netty.demo.constants.Constants;
import com.mundo.netty.demo.constants.RedisConstants;
import com.mundo.netty.demo.enums.ResultEnum;
import com.mundo.netty.demo.exceptions.BaseException;
import com.mundo.netty.demo.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String createToken() {

        String randomValue = String.valueOf(RandomUtil.randomInt(10000, 99999));
        String tokenKey = RedisConstants.TOKEN_PREFIX + "1";
        Boolean locked = stringRedisTemplate.opsForValue().setIfAbsent(tokenKey, randomValue, 20, TimeUnit.MINUTES);
        if (null != locked && locked) {
            return randomValue;
        }
        return null;
    }

    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(Constants.TOKEN_NAME);
        if (StrUtil.isBlank(token)) {// header中不存在token
            token = request.getParameter(Constants.TOKEN_NAME);
            if (StrUtil.isBlank(token)) {// parameter中也不存在token
                throw new BaseException(ResultEnum.VALIDATE_FAILED.getCode(), ResultEnum.VALIDATE_FAILED.getMessage());
            }
        }

        String tokenKey = stringRedisTemplate.opsForValue().get(Constants.TOKEN_NAME);
        if (null == tokenKey) {
            throw new BaseException(ResultEnum.VALIDATE_FAILED.getCode(), ResultEnum.VALIDATE_FAILED.getMessage());
        }

        Boolean delete = stringRedisTemplate.delete(Constants.TOKEN_NAME);
        if (null == delete || !delete) {
            throw new BaseException(ResultEnum.VALIDATE_FAILED.getCode(), ResultEnum.VALIDATE_FAILED.getMessage());
        }
        return true;
    }

}
