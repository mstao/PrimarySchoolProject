package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ITeacherDao;
import com.primaryschool.home.service.ITeacherService;

/**
 * 
* @ClassName: TeacherService
* @Description: TODO教师园地  service
* @author Mingshan
* @date 2017年4月8日 下午8:08:21
*
* @param <T>
 */
@Service
public class TeacherService<T> implements ITeacherService<T>{
    @Autowired
    private ITeacherDao<T> teacherDao;
	
    @Override
	public List<T> findTeacherInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)teacherDao.findTeacherInfo(flag, position, item_per_page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findTeacherInfoById(int id) {
		// TODO Auto-generated method stub
		return (T)teacherDao.findTeacherInfoById(id);
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		return teacherDao.addViewCount(id);
	}

	@Override
	public List<T> findLatestTeacherInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)teacherDao.findTeacherInfo(flag, position, item_per_page);
	}

	@Override
	public int findTeacherCount(String flag) {
		// TODO Auto-generated method stub
		return teacherDao.findTeacherCount(flag);
	}

	@Override
	public List<T> findHotTeacherInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return teacherDao.findHotTeacherInfo(flag, position, item_per_page);
	}

}
