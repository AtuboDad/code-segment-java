package com.mundo.netty.demo.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CustomerReadTimeoutHandler extends ReadTimeoutHandler {

    public CustomerReadTimeoutHandler(int timeoutSeconds) {
        super(timeoutSeconds);
    }

    public CustomerReadTimeoutHandler(long timeout, TimeUnit unit) {
        super(timeout, unit);
    }

    @Override
    protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
        log.error("等待服务端响应消息超时, {}", ctx.channel().id());
    }
}
