package com.mundo.netty.demo.controller;

import cn.hutool.core.text.CharSequenceUtil;
import com.mundo.netty.demo.annotation.AutoIdempotent;
import com.mundo.netty.demo.client.NettyClient;
import com.mundo.netty.demo.constants.Constants;
import com.mundo.netty.demo.enums.ResultEnum;
import com.mundo.netty.demo.message.MessageTypeEnum;
import com.mundo.netty.demo.models.Result;
import com.mundo.netty.demo.protobuf.MessageBase;
import com.mundo.netty.demo.services.RedisService;
import com.mundo.netty.demo.services.TestService;
import com.mundo.netty.demo.services.TokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private NettyClient nettyClient;

    @Resource
    private TokenService tokenService;
    @Resource
    private TestService testService;

    @Resource
    private RedisService redisService;

    @GetMapping("/mock")
    public String mock(String type, String message) {

        MessageBase.Message msg = MessageBase.Message.newBuilder()
                .setCmd(MessageBase.Message.CommandType.NORMAL)
                .setType(MessageTypeEnum.ChatSendToOneRequest.TYPE)
                .setContent(message)
                .setRequestId(UUID.randomUUID().toString())
                .setToUser("1").build();
        // 发送消息
        nettyClient.send(msg);
        return "success";
    }

    @GetMapping("/token")
    public Result redis(String type, String message) {
        String token = tokenService.createToken();
        if (CharSequenceUtil.isNotEmpty(token)) {
            return new Result(ResultEnum.SUCCESS.getCode(), Constants.SUCCESS, token);
        }
        return Result.success();

    }

    @AutoIdempotent
    @PostMapping("/idempotence")
    public Result testIdempotence() {
        String businessResult = testService.testIdempotence();
        if (CharSequenceUtil.isNotEmpty(businessResult)) {
            return Result.success(businessResult);
        }
        return Result.success();
    }

}
