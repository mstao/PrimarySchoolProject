package com.primaryschool.home.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
* @ClassName: StudentLabMenuContent
* @Description: TODO 综合实验课  子栏目 -内容
* @author Mingshan
* @date 2017年4月7日 下午9:45:06
*
 */

@Entity
@Table(name="ps_student_lab_menu_content")
public class StudentLabMenuContent implements Serializable{
	

	private static final long serialVersionUID = 8533008634404773449L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="item_title")
	private String itemTitle;
	
	@Column(name="item_content")
	private String itemContent;
	
	@Column(name="author")
	private String author;
	
	@Column(name="menu_id")
	private int  menuId;
	
	@Column(name="add_time")
	private String addTime;
	
	@Column(name="view_count")
	private int viewCount;
	
	@Column(name="is_image")
	private int isImage;
	
	@Column(name="is_publish")
	private int isPublish;

	@Column(name="lab_id")
	private int labId;
	
	//临时属性
    @Transient
    private String itemTypeFlag;
    
    @Transient
	private String itemTypeName;
    
	
	public StudentLabMenuContent(){}
	
	
	
	public StudentLabMenuContent(int id, String itemTitle, String addTime, int viewCount) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
		this.viewCount = viewCount;
	}

	 
	

	public StudentLabMenuContent(int id, String itemTitle, String itemContent, String author, String addTime,
			int viewCount, String itemTypeFlag, String itemTypeName) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.author = author;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.itemTypeFlag = itemTypeFlag;
		this.itemTypeName = itemTypeName;
	}

	//轮播

	public StudentLabMenuContent(int id, String itemTitle, String itemContent, String addTime, String itemTypeName) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.addTime = addTime;
		this.itemTypeName = itemTypeName;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	
	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}



	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getIsImage() {
		return isImage;
	}

	public void setIsImage(int isImage) {
		this.isImage = isImage;
	}

	public int getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(int isPublish) {
		this.isPublish = isPublish;
	}


	public int getLabId() {
		return labId;
	}


	public void setLabId(int labId) {
		this.labId = labId;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getItemTypeFlag() {
		return itemTypeFlag;
	}



	public void setItemTypeFlag(String itemTypeFlag) {
		this.itemTypeFlag = itemTypeFlag;
	}



	public String getItemTypeName() {
		return itemTypeName;
	}



	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	
	
	
}
