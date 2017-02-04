package com.mq.custommq.network.server;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/** 
 * ClassName:MyServerHandler <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月18日 下午11:17:13 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class MyServerHandler extends ChannelHandlerAdapter {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.debug("活动通道 : " + ctx.channel().localAddress().toString() + " channelActive");
		// 添加到channelGroup 通道组
		MyChannelHandlerPool.channelGroup.add(ctx.channel());
		// 通知您已经链接上客户端
		String str = "您已经开启与服务端链接" + " " + new Date() + " " + ctx.channel().localAddress();
		log.debug(str);
		ctx.writeAndFlush(str);
	}

	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		MyChannelHandlerPool.channelGroup.remove(ctx.channel());
		log.debug("close: 不活跃!" + ctx.channel().localAddress().toString() + " channelInactive");
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		log.debug("服务端收到："+new Date()+" "+msg+"\r\n");
		MyChannelHandlerPool.channelGroup.writeAndFlush(msg);
	}

	/*
	 * channelReadComplete channel 通道 Read 读取 Complete 完成
	 * 在通道读取完成后会在这个方法里通知，对应可以做刷新操作 ctx.flush()
	 */
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		log.debug("通道读取完成,结束!做刷新的动作");
		ctx.flush();
	}

	/*
	 * exceptionCaught exception 异常 Caught 抓住
	 * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
	 */
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		log.error("异常信息：\r\n", cause.getMessage());
	}
}
