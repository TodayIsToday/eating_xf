package com.xinfang.web.eat.modules.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.xinfang.web.eat.modules.login.dao.LoginMapper;
import com.xinfang.web.eat.modules.login.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	/*-------------------------------------------
	|             C O N S T A N T S             |
	============================================*/
	
	
	/*-------------------------------------------
	|    I N S T A N C E   V A R I A B L E S    |
	============================================*/
	@Autowired
	private LoginMapper loginMapper;
	
	
	/*-------------------------------------------
	|               M E T H O D S               |
	============================================*/
	
	public boolean validateLogin(String userName, String password) {
		
		Assert.notNull(userName);
		
		boolean hasCurrentLoginUser = true;
		
		
		int rowNumber = loginMapper.validateLogin(userName, password);
		
		if(rowNumber != 1){
			hasCurrentLoginUser = false;
		}
		
		return hasCurrentLoginUser;
	}

}
