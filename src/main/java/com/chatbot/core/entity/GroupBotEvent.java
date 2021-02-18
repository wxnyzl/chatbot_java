package com.chatbot.core.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @program: chatbot
 * @description: 触发事件产生的消息实体
 * @author: zxw_
 * @create: 2021-02-08 15:31
 */
public class GroupBotEvent {

    /**
     * 具体的事件id 参考
     */
    private Long event;

    /**
     * 事件的中文描述
     */
    @JsonProperty("EventText")
    private String EventText;

    /**
     * 群信息
     */
    private GroupInfo group;

    /**
     * 触发成员信息
     */
    private List<GroupMembers> members;

    public Long getEvent() {
        return event;
    }

    public void setEvent(Long event) {
        this.event = event;
    }

    public String getEventText() {
        return EventText;
    }

    public void setEventText(String eventText) {
        EventText = eventText;
    }

    public GroupInfo getGroup() {
        return group;
    }

    public void setGroup(GroupInfo group) {
        this.group = group;
    }

    public List<GroupMembers> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMembers> members) {
        this.members = members;
    }

    public static class GroupInfo {

        /**
         * 群id
         */
        private String groupUserName;
        /**
         * 群名称
         */
        private String groupNickName;
        /**
         * 群头像
         */
        private String groupHeadImg;

        public String getGroupUserName() {
            return groupUserName;
        }

        public void setGroupUserName(String groupUserName) {
            this.groupUserName = groupUserName;
        }

        public String getGroupNickName() {
            return groupNickName;
        }

        public void setGroupNickName(String groupNickName) {
            this.groupNickName = groupNickName;
        }

        public String getGroupHeadImg() {
            return groupHeadImg;
        }

        public void setGroupHeadImg(String groupHeadImg) {
            this.groupHeadImg = groupHeadImg;
        }
    }

    public static class GroupMembers {

        /**
         * 群成员id
         */
        private String userName;

        /**
         * 群成员昵称
         */
        private String nickName;

        /**
         * 群成员头像 地址
         */
        private String headImg;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }
    }

}
