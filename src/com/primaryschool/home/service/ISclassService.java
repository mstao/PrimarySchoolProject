package com.primaryschool.home.service;

import java.util.List;

public interface ISclassService<T> {
	//获取所有班级信息
	List<T> findClassInfo();
	//获取指定年级信息
	List<T> findClassInfoById(int id);
}
