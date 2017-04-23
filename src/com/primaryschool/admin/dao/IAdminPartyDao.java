package com.primaryschool.admin.dao;

import java.util.List;

public interface IAdminPartyDao<T> {

		 /**获取党务管理记录**/
	   List<T> findPartyInfo(String flag,int position,int item_per_page);
	   /**根据id获获取详细信息**/
		 T findPartyInfoById(int id);
		/**根据 类型获取统计总数**/ 
		int findPartyCount(String flag);  
	   /**根据id修改信息**/
	   boolean updatePartyInfo(T t);
	   /**添加信息，返回值为该记录的主键值**/
	   int addPartyInfo(T t);
	   /**删除信息**/
	   void deletePartyById(List<?> ids);     

}
