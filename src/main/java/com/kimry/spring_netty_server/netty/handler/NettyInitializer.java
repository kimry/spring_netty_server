package com.kimry.spring_netty_server.netty.handler;

import com.kimry.spring_netty_server.netty.handler.decoder.SharableByteArrayDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NettyInitializer extends ChannelInitializer<SocketChannel> {

    private ByteArrayEncoder byteArrayEncoder = new ByteArrayEncoder();
    private SharableByteArrayDecoder byteArrayDecoder = new SharableByteArrayDecoder();
    private final NettyHandler nettyHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(byteArrayDecoder);
        channelPipeline.addLast(byteArrayEncoder);
        channelPipeline.addLast(nettyHandler);
    }
}
