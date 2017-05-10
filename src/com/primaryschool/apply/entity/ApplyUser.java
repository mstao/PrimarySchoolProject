package com.primaryschool.apply.entity;

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
* @ClassName: ApplyUser
* @Description: TODO 报名用户表
* @author Mingshan
* @date 2017年4月30日 下午2:15:34
*
 */
@Entity
@Table(name="ps_apply_user")
public class ApplyUser implements Serializable{


	private static final long serialVersionUID = 7595901396782670170L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="card_code")
	@Index(name = "idx_sys_apply_user_cardCode")
	private String cardCode;
	
	@Column(name="add_time")
	private String addTime;
	
	@Column(name="salt")
	private String salt;
	
	@Column(name="email")
	private String email;
	
	//过期时间
	@Column(name="out_date")
	private Long outDate;
	
	//验证
	@Column(name="validataCode")
	private String validataCode;
	
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
	public String getCardCode() {
		return cardCode;
	}
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getOutDate() {
		return outDate;
	}
	public void setOutDate(Long outDate) {
		this.outDate = outDate;
	}
	public String getValidataCode() {
		return validataCode;
	}
	public void setValidataCode(String validataCode) {
		this.validataCode = validataCode;
	}

}
