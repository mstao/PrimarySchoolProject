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
	public List<T> findStudentInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
