package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminCourseScoreDao;
import com.primaryschool.admin.entity.CourseScore;
import com.primaryschool.admin.service.IAdminCourseScoreService;
@Service
public class AdminCourseScoreService<T> implements IAdminCourseScoreService<T> {

	@Autowired
	IAdminCourseScoreDao<T> courseDao;
	@Override
	public List<?> findCourseType() {
		// TODO Auto-generated method stub
		return (List<?>)courseDao.findCourseType();
	}

	@Override
	public int addCourseType(T t) {
		// TODO Auto-generated method stub
		return courseDao.addCourseType(t);
	}

	@Override
	public void deleteCourseType(List<?> ids) {
		// TODO Auto-generated method stub
		courseDao.deleteCourseType(ids);
	}

	@Override
	public List<?> findScoreInfo(int classId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<?>)courseDao.findScoreInfo(classId, position, item_per_page);
	}

	@Override
	public int findScoreCount(int classId) {
		// TODO Auto-generated method stub
		return courseDao.findScoreCount(classId);
	}

	@Override
	public List<?> findScoreInfoById(int classId,String stuId,String addTime) {
		// TODO Auto-generated method stub
		return (List<?>)courseDao.findScoreInfoById(classId, stuId, addTime);
	}

	@Override
	public void updateScoreInfo(List<CourseScore> t) {
		// TODO Auto-generated method stub
		 courseDao.updateScoreInfo(t);
	}

	@Override
	public void addScoreInfo(List<CourseScore> t) {
		// TODO Auto-generated method stub
		courseDao.addScoreInfo(t);
	}

	@Override
	public void deleteScoreInfo(List<?> ids) {
		// TODO Auto-generated method stub
		courseDao.deleteScoreInfo(ids);
	}

	@Override
	public long findTypeCount() {
		// TODO Auto-generated method stub
		return courseDao.findTypeCount();
	}

	@Override
	public boolean scoreExist(int stuinfoId, String addTime) {
		return courseDao.scoreExist(stuinfoId, addTime);
	}

	@Override
	public List<?> findScoreInfoByTimeAndId(int stuinfoId, int classId) {
		// TODO Auto-generated method stub
		return (List<?>)courseDao.findScoreInfoByTimeAndId(stuinfoId, classId);
	}

}
