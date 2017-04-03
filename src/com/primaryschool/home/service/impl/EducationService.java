package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IEducationDao;
import com.primaryschool.home.service.IEducationService;

@Service
public class EducationService<T> implements IEducationService<T> {

	@Autowired 
    private IEducationDao<T> educationDao;

	@Override
	public List<T> findEducationInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) educationDao.findEducationInfo(flag, position, item_per_page);
	}

	@Override
	public T findEducationInfoById(int id) {
		// TODO Auto-generated method stub
		return (T)educationDao.findEducationInfoById(id);
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		return educationDao.addViewCount(id);
	}

	@Override
	public List<T> findLatestEducationInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)educationDao.findEducationInfo(flag, position, item_per_page);
	}

	@Override
	public int findEducationCount(String flag) {
		// TODO Auto-generated method stub
		return educationDao.findEducationCount(flag);
	}

	@Override
	public List<T> findHotEducationInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)educationDao.findHotEducationInfo(flag, position, item_per_page);
	}
	

}
