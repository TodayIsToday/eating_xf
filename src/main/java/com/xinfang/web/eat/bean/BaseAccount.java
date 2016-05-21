package com.xinfang.web.eat.bean;

import java.io.Serializable;

import org.joda.time.DateTime;

/**
 * 账单表
 * @author hk
 *
 */
public class BaseAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected String accountUuid;
	/** 单次消费总价 */
	protected float totalPrice;
	/** 账单类型 */
	protected String accountType;
	
	protected String userUuid;
	
	protected String createId;
	
	protected String updateId;
	
	protected DateTime createTime;
	
	protected DateTime updateTime;

	public String getAccountUuid() {
		return accountUuid;
	}

	public void setAccountUuid(String accountUuid) {
		this.accountUuid = accountUuid;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public DateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}

	public DateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(DateTime updateTime) {
		this.updateTime = updateTime;
	}


	
	
}
