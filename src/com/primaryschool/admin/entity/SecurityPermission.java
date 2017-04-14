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
* @ClassName: SecurityPermission
* @Description: TODO 权限 实体类
* @author Mingshan
* @date 2017年4月14日 上午11:24:34
*
 */

@Entity
@Table(name="ps_security_permission")
public class SecurityPermission implements Serializable{


	private static final long serialVersionUID = -3932443130930166310L;

	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="permission_name")
	private String permissionName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	
}
