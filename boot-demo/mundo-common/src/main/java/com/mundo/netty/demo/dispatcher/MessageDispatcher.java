package com.mundo.netty.demo.dispatcher;

import com.mundo.netty.demo.protobuf.MessageBase;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@ChannelHandler.Sharable
public class MessageDispatcher extends SimpleChannelInboundHandler<MessageBase.Message> {

    @Autowired
    private MessageHandlerContainer messageHandlerContainer;

    private final ExecutorService executor =  Executors.newFixedThreadPool(200);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageBase.Message msg) {
        log.info(msg.toString());
        // 获得 type 对应的 MessageHandler 处理器
        MessageHandler messageHandler = messageHandlerContainer.getMessageHandler(msg.getType());
        // 执行逻辑
        executor.submit(new Runnable() {
            @Override
            public void run() {
                // noinspection unchecked
                messageHandler.execute(ctx.channel(), msg);
            }
        });
    }

}
