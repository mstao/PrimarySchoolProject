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
* @ClassName: TeachingResourcesClass
* @Description: TODO 教学资源 -年级
* @author Mingshan
* @date 2017年4月8日 下午8:59:28
*
 */

@Entity
@Table(name="ps_teaching_resources_class")
public class TeachingResourcesClass implements Serializable{


	private static final long serialVersionUID = 1786102851120764777L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="class_name")
	private String className;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
