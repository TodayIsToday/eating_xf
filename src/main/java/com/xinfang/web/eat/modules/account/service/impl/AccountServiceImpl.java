package com.xinfang.web.eat.modules.account.service.impl;

import java.util.List;

import java.util.UUID;

import org.joda.time.DateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.xinfang.web.eat.bean.BaseAccount;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.bean.BaseUserAccount;
import com.xinfang.web.eat.constant.Globals;
import com.xinfang.web.eat.modules.account.dao.AccountMapper;
import com.xinfang.web.eat.modules.account.entity.AccountDetails;
import com.xinfang.web.eat.modules.account.service.AccountService;
import com.xinfang.web.eat.modules.login.service.LoginService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	/*-------------------------------------------
	|             C O N S T A N T S             |
	============================================*/
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
	/*-------------------------------------------
	|    I N S T A N C E   V A R I A B L E S    |
	============================================*/
	
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private LoginService loginService;
	
	/*-------------------------------------------
	|               M E T H O D S               |
	============================================*/
	
	@Override
	public boolean insertTotalAccount(BaseUserAccount baseUserAccount) {
		
		Assert.notNull(baseUserAccount);
		boolean paySuccess = true;
		
		baseUserAccount.setUserAccountUuid(UUID.randomUUID().toString());
		baseUserAccount.setCreateTime(DateTime.now());
		baseUserAccount.setCreateId(loginService.getCurrentLoginUser().getLoginName());
		int rowNum = accountMapper.insertTotalAccount(baseUserAccount);
		
		if(rowNum != Globals.Flag_Int.YES){
			LOG.info("充值失败");
			paySuccess = false;
		}
		
		return paySuccess;
	}

	@Override
	public boolean insertCommonAccount(BaseAccount baseAccount) {
		return accountMapper.insertAccount(baseAccount)>0;
	}

	@Override
	public List<BaseAccount> commonAccount(BaseUser baseUser) {
		return accountMapper.selectAccounts(baseUser);
	}

	@Override
	public float balanceOfCard() {
		float balanceOfCard = accountMapper.selectBalanceOfCard();
		return balanceOfCard;
	}

	@Override
	public float selectpersonBalanceOfCard(String loginName) {
		BaseUser user = loginService.getUserByLoginName(loginName);
		AccountDetails accountDetail = accountMapper.personBalanceOfCard(user.getUserUuid()).get(0);
		float balanceOfCare = accountDetail.getPersonBalanceOfCare();
		return balanceOfCare;
	}

	@Override
	public List<AccountDetails> selectBalanceOfCard() {
		List<AccountDetails> listDetails= accountMapper.personBalanceOfCard(null);
		// 获取用户姓名
		for (AccountDetails accountDetails : listDetails) {
			String userName = loginService.getUserByUserUuid(accountDetails.getUserUuid()).getUserName();
			accountDetails.setUserName(userName);
		}
		return listDetails;
	}

	@Override
	public AccountDetails currentUserBalanceOfCard() {
		BaseUser user = loginService.getCurrentLoginUser();
		if(null == user){
			LOG.error("当前用户不存在");
			return null;
		}
		AccountDetails accountDetail = accountMapper.personBalanceOfCard(user.getUserUuid()).get(0);
		return accountDetail;
	}



}
