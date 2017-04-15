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
* @ClassName: File
* @Description: TODO 文件 实体类
* @author Mingshan
* @date 2017年4月15日 下午2:51:45
*
 */
@Entity
@Table(name="ps_file")
public class FileBean implements Serializable{

	private static final long serialVersionUID = -4918140583178609412L;
	
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="real_name")
	private String realName;
	
	@Column(name="file_belong_id")
	private int fileBlongId;
	
	@Column(name="add_time")
	private String addTime;
	
	@Column(name="item_id")
	private int itemId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getFileBlongId() {
		return fileBlongId;
	}
	public void setFileBlongId(int fileBlongId) {
		this.fileBlongId = fileBlongId;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
}
