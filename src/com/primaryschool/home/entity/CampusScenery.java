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
* @ClassName: CampusScenery
* @Description: TODO 校园风光  - 实体类
* @author Mingshan
* @date 2017年4月18日 下午8:17:27
*
 */

@Entity
@Table(name="ps_campus_scenery")
public class CampusScenery implements Serializable{

	private static final long serialVersionUID = 2437820826154497922L;

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
