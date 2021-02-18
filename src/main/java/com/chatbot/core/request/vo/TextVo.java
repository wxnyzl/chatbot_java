package com.chatbot.core.request.vo;

import java.util.List;

/**
 * 文本发送接口参数
 */
public class TextVo {

    private String toUser;
    private String content;
    private List<String> atList;

    public TextVo(String toUser, String content) {
        this.toUser = toUser;
        this.content = content;
    }

    public TextVo(String toUser, String content, List<String> atList) {
        this.toUser = toUser;
        this.content = content;
        this.atList = atList;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAtList() {
        return atList;
    }

    public void setAtList(List<String> atList) {
        this.atList = atList;
    }
}
