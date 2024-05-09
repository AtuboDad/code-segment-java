package com.mundo.netty.demo.messagehandler.chat;

import com.mundo.netty.demo.dispatcher.MessageHandler;
import com.mundo.netty.demo.message.MessageTypeEnum;
import com.mundo.netty.demo.protobuf.MessageBase;
import com.mundo.netty.demo.server.NettyChannelManager;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ChatSendToOneHandler implements MessageHandler<MessageBase.Message> {

    @Autowired
    private NettyChannelManager nettyChannelManager;

    @Override
    public void execute(Channel channel, MessageBase.Message message) {
        // 这里，假装直接成功
        MessageBase.Message sendResponse = MessageBase.Message.newBuilder()
                .setCmd(MessageBase.Message.CommandType.NORMAL)
                .setType(MessageTypeEnum.ChatSendResponse.TYPE)
                .setContent("登陆成功")
                .setRequestId(UUID.randomUUID().toString()).build();
        channel.writeAndFlush(sendResponse);

        nettyChannelManager.addUser(channel, "1");
        // 创建转发的消息，发送给指定用户
        if (null == message.getToUser()) {
            log.error("消息发送对象为空");
        } else {
            MessageBase.Message sendToUserRequest = MessageBase.Message.newBuilder()
                    .setCmd(MessageBase.Message.CommandType.NORMAL)
                    .setType(MessageTypeEnum.ChatRedirectToUserRequest.TYPE)
                    .setContent(message.getContent())
                    .setRequestId(UUID.randomUUID().toString()).build();
            nettyChannelManager.send(message.getToUser(), sendToUserRequest);
        }

    }

    @Override
    public String getType() {
        return MessageTypeEnum.ChatSendToOneRequest.TYPE;
    }

}
