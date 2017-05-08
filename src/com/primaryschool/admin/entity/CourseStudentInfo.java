package com.primaryschool.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
@Entity
@Table(name="ps_course_studentinfo")
public class CourseStudentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="stu_id")
	@Index(name = "idx_sys_student_id")
	private String stuId;
	
	@Column(name="class_id")
	private int classId;
	
	@Column(name="stu_name")
	private String stuName;
	
	@Column(name="stu_age")
	private int stuAge;
	
	@Column(name="stu_nation")
	private String stuNation;

	@Column(name="stu_sex")
	private String stuSex;
	
	@Column(name="stu_birthday")
	private String stuBirthday;
	
	@Column(name="stu_cardId")
	@Index(name = "idx_sys_student_card_id")
	private String stuCardId;
	
	@Column(name="stu_address")
	private String stuAddress;
	
	@Column(name="stu_phone")
	private String stuPhone;
	
	@Column(name="stu_parent")
	private String stuParent;
	
	@Column(name="stu_author")
	private String stuAuthor;
	
	

	public CourseStudentInfo() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getStuId() {
		return stuId;
	}



	public void setStuId(String stuId) {
		this.stuId = stuId;
	}



	public int getClassId() {
		return classId;
	}



	public void setClassId(int classId) {
		this.classId = classId;
	}



	public String getStuName() {
		return stuName;
	}



	public void setStuName(String stuName) {
		this.stuName = stuName;
	}



	public int getStuAge() {
		return stuAge;
	}



	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}



	public String getStuNation() {
		return stuNation;
	}



	public void setStuNation(String stuNation) {
		this.stuNation = stuNation;
	}



	public String getStuSex() {
		return stuSex;
	}



	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}



	public String getStuBirthday() {
		return stuBirthday;
	}



	public void setStuBirthday(String stuBirthday) {
		this.stuBirthday = stuBirthday;
	}



	public String getStuCardId() {
		return stuCardId;
	}



	public void setStuCardId(String stuCardId) {
		this.stuCardId = stuCardId;
	}



	public String getStuAddress() {
		return stuAddress;
	}



	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}



	public String getStuPhone() {
		return stuPhone;
	}



	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}



	public String getStuParent() {
		return stuParent;
	}



	public void setStuParent(String stuParent) {
		this.stuParent = stuParent;
	}



	public String getStuAuthor() {
		return stuAuthor;
	}



	public void setStuAuthor(String stuAuthor) {
		this.stuAuthor = stuAuthor;
	}

	//admin 查找所有信息
	

}
