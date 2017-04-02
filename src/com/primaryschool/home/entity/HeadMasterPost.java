package com.primaryschool.home.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ps_headmaster_post")
public class HeadMasterPost {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="psot_name")
	private String  postName;
	
	   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	   
	   
}
