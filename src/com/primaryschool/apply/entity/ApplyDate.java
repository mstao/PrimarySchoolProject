package com.primaryschool.apply.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

/**
 * 
* @ClassName: ApplyDate
* @Description: TODO 报名时间
* @author Mingshan
* @date 2017年5月2日 下午2:09:16
*
 */

@Entity
@Table(name="ps_apply_date")
public class ApplyDate implements Serializable{


	private static final long serialVersionUID = -5906177320480538123L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="year")
	@Index(name = "idx_sys_apply_date_year")
	private int year;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="end_date")
	private String endDate;
	
	@Column(name="begin_apply")
	private int beginApply;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getBeginApply() {
		return beginApply;
	}
	public void setBeginApply(int beginApply) {
		this.beginApply = beginApply;
	}
	
	
}
