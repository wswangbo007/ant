package com.ant.network;

import com.ant.constant.ConstantUtil;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * ClassName:MyIdleHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年1月18日 下午11:11:00 <br/>
 * 
 * @author 神经刀
 * @version 0.1
 * @since JDK 1.8
 * @see Copyright (c) 2017, wswangbo007@163.com All Rights Reserved.
 */
public class MyIdleHandler extends ChannelHandlerAdapter {

	/**
	 * <p>
	 * Title: bind
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param ctx
	 * @param localAddress
	 * @param promise
	 * @throws Exception
	 * @see io.netty.channel.ChannelHandlerAdapter#bind(io.netty.channel.ChannelHandlerContext,
	 *      java.net.SocketAddress, io.netty.channel.ChannelPromise)
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			if (e.state() == IdleState.READER_IDLE) {
				ctx.writeAndFlush(ConstantUtil.NETTYWORK.HEARTBEATTEXT);
				ctx.close();
			} else if (e.state() == IdleState.WRITER_IDLE) {
				ctx.writeAndFlush(ConstantUtil.NETTYWORK.HEARTBEATTEXT);
				ctx.close();
			} else if (e.state() == IdleState.ALL_IDLE) {
				ctx.writeAndFlush(ConstantUtil.NETTYWORK.HEARTBEATTEXT);
			}
		}
	}

}