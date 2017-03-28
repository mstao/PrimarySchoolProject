package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primaryschool.home.dao.IEducationDao;
import com.primaryschool.home.service.IEducationService;

@Service
@Transactional
public class EducationService<T> implements IEducationService<T> {

	@Autowired 
    private IEducationDao<T> educationDao;

	@Override
	public List<T> findEducationInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) educationDao.findEducationInfo(flag, position, item_per_page);
	}

	@Override
	public List<T> findEducationInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
