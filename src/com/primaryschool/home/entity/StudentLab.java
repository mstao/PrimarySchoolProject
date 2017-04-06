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
* @ClassName: StudentLab
* @Description: TODO 综合实验课   - 实体类
* @author Mingshan
* @date 2017年4月6日 下午8:21:15
*
 */

@Entity
@Table(name="ps_student_lab")
public class StudentLab  implements Serializable{
	

	private static final long serialVersionUID = 2147997398902640013L;

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
	   
	   @Column(name="lab_name")
       private String  labName;

		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public String getLabName() {
			return labName;
		}
	
		public void setLabName(String labName) {
			this.labName = labName;
		}
	   
	   
	   
}
