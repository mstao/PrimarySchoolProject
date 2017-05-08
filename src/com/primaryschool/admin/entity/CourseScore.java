package com.primaryschool.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="ps_course_score")
public class CourseScore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="stuinfo_id")
	private int stuinfoId;
	
	@Column(name="class_id")
	private int classId;
	
	@Column(name="course_id")
	private int courseId;

	@Column(name="score")
	private String score;
	
	@Column(name="author")
	private String author;
	
	@Column(name="addTime")
	private String addTime;
	
	//临时属性
    @Transient
    private String courseName;
    
    @Transient
    private String stuName;
    
    @Transient
    private String stuId;

	public CourseScore() {
		super();
	}
	
	//for-update
	public CourseScore(int id, int stuinfoId, int classId, int courseId, String score, String author, String addTime) {
		super();
		this.id = id;
		this.stuinfoId = stuinfoId;
		this.classId = classId;
		this.courseId = courseId;
		this.score = score;
		this.author = author;
		this.addTime = addTime;
	}


	//admin-list获取学生成绩
	public CourseScore(int id, int stuinfoId, int courseId, String score, String author, String addTime,
			String courseName, String stuName,String stuId) {
		super();
		this.id = id;
		this.stuinfoId = stuinfoId;
		this.courseId = courseId;
		this.score = score;
		this.author = author;
		this.addTime = addTime;
		this.courseName = courseName;
		this.stuName = stuName;
		this.stuId=stuId;
	}
	

	//admin-detail获取学生成绩ById
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getStuinfoId() {
		return stuinfoId;
	}

	public void setStuinfoId(int stuinfoId) {
		this.stuinfoId = stuinfoId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

    
}
