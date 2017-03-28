package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primaryschool.home.dao.ITeacherDao;
import com.primaryschool.home.service.ITeacherService;

@Service
@Transactional
public class TeacherService<T> implements ITeacherService<T>{
    @Autowired
    private ITeacherDao<T> teacherDao;
	
    @Override
	public List<T> findTeacherInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)teacherDao.findTeacherInfo(flag, position, item_per_page);
	}

	@Override
	public List<T> findTeacherInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
