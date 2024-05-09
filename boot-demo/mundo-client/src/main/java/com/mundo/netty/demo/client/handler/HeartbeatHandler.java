package com.mundo.netty.demo.client.handler;

import com.mundo.netty.demo.client.NettyClient;
import com.mundo.netty.demo.message.MessageTypeEnum;
import com.mundo.netty.demo.protobuf.MessageBase;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@ChannelHandler.Sharable
public class HeartbeatHandler extends ChannelInboundHandlerAdapter {

    @Autowired
    private NettyClient nettyClient;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 空闲时，向服务端发起一次心跳
        if (evt instanceof IdleStateEvent) {
            log.info("[HeartbeatHandler userEventTriggered][发起一次心跳]");
            MessageBase.Message message = MessageBase.Message.newBuilder()
                    .setCmd(MessageBase.Message.CommandType.NORMAL)
                    .setRequestId(UUID.randomUUID().toString())
                    .setType(MessageTypeEnum.HeartbeatRequest.TYPE)
                    .setContent("Heart beat message")
                    .build();

            ctx.writeAndFlush(message).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //如果运行过程中服务端挂了,执行重连机制
        EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(() -> nettyClient.reconnect(), 10L, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("捕获的异常：", cause);
        ctx.channel().close();
    }
}
