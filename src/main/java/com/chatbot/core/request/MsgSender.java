package com.chatbot.core.request;


import com.chatbot.core.request.response.BaseRes;
import com.chatbot.core.request.response.ImageRes;
import com.chatbot.core.request.response.VideoRes;
import com.chatbot.core.request.response.VoiceRes;
import com.chatbot.core.request.vo.*;
import com.dtflys.forest.http.ForestResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 消息发送分层
 */
@Component
public class MsgSender {

    @Resource
    private MessageSender messageSender;

    public void sendText(String toUser, String text) {
        messageSender.sendText(new TextVo(toUser,text));
    }

    public ForestResponse<Object> sendText(String toUser, String text, String... atList) {
        return messageSender.sendText(new TextVo(toUser,text, Arrays.asList(atList)));
    }

    public ForestResponse<Object> sendPic(String toUser,String imgUrl) {
        return messageSender.sendPic(new PicVo(toUser,imgUrl));
    }

    public ForestResponse<Object> sendEmoji(String toUser,String emojiMd5,String emojiLen) {
        return messageSender.sendEmoji(new EmojiVo(toUser,emojiMd5,emojiLen));
    }

    public ForestResponse<Object> sendVideo(String toUser,String videoUrl,String videoThumbUrl) {
        return messageSender.sendVideo(new VideoVo(toUser,videoUrl,videoThumbUrl));
    }

    public ForestResponse<Object> sendVoice(String toUser,String silkUrl) {
        return messageSender.sendVoice(new VoiceVo(toUser,silkUrl));
    }

    public ForestResponse<Object> sendSmallProgram(SmallProgramVo vo) {
        return messageSender.sendSmallApp(vo);
    }

    public ForestResponse<Object> delGroupMember(String chatroom,List<String> atList) {
        return messageSender.delGroupMember(new DelGroupMemberVo(chatroom,atList));
    }

    public ForestResponse<BaseRes<VideoRes>> downloadVideo(String content) {
        return messageSender.downloadVideo(content);
    }

    public ForestResponse<BaseRes<ImageRes>> downloadImage(String content) {
        return messageSender.downloadImage(content);
    }

    public ForestResponse<BaseRes<VoiceRes>> downloadVoice(Long newMsgId,String content) {
        return messageSender.downloadVoice(newMsgId,content);
    }

}
