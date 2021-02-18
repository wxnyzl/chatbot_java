package com.chatbot.sample;

import com.chatbot.core.anno.MsgPlugin;
import com.chatbot.core.entity.EntityConstants;
import com.chatbot.core.entity.UserMessage;
import com.chatbot.core.handler.MessageProcess;
import com.chatbot.core.request.response.BaseRes;
import com.chatbot.core.request.response.ImageRes;
import com.chatbot.core.request.response.VideoRes;
import com.chatbot.core.request.response.VoiceRes;
import com.dtflys.forest.http.ForestResponse;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.Iterator;

/**
 * 复读机 演示其他方法的使用
 */
@MsgPlugin
@Component
public class RepeaterPlugin extends MessageProcess {

    private static final Logger log = LoggerFactory.getLogger(RepeaterPlugin.class);


    @Override
    protected void process(UserMessage userMessage) {
        if (!isGroupMessage(userMessage.getFromUser())) {
            String content = userMessage.getContent();
            int msgType = userMessage.getMsgType();
            if (msgType == EntityConstants.MsgType.MsgTypeImage.getMsgType()) {
                ForestResponse<BaseRes<ImageRes>> response = this.sender().downloadImage(content);
                if (response.isSuccess()) {
                    BaseRes<ImageRes> result = response.getResult();
                    Integer code = result.getCode();
                    if (code == 0) {
                        ImageRes data = result.getData();
                        this.sender().sendPic(userMessage.getFromUser(),data.getImgUrl());
                    }
                }
            }else if (msgType == EntityConstants.MsgType.MsgTypeVoice.getMsgType()) {
                ForestResponse<BaseRes<VoiceRes>> response = this.sender().downloadVoice(userMessage.getNewMsgId(), content);
                if (response.isSuccess()) {
                    BaseRes<VoiceRes> result = response.getResult();
                    VoiceRes data = result.getData();
                    this.sender().sendVoice(userMessage.getFromUser(),data.getVoiceUrl());
                }
            }
            else if (msgType == EntityConstants.MsgType.MsgTypeVideo.getMsgType()) {
                ForestResponse<BaseRes<VideoRes>> response = this.sender().downloadVideo(content);
                if (response.isSuccess()) {
                    BaseRes<VideoRes> result = response.getResult();
                    VideoRes data = result.getData();
                    this.sender().sendVideo(userMessage.getFromUser(),data.getVideoUrl(),
                            "http://5b0988e595225.cdn.sohucs.com/images/20200213/cfcf842cd2284a5f91de0b1ee60a23b0.jpeg");
                }
            }
            else if (msgType == EntityConstants.MsgType.MsgTypeEmoji.getMsgType()) {
                try{
                    SAXReader saxReader = new SAXReader();
                    Document read = saxReader.read(new StringReader(content));
                    Element rootElement = read.getRootElement();
                    Iterator<Element> emoji = rootElement.elementIterator("emoji");
                    if (emoji.hasNext()) {
                        Element element = emoji.next();
                        String md5 = element.attributeValue("md5");
                        String len = element.attributeValue("len");
                        String cdnurl = element.attributeValue("cdnurl");
                        log.info("表情下载地址为: {}",cdnurl);
                        this.sender().sendEmoji(userMessage.getFromUser(),md5,len);
                    }
                }catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
