package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primaryschool.home.dao.IPartyDao;
import com.primaryschool.home.service.IPartyService;

@Service
@Transactional
public class PartyService<T> implements IPartyService<T>{
    @Autowired 
    private IPartyDao<T> partyDao;
	
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
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		return partyDao.addViewCount(id);
	}

	@Override
	public List<T> findLatestPartyInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return partyDao.findPartyInfo(flag, position, item_per_page);
	}

	@Override
	public int findPartyCount(String flag) {
		// TODO Auto-generated method stub
		return partyDao.findPartyCount(flag);
	}

	@Override
	public List<T> findHotPartyInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return partyDao.findHotPartyInfo(flag, position, item_per_page);
	}

}
