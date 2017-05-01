package com.primaryschool.apply.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name="ps_apply")
public class Apply implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="stu_name")
	private String stuName;
	
	@Column(name="stu_sex")
	private String stuSex;
	
	@Column(name="stu_nation")
	private String stuNation;
	
	@Column(name="stu_idnum")
	@Index(name = "idx_sys_apply_stuIdNum")
	private String stuIdNum;
	
	@Column(name="original_school")
	private String originalSchool;
	
	@Column(name="address")
	private String address;
	
	@Column(name="register")
	private String register;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="father_idnum")
	private String fatherIdNum;
	
	@Column(name="father_phone")
	private String fatherPhone;
	
	@Column(name="mother_name")
	private String motherName;
	
	@Column(name="mother_idnum")
	private String motherIdNum;
	
	@Column(name="mother_phone")
	private String motherPhone;
	
	@Column(name="status")
	private String status;

	@Column(name="uid")
	@Index(name = "idx_sys_apply_uid")
	private int uid;
	
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuNation() {
		return stuNation;
	}

	public void setStuNation(String stuNation) {
		this.stuNation = stuNation;
	}

	public String getStuIdNum() {
		return stuIdNum;
	}

	public void setStuIdNum(String stuIdNum) {
		this.stuIdNum = stuIdNum;
	}

	public String getOriginalSchool() {
		return originalSchool;
	}

	public void setOriginalSchool(String originalSchool) {
		this.originalSchool = originalSchool;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherIdNum() {
		return fatherIdNum;
	}

	public void setFatherIdNum(String fatherIdNum) {
		this.fatherIdNum = fatherIdNum;
	}

	public String getFatherPhone() {
		return fatherPhone;
	}

	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherIdNum() {
		return motherIdNum;
	}

	public void setMotherIdNum(String motherIdNum) {
		this.motherIdNum = motherIdNum;
	}

	public String getMotherPhone() {
		return motherPhone;
	}

	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
	
	
	
}
