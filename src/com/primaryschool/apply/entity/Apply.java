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
	private int status;

	@Column(name="uid")
	@Index(name = "idx_sys_apply_uid")
	private int uid;
	
	@Column(name="add_time")
	private String addTime;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="date_id")
	private int dateId;
	
	@Column(name="img_path")
	private String imgPath;
	
	public Apply() {
		super();
	}

	/**通过id找身份证号**/
	public Apply(int id,String stuIdNum) {
		super();
		this.id=id;
		this.stuIdNum = stuIdNum;
	}

	/**后台获取列表**/
	/**
	 * 
	* <p>Title: </p>
	* <p>Description:  </p>
	* @param id
	* @param stuName
	* @param stuSex
	* @param stuNation
	* @param stuIdNum
	* @param addTime
	* @param status
	 */
	public Apply(int id, String stuName, String stuSex, String stuNation, String stuIdNum, String addTime,int status
			,String reason) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuNation = stuNation;
		this.stuIdNum = stuIdNum;
		this.addTime = addTime;
		this.status=status;
		this.reason=reason;
	}
	
	
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getDateId() {
		return dateId;
	}

	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	
	
	
	
	
	
}
