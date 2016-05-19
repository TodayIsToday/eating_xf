package com.xinfang.web.eat.modules.login.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfang.web.eat.base.action.BaseAction;
import com.xinfang.web.eat.modules.login.service.LoginService;

/**
 * 登录
 * 
 * @author hk
 *
 */
public class LoginAction extends BaseAction {

	/*-------------------------------------------
	 |             C O N S T A N T S             |
	 ============================================*/

	private static final long serialVersionUID = 1L;
	// log4j return log4j
//	private static final Logger LOG = LogManager.getLogger(LoginAction.class);
	
	// logBack return self4j
	static final Logger LOG = LoggerFactory.getLogger(LoginAction.class);
	
	/*-------------------------------------------
	  |    I N S T A N C E   V A R I A B L E S    |
	  ============================================*/

	@Autowired
	private LoginService loginService;
	
	
	private String userName, password;

	/*-------------------------------------------
	  |               M E T H O D S               |
	  ============================================*/

	/**
	 * 初试到登记页面
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		
		loginService.validateLogin(userName, password);
		LOG.trace("Hello World!");
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
