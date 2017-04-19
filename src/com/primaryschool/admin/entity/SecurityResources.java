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
* @ClassName: SecurityResources
* @Description: TODO  资源实体类
* @author Mingshan
* @date 2017年4月18日 下午4:51:13
*
 */
@Entity
@Table(name="ps_security_resources")
public class SecurityResources implements Serializable{

	
	private static final long serialVersionUID = 56849239395994210L;

	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="value")
	private String value;
	
	@Column(name="permission")
	private String permission;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
