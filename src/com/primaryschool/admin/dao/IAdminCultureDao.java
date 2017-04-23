package com.primaryschool.admin.dao;

import java.util.List;

public interface IAdminCultureDao<T> {


	 /**获取校园文化记录**/
   List<T> findCultureInfo(String flag,int position,int item_per_page);
   /**根据id获获取详细信息**/
	 T findCultureInfoById(int id);
	/**根据 类型获取统计总数**/ 
	int findCultureCount(String flag);  
   /**根据id修改信息**/
   boolean updateCultureInfo(T t);
   /**添加信息，返回值为该记录的主键值**/
   int addCultureInfo(T t);
   /**删除信息**/
   void deleteCultureById(List<?> ids);     
}
