package com.xinfang.web.eat.modules.account.action;

import java.util.Collections;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.bean.BaseUserAccount;
import com.xinfang.web.eat.modules.account.service.AccountService;
import com.xinfang.web.eat.modules.base.action.BaseAction;


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
	
	static final Logger LOG = LoggerFactory.getLogger(AccountAction.class);
	
	/*-------------------------------------------
	  |    I N S T A N C E   V A R I A B L E S    |
	  ============================================*/
	/**所有用户*/
	public List<BaseUser> xfUserList = Collections.emptyList();
	
	/**充值bean*/
	private BaseUserAccount baseUserAccount;
	/**异步返回标志*/
	private boolean ajaxFlg;
	
	@Autowired
	private AccountService accountService;
	/*-------------------------------------------
	  |               M E T H O D S               |
	  ============================================*/

	/**
	 * 初试化
	 * @return
	 */
	public String init(){
		
		xfUserList = loginService.getAllUsers();
		return SUCCESS;
	}
	
	
	/**
	 * 普通用户记账
	 */
	
	
	/**
	 * 管理员充值
	 * @return
	 */
	public String payment(){
		ajaxFlg = accountService.insertTotalAccount(baseUserAccount);
		return SUCCESS;
	}
	
	/*-------------------------------------------
	 |        G E T T E R && S E T T E R          |
	 ============================================*/
	@JSON(serialize=false)
	public BaseUserAccount getBaseUserAccount() {
		return baseUserAccount;
	}

	public void setBaseUserAccount(BaseUserAccount baseUserAccount) {
		this.baseUserAccount = baseUserAccount;
	}
	public boolean isAjaxFlg() {
		return ajaxFlg;
	}

	public void setAjaxFlg(boolean ajaxFlg) {
		this.ajaxFlg = ajaxFlg;
	}
	


}
