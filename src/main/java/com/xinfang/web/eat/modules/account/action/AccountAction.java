package com.xinfang.web.eat.modules.account.action;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.json.annotations.JSON;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfang.web.eat.bean.BaseAccount;
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
	
	/**消费bean*/
	private BaseAccount baseAccount;
	/**消费记录*/
	private List<BaseAccount> baseAccounts;
	
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
	 * 普通用户账户明细
	 */
	public String common(){
//		BaseUser baseUser = loginService.getCurrentLoginUser();
		BaseUser baseUser = new BaseUser();
		baseUser.setUserUuid("b1c3c31b-1b82-11e6-bfe5-3c970ed624cf");
		if(baseUser!=null)
			baseAccounts = accountService.commonAccount(baseUser);
		return SUCCESS;
	}
	/**
	 * 普通用户记账
	 */
	public String insertCommon(){
//		BaseUser baseUser = loginService.getCurrentLoginUser();
//		String userUuid = baseUser.getUserUuid();
		String userUuid = "b1c3c31b-1b82-11e6-bfe5-3c970ed624cf";
		baseAccount.setCreateId(userUuid);
		baseAccount.setUserUuid(userUuid);
		baseAccount.setCreateTime(new DateTime());
		baseAccount.setAccountUuid(UUID.randomUUID().toString());
		Integer accountType = Integer.parseInt(baseAccount.getAccountType());
		Float totalPrice = baseAccount.getTotalPrice();
		if(accountType!=null && accountType>-1 && accountType<4 && totalPrice>0.00)
			return accountService.insertCommonAccount(baseAccount)?SUCCESS:ERROR;
		return ERROR;
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


	public BaseAccount getBaseAccount() {
		return baseAccount;
	}


	public void setBaseAccount(BaseAccount baseAccount) {
		this.baseAccount = baseAccount;
	}


	public List<BaseAccount> getBaseAccounts() {
		return baseAccounts;
	}


	public void setBaseAccounts(List<BaseAccount> baseAccounts) {
		this.baseAccounts = baseAccounts;
	}
	


}
