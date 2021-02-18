package com.chatbot.core.netty;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.chatbot.core.entity.EntityConstants;
import com.chatbot.core.entity.GroupBotEvent;
import com.chatbot.core.entity.MessageEntity;
import com.chatbot.core.entity.UserMessage;
import com.chatbot.core.handler.EventExecutor;
import com.chatbot.core.handler.MessageExecutor;
import com.chatbot.core.util.JacksonUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * @program: chatbot
 * @description:
 * @author: zxw_
 * @create: 2021-02-08 14:21
 */
@Component
@ChannelHandler.Sharable
public class MClientHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final Logger log = LoggerFactory.getLogger(MClientHandler.class);

    @Autowired
    private MessageExecutor messageExecutor;
    @Autowired
    private EventExecutor eventExecutor;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String str = msg.text();
        if ("pong".equals(str)) {
            return;
        }
        log.info("收到消息:{}",str);
        MessageEntity messageEntity = JacksonUtil.json2Bean(str, MessageEntity.class);
        if (messageEntity == null) {
            return;
        }
        LinkedHashMap data = messageEntity.getData();
        if (EntityConstants.PushMsgType.Message.getMsgType().equals(messageEntity.getMsgType())) {
            UserMessage userMessage = BeanUtil.mapToBean(data,UserMessage.class,true, CopyOptions.create());
            messageExecutor.executor(userMessage);
        } else if (EntityConstants.PushMsgType.Event.getMsgType().equals(messageEntity.getMsgType())) {
            GroupBotEvent groupBotEvent = BeanUtil.mapToBean(data,GroupBotEvent.class,true, CopyOptions.create());
            eventExecutor.executor(groupBotEvent);
        }
    }


}
