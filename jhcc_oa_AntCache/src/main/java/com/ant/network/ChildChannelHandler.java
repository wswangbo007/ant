package com.ant.network;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.constant.ConstantUtil;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * ClassName:ChildChannelHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年1月18日 下午11:01:40 <br/>
 * 
 * @author 神经刀
 * @version 0.1
 * @since JDK 1.8
 * @see Copyright (c) 2017, wswangbo007@163.com All Rights Reserved.
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/*
	 * <p>Title: initChannel</p> <p>Description: </p>
	 * 
	 * @param ch
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * io.netty.channel.ChannelInitializer#initChannel(io.netty.channel.Channel)
	 */
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		if (log.isDebugEnabled()) log.debug("初始化通道 {}",ch);
		/**
		 * 心跳包 1、readerIdleTimeSeconds 读超时时间 2、writerIdleTimeSeconds 写超时时间
		 * 3、allIdleTimeSeconds 读写超时时间 4、TimeUnit.SECONDS 秒[默认为秒，可以指定]
		 */
		ch.pipeline().addLast(new IdleStateHandler(9, 9, 9));
		ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
		ch.pipeline().addLast(new StringDecoder(Charset.forName(ConstantUtil.NETTYWORK.CODING)));
		ch.pipeline().addLast(new StringEncoder(Charset.forName(ConstantUtil.NETTYWORK.CODING)));
		ch.pipeline().addLast(new MyIdleHandler());
		MyServerHandler myServerHandler = new MyServerHandler();
		ch.pipeline().addLast(myServerHandler);
	}

}
