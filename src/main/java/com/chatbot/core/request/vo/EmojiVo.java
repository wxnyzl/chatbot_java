package com.chatbot.core.request.vo;

/**
 * Emoji表情发送接口参数
 */
public class EmojiVo {

    private String toUser;
    private String emojiMd5;
    private String emojiLen;

    public EmojiVo(String toUser, String emojiMd5, String emojiLen) {
        this.toUser = toUser;
        this.emojiMd5 = emojiMd5;
        this.emojiLen = emojiLen;
    }

    public String getToUser() {
        return toUser;
    }

    public EmojiVo setToUser(String toUser) {
        this.toUser = toUser;
        return this;
    }

    public String getEmojiMd5() {
        return emojiMd5;
    }

    public EmojiVo setEmojiMd5(String emojiMd5) {
        this.emojiMd5 = emojiMd5;
        return this;
    }

    public String getEmojiLen() {
        return emojiLen;
    }

    public EmojiVo setEmojiLen(String emojiLen) {
        this.emojiLen = emojiLen;
        return this;
    }
}
