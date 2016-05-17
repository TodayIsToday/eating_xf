package com.xinfang.web.eat.bean;

import java.io.Serializable;

/**
 * 用户表
 * @author hk
 *
 */
public class BaseUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String userUuid;
	
	protected String UserName;
	
	protected String password;
	
	protected String loginName;
	
	protected String mobliePhone;
	
	protected String email;

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMobliePhone() {
		return mobliePhone;
	}

	public void setMobliePhone(String mobliePhone) {
		this.mobliePhone = mobliePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
