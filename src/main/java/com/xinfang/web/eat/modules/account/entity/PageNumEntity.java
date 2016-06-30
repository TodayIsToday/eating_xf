package com.xinfang.web.eat.modules.account.entity;

import java.io.Serializable;

import com.xinfang.web.eat.bean.BaseUser;

public class PageNumEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BaseUser baseUser;
	
	private Integer pageNum;
	
	private Integer startRn;
	
	private Integer endRn;
	
	private Integer pageSize = 3;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public BaseUser getBaseUser() {
		return baseUser;
	}

	public void setBaseUser(BaseUser baseUser) {
		this.baseUser = baseUser;
	}

	public Integer getStartRn() {
		this.startRn = (pageNum-1)*pageSize;
		return startRn;
	}

	public void setStartRn(Integer startRn) {
		this.startRn = startRn;
	}

	public Integer getEndRn() {
		return endRn;
	}

	public void setEndRn(Integer endRn) {
		this.endRn = endRn;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	

}
