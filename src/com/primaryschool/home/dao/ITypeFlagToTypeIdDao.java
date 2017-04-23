package com.primaryschool.home.dao;

public interface ITypeFlagToTypeIdDao {
	
	int findCultureTypeIdByTypeFlag(String flag);
	
	int findTrendsTypeIdByTypeFlag(String flag);
	   
	int findEducationTypeIdByTypeFlag(String flag);
	    
	int findStudentTypeIdByTypeFlag(String flag);
	 //教师天地
    int findTeacherTypeIdByTypeFlag(String flag);
    //学校管理
    int findManageTypeIdByTypeFlag(String flag);
    //党务工会
    int findPartyTypeIdByTypeFlag(String flag);
    //综合实验课  
    int findLabClassTypeIdByTypeFlag(String flag);
    
    //教学资源
    int findTeachingResourcesTypeFlag(String flag);
    //班级主页信息
    int findClasshomepageIdByTypeFlag(String flag);
    //文件类型id
    int findFileBelongIdByBelongFalg(String flag);
    
    //教学资源类型
  	int findTeachingResourcesTypeIdByTypeFlag(String flag);
    //社团资源类型
  	int findLabClassMenuIdByTypeFlag(String flag);
}
