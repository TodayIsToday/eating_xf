package com.xinfang.web.eat.modules.account.action;

import java.util.Collections;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinfang.web.eat.bean.BaseAccount;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.bean.BaseUserAccount;
import com.xinfang.web.eat.modules.account.entity.AccountDetails;
import com.xinfang.web.eat.modules.account.entity.AccountCommonEntity;
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
	/**消费bean*/
	private BaseAccount baseAccount;
	
	/**消费历史页面*/
	private List<AccountCommonEntity> accountCommons;
	
	/**消费记录*/
	public List<BaseAccount> baseAccounts = Collections.emptyList();
	/**所有用户账户余额*/
	public List<AccountDetails> acciontDetails = Collections.emptyList();
	/*-------------------------------------------
	  |               M E T H O D S               |
	  ============================================*/

	/**
	 * 初试化
	 * @return
	 */
	public String init(){
		// 用户列表
		xfUserList = loginService.getAllUsers();
		// 账户余额列表
		acciontDetails = accountService.selectBalanceOfCard();
		return SUCCESS;
	}
	
	
	/**
	 * 普通用户账户明细
	 */
	public String common(){
		BaseUser baseUser = loginService.getCurrentLoginUser();
		if(baseUser!=null){
			accountCommons = accountService.commonAccount(baseUser);
		}
		return SUCCESS;
	}
	/**
	 * 普通用户记账
	 * @return
	 */
	public String insertCommon(){
		BaseUser baseUser = loginService.getCurrentLoginUser();
		return accountService.insertCommonAccount(baseAccount,baseUser)?SUCCESS:ERROR;
	}
	
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
	@JSON(serialize=false)
	public BaseAccount getBaseAccount() {
		return baseAccount;
	}
	public void setBaseAccount(BaseAccount baseAccount) {
		this.baseAccount = baseAccount;
	}


	public List<AccountCommonEntity> getAccountCommons() {
		return accountCommons;
	}


	public void setAccountCommons(List<AccountCommonEntity> accountCommons) {
		this.accountCommons = accountCommons;
	}

	
}
