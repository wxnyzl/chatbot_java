package com.chatbot.core.request;

public interface RequestUrl {

    /**
     * v1
     */
    String V1_BASE_URL = "/api/v1";

    /**
     * 文本url
     */
    String SEND_TEXT_URL = "/chat/sendText";
    /**
     * 图片url
     */
    String SEND_PIC_URL = "/chat/sendPic";
    /**
     * 表情url
     */
    String SEND_EMOJI_URL = "/chat/sendEmoji";
    /**
     * 视频url
     */
    String SEND_VIDEO_URL = "/chat/sendVideo";
    /**
     * 语音url
     */
    String SEND_VOICE_URL = "/chat/sendVoice";
    /**
     * 小程序url
     */
    String SEND_MINI_PROGRAM_URL = "/chat/sendSmallApp";

    /**
     * 删除群成员
     */
    String DEL_CHATROOM_MEMBER = "/chatroom/delChatRoomMember";

    /**
     * 下载视频消息
     */
    String DOWNLOAD_VIDEO = "/chat/downloadVideo";

    /**
     * 下载音频消息
     */
    String DOWNLOAD_VOICE = "/chat/downloadVoice";

    /**
     * 下载图片消息
     */
    String DOWNLOAD_IMAGE = "/chat/downloadImage";


}
