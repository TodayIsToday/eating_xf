package com.xinfang.web.eat.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户充值表
 * 
 * @author hk
 *
 */
public class BaseUserAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String userAccountUuid;

	protected String userUuid;

	protected float totalAccount;

	protected String createId;

	protected String updateId;

	protected Date createTime;

	protected Date updateTime;

	
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserAccountUuid() {
		return userAccountUuid;
	}

	public void setUserAccountUuid(String userAccountUuid) {
		this.userAccountUuid = userAccountUuid;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public float getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(float totalAccount) {
		this.totalAccount = totalAccount;
	}

}
