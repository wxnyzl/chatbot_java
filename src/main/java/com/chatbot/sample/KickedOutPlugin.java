package com.chatbot.sample;

import cn.hutool.core.util.StrUtil;
import com.chatbot.core.anno.MsgPlugin;
import com.chatbot.core.entity.UserMessage;
import com.chatbot.core.handler.MessageProcess;
import com.dtflys.forest.http.ForestResponse;
import org.springframework.stereotype.Component;

@MsgPlugin
@Component
public class KickedOutPlugin extends MessageProcess {

    @Override
    protected void process(UserMessage userMessage) {
        if (isGroupMessage(userMessage.getFromUser())) {
            String content = userMessage.getGroupContent();
            if (StrUtil.equals("踢",splitAtContent(content))) {
                if (IsGroupMember(userMessage.getGroupMemberRole())) {
                    this.sender().sendText(userMessage.getFromUser(),
                            "@" + userMessage.getGroupMemberNickname() + " 你不是管理员休想命令我!",
                            userMessage.getGroupMember()
                    );
                } else {
                    ForestResponse<Object> response = this.sender().delGroupMember(userMessage.getFromUser(), userMessage.getAtList());
                    if (response.isSuccess()) {
                        this.sender().sendText(userMessage.getFromUser(),
                                '@' + userMessage.getGroupMemberNickname() + " 搞定了老板" ,
                                userMessage.getGroupMember()
                            );
                    }
                }
            }
        }
    }
}
