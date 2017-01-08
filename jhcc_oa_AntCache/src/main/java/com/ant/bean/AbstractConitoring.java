package com.ant.bean;

/** 
 * 监控对象
 * ClassName:AbstractConitoring <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月19日 上午12:43:43 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see      
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public abstract class AbstractConitoring {

	protected ReportBean reportBean;
	
	protected StringBuffer content;
	
	/**
	  * setContent(设置内容)
	  * @Title: setContent
	  * @Description: TODO
	  * @param     设定文件
	  * @return void    返回类型
	 */
	protected void setContent() {
		reportBean.setContent(content);
	}
	
	/**
	  * getContent(获取内容)
	  * @Title: getContent
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return String    返回类型
	 */
	protected abstract String getContent();
	
	protected void performance() {
		// TODO 设置时间调度
	}

	/**
	  * 创建一个新的实例 AbstractConitoring. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  */
	public AbstractConitoring() {};
	
	public AbstractConitoring(ReportBean reportBean) {
		super();
		this.reportBean = reportBean;
	};

	public ReportBean getReportBean() {
		return reportBean;
	}

	public void setReportBean(ReportBean reportBean) {
		this.reportBean = reportBean;
	}
}