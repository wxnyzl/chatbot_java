package com.chatbot.core.handler;

import cn.hutool.core.collection.CollUtil;
import com.chatbot.core.anno.MsgPlugin;
import com.chatbot.core.entity.UserMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: chatbot
 * @description:
 * @author: zxw_
 * @create: 2021-02-08 17:27
 */
@Component
public class MessageExecutor implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(MessageExecutor.class);

    private final List<MessageProcess> processList = new ArrayList<>();

    public void executor(UserMessage userMessage) {
        if (CollUtil.isNotEmpty(processList)) {
            for (MessageProcess messageProcess : processList) {
                try{
                    messageProcess.process(userMessage);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 根容器为Spring容器
        if(event.getApplicationContext().getParent()==null){
            Map<String,Object> beans = event.getApplicationContext().getBeansWithAnnotation(MsgPlugin.class);
            for(Object bean: beans.values()){
                MsgPlugin annotation = bean.getClass().getAnnotation(MsgPlugin.class);
                if (annotation.open()) {
                    log.info("启用消息处理插件 : {}",bean.getClass().toString());
                    processList.add((MessageProcess) bean);
                }
            }
        }
    }
}
