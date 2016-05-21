package com.xinfang.web.eat.modules.account.service;

import java.util.List;

import com.xinfang.web.eat.bean.BaseAccount;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.bean.BaseUserAccount;

public interface AccountService {

	boolean insertTotalAccount(BaseUserAccount baseUserAccount);
	
	boolean insertCommonAccount(BaseAccount baseAccount);
	
	List<BaseAccount> commonAccount(BaseUser baseUser);
}
