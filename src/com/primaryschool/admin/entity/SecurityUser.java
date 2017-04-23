package com.primaryschool.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

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
@Table(name="ps_security_user",uniqueConstraints = {@UniqueConstraint(columnNames={"username","email","number"})})
public class SecurityUser implements Serializable{

	
	
	private static final long serialVersionUID = 4323743486626069648L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	@Index(name = "idx_sys_security_username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	//加点盐
	@Column(name="salt")
	private String salt;
	
	//用户状态
	@Column(name="status")
	private int status;
	
	//用户邮箱
	@Column(name="email")
	@Index(name = "idx_sys_security_email")
	private String email;
	
	//工号
	@Column(name="number")
	@Index(name = "idx_sys_security_number")
	private String number;
	
	//注册时间
	@Column(name="add_time")
	private String addTime;
	
	@Transient
	private String roleName;
	
	@Transient
	private String permissionName;
	
	public SecurityUser(){}
	
	
	/**
	 * 
	* <p>Title: </p>
	* <p>Description: 用于获取角色</p>
	* @param id
	* @param username
	* @param roleName
	 */
	public SecurityUser(int id, String userName, String roleName) {
		super();
		this.id = id;
		this.userName = userName;
		this.roleName = roleName;
	}


	/**
	 * 
	* <p>Title: </p>
	* <p>Description: 用于获取permission </p>
	* @param id
	* @param username
	* @param roleName
	* @param permissionName
	 */
	public SecurityUser(int id, String userName, String roleName, String permissionName) {
		super();
		this.id = id;
		this.userName = userName;
		this.roleName = roleName;
		this.permissionName = permissionName;
	}

	
	

	/**
	 * 
	* <p>Title: </p>
	* <p>Description:用户分配角色 </p>
	* @param id
	* @param userName
	* @param status
	* @param email
	* @param number
	* @param roleName
	 */
	public SecurityUser(int id, String userName, int status, String email, String number, String roleName) {
		super();
		this.id = id;
		this.userName = userName;
		this.status = status;
		this.email = email;
		this.number = number;
		this.roleName = roleName;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getAddTime() {
		return addTime;
	}


	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
	
}
