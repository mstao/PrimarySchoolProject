package com.primaryschool.admin.dao;

import java.util.List;

public interface IAdminManageDao<T> {

	 /**获取学校管理记录**/
  List<T> findManageInfo(String flag,int position,int item_per_page);
  /**根据id获获取详细信息**/
	 T findManageInfoById(int id);
	/**根据 类型获取统计总数**/ 
	int findManageCount(String flag);  
  /**根据id修改信息**/
  boolean updateManageInfo(T t);
  /**添加信息，返回值为该记录的主键值**/
  int addManageInfo(T t);
  /**删除信息**/
  void deleteManageById(List<?> ids);     
}
