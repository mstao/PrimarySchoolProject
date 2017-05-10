package com.primaryschool.admin.service;

import java.util.List;

/*
 * 班级风采
 * */
public interface IClassStyleService<T> {
	/**获取班级风采列表**/
	List<T> findClassStyleList(int classId);
	
	/**添加班级风采图片**/
	int saveClassStyle(T t);
	
	/**删除班级风采**/
	void deleteClassStyle(int id);
}
