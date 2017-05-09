package com.primaryschool.admin.service;

import java.util.List;


public interface IAdminStuInfoService<T> {

	   /**获取学生信息记录ByClassId**/
	   List<T> findStuInfo(int classId,int position,int item_per_page);
	   /**根据id获获取详细信息**/
	   T findStuInfoById(int id);
	   /**根据 类型获取统计总数**/ 
	   int findStuCount(int classId);  
	   /**根据id修改信息**/
	   boolean updateStuInfo(T t);
	   /**根据stuId/stuName获取id**/
	   int findIdByStuIdOrStuName(String info);
	   /**添加信息，返回值为该记录的主键值**/
	   int addStuInfo(T t);
	   /**删除信息**/
	   void deleteStuById(List<?> ids); 
	   /**查找信息ByCardId**/
	   T findStuInfoByCardId(String cardId);
	   /**查找信息ByStuId**/
	   T findStuInfoByStuId(String stuId);
	   /**模糊查询**/
	   List<T> searchInfo(int flag, String token);
}
