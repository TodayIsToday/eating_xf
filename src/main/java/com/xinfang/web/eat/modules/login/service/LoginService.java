package com.xinfang.web.eat.modules.login.service;


import java.util.List;

import com.xinfang.web.eat.bean.BaseRole;
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
	
	/**
	 * 获取当前用户角色
	 * @return
	 */
	List<BaseRole> getCurrentLoginUserRole();
	
	/**
	 * 获取所有用户
	 * @return
	 */
	List<BaseUser> getAllUsers();
	
	/**
	 * 获取登录者
	 * @return
	 */
	BaseUser getUserByLoginName(String loginName);
	
	/**
	 * 获取用户信息通过userUUid
	 * @return
	 */
	BaseUser getUserByUserUuid(String userUuid);
}
