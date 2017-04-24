package com.primaryschool.home.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
* @ClassName: Trends
* @Description: TODO  校园动态实体类
* @author Mingshan
* @date 2017年3月26日 下午3:34:56
*
 */

@Entity
@Table(name = "ps_trends")
public class Trends implements Serializable{


	private static final long serialVersionUID = -2228382525594394975L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "item_title")
	private String itemTitle;
	
	@Column(name = "item_content")
	private String itemContent;
	
	@Column(name = "type_id")
	private int  typeId;
	
	@Column(name = "add_time")
	private String addTime;
	
	@Column(name = "view_count")
	private int viewCount;
	
	@Column(name = "is_image")
	private int isImage;
	
	@Column(name = "is_publish")
	private int isPublish;
	
	@Column(name="author")
	private String author;
	
    //临时属性
    @Transient
    private String itemTypeFlag;
    
    @Transient
	private String itemTypeName;
    
    public Trends(){}
    
    public Trends(int id,String itemTitle,String addTime){
    	super();
    	this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
    }
    
    public Trends(int id , String itemTitle,String addTime,int viewCount){
    	super();
    	this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
		this.viewCount =viewCount;
    }
    
    public Trends(int id, String itemTitle, String itemContent, String addTime, int viewCount, 
			  String itemTypeName,String itemTypeFlag,String author) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.itemTypeName = itemTypeName;
		this.itemTypeFlag = itemTypeFlag;
		this.author=author;
	}
   
    //后台详细信息
	public Trends(int id, String itemTitle, String itemContent, String addTime, int viewCount, 
			  String itemTypeName,String itemTypeFlag,int isPublish,String author) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.itemTypeName = itemTypeName;
		this.itemTypeFlag = itemTypeFlag;
		this.isPublish = isPublish;
		this.author=author;
	}

	//后台列表要用
	public Trends(int id, String itemTitle, String addTime, int isPublish,String author) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
		this.author = author;
		this.isPublish = isPublish;
	}
	
	
    //图片；轮播
	public Trends(int id, String itemTitle, String itemContent, String addTime,String itemTypeFlag) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.addTime = addTime;
		this.itemTypeFlag = itemTypeFlag;
	}


    

    public Trends(int id,String itemTitle, String itemContent, String addTime, int viewCount, 
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
    
	public Trends(int id, String itemTitle, String itemContent, String addTime, int viewCount,String author, 
			  String itemTypeName,String itemTypeFlag,int isPublish) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemContent = itemContent;
		this.addTime = addTime;
		this.viewCount = viewCount;
		this.author=author;
		this.itemTypeName = itemTypeName;
		this.itemTypeFlag = itemTypeFlag;
		this.isPublish = isPublish;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
