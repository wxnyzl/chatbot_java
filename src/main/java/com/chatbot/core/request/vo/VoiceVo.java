package com.chatbot.core.request.vo;

/**
 * 音频发送接口参数
 */
public class VoiceVo {
   private String toUser;
   private String silkUrl;

    public VoiceVo(String toUser, String silkUrl) {
        this.toUser = toUser;
        this.silkUrl = silkUrl;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getSilkUrl() {
        return silkUrl;
    }

    public void setSilkUrl(String silkUrl) {
        this.silkUrl = silkUrl;
    }
}
