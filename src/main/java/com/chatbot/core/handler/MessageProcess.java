package com.chatbot.core.handler;

import cn.hutool.core.util.StrUtil;
import com.chatbot.core.entity.EntityConstants;
import com.chatbot.core.entity.UserMessage;
import com.chatbot.core.request.MsgSender;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @desc: 用户操作信息抽象类
 */
@Component
public abstract class MessageProcess {

    @Autowired
    private MsgSender msgSender;

    /**
     * 处理流程
     * @param userMessage
     */
    protected abstract void process(UserMessage userMessage) throws DocumentException;

    public MsgSender sender() {
        return msgSender;
    }

    /**
     * 是否为群信息
     * @param fromUser
     * @return 如果为Group信息 返回true
     */
    protected boolean isGroupMessage(String fromUser) {
        if (StrUtil.isNotEmpty(fromUser) && StrUtil.endWith(fromUser,"@chatroom")) {
            return true;
        }
        return false;
    }

    /**
     * 机器人是否被@at
     * @param userMessage
     * @return 被at返回true
     */
    protected boolean isBotBeenAt(UserMessage userMessage) {
        if (!isGroupMessage(userMessage.getFromUser())) {
            return false;
        }
        List<String> atList = userMessage.getAtList();
        for (String atId : atList) {
            if (StrUtil.equals(atId,userMessage.getClientUserName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 如果机器人被@并带有文本信息,该方法可以用来分离文本
     * @param atContent
     * @return
     */
    protected String splitAtContent(String atContent) {
        String content = atContent;
        String[] contents = content.split("\u2005", 2);
        if (contents.length != 2) {
            contents = content.split(" ", 2);
        }
        if (contents.length == 2) {
            content = contents[1].trim();
        }
        return content;
    }

    /**
     * 判断群内成员身份是否为成员
     * @param role
     * @return
     */
    protected boolean IsGroupMember(Integer role) {
        return EntityConstants.GroupRole.Member.getRoleCode().equals(role);
    }
}
