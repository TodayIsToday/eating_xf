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
import com.xinfang.web.eat.modules.account.entity.AccountCommonEntity;
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
	public boolean insertCommonAccount(BaseAccount baseAccount,BaseUser baseUser) {
//		String userUuid = baseUser.getUserUuid();
		String userUuid = "b1c3c31b-1b82-11e6-bfe5-3c970ed624cf";
		baseAccount.setCreateId(userUuid);
		baseAccount.setUserUuid(userUuid);
		baseAccount.setCreateTime(new DateTime());
		baseAccount.setAccountUuid(UUID.randomUUID().toString());
		Integer accountType = Integer.parseInt(baseAccount.getAccountType());
		Float totalPrice = baseAccount.getTotalPrice();
		boolean flag = false;
		if(accountType!=null && accountType>-1 && accountType<4 && totalPrice>0.00)
			flag = accountMapper.insertAccount(baseAccount)>0;
		return flag;
	}

	@Override
	public AccountCommonEntity commonAccount(BaseUser baseUser) {
		AccountCommonEntity accountCommon = new AccountCommonEntity();
		accountCommon.setBaseAccounts(accountMapper.selectAccounts(baseUser));
		accountCommon.setAccountSum(accountMapper.accountSum(baseUser));
		return accountCommon;
	}

	@Override
	public float balanceOfCard() {
		float balanceOfCard = accountMapper.selectBalanceOfCard();
		return balanceOfCard;
	}

	@Override
	public float personBalanceOfCard(String loginName, String userUuid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccountDetails> selectBalanceOfCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDetails selectPersonBalanceOfCard() {
		// TODO Auto-generated method stub
		return null;
	}



}
