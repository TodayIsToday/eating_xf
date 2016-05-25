package com.xinfang.web.eat.modules.account.service;

import java.util.List;

import com.xinfang.web.eat.bean.BaseAccount;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.bean.BaseUserAccount;
import com.xinfang.web.eat.modules.account.entity.AccountCommonEntity;
import com.xinfang.web.eat.modules.account.entity.AccountDetails;

/**
 * 
 * @author st && hk
 *
 */
public interface AccountService {

	/**
	 * 充值
	 * @param baseUserAccount
	 * @return
	 */
	boolean insertTotalAccount(BaseUserAccount baseUserAccount);
	
	/**
	 * 记录单笔账目表数据
	 * @param baseAccount
	 * @return
	 */
	boolean insertCommonAccount(BaseAccount baseAccount,BaseUser baseUser);
	
	/**
	 * 查询消费记录
	 * @param baseUser
	 * @return
	 */
	List<AccountCommonEntity> commonAccount(BaseUser baseUser);
	
	/**
	 * 卡内应有余额
	 * @return
	 */
	float balanceOfCard();
	
	/**
	 * 查询用户账户余额
	 * @param loginName
	 * @return
	 */
	float selectpersonBalanceOfCard(String loginName );
	
	/**
	 * 查询所有用户账户余额列表
	 * @param userUuid 
	 * @return
	 */
	List<AccountDetails> selectBalanceOfCard();
	
	/**
	 * 查询账当前用户账户余额
	 * @param userUuid 
	 * @return
	 */
	AccountDetails currentUserBalanceOfCard();
}
