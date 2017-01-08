package com.ant.bean;
/** 
 * ClassName:ReportBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月19日 上午12:51:46 <br/> 
 * @author   神经刀
 * @version  0.1
 * @since    JDK 1.8
 * @see       
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class ReportBean {
	
	/**邮箱*/
	protected String email;
	
	/**密码*/
	protected String password;
	
	/**内容*/
	protected StringBuffer content;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StringBuffer getContent() {
		return content;
	}

	public void setContent(StringBuffer content) {
		this.content = content;
	}

	public ReportBean(String email, String password, StringBuffer content) {
		super();
		this.email = email;
		this.password = password;
		this.content = content;
	}

	public ReportBean() {
		super();
	}
}