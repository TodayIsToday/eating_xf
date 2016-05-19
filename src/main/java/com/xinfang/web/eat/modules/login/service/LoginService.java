package com.xinfang.web.eat.modules.login.service;

import com.xinfang.web.eat.bean.BaseUser;

/**
 * 登录接口
 * @author hk
 *
 */
public interface LoginService {
	/**
	 * 登录校验，暂时只校验用户名
	 * @param userName
	 * @param password
	 * @return
	 */
	boolean validateLogin(final String userName ,final String password);
	
	/**
	 * 获取登录者
	 * @return
	 */
	BaseUser getCurrentLoginUser();
}
