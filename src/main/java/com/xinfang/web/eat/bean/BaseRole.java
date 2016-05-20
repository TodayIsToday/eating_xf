package com.xinfang.web.eat.bean;

import java.io.Serializable;

/**
 * 角色表
 * 
 * @author hk
 *
 */
public class BaseRole implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String roleUuid;

	protected String roleName;
	
	protected String roleCode;
	
	

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleUuid() {
		return roleUuid;
	}

	public void setRoleUuid(String roleUuid) {
		this.roleUuid = roleUuid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
