package com.primaryschool.home.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: Contact
* @Description: TODO 联系我们 -实体类
* @author Mingshan
* @date 2017年4月20日 下午10:14:45
*
 */

@Entity
@Table(name="ps_contact")
public class Contact implements Serializable{
	

	private static final long serialVersionUID = -5074983223187453299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="content")
	private String content;
	
	@Column(name="author")
	private String author;
	
	@Column(name="add_time")
	private String addTime;
	
	@Column(name="is_publish")
	private int isPublish;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(int isPublish) {
		this.isPublish = isPublish;
	}
	
	
}
