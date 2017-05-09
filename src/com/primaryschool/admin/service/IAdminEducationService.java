package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminEducationService<T> {
	 /**获取阳光德育记录**/
	   List<T> findEducationInfo(String flag,int position,int item_per_page);
	   /**根据id获获取详细信息**/
		 T findEducationInfoById(int id);
		/**根据 类型获取统计总数**/ 
		int findEducationCount(String flag);  
	   /**根据id修改信息**/
	   boolean updateEducationInfo(T t);
	   /**添加信息，返回值为该记录的主键值**/
	   int addEducationInfo(T t);
	   /**删除信息**/
	   void deleteEducationById(List<?> ids);  
	   /**模糊查询**/
	   List<T> searchInfo(String flag, String token);
}
