package com.xinfang.web.eat.modules.login.dao;

import com.xinfang.web.eat.bean.BaseUser;

/**
 * 登录mapper
 * @author hk
 *
 */
public interface LoginMapper {

	/**
	 * 登录验证
	 * @param userName
	 * @param password
	 * @return
	 */
	int validateLogin(String userName ,String password);
	
	/**
	 * 获取登录者
	 * @param userName
	 * @param password
	 * @return
	 */
	BaseUser getLoginUser(final String userName );
}
