package com.chatbot.core.handler;

import com.chatbot.core.entity.GroupBotEvent;
import com.chatbot.core.request.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 群事件执行接口
 */
@Component
public abstract class GroupEventProcess {

    @Autowired
    private MsgSender msgSender;

    protected abstract void process(GroupBotEvent groupBotEvent);

    public MsgSender sender() {
        return msgSender;
    }

    public void setMessageSender(MsgSender messageSender) {
        this.msgSender = messageSender;
    }

}
