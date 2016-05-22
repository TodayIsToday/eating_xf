package com.xinfang.web.eat.modules.login.service.impl;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinfang.web.eat.bean.BaseRole;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.constant.Globals;
import com.xinfang.web.eat.constant.SessionKey;
import com.xinfang.web.eat.modules.login.dao.LoginMapper;
import com.xinfang.web.eat.modules.login.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	/*-------------------------------------------
	|             C O N S T A N T S             |
	============================================*/
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);
	/*-------------------------------------------
	|    I N S T A N C E   V A R I A B L E S    |
	============================================*/
	@Autowired
	private LoginMapper loginMapper;
	
	
	/*-------------------------------------------
	|               M E T H O D S               |
	============================================*/
	
	public boolean validateLogin(String userName, String password) {
		
		boolean hasCurrentLoginUser = true;
		
		int rowNumber = loginMapper.validateLogin(userName, password);
		
		if(rowNumber != Globals.Flag_Int.YES){
			hasCurrentLoginUser = false;
		}
		
		return hasCurrentLoginUser;
	}


	@Override
	public BaseUser getCurrentLoginUser() {
		String sessionLoginName = (String)ServletActionContext.getRequest()
				.getSession().getAttribute(SessionKey.LOGIN_USER_SESSION_KEY);
		if(StringUtils.isBlank(sessionLoginName)){
			LOG.error("session 值为空");
		}
		BaseUser loginUser = loginMapper.getLoginUser( sessionLoginName );
		return loginUser;
	}


	@Override
	public List<BaseRole> getCurrentLoginUserRole() {
		String sessionLoginName = (String)ServletActionContext.getRequest()
				.getSession().getAttribute(SessionKey.LOGIN_USER_SESSION_KEY);
		if(StringUtils.isBlank(sessionLoginName)){
			LOG.error("session 值为空");
		}
		
		List<BaseRole> loginUserRole = loginMapper.getCurrentLoginUserRole(sessionLoginName);
		
		return loginUserRole;
	}


	@Override
	public List<BaseUser> getAllUsers() {
			
		return loginMapper.getAllUsers();
	}


	@Override
	public BaseUser getUserByLoginName(String loginName) {
		BaseUser user = loginMapper.getLoginUser(loginName);
		return user;
	}


	@Override
	public BaseUser getUserByUserUuid(String userUuid) {
		BaseUser user = loginMapper.getLoginUserByUuid(userUuid);
		return user;
	}

}
