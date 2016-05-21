package com.xinfang.web.eat.modules.account.dao;

import java.util.List;

import com.xinfang.web.eat.bean.BaseAccount;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.bean.BaseUserAccount;

/**
 * 
 * 账目相关
 *
 */
public interface AccountMapper {

	/**
	 * 记录单笔账目表数据
	 * @param baseAccount
	 * @return
	 */
	int insertAccount(BaseAccount baseAccount);
	
	/**
	 * 更新单笔账单
	 * @param baseAccount
	 * @return
	 */
	int deleteBeforeData(BaseAccount baseAccount);
	
	/**
	 * 充值
	 * @param baseUserAccount
	 * @return
	 */
	int insertTotalAccount(BaseUserAccount baseUserAccount);
	
	/**
	 * 查询消费记录
	 * @param baseUser
	 * @return
	 */
	List<BaseAccount> selectAccounts(BaseUser baseUser);
}
