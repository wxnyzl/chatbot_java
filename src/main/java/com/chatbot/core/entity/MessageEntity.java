package com.chatbot.core.entity;

import java.util.LinkedHashMap;

/**
 * @program: chatbot
 * @description:
 * @author: zxw_
 * @create: 2021-02-08 15:06
 */
public class MessageEntity {
    /**
     * 消息类型
     * 1000为转发的聊天消息,1001为群内事件消息
     */
    private Long msgType;

    /**
     * 剩余的json串
     */
    private LinkedHashMap data;

    public Long getMsgType() {
        return msgType;
    }

    public void setMsgType(Long msgType) {
        this.msgType = msgType;
    }

    public LinkedHashMap getData() {
        return data;
    }

    public MessageEntity setData(LinkedHashMap data) {
        this.data = data;
        return this;
    }
}
