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
* @ClassName: TeachingResourcesMenu
* @Description: TODO 教学资源 - 资源列表
* @author Mingshan
* @date 2017年4月8日 下午9:16:28
*
 */
@Entity
@Table(name="ps_teaching_resources_menu")
public class TeachingResourcesMenu implements Serializable{
    

	private static final long serialVersionUID = 1827103637702804978L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="resource_name")
	private String resourceName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	
}
