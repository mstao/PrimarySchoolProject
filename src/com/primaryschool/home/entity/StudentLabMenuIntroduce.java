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
* @ClassName: StudentLabMenuIntroduce
* @Description: TODO  综合实验课简介
* @author Mingshan
* @date 2017年4月7日 下午5:24:03
*
 */


@Entity
@Table(name="ps_student_lab_menu_intro")
public class StudentLabMenuIntroduce implements Serializable{
	 
	
	private static final long serialVersionUID = -2228618426261505521L;

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Column(name="introduce")
	  private String introduce;
	  
	  @Column(name="menu_id")
	  private int menuId;
	  
	  
	public StudentLabMenuIntroduce() {
		super();
	}

		//根据LabId(menuId)获取intro信息
		public StudentLabMenuIntroduce(int id, String introduce) {
			super();
			this.id = id;
			this.introduce = introduce;
		}
		  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	  
	  
}
