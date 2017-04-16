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
* @ClassName: IndexImages
* @Description: TODO 首页轮播图片 实体
* @author Mingshan
* @date 2017年4月16日 下午3:50:30
*
 */

@Entity
@Table(name="ps_index_images")
public class IndexImages implements Serializable{


	private static final long serialVersionUID = -5138087184937924876L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="img_path")
	private String imgPath;
	
	@Column(name="add_time")
	private String addTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
}
