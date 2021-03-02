package com.chatbot.core.handler;

import cn.hutool.core.collection.CollUtil;
import com.chatbot.core.anno.EventPlugin;
import com.chatbot.core.entity.GroupBotEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class EventExecutor  implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(EventExecutor.class);

    private final List<GroupEventProcess> processList = new ArrayList<>();

    public void executor(GroupBotEvent event) {
        if (CollUtil.isNotEmpty(processList)) {
            for (GroupEventProcess messageProcess : processList) {
                messageProcess.process(event);
            }
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 根容器为Spring容器
        if(event.getApplicationContext().getParent()==null){
            Map<String,Object> beans = event.getApplicationContext().getBeansWithAnnotation(EventPlugin.class);
            for(Object bean: beans.values()){
                EventPlugin annotation = bean.getClass().getAnnotation(EventPlugin.class);
                if (annotation.open()) {
                    log.info("启用群事件处理插件 : {}",bean.getClass().toString());
                    processList.add((GroupEventProcess) bean);
                }
            }
        }
    }
}
