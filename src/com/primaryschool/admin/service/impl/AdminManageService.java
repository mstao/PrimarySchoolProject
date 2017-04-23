package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminManageDao;
import com.primaryschool.admin.service.IAdminManageService;
@Service
public class AdminManageService<T> implements IAdminManageService<T> {

	@Autowired
	private IAdminManageDao<T> ManageDao;
	@Override
	public List<T> findManageInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)ManageDao.findManageInfo(flag, position, item_per_page);
	}

	@Override
	public T findManageInfoById(int id) {
		// TODO Auto-generated method stub
		return ManageDao.findManageInfoById(id);
	}

	@Override
	public int findManageCount(String flag) {
		// TODO Auto-generated method stub
		return ManageDao.findManageCount(flag);
	}

	@Override
	public boolean updateManageInfo(T t) {
		// TODO Auto-generated method stub
		return ManageDao.updateManageInfo(t);
	}

	@Override
	public int addManageInfo(T t) {
		// TODO Auto-generated method stub
		return ManageDao.addManageInfo(t);
	}

	@Override
	public void deleteManageById(List<?> ids) {
		// TODO Auto-generated method stub
		ManageDao.deleteManageById(ids);
	}

}
