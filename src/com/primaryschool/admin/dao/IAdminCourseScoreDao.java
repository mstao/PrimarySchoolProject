package com.primaryschool.admin.dao;

import java.util.List;

import com.primaryschool.admin.entity.CourseScore;

public interface IAdminCourseScoreDao<T> {
	/**考试成绩**/
	//根据班级Id获取记录
	List<?> findScoreInfo(int classId,int position,int item_per_page);
	//根据班级Id获取记录总数
	int findScoreCount(int classId);
	//根据Id获取成绩详细信息
	List<?> findScoreInfoById(int id,String stuId,String addTime);
	//查找成绩By-classId and stuinfoId
	List<?> findScoreInfoByTimeAndId(int stuinfoId,int classId);
	//更新成绩信息
	void updateScoreInfo(List<CourseScore> t);
	//添加成绩信息
	void addScoreInfo(List<CourseScore> t);
	//判断成绩信息是否存在By-addTime and stuinfoId
	boolean scoreExist(int stuinfoId,String addTime);
	//删除成绩信息
	void deleteScoreInfo(List<?> ids);
	/**考试科目管理**/
	//获取所有考试科目
	List<?> findCourseType();
	//添加考试科目
	int addCourseType(T t);
	//删除考试科目
	void deleteCourseType(List<?> ids);
	//获取考试科目总量
	long findTypeCount();
}
