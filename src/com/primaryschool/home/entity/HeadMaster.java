package com.primaryschool.home.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: HeadMaster
* @Description: TODO 校长 实体类
* @author Mingshan
* @date 2017年4月1日 上午9:31:37
*
 */


@Entity
@Table(name="ps_headmaster")
public class HeadMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="headmaster_name")
	private String name;
	
	@Column(name="headmaster_post")
	private String post;
	
	@Column(name="headmaster_work")
	private String work;

	@Column(name="headmaster_email")
	private String email;
	
	@Column(name="headmaster_avatar")
	private String avatar;


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "HeadMaster [id=" + id + ", name=" + name + ", post=" + post + ", work=" + work + ", email=" + email
				+ ", avatar=" + avatar + "]";
	}
	
	
	
}
