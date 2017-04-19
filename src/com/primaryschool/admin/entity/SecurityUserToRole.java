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
* @ClassName: SecurityUserToRole
* @Description: TODO  用户与角色关联表
* @author Mingshan
* @date 2017年4月18日 下午4:55:38
*
 */

@Entity
@Table(name="ps_security_user_to_role")
public class SecurityUserToRole implements Serializable{


	private static final long serialVersionUID = 5329074986291411851L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="user_id")
	private int userId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
