package com.mq.custommq.network.server;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mq.config.AbstractMqConfig;
import com.mq.config.CustomMqConfig;
import com.mq.constant.ConstantUtil;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * ClassName:ChildChannelHandler <br/>
 * Date: 2017年1月18日 下午11:01:40 <br/>
 * 
 * @author 神经刀
 * @version 0.1
 * @since JDK 1.8
 * @see Copyright (c) 2017, wswangbo007@163.com All Rights Reserved.
 */
public abstract class AbstractChildChannelHandler extends ChannelInitializer<SocketChannel> {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected AbstractMqConfig abstractMqConfig;
	
	/**
	 * <p>Title: initChannel</p> <p>Description: </p>
	 * @param ch
	 * @throws Exception
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
		CustomMqConfig customMqConfig = (CustomMqConfig)abstractMqConfig;
		ch.pipeline().addLast(new IdleStateHandler(customMqConfig.getReaderIdleTimeSeconds()
				, customMqConfig.getWriterIdleTimeSeconds(), customMqConfig.getAllIdleTimeSeconds(),TimeUnit.SECONDS));
		ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
		ch.pipeline().addLast(new StringDecoder(Charset.forName(ConstantUtil.NETTYWORK.CODING)));
		ch.pipeline().addLast(new StringEncoder(Charset.forName(ConstantUtil.NETTYWORK.CODING)));
		ch.pipeline().addLast(new MyIdleHandler());
		MyServerHandler myServerHandler = new MyServerHandler();
		ch.pipeline().addLast(myServerHandler);
	}
	
	public AbstractMqConfig getAbstractMqConfig() {
		return abstractMqConfig;
	}

	public void setAbstractMqConfig(AbstractMqConfig abstractMqConfig) {
		this.abstractMqConfig = abstractMqConfig;
	}
}
