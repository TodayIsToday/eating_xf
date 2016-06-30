package com.xinfang.web.eat.modules.login.action;


import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinfang.web.eat.constant.SessionKey;
import com.xinfang.web.eat.modules.base.action.BaseAction;

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
	
	static final Logger LOG = LoggerFactory.getLogger(LoginAction.class);
	
	/*-------------------------------------------
	  |    I N S T A N C E   V A R I A B L E S    |
	  ============================================*/
	
	private String userName, password;
	public Date test;
	public DateTime test2;
	

	/*-------------------------------------------
	  |               M E T H O D S               |
	  ============================================*/

	/**
	 * 登录验证
	 * @return
	 */
	public String login(){
		if(null != getCurrentUser()){
			return SUCCESS;
		}
		// 校验
		boolean isSuccessLogin = loginService.validateLogin(userName, password);
		if(isSuccessLogin){
			// 记录session
			getSession().setAttribute(SessionKey.LOGIN_USER_SESSION_KEY, userName);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 注销
	 * @return
	 */
	public String logout(){
			
		getSession().removeAttribute(SessionKey.LOGIN_USER_SESSION_KEY);
		return SUCCESS;
	}
	
	
	/*-------------------------------------------
	 |        G E T T E R && S E T T E R          |
	 ============================================*/
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
