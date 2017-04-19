package com.primaryschool.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: SecurityRoleToPermission
* @Description: TODO 角色与权限对应实体类
* @author Mingshan
* @date 2017年4月18日 下午5:04:44
*
 */

@Entity
@Table(name="ps_security_role_permission")
public class SecurityRoleToPermission implements Serializable{


	private static final long serialVersionUID = 2900382285165238636L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="permission_id")
	private int permissionId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	
	
}
