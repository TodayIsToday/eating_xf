package com.xinfang.web.eat.modules.account.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfang.web.eat.base.action.BaseAction;
import com.xinfang.web.eat.modules.login.service.LoginService;

/**
 * 账本
 * 
 * @author st
 *
 */
public class AccountAction extends BaseAction {

	/*-------------------------------------------
	 |             C O N S T A N T S             |
	 ============================================*/

	private static final long serialVersionUID = 1L;
	// log4j return log4j
//	private static final Logger LOG = LogManager.getLogger(LoginAction.class);
	
	// logBack return self4j
	static final Logger LOG = LoggerFactory.getLogger(AccountAction.class);
	
	/*-------------------------------------------
	  |    I N S T A N C E   V A R I A B L E S    |
	  ============================================*/

	@Autowired
	private LoginService loginService;
	
	
	

	/*-------------------------------------------
	  |               M E T H O D S               |
	  ============================================*/
	/**
	 * 记账
	 * @return
	 */
	public String excute(){
		return SUCCESS;
	}

	
	
	
	
	


}
