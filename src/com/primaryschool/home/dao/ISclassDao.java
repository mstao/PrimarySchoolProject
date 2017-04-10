package com.primaryschool.home.dao;

import java.util.List;

public interface ISclassDao<T> {
	//获取所有班级信息
	List<T> findClassInfo();
}
