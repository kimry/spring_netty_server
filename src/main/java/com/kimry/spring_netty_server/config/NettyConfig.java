package com.kimry.spring_netty_server.config;

import com.kimry.spring_netty_server.netty.handler.NettyInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class NettyConfig {

    private final NettyInitializer nettyInitializer;

    @Bean
    public ServerBootstrap serverBootstrap(){
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(new NioEventLoopGroup(5), new NioEventLoopGroup(5))
                .channel(NioServerSocketChannel.class)
                .childHandler(nettyInitializer);
        return serverBootstrap;
    }
}
