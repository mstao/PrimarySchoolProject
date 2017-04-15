package com.primaryschool.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
* @ClassName: FileBelong
* @Description: TODO   文件归属类型
* @author Mingshan
* @date 2017年4月15日 下午3:12:18
*
 */
@Entity
@Table(name="ps_file_belong")
public class FileBelong implements Serializable{


	private static final long serialVersionUID = 7357518945830903856L;

	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="belong_name")
	private String belongName;

	@Column(name="type_flag")
	private String typeFlag;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBelongName() {
		return belongName;
	}
	public void setBelongName(String belongName) {
		this.belongName = belongName;
	}
	public String getTypeFlag() {
		return typeFlag;
	}
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}
	
	
}
