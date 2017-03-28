package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primaryschool.home.dao.IManageDao;
import com.primaryschool.home.service.IManageService;

@Service
@Transactional
public class ManageService<T> implements IManageService<T>{
    @Autowired
    private IManageDao<T> manageDao;
	
    @Override
	public List<T> findManageInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)manageDao.findManageInfo(flag, position, item_per_page);
	}

	@Override
	public List<T> findManageInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
