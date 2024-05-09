package com.mundo.netty.demo.client.handler;

import com.mundo.netty.demo.dispatcher.MessageDispatcher;
import com.mundo.netty.demo.protobuf.MessageBase;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyClientHandlerInitializer extends ChannelInitializer<Channel> {

    /**
     * 心跳超时时间
     */
    private static final Integer READ_TIMEOUT_SECONDS = 100;

    @Autowired
    private MessageDispatcher messageDispatcher;

    @Override
    protected void initChannel(Channel ch) {
        ch.pipeline()
                // 空闲检测
                .addLast(new IdleStateHandler(0, READ_TIMEOUT_SECONDS, 0))
                .addLast(new CustomerReadTimeoutHandler(3 * READ_TIMEOUT_SECONDS))
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(MessageBase.Message.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                // 心跳
                .addLast(new HeartbeatHandler())
                // 消息分发器
                .addLast(messageDispatcher);
    }

}
