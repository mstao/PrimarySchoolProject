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
* @ClassName: SecurityUser
* @Description: TODO 后台管理用户 -实体类
* @author Mingshan
* @date 2017年4月14日 上午11:19:03
*
 */

@Entity
@Table(name="ps_security_user")
public class SecurityUser implements Serializable{

	
	
	private static final long serialVersionUID = 4323743486626069648L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="usrname")
	@Index(name = "idx_sys_security_username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	//加点盐
	@Column(name="salt")
	private String salt;
	
	//用户状态
	@Column(name="status")
	private int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
