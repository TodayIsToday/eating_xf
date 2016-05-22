package com.xinfang.web.eat.modules.account.entity;

import java.io.Serializable;

/**
 * 账户明细列表展示数据
 * @author hk
 *
 */
public class AccountDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**卡内余额*/
	private float personBalanceOfCare;
	
	private String userUuid;
	
	private String loginName;
	
	private String userName;

	
	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public float getPersonBalanceOfCare() {
		return personBalanceOfCare;
	}

	public void setPersonBalanceOfCare(float personBalanceOfCare) {
		this.personBalanceOfCare = personBalanceOfCare;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

}
