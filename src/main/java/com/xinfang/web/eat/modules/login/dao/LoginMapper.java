package com.xinfang.web.eat.modules.login.dao;


import java.util.List;

import com.xinfang.web.eat.bean.BaseRole;
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
	BaseUser getLoginUser(String userName);
	
	/**
	 * 获取当前用户角色
	 * @return
	 */
	List<BaseRole> getCurrentLoginUserRole(String userName);
	
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
}
