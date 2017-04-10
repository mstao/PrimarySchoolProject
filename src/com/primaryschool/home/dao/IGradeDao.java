package com.primaryschool.home.dao;

import java.util.List;

public interface IGradeDao<T> {
	//获取在校学生的入学时间
	List<T> findGradeCode();

}
