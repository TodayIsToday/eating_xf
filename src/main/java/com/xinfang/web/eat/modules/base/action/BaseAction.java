package com.xinfang.web.eat.modules.base.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xinfang.web.eat.bean.BaseRole;
import com.xinfang.web.eat.bean.BaseUser;
import com.xinfang.web.eat.modules.account.service.AccountService;
import com.xinfang.web.eat.modules.login.service.LoginService;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	

	@Autowired
	protected LoginService loginService;
	@Autowired
	protected AccountService accountService;


	// ---------------------------------------------------------------------------
	// Request, Response, Session
	// ---------------------------------------------------------------------------
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public ActionContext getContext() {
		return ActionContext.getContext();
	}
	
	// 获取当前登录者
	public BaseUser getCurrentUser(){
		
		return loginService.getCurrentLoginUser();
	}
	
	// 获取当前用户角色
	public List<BaseRole> getCurrentUserRole(){
		
		return loginService.getCurrentLoginUserRole();
	}
	// 获取当前用户余额
	public float getCurrentUserBalanceOfCard(){
		
		float balanceOfcard =  accountService.currentUserBalanceOfCard().getPersonBalanceOfCare();
		
		return balanceOfcard;
	}
}
