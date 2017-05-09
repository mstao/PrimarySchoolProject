package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminCultureDao;
import com.primaryschool.admin.service.IAdminCultureService;
@Service
public class AdminCultureService<T> implements IAdminCultureService<T> {
	
	@Autowired
	private IAdminCultureDao<T> cultureDao;
	@Override
	public List<T> findCultureInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)cultureDao.findCultureInfo(flag, position, item_per_page);
	}

	@Override
	public T findCultureInfoById(int id) {
		// TODO Auto-generated method stub
		return cultureDao.findCultureInfoById(id);
	}

	@Override
	public int findCultureCount(String flag) {
		// TODO Auto-generated method stub
		return cultureDao.findCultureCount(flag);
	}

	@Override
	public boolean updateCultureInfo(T t) {
		// TODO Auto-generated method stub
		return cultureDao.updateCultureInfo(t);
	}

	@Override
	public int addCultureInfo(T t) {
		// TODO Auto-generated method stub
		return cultureDao.addCultureInfo(t);
	}

	@Override
	public void deleteCultureById(List<?> ids) {
		// TODO Auto-generated method stub
		cultureDao.deleteCultureById(ids);
	}
	
	@Override
	public List<T> searchInfo(String type, String token) {
		// TODO Auto-generated method stub
		return cultureDao.searchInfo(type, token);
	}
}
