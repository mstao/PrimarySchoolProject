package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ICultureDao;
import com.primaryschool.home.service.ICultureService;

@Service
public class CultureService<T> implements ICultureService<T> {
    
	@Autowired
	private ICultureDao<T> cultureDao;
	
	
	@Override
	public List<T> findCultureInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)cultureDao.findCultureInfo(flag, position, item_per_page);
	}

	@Override
	public T findCultureInfoById(int id) {
		// TODO Auto-generated method stub
		return (T)cultureDao.findCultureInfoById(id);
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		return cultureDao.addViewCount(id);
	}

	@Override
	public int findCultureCount(String flag) {
		// TODO Auto-generated method stub
		return cultureDao.findCultureCount(flag);
	}


	@Override
	public List<T> findHotCultureInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)cultureDao.findHotCultureInfo(flag, position, item_per_page);
	}


	@Override
	public List<T> findLatestCultureInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)cultureDao.findCultureInfo(flag, position, item_per_page);
	}

	@Override
	public List<T> findSliderCultureInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return cultureDao.findSliderCultureInfo(flag, position, item_per_page);
	}

}
