package com.primaryschool.home.service;

import java.util.List;

public interface IGradeService<T> {
	//获取在校学生的入学时间
	List<T> findGradeCode();
}
