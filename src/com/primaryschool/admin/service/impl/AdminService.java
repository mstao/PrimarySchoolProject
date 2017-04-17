package com.primaryschool.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminDao;
import com.primaryschool.admin.service.IAdminService;
import com.primaryschool.home.entity.Trends;

@Service
public class AdminService implements IAdminService<Trends> {

	@Autowired
	private IAdminDao adminDao;

	@Override
	public boolean update(Trends t) {
		// TODO Auto-generated method stub
		return adminDao.update(t);
	}

}
