package com.mundo.netty.demo.messagehandler.chat;

import com.mundo.netty.demo.dispatcher.MessageHandler;
import com.mundo.netty.demo.message.MessageTypeEnum;
import com.mundo.netty.demo.protobuf.MessageBase;
import com.mundo.netty.demo.server.NettyChannelManager;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ChatSendToAllHandler implements MessageHandler<MessageBase.Message> {

    @Autowired
    private NettyChannelManager nettyChannelManager;

    @Override
    public void execute(Channel channel, MessageBase.Message message) {
        // 这里，假装直接成功
        MessageBase.Message sendResponse = MessageBase.Message.newBuilder()
                .setCmd(MessageBase.Message.CommandType.NORMAL)
                .setRequestId(UUID.randomUUID().toString())
                .setType(MessageTypeEnum.ChatSendResponse.TYPE)
                .setContent("0")
                .setMsgId(message.getMsgId()).build();
        channel.writeAndFlush(sendResponse);

        // 创建转发的消息，并广播发送
        MessageBase.Message sendToUserRequest = MessageBase.Message.newBuilder()
                .setCmd(MessageBase.Message.CommandType.NORMAL)
                .setRequestId(UUID.randomUUID().toString())
                .setType(MessageTypeEnum.ChatRedirectToUserRequest.TYPE)
                .setContent(message.getContent())
                .setMsgId(message.getMsgId()).build();
        nettyChannelManager.sendAll(sendToUserRequest);
    }

    @Override
    public String getType() {
        return MessageTypeEnum.ChatSendToAllRequest.TYPE;
    }

}
