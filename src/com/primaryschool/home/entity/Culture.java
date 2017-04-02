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
* @ClassName: Culture
* @Description: TODO学校文化实体类
* @author Mingshan
* @date 2017年3月26日 下午3:42:02
*
 */

@Entity
@Table(name="ps_culture")
public class Culture implements Serializable{

	private static final long serialVersionUID = 3157598607945581466L;

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
    
	//临时属性
    @Transient
    private String itemTypeFlag;
    
    @Transient
	private String itemTypeName;
    
    public Culture(){}
    
	
    public Culture(int id,String itemTitle,String addTime){
    	super();
    	this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
    }
		
    public Culture(int id , String itemTitle,String addTime,int viewCount){
    	super();
    	this.id = id;
		this.itemTitle = itemTitle;
		this.addTime = addTime;
		this.viewCount =viewCount;
    }
    
    public Culture(int id, String itemTitle, String itemContent, String addTime, int viewCount, 
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
	
}
