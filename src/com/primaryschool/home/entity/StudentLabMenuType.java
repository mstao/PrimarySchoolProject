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
* @ClassName: StudentLabMenuType
* @Description: TODO  综合实验课  - 类型  - 实体类
* @author Mingshan
* @date 2017年4月7日 下午4:46:34
*
 */

@Entity
@Table(name="ps_student_lab_menu")
public class StudentLabMenuType implements Serializable{


	private static final long serialVersionUID = 6540809273788575016L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	
	@Column(name="item_title")
	private  String menuName;
	
	@Column(name="item_type_flag")
	private  String menuTypeFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuTypeFlag() {
		return menuTypeFlag;
	}

	public void setMenuTypeFlag(String menuTypeFlag) {
		this.menuTypeFlag = menuTypeFlag;
	}
	
	
	
}
