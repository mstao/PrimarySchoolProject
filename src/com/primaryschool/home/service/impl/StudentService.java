package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IStudentDao;
import com.primaryschool.home.service.IStudentService;

@Service
public class StudentService<T> implements IStudentService<T> {

	@Autowired 
    private IStudentDao<T> studentDao;
	@Override
	public List<T> findStudentInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) studentDao.findStudentInfo(flag, position, item_per_page);
	}

	@Override
	public T findStudentInfoById(int id) {
		// TODO Auto-generated method stub
		return (T) studentDao.findStudentInfoById(id);
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		return studentDao.addViewCount(id);
	}

	@Override
	public List<T> findLatestStudentInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) studentDao.findStudentInfo(flag, position, item_per_page);
	}

	@Override
	public int findStudentCount(String flag) {
		// TODO Auto-generated method stub
		return studentDao.findStudentCount(flag);
	}

	@Override
	public List<T> findHotStudentInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)studentDao.findHotStudentInfo(flag, position, item_per_page);
	}

}
