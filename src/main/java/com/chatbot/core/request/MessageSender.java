package com.chatbot.core.request;

import com.chatbot.core.request.response.BaseRes;
import com.chatbot.core.request.response.ImageRes;
import com.chatbot.core.request.response.VideoRes;
import com.chatbot.core.request.response.VoiceRes;
import com.chatbot.core.request.vo.*;
import com.dtflys.forest.annotation.*;
import com.dtflys.forest.http.ForestResponse;

import java.util.Map;


/**
 * 消息发送器
 */
@BaseRequest(
        baseURL = "${httpip}" + RequestUrl.V1_BASE_URL
)
public interface MessageSender {

    /**
     * 发送文本消息
     */
    @PostRequest(
            url =  RequestUrl.SEND_TEXT_URL + "?token=${token}"
    )
    ForestResponse<Object> sendText(@JSONBody TextVo vo);

    /**
     * 发送图片消息
     */
    @PostRequest(
            url = RequestUrl.SEND_PIC_URL + "?token=${token}"
    )
    ForestResponse<Object> sendPic(@JSONBody PicVo vo);

    /**
     * 发送Emoji表情消息
     */
    @PostRequest(
            url = RequestUrl.SEND_EMOJI_URL + "?token=${token}"
    )
    ForestResponse<Object> sendEmoji(@JSONBody EmojiVo vo);

    /**
     * 发送视频消息
     */
    @PostRequest(
            url = RequestUrl.SEND_VIDEO_URL + "?token=${token}"
    )
    ForestResponse<Object> sendVideo(@JSONBody VideoVo vo);

    /**
     * 发送语音消息
     */
    @PostRequest(
            url = RequestUrl.SEND_VOICE_URL + "?token=${token}"
    )
    ForestResponse<Object> sendVoice(@JSONBody VoiceVo vo);

    /**
     * 发送小程序
     */
    @PostRequest(
            url = RequestUrl.SEND_MINI_PROGRAM_URL + "?token=${token}"
    )
    ForestResponse<Object> sendSmallApp(@JSONBody SmallProgramVo vo);

    /**
     * 踢出群成员
     * @param vo
     * @return
     */
    @PostRequest(
            url = RequestUrl.DEL_CHATROOM_MEMBER + "?token=${token}"
    )
    ForestResponse<Object> delGroupMember(@JSONBody DelGroupMemberVo vo);

    /**
     * 下载视频消息
     */
    @PostRequest(
        url = RequestUrl.DOWNLOAD_VIDEO + "?token=${token}"
    )
    ForestResponse<BaseRes<VideoRes>> downloadVideo(@JSONBody("xml")String xml);

    /**
     * 下载视频消息
     */
    @PostRequest(
            url = RequestUrl.DOWNLOAD_IMAGE + "?token=${token}"
    )
    ForestResponse<BaseRes<ImageRes>> downloadImage(@JSONBody("xml")String xml);

    /**
     * 下载视频消息
     */
    @PostRequest(
            url = RequestUrl.DOWNLOAD_VOICE + "?token=${token}"
    )
    ForestResponse<BaseRes<VoiceRes>> downloadVoice(@JSONBody("newMsgId")Long newMsgId,@JSONBody("xml")String xml);

}

