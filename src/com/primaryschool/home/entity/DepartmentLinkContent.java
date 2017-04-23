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
 * 部门链接详情实体类
 */
@Entity
@Table(name="ps_departmentlink_content")
public class DepartmentLinkContent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="item_title")
	private String itemTitle;
	
	@Column(name="item_content")
	private String itemContent;
	
	@Column(name="type_id")
	private int  typeId;
	
	@Column(name="add_time")
	private String addTime;
	
	@Column(name="view_count")
	private int viewCount;
	
	@Column(name="is_image")
	private int isImage;
	
	@Column(name="is_publish")
	private int isPublish;
	
	@Column(name="item_author")
	private String itemAuthor;
	
	@Column(name="department_id")
	private int departmentId;
	
	//临时属性
    @Transient
    private String itemTypeFlag;
    
    @Transient
	private String itemTypeName;
    
	
	public DepartmentLinkContent(){}
	
    
    public DepartmentLinkContent(int id,String itemTitle,String addTime){
    	super();
    	this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
    }
    
    /**后台list页面显示当前分类的信息BydeptId**/
    public DepartmentLinkContent(int id, String itemTitle, int typeId, String addTime, int isPublish, String itemAuthor) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.typeId = typeId;
		this.addTime = addTime;
		this.isPublish = isPublish;
		this.itemAuthor = itemAuthor;
		
	}
    
	public DepartmentLinkContent(int id,String itemTitle,String addTime,int typeId,int departmentId){
    	super();
    	this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
		this.departmentId=departmentId;
		this.typeId=typeId;
    }
	
	/**后台list页面显示详细信息ById**/
    public DepartmentLinkContent(int id, String itemTitle, String itemContent,int typeId, String addTime, int isPublish,
			String itemAuthor, int departmentId, String itemTypeFlag, String itemTypeName) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.typeId=typeId;
		this.addTime = addTime;
		this.isPublish = isPublish;
		this.itemAuthor = itemAuthor;
		this.departmentId = departmentId;
		this.itemTypeFlag = itemTypeFlag;
		this.itemTypeName = itemTypeName;
	}


	public DepartmentLinkContent(int id , String itemTitle,String addTime,int viewCount){
    	super();
    	this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
		this.viewCount =viewCount;
    }
    
    public DepartmentLinkContent(int id, String itemTitle, String itemContent, String addTime, int viewCount, 
			  String itemTypeName,String itemTypeFlag) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.itemTypeName = itemTypeName;
		this.itemTypeFlag = itemTypeFlag;
		
	}
    
    //图片轮播
	public DepartmentLinkContent(int id, String itemTitle, String itemContent, String addTime) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.addTime = addTime;
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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
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

	public String getItemAuthor() {
		return itemAuthor;
	}

	public void setItemAuthor(String itemAuthor) {
		this.itemAuthor = itemAuthor;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	
	
}
