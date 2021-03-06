package com.primaryschool.home.entity;

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
 * @ClassName: ClasshomepageType
 * @Description: TODO 班级主页 -类型-实体类
 * @author zsk
 * @date 2017年4月5日 下午7:25:50
 *
 */


@Entity
@Table(name = "ps_class_synopsis")
public class ClassSynopsis implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		/**
		 * 
		 */

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
		
		@Column(name = "class_id")
		@Index(name = "idx_sys_class_class_id")
	    private int classId;
		
		@Column(name = "class_synopsis")
		@Index(name = "idx_sys_class_class_synopsis")
	    private String classSynopsis;

		public ClassSynopsis(){}
		
		
		
		public ClassSynopsis(int classId, String classSynopsis) {
			super();
			this.classId = classId;
			this.classSynopsis = classSynopsis;
		}



		public ClassSynopsis(String classSynopsis) {
			super();
			this.classSynopsis = classSynopsis;
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	
		public int getClassId() {
			return classId;
		}



		public void setClassId(int classId) {
			this.classId = classId;
		}



		public String getClassSynopsis() {
			return classSynopsis;
		}

		public void setClassSynopsis(String classSynopsis) {
			this.classSynopsis = classSynopsis;
		}
		  
		  
}
