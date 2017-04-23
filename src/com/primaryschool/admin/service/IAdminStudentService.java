package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminStudentService<T> {
	/**获取学生天地记录**/
	   List<T> findStudentInfo(String flag,int position,int item_per_page);
	   /**根据id获获取详细信息**/
		 T findStudentInfoById(int id);
		/**根据 类型获取统计总数**/ 
		int findStudentCount(String flag);  
	   /**根据id修改信息**/
	   boolean updateStudentInfo(T t);
	   /**添加信息，返回值为该记录的主键值**/
	   int addStudentInfo(T t);
	   /**删除信息**/
	   void deleteStudentById(List<?> ids); 
}
