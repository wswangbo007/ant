package com.ant.bean;
/** 
 * ClassName:PerformanceBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月19日 上午1:00:05 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class PerformanceBean {

	/**最大堆内存*/
	private Long maxHeap;
	
	/**用户堆内存*/
	private Long useHeap;

	public Long getMaxHeap() {
		return maxHeap;
	}

	public void setMaxHeap(Long maxHeap) {
		this.maxHeap = maxHeap;
	}

	public Long getUseHeap() {
		return useHeap;
	}

	public void setUseHeap(Long useHeap) {
		this.useHeap = useHeap;
	}

	public PerformanceBean(Long maxHeap, Long useHeap) {
		super();
		this.maxHeap = maxHeap;
		this.useHeap = useHeap;
	}

	public PerformanceBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}