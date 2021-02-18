package com.chatbot.core.request.vo;

/**
 * 图片发送接口参数
 */
public class PicVo {
    private String toUser;
    private String imgUrl;

    public PicVo(String toUser, String imgUrl) {
        this.toUser = toUser;
        this.imgUrl = imgUrl;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
