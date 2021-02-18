package com.chatbot.core.entity;

import java.util.List;

/**
 * @program: chatbot
 * @description: 用户操作产生的消息实体
 * @author: zxw_
 * @create: 2021-02-08 15:06
 */
public class UserMessage {

    /**
     * 消息id
     */
    private Long newMsgId;
    /**
     * 发送人,这个也会是你发送消息的对象,即接口toUser字段的值就是这个
     */
    private String fromUser;
    /**
     * 消息中@了谁
     */
    private List<String> atList;
     /**
      * 时间戳
      */
    private Long createTime;
     /**
      *  "潮汐的永恒 : 帮助"
      *  发言昵称和内容
      *  群内消息会变成"xxx发送了一个图片"这样的简短说明
      */
    private String pushContent;
     /**
      * 机器人id(wxid_0ef5sxqjb7ta22)
      */
    private String clientUserName;
     /**
      * 消息接收人id(wxid_0ef5sxqjb7ta22)
      */
    private String toUser;
     /**
      *
      */
    private String imgBuf;
     /**
      * 1
      */
    private Integer msgType;
     /**
      * 发言内容
      */
    private String content;
     /**
      * 暂时无用  消息来源":"\\u003 cmsg source /\\u003e\n",
      *                 => <msgsource />
      */
    private String msgSource;

    /**
     *   以下字段是群内消息才会用到
     */

     /**
      * 谁@了机器人,显示的是用户昵称
      */
    private String whoAtBot;
    /**
     * 群内说话人的身份
     */
    private Integer groupMemberRole;
    /**
     * 群内说话人的微信id
     */
    private String groupMember;
    /**
     * 群内说话人的微信昵称
     */
    private String groupMemberNickname;
    /**
     * 群内消息主体
     */
    private String groupContent;

    public Long getNewMsgId() {
        return newMsgId;
    }

    public void setNewMsgId(Long newMsgId) {
        this.newMsgId = newMsgId;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public List<String> getAtList() {
        return atList;
    }

    public void setAtList(List<String> atList) {
        this.atList = atList;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getImgBuf() {
        return imgBuf;
    }

    public void setImgBuf(String imgBuf) {
        this.imgBuf = imgBuf;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public UserMessage setMsgType(Integer msgType) {
        this.msgType = msgType;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgSource() {
        return msgSource;
    }

    public void setMsgSource(String msgSource) {
        this.msgSource = msgSource;
    }

    public String getWhoAtBot() {
        return whoAtBot;
    }

    public void setWhoAtBot(String whoAtBot) {
        this.whoAtBot = whoAtBot;
    }

    public Integer getGroupMemberRole() {
        return groupMemberRole;
    }

    public UserMessage setGroupMemberRole(Integer groupMemberRole) {
        this.groupMemberRole = groupMemberRole;
        return this;
    }

    public String getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(String groupMember) {
        this.groupMember = groupMember;
    }

    public String getGroupMemberNickname() {
        return groupMemberNickname;
    }

    public void setGroupMemberNickname(String groupMemberNickname) {
        this.groupMemberNickname = groupMemberNickname;
    }

    public String getGroupContent() {
        return groupContent;
    }

    public void setGroupContent(String groupContent) {
        this.groupContent = groupContent;
    }
}
