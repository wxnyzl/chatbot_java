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
public class AcgPlugin extends MessageProcess {

    @Resource
    private IRequest iRequest;

    @Override
    protected void process(UserMessage userMessage) {
        String content = userMessage.getGroupContent();
        if (!isGroupMessage(userMessage.getFromUser())) {
            content =  userMessage.getContent();
        }
        if (StrUtil.equals("acg",content)) {
            ForestResponse<Map> response = iRequest.acg();
            if (response.isSuccess()) {
                Map result = response.getResult();
                Map data = (Map)result.get("data");
                String url = (String)data.get("url");
                this.sender().sendPic(userMessage.getFromUser(), url);
            }
        }
    }

}
