package com.kimry.spring_netty_server.netty.handler.decoder;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class SharableByteArrayDecoder extends ByteArrayDecoder {
}
