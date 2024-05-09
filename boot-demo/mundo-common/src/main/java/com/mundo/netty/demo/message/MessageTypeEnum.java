package com.mundo.netty.demo.message;

public enum MessageTypeEnum {

    AuthRequest("AUTH_REQUEST"),
    AuthResponse("AUTH_RESPONSE"),
    ChatRedirectToUserRequest("CHAT_REDIRECT_TO_USER_REQUEST"),
    ChatSendResponse("CHAT_SEND_RESPONSE"),
    ChatSendToAllRequest("CHAT_SEND_TO_ALL_REQUEST"),
    ChatSendToOneRequest("CHAT_SEND_TO_ONE_REQUEST"),
    HeartbeatRequest("HEARTBEAT_REQUEST"),
    HeartbeatResponse("HEARTBEAT_RESPONSE"),

    ;

    public String TYPE;

    MessageTypeEnum(String type) {
        this.TYPE = type;
    }

    public String getType() {
        return TYPE;
    }
}
