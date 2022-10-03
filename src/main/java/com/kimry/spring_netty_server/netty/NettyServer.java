package com.kimry.spring_netty_server.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class NettyServer {

    @Value("${server.port}")
    private String port;

    private final ServerBootstrap serverBootstrap;

    @PostConstruct
    public void run(){

        try {
            log.info("Netty Server Start!!");
            ChannelFuture channelFuture = serverBootstrap.bind(Integer.parseInt(port)).sync();
            channelFuture.channel().closeFuture().sync();
        }
        catch (InterruptedException e){
            log.error("NettyServer Error!!" + e);
        }
    }

}
