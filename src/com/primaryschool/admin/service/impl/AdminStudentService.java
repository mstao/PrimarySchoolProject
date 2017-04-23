package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminStudentDao;
import com.primaryschool.admin.service.IAdminStudentService;
@Service
public class AdminStudentService<T> implements IAdminStudentService<T> {

	@Autowired
	private IAdminStudentDao<T> studentDao;
	
	@Override
	public List<T> findStudentInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) studentDao.findStudentInfo(flag, position, item_per_page);
	}

	@Override
	public T findStudentInfoById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentInfoById(id);
	}

	@Override
	public int findStudentCount(String flag) {
		// TODO Auto-generated method stub
		return studentDao.findStudentCount(flag);
	}

	@Override
	public boolean updateStudentInfo(T t) {
		// TODO Auto-generated method stub
		return studentDao.updateStudentInfo(t);
	}

	@Override
	public int addStudentInfo(T t) {
		// TODO Auto-generated method stub
		return studentDao.addStudentInfo(t);
	}

	@Override
	public void deleteStudentById(List<?> ids) {
		// TODO Auto-generated method stub
		studentDao.deleteStudentById(ids);
	}

}
