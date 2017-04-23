package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminTeachingResourceService<T> {
	/**获取教师园地记录**/
	   List<T> findTeachingResourceInfo(int classId,int menuId,int position,int item_per_page);
	   /**根据id获获取详细信息**/
		 T findTeachingResourceInfoById(int id);
		/**根据 类型获取统计总数**/ 
		int findTeachingResourceCount(int classId,int menuId);  
	   /**根据id修改信息**/
	   boolean updateTeachingResourceInfo(T t);
	   /**添加信息，返回值为该记录的主键值**/
	   int addTeachingResourceInfo(T t);
	   /**删除信息**/
	   void deleteTeachingResourceById(List<?> ids);  
	   /**根据menuId查找resourceName**/
	   String findTeachingResurceNameById(int menuId);
	   /**获取resourceType的信息**/
	   List<T> findTeachingResourceTypeInfo();
	   /**根据typeId查找resourceType**/
	   String findTeachingResurceTypeById(int typeId);
	   /**添加资源类别，返回值为该记录的主键值**/
	   int addTeachingResourceMenuInfo(T t);
	   /**删除资源类别**/
	   void deleteTeachingResourceMenuById(List<?> ids);  
}
