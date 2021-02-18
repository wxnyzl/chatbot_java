package com.chatbot.core.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@ChannelHandler.Sharable
public class MHeartbeatHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(MHeartbeatHandler.class);

    @Autowired
    private MClient client;

    int readIdleTimes = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent)evt;
            switch (idleStateEvent.state()){
                // 读空闲
                case READER_IDLE:
                    // 计数
                    readIdleTimes++;
                    break;
                // 写空闲
                case WRITER_IDLE:
                    ctx.writeAndFlush(new TextWebSocketFrame("ping"));
                    break;
                // 读写空闲
                case ALL_IDLE:
                    break;
            }

            if (readIdleTimes > 5 ) {
                // 6次未收到服务端的心跳回应了,关闭连接
                ctx.channel().close();
                log.info("服务端链接断开,1s后重新链接");
            }
        }else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 断线直接开启重连
        client.startClient();
    }
}
