package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IPartyDao;
import com.primaryschool.home.service.IPartyService;

@Service
public class PartyService<T> implements IPartyService<T>{
    @Autowired 
    private IPartyDao<T> partyDao;
	
    @Override
	public List<T> findPartyInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)partyDao.findPartyInfo(flag, position, item_per_page);
	}

	@Override
	public List<T> findPartyInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
