package com.mundo.netty.demo.messagehandler.heartbeat;

import com.mundo.netty.demo.dispatcher.MessageHandler;
import com.mundo.netty.demo.message.MessageTypeEnum;
import com.mundo.netty.demo.protobuf.MessageBase;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HeartbeatResponseHandler implements MessageHandler<MessageBase.Message> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Channel channel, MessageBase.Message message) {
        logger.info("[execute][收到连接({}) 的心跳响应]", channel.id());
    }

    @Override
    public String getType() {
        return MessageTypeEnum.HeartbeatResponse.TYPE;
    }

}
