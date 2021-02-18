package com.chatbot.core.request.response;

public class VoiceRes {

    private String content;
    private Long voiceLength;
    private String voiceUrl;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getVoiceLength() {
        return voiceLength;
    }

    public void setVoiceLength(Long voiceLength) {
        this.voiceLength = voiceLength;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }
}
