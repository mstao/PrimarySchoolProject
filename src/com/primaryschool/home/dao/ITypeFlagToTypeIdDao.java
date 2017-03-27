package com.primaryschool.home.dao;

public interface ITypeFlagToTypeIdDao {
	int findTrendsTypeIdByTypeFlag(String flag);
	   
	int findEducationTypeIdByTypeFlag(String flag);
	    
	int findStudentTypeIdByTypeFlag(String flag);
	 //教师天地
    int findTeacherTypeIdByTypeFlag(String flag);
    //学校管理
    int findManageTypeIdByTypeFlag(String flag);
    //党务工会
    int findPartyTypeIdByTypeFlag(String flag);
}
