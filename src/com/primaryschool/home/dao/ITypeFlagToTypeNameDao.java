package com.primaryschool.home.dao;

/**
 * 
* @ClassName: ITypeFlagToTypeName
* @Description: TODO 由typeflag获取typename
* @author Mingshan
* @date 2017年3月26日 下午4:43:42
*
 */

public interface ITypeFlagToTypeNameDao {
	
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
