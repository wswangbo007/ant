package com.mq.custommq.network.server;

import com.mq.config.AbstractMqConfig;
import com.mq.config.CustomMqConfig;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/** 
 * ClassName:NettyServer <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月18日 下午10:33:40 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class NettyServer {
	
	private AbstractMqConfig abstractMqConfig;
	
	private NettyServer(){};
	
	private static NettyServer nettyServer = new NettyServer();
	
	public NettyServer(AbstractMqConfig abstractMqConfig) {
		this.abstractMqConfig = abstractMqConfig;
	}
	
	/**
	  * getNettyServer(get NettyServer)
	  * @Title: getNettyServer
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return NettyServer    返回类型
	 */
	public static NettyServer getNettyServer() {
		if (null == nettyServer) {
			nettyServer = new NettyServer();
		}
		return nettyServer;
	}

	/**
	  * bing(绑定)
	  * @Title: bing
	  * @Description: TODO
	  * @param @param port
	  * @param @throws InterruptedException    设定文件
	  * @return void    返回类型
	 */
	public void bing(int port) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workGroup);
			b.channel(NioServerSocketChannel.class);
			b.option(ChannelOption.SO_BACKLOG, 1024);
			b.childHandler(new ChildChannelHandler());
			ChannelFuture f = b.bind(((CustomMqConfig)abstractMqConfig).getSocketAddress()).sync();
			f.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}

	public AbstractMqConfig getAbstractMqConfig() {
		return abstractMqConfig;
	}

	public void setAbstractMqConfig(AbstractMqConfig abstractMqConfig) {
		this.abstractMqConfig = abstractMqConfig;
	}
}
