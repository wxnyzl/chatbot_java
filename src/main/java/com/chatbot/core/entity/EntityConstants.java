package com.chatbot.core.entity;

/**
 * @program: chatbot
 * @description:
 * @author: zxw_
 * @create: 2021-02-08 15:27
 */
public class EntityConstants {

    public enum PushMsgType{
        /**
         * 转发的消息
         */
        Message(10000L,"转发的消息"),
        /**
         * 事件消息
         */
        Event(10001L,"事件消息");

        private Long msgType;

        PushMsgType(Long msgType,String desc){
            this.msgType = msgType;
        }

        public Long getMsgType() {
            return msgType;
        }

    }


    /**
     * 收到的转发消息具体分类
     */
    public enum MsgType{
        /**
         * 文本消息
         */
        MsgTypeText(1,"转发的消息"),
        /**
         * 图片消息
         */
        MsgTypeImage(3,"图片消息"),
        /**
         * 语音消息
         */
        MsgTypeVoice(34,"语音消息"),

        /**
         * 视频消息
         */
        MsgTypeVideo(43,"视频消息"),

        /**
         * 表情动图消息
         */
        MsgTypeEmoji(47,"表情动图消息");

        private int type;
        private String desc;

        MsgType(int type,String desc){
            this.type = type;
            this.desc = desc;
        }

        public int getMsgType() {
            return type;
        }

    }

    /**
     * 群成员角色
     */
    public enum GroupRole{
        Member(1,"成员"),
        Admin(2,"超级管理员"),
        Owner(3,"所有者");

        private Integer roleCode;
        private String desc;

        GroupRole(Integer roleCode,String desc){
            this.roleCode = roleCode;
            this.desc = desc;
        }

        public Integer getRoleCode() {
            return roleCode;
        }
    }

    public enum GroupEvent{
        GroupEventInvited(100000L,"机器人被邀请入群"),
        GroupEventKicked(100001L,"机器人被踢出群"),
        GroupEventNewMember(100002L,"群内有新用户加群"),
        GroupEventMemberQuit(100003L,"群内有用户离开");

        private Long eventCode;
        private String desc;

        GroupEvent(Long eventCode,String desc){
            this.eventCode = eventCode;
            this.desc = desc;
        }

        public Long getEventCode() {
            return eventCode;
        }
    }





}
