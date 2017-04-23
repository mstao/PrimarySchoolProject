package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminLabClassService<T> {
	/**获取综合实验课记录**/
	   List<T> findLabClassInfo(int labId,int position,int item_per_page);
	   /**根据id获获取详细信息**/
		 T findLabClassInfoById(int id);
		/**根据 类型获取统计总数**/ 
		int findLabClassCount(int labId);  
	   /**根据id修改信息**/
	   boolean updateLabClassInfo(T t);
	   /**添加信息，返回值为该记录的主键值**/
	   int addLabClassInfo(T t);
	   /**删除信息**/
	   void deleteLabClassById(List<?> ids);  
	   /**根据menuId查找resourceName(menu)**/
	   String findLabClassNameById(int menuId);
	   /**获取LabClassType的信息**/
	   List<T> findLabClassTypeInfo();
	   /**根据typeId查找LabClassType**/
	   String findLabClassTypeById(int typeId);
	   /**获取LabClassMenu的信息**/
	   List<T> findLabClassMenuInfo();
	   /**通过menuId获取LabClassMenu的信息**/
	   String findLabClassMenuById(int menuId);
	   /**根据LabId获取labIntro信息**/
	   T findLabMenuIntroById(int labId);
	   /**添加intro信息，返回值为该记录的主键值**/
	   int addLabIntroInfo(T t);
	   /**根据id修改intro信息**/
	   boolean updateLabIntroInfo(T t);
	   /**删除社团**/
	   void deleteLabById(List<?> ids); 
	   /**添加社团信息，返回值为该记录的主键值**/
	   int addLabInfo(T t);
}
