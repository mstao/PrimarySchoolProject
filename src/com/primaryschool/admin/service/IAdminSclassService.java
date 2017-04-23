package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminSclassService<T> {
	/**添加班级，返回值为该记录的主键值**/
	   int addSclass(T t);
	   /**删除信息**/
	   void deleteSclassById(List<?> ids);   
	   /**获取最新一届年份**/
	   int getSclassYear();
	   /**添加班级**/
	   void addGradeInfo();
	   /**根据gradeCode获取id**/
	   int findGradeIdByCode(int gradeCode);
	   /**根据classId获取班级内信息**/
	   List<T> findClassInfoByClassId(int ClassId,int position,int item_per_page);
	    /**根据id获获取详细信息**/
	    T findSclassInfoById(int id);
	    /**根据id修改班级信息**/
	    boolean updateSclassInfo(T t);
	    /**添加信息，返回值为该记录的主键值**/
	    int addSclassInfo(T t);
	    /**删除班级内信息**/
	    void deleteSclassInfoById(List<?> ids);
	    /**获取班级内记录总数**/
	    int  findSclassCount(int classId);
	   //班级简介
	    /**根据LabId获取labIntro信息**/
		T findSclassIntroById(int id);
		   /**添加intro信息，返回值为该记录的主键值**/
		int addSclassIntro(T t);
		   /**根据id修改intro信息**/
	    boolean updateSclassIntroInfo(T t);
	  //文章类型
	    /**获取pageType的信息**/
		   List<T> findClassPageType();
		   /**通过typeId获取ClassPageType的信息**/
		   String findfindClassPageTypeByTypeId(int typeId);
		   /**通过typeFlag获取typeId的信息**/
		   int findPageTypeIdByTypeFlag(String flag);
}
