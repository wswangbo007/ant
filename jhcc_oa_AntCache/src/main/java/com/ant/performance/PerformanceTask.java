package com.ant.performance;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;
import java.util.concurrent.Callable;

import com.ant.bean.PerformanceBean;

/** 
 * 
 * ClassName:PerformanceTask <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月19日 上午12:59:31 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class PerformanceTask implements Callable<PerformanceBean> {
	
	/**
	  * getPerformanceBean(获取JVM堆信息)
	  * @Title: getPerformanceBean
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return PerformanceBean    返回类型
	  * @throws
	 */
	private PerformanceBean getPerformanceBean() {
		return null;
	}

	/**
	  * <p>Title: call</p>
	  * <p>Description: 实时调用</p>
	  * @return
	  * @throws Exception
	  * @see java.util.concurrent.Callable#call()
	  */
	@Override
	public PerformanceBean call() throws Exception {
		return null == this.getPerformanceBean() ? new PerformanceBean() : this.getPerformanceBean();
	}
}
