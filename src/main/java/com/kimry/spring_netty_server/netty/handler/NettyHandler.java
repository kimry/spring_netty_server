package com.kimry.spring_netty_server.netty.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ChannelHandler.Sharable
public class NettyHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("연결 완료");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String rcvMsg = new String( (byte[])msg,"EUC-KR");
        log.info("수신 메세지 : " + rcvMsg);
        String sndMsg = new String((rcvMsg+"_reply").getBytes("EUC-KR"),"EUC-KR");
        ctx.writeAndFlush(sndMsg.getBytes("EUC-KR"));
        log.info("송신 메세지 : " + sndMsg);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("연결 해제");
    }
}
