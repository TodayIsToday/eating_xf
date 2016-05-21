package com.xinfang.web.eat.modules.account.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinfang.web.eat.bean.BaseAccount;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.bean.BaseUserAccount;
import com.xinfang.web.eat.constant.Globals;
import com.xinfang.web.eat.modules.account.dao.AccountMapper;
import com.xinfang.web.eat.modules.account.service.AccountService;

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
	
	/*-------------------------------------------
	|               M E T H O D S               |
	============================================*/
	
	@Override
	public boolean insertTotalAccount(BaseUserAccount baseUserAccount) {
		
		boolean paySuccess = true;
		
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



}
