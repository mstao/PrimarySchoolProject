package com.primaryschool.home.dao;

/**
 * 
* @ClassName: ITypeNameToTypeFlag
* @Description: TODO  由typename获取typeflag
* @author Mingshan
* @date 2017年3月26日 下午4:43:09
*
 */
public interface ITypeNameToTypeFlagDao {
	String findTrendsTypeFlagByTypeName(String name);
	
	String findEducationTypeFlagByTypeName(String name);
	
	String findTeacherTypeFlagByTypeName(String name);
	
	String findManageTypeFlagByTypeName(String name);
	
	String findPartyTypeFlagByTypeName(String name);
}
