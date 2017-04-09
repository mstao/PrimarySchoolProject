package com.primaryschool.home.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ps_teaching_resources_content")
public class TeachingResourcesContent implements Serializable{

	private static final long serialVersionUID = 691846506297438767L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="item_title")
	private String itemTitle;
	
	@Column(name="item_content")
	private String itemContent;
	
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
	
	@Column(name="author")
	private String author;
	
	@Column(name="class_id")
	private int classId;
	
	@Column(name="type_id")
	private int typeId;
	
	//临时属性
    @Transient
    private String resourcesName;
    
    @Transient
	private String className;
    
    @Transient
    private String itemTypeFlag;
    
    @Transient
	private String itemTypeName;
    

    public TeachingResourcesContent(){}
    
    
    
	public TeachingResourcesContent(int id, String itemTitle, String addTime, int viewCount) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
		this.viewCount = viewCount;
	}

	


	public TeachingResourcesContent(int id, String itemTitle, String itemContent, String addTime, int viewCount,
			String author, String resourcesName, String className, String itemTypeFlag, String itemTypeName) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.author = author;
		this.resourcesName = resourcesName;
		this.className = className;
		this.itemTypeFlag = itemTypeFlag;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getResourcesName() {
		return resourcesName;
	}

	public void setResourcesName(String resourcesName) {
		this.resourcesName = resourcesName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}



	public int getTypeId() {
		return typeId;
	}



	public void setTypeId(int typeId) {
		this.typeId = typeId;
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
