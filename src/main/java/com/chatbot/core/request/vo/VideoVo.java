package com.chatbot.core.request.vo;

/**
 * 视频发送接口参数
 */
public class VideoVo {

    private String toUser;
    /**
     *  视频地址
     */
    private String videoUrl;
    /**
     * 视频缩略图地址
     */
    private String videoThumbUrl;

    public VideoVo(String toUser, String videoUrl, String videoThumbUrl) {
        this.toUser = toUser;
        this.videoUrl = videoUrl;
        this.videoThumbUrl = videoThumbUrl;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoThumbUrl() {
        return videoThumbUrl;
    }

    public void setVideoThumbUrl(String videoThumbUrl) {
        this.videoThumbUrl = videoThumbUrl;
    }
}
