package com.chatbot.core.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * @program: chatbot
 * @description:
 * @author: zxw_
 * @create: 2021-02-08 14:21
 */
@Component
public class MClient implements ApplicationRunner, ApplicationListener<ContextClosedEvent> {

    private static final Logger log = LoggerFactory.getLogger(MClient.class);

    @Autowired
    private MClientHandler clientHandler;
    @Autowired
    private MHeartbeatHandler heartbeatHandler;

    private URI uri = null;

    @Value("${wsip}")
    private String ip;
    @Value("${wstoken}")
    private String token;

    EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void startClient(){
        try {
            uri = new URI("ws://" + ip + "/ws?token=" + token);
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new HttpClientCodec());
                            pipeline.addLast(new ChunkedWriteHandler());
                            pipeline.addLast(new HttpObjectAggregator(65535));
                            pipeline.addLast(new WebSocketClientProtocolHandler(uri, WebSocketVersion.V13,
                                    null, true, new DefaultHttpHeaders(), Integer.MAX_VALUE));
                            pipeline.addLast(new IdleStateHandler(20,15,20, TimeUnit.SECONDS));
                            pipeline.addLast(heartbeatHandler);
                            pipeline.addLast(clientHandler);
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect(uri.getHost(), uri.getPort());
            channelFuture.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    log.info("连接服务端成功");
                } else {
                    log.info("连接失败，20s后进行断线重连");
                    future.channel().eventLoop().schedule(this::startClient, 20, TimeUnit.SECONDS);
                }
            });
            ChannelFuture sync = channelFuture.sync();
            sync.channel().closeFuture().sync();
        }catch (InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        startClient();
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        log.info("client closed.");
        workerGroup.shutdownGracefully();
    }
}
