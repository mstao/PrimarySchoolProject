package com.primaryschool.home.service;

public interface ITypeFlagToTypeNameService {
    String findTrendsTypeNameByTypeFlag(String flag);
	
	String findTeacherTypeNameByTypeFlag(String flag);
	
	String findManageTypeNameByTypeFlag(String flag);
	
	String findPartyTypeNameByTypeFlag(String flag);
}
