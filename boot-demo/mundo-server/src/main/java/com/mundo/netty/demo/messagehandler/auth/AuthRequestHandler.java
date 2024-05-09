package com.mundo.netty.demo.messagehandler.auth;

import com.mundo.netty.demo.dispatcher.MessageHandler;
import com.mundo.netty.demo.message.MessageTypeEnum;
import com.mundo.netty.demo.protobuf.MessageBase;
import com.mundo.netty.demo.server.NettyChannelManager;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Component
public class AuthRequestHandler implements MessageHandler<MessageBase.Message> {

    @Autowired
    private NettyChannelManager nettyChannelManager;

    @Override
    public void execute(Channel channel, MessageBase.Message authRequest) {
        // 如果未传递 accessToken
        if (StringUtils.isEmpty(authRequest.getToUser())) {
            MessageBase.Message msg = MessageBase.Message.newBuilder()
                    .setCmd(MessageBase.Message.CommandType.NORMAL)
                    .setType(MessageTypeEnum.AuthResponse.TYPE)
                    .setContent("认证 accessToken 未传入")
                    .setRequestId(UUID.randomUUID().toString()).build();
            channel.writeAndFlush(msg);
            return;
        }

        // ... 此处应有一段

        // 将用户和 Channel 绑定
        // 考虑到代码简化，我们先直接使用 accessToken 作为 User
        nettyChannelManager.addUser(channel, authRequest.getToUser());

        // 响应认证成功
        MessageBase.Message msg = MessageBase.Message.newBuilder()
                .setCmd(MessageBase.Message.CommandType.NORMAL)
                .setRequestId(UUID.randomUUID().toString())
                .setType(MessageTypeEnum.AuthResponse.TYPE)
                .setContent("0").build();

        channel.writeAndFlush(msg);
    }

    @Override
    public String getType() {
        return MessageTypeEnum.AuthRequest.TYPE;
    }

}
