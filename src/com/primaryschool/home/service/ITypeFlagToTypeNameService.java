package com.primaryschool.home.service;

public interface ITypeFlagToTypeNameService {
    
	String findCultureTypeNameByTypeFlag(String flag);
	
	String findTrendsTypeNameByTypeFlag(String flag);
	
    String findEducationTypeNameByTypeFlag(String flag);
    
    String findStudentTypeNameByTypeFlag(String flag);
    
	String findTeacherTypeNameByTypeFlag(String flag);
	
	String findManageTypeNameByTypeFlag(String flag);
	
	String findPartyTypeNameByTypeFlag(String flag);
	
	String findLabClassTypeNameByTypeFlag(String flag);
	
	String findClassTypeNameByTypeFlag(String flag);
}
