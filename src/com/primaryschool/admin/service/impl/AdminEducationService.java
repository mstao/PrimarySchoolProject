package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminEducationDao;
import com.primaryschool.admin.service.IAdminEducationService;
@Service
public class AdminEducationService<T> implements IAdminEducationService<T> {
	
	@Autowired
	private IAdminEducationDao<T> educationDao;
	@Override
	public List<T> findEducationInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)educationDao.findEducationInfo(flag, position, item_per_page);
	}

	@Override
	public T findEducationInfoById(int id) {
		// TODO Auto-generated method stub
		return educationDao.findEducationInfoById(id);
	}

	@Override
	public int findEducationCount(String flag) {
		// TODO Auto-generated method stub
		return educationDao.findEducationCount(flag);
	}

	@Override
	public boolean updateEducationInfo(T t) {
		// TODO Auto-generated method stub
		return educationDao.updateEducationInfo(t);
	}

	@Override
	public int addEducationInfo(T t) {
		// TODO Auto-generated method stub
		return educationDao.addEducationInfo(t);
	}

	@Override
	public void deleteEducationById(List<?> ids) {
		// TODO Auto-generated method stub
		educationDao.deleteEducationById(ids);
	}

}
