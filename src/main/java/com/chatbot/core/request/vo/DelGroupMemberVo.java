package com.chatbot.core.request.vo;

import java.util.List;

/**
 * 删除群成员发送接口参数
 */
public class DelGroupMemberVo {

    private String chatroom;
    private List<String> memberList;

    public DelGroupMemberVo(){

    }

    public DelGroupMemberVo(String chatroom, List<String> memberList) {
        this.chatroom = chatroom;
        this.memberList = memberList;
    }

    public String getChatroom() {
        return chatroom;
    }

    public DelGroupMemberVo setChatroom(String chatroom) {
        this.chatroom = chatroom;
        return this;
    }

    public List<String> getMemberList() {
        return memberList;
    }

    public DelGroupMemberVo setMemberList(List<String> memberList) {
        this.memberList = memberList;
        return this;
    }
}
