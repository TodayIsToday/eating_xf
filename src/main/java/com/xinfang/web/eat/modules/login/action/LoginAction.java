package com.xinfang.web.eat.modules.login.action;

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

	/*-------------------------------------------
	  |    I N S T A N C E   V A R I A B L E S    |
	  ============================================*/

	@Autowired
	private LoginService loginService;
	
	
	private String userName, password;

	/*-------------------------------------------
	  |               M E T H O D S               |
	  ============================================*/

	public String login() throws Exception{
		
		loginService.validateLogin(userName, password);
		
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
