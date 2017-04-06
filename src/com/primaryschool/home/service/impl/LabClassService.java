package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ILabClassDao;
import com.primaryschool.home.service.ILabClassService;

@Service
public class LabClassService<T> implements ILabClassService<T> {

	@Autowired
	private ILabClassDao<T>  labClassDao;
	
	@Override
	public List<T> findLabClassListInfo() {
		// TODO Auto-generated method stub
		return labClassDao.findLabClassListinfo();
	}

}
