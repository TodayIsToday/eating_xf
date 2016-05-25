package com.xinfang.web.eat.modules.account.dao;

import java.util.List;

import com.xinfang.web.eat.bean.BaseAccount;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.bean.BaseUserAccount;
import com.xinfang.web.eat.modules.account.entity.AccountCommonEntity;
import com.xinfang.web.eat.modules.account.entity.AccountDetails;

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
	List<AccountCommonEntity> selectAccounts(BaseUser baseUser);
	
	/**
	 * 卡内应有余额
	 * @return
	 */
	float selectBalanceOfCard();
	
	/**
	 * @param userUuid 
	 * @return
	 */
	List<AccountDetails> personBalanceOfCard( String userUuid);
	
	/**
	 * 查询消费历史总计
	 */
	Float accountSum(BaseUser baseUser);
}
