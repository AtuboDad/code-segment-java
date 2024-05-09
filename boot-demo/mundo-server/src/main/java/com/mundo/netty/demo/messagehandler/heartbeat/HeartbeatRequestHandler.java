package com.mundo.netty.demo.messagehandler.heartbeat;

import com.mundo.netty.demo.dispatcher.MessageHandler;
import com.mundo.netty.demo.message.MessageTypeEnum;
import com.mundo.netty.demo.protobuf.MessageBase;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HeartbeatRequestHandler implements MessageHandler<MessageBase.Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Channel channel, MessageBase.Message message) {
        logger.info("[execute][收到连接({}) 的心跳请求]", channel.id());
        // 响应心跳
        MessageBase.Message msg = MessageBase.Message.newBuilder()
                .setCmd(MessageBase.Message.CommandType.NORMAL)
                .setRequestId(UUID.randomUUID().toString())
                .setType(MessageTypeEnum.HeartbeatResponse.TYPE)
                .setContent("Heartbeat response").build();

        channel.writeAndFlush(msg);
    }

    @Override
    public String getType() {
        return MessageTypeEnum.HeartbeatRequest.TYPE;
    }

}
