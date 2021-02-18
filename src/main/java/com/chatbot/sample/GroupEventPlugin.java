package com.chatbot.sample;

import cn.hutool.core.collection.CollUtil;
import com.chatbot.core.anno.EventPlugin;
import com.chatbot.core.entity.EntityConstants;
import com.chatbot.core.entity.GroupBotEvent;
import com.chatbot.core.handler.GroupEventProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@EventPlugin
@Component
public class GroupEventPlugin extends GroupEventProcess {

    private static final Logger log = LoggerFactory.getLogger(GroupEventPlugin.class);

    @Override
    protected void process(GroupBotEvent groupBotEvent) {
        Long event = groupBotEvent.getEvent();
        GroupBotEvent.GroupInfo group = groupBotEvent.getGroup();
        if (event.equals(EntityConstants.GroupEvent.GroupEventInvited.getEventCode())) {
            // 机器人被邀请入群
            this.sender().sendText(group.getGroupUserName(),"大家好我是机器人");
        } else if (event.equals(EntityConstants.GroupEvent.GroupEventKicked.getEventCode())) {
            // 机器人被踢出群
            log.info("机器人被踢出群");
        } else if (event.equals(EntityConstants.GroupEvent.GroupEventNewMember.getEventCode())) {
            // 群内有新用户加群
            List<GroupBotEvent.GroupMembers> members = groupBotEvent.getMembers();
            if (CollUtil.isNotEmpty(members)) {
                for (GroupBotEvent.GroupMembers member : members) {
                    this.sender().sendText(group.getGroupUserName(),"欢迎新成员:@" + member.getNickName(), member.getUserName());
                }
            }
        } else if (event.equals(EntityConstants.GroupEvent.GroupEventMemberQuit.getEventCode())) {
            // 群内有用户离开
            List<GroupBotEvent.GroupMembers> members = groupBotEvent.getMembers();
            if (CollUtil.isNotEmpty(members)) {
                for (GroupBotEvent.GroupMembers member : members) {
                    this.sender().sendText(group.getGroupUserName(),"有人离开了:" + member.getNickName());
                }
            }
        }
    }
}
