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
* @ClassName: CopyRight
* @Description: TODO 版权声明
* @author Mingshan
* @date 2017年4月20日 下午10:21:44
*
 */

@Entity
@Table(name="ps_copyright")
public class CopyRight implements Serializable{

	private static final long serialVersionUID = -404761414119775762L;

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
