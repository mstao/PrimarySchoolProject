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
* @ClassName: ManageType
* @Description: TODO 校园管理-类型 -实体类
* @author Mingshan
* @date 2017年3月26日 下午4:35:03
*
 */


@Entity
@Table(name = "ps_manage_type")
public class ManageType implements Serializable{

	private static final long serialVersionUID = 9006332104583128040L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "item_type_name")
	@Index(name = "idx_sys_manage_type_name")
    private String itemTypeName;
	
	@Column(name = "item_type_flag")
	@Index(name = "idx_sys_manage_type_flag")
    private String itemTypeFlag;
	  
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	public String getItemTypeFlag() {
		return itemTypeFlag;
	}
	public void setItemTypeFlag(String itemTypeFlag) {
		this.itemTypeFlag = itemTypeFlag;
	}
}
