package com.chatbot.sample;

import cn.hutool.core.util.StrUtil;
import com.chatbot.core.anno.MsgPlugin;
import com.chatbot.core.entity.UserMessage;
import com.chatbot.core.handler.MessageProcess;
import com.chatbot.sample.request.IRequest;
import com.dtflys.forest.http.ForestResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@MsgPlugin
@Component
public class PoetryPlugin extends MessageProcess {

    @Resource
    private IRequest iRequest;

    @Override
    public void process(UserMessage userMessage) {
        // 群消息可能多一些
        String content = userMessage.getGroupContent();
        if (!isGroupMessage(userMessage.getFromUser())) {
            content =  userMessage.getContent();
        }
        if (StrUtil.equals("诗词",content)) {
            ForestResponse<Map> response = iRequest.poetry();
            if (response.isSuccess()) {
                Map result = response.getResult();
                Map body = (Map)result.get("data");
                // content, author, author
                Object pContent = body.get("content");
                Object author = body.get("author");
                Object origin = body.get("origin");
                this.sender().sendText(userMessage.getFromUser(),pContent + "\n\n\n      --《" + origin  + "》" + author);
            }
        }
    }
}
