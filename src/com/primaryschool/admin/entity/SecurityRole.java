package com.primaryschool.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
/**
 * 
* @ClassName: SecurityRole
* @Description: TODO 角色实体类
* @author Mingshan
* @date 2017年4月14日 上午11:13:53
*
 */
@Entity
@Table(name="ps_security_role")
public class SecurityRole implements Serializable{


	private static final long serialVersionUID = 1709893841250076200L;
	  
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="role_name")
	@Index(name = "idx_sys_security_role_name")
	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
