package com.primaryschool.admin.dao;

import java.util.List;

public interface IClassStyleDao <T> {
	/**获取班级风采列表**/
	List<T> findClassStyleList(int classId);
	
	/**添加班级风采图片**/
	int saveClassStyle(T t);
	
	/**删除班级风采图片**/
	void deleteClassStyle(int id);
}
