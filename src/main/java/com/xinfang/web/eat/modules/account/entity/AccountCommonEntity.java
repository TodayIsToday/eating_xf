package com.xinfang.web.eat.modules.account.entity;

import java.io.Serializable;

import com.xinfang.web.eat.bean.BaseAccount;

public class AccountCommonEntity extends BaseAccount implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String accountTypeName;
	
	private String dateTime;

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		Integer typeName = Integer.valueOf(accountTypeName);
		switch (typeName) {
		case 0:
			this.accountTypeName = "早饭";
			break;
		case 1:
			this.accountTypeName = "中饭";
			break;
		case 2:
			this.accountTypeName = "晚饭";
			break;
		case 3:
			this.accountTypeName = "其他";
			break;
		}
		
	}
	
	
	
	
}
