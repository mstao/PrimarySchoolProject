package com.primaryschool.home.dao;

public interface ITypeFlagToTypeIdDao {
	int findTrendsTypeIdByTypeFlag(String flag);
	   
	int findEducationTypeIdByTypeFlag(String flag);
	    
	int findStudentTYpeIdByTypeFlag(String flag);
}
