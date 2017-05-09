package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminPartyDao;
import com.primaryschool.admin.service.IAdminPartyService;
@Service
public class AdminPartyService<T> implements IAdminPartyService<T> {

	@Autowired
	private IAdminPartyDao<T> partyDao;
	@Override
	public List<T> findPartyInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)partyDao.findPartyInfo(flag, position, item_per_page);
	}

	@Override
	public T findPartyInfoById(int id) {
		// TODO Auto-generated method stub
		return partyDao.findPartyInfoById(id);
	}

	@Override
	public int findPartyCount(String flag) {
		// TODO Auto-generated method stub
		return partyDao.findPartyCount(flag);
	}

	@Override
	public boolean updatePartyInfo(T t) {
		// TODO Auto-generated method stub
		return partyDao.updatePartyInfo(t);
	}

	@Override
	public int addPartyInfo(T t) {
		// TODO Auto-generated method stub
		return partyDao.addPartyInfo(t);
	}

	@Override
	public void deletePartyById(List<?> ids) {
		// TODO Auto-generated method stub
		partyDao.deletePartyById(ids);
	}
	
	@Override
	public List<T> searchInfo(String flag, String token) {
		// TODO Auto-generated method stub
		return partyDao.searchInfo(flag, token);
	}
}
