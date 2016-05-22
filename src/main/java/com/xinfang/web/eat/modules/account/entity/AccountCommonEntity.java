package com.xinfang.web.eat.modules.account.entity;

import java.util.List;

import com.xinfang.web.eat.bean.BaseAccount;

public class AccountCommonEntity {
	/**消费记录*/
	private List<BaseAccount> baseAccounts;
	/**历史消费总计*/
	private float accountSum;
	
	public List<BaseAccount> getBaseAccounts() {
		return baseAccounts;
	}
	public void setBaseAccounts(List<BaseAccount> baseAccounts) {
		this.baseAccounts = baseAccounts;
	}
	public float getAccountSum() {
		return accountSum;
	}
	public void setAccountSum(float accountSum) {
		this.accountSum = accountSum;
	}
	
	
}
