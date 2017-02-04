package com.mq.constant;

/**
 * ClassName:ConstantUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年1月18日 下午11:08:16 <br/>
 * 
 * @author 神经刀
 * @version 0.1
 * @since JDK 1.8
 * @see Copyright (c) 2017, wswangbo007@163.com All Rights Reserved.
 */
public interface ConstantUtil {
	
	/**
	 * 网络
	  * @ClassName: NETTYWORK
	  * @Description: TODO
	  * @author 神经刀
	  * @date 2017年1月18日 下午11:09:07
	  * 
	  * @since    JDK 1.8
	 */
	public interface NETTYWORK {
		
		/**
		 * 编码格式
		 */
		final String CODING = "GBK";
		
		/**
		 * TODO 临时使用,后期改为序列化对象
		 * 心跳包内容  
		 */
		final String HEARTBEATTEXT = "心跳包... ...\r\n";

		/**
		 * TODO 后期改成配置文件<br>
		 * 端口号
		 */
		final int PROT = 8888;
		
	}

	public interface CACHEDATA {
		
		final int INITSIZE = Integer.MAX_VALUE;
	}
}
