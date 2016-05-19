package com.xinfang.web.eat.modules.login.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinfang.web.eat.base.action.BaseAction;
import com.xinfang.web.eat.constant.SessionKey;

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
	
	private String userName, password;

	/*-------------------------------------------
	  |               M E T H O D S               |
	  ============================================*/

	/**
	 * 初试到登记页面
	 * @return
	 */
	public String init() {
		
		// TODO init data
		LOG.trace("Hello World!");
	
		return SUCCESS;
	}
	
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
