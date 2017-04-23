package com.primaryschool.admin.dao;

import java.util.List;

public interface IAdminTeacherDao<T> {
	 /**获取教师园地记录**/
	   List<T> findTeacherInfo(String flag,int position,int item_per_page);
	   /**根据id获获取详细信息**/
		 T findTeacherInfoById(int id);
		/**根据 类型获取统计总数**/ 
		int findTeacherCount(String flag);  
	   /**根据id修改信息**/
	   boolean updateTeacherInfo(T t);
	   /**添加信息，返回值为该记录的主键值**/
	   int addTeacherInfo(T t);
	   /**删除信息**/
	   void deleteTeacherById(List<?> ids);    
}
