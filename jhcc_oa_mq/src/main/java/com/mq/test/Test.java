//package com.mq.test;
//
//import com.mq.activemq.send.ActiveMqObjectSend;
//import com.mq.config.ActiveMqConfig;
//import com.mq.integration.MqSend;
//
///** 
// * ClassName:Test <br/> 
// * Function: TODO ADD FUNCTION. <br/> 
// * Reason:   TODO ADD REASON. <br/> 
// * Date:     2017年2月4日 上午12:19:20 <br/> 
// * @author   神经刀
// * @version  0.1
// * @since    JDK 1.8
// * @see       
// * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
// */
//public class Test {
//
//	@org.junit.Test
//	public void testMq() {
//		// TODO 测试active,Kafka
//		ActiveMqConfig activeMqConfig = new ActiveMqConfig("192.168.1.1", "1111");
//		try {
//			MqSend mqsend = new ActiveMqObjectSend(activeMqConfig);
//			mqsend.sendQueueMsg("111");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
