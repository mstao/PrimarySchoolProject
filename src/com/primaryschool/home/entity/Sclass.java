package com.primaryschool.home.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 * 班级列表
 * 
 */
@Entity
@Table(name="ps_class")
public class Sclass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="class_name")
	private String className;
	@Column(name="grade_id")
	private int gradeId;
	//临时属性
    @Transient
    private int gradeCode;
	
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
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}
	public Sclass(int id, String className, int gradeId, int gradeCode) {
		super();
		this.id = id;
		this.className = className;
		this.gradeId = gradeId;
		this.gradeCode = gradeCode;
	}
	public Sclass() {
		super();
	}
	public Sclass(int id,String className,int gradeId){
		super();
		this.id=id;
		this.gradeId=gradeId;
		this.className=className;
	}
}
