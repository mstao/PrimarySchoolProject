package com.primaryschool.home.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.primaryschool.home.dao.ITrendsDao;

import com.primaryschool.home.service.ITrendsService;


@Service
@Transactional
public class TrendsService<T> implements  ITrendsService<T>{
	private  Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@Autowired 
    private ITrendsDao<T> trendsDao;
    
	@Override
	public List<T> findTrendsInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		
		return (List<T>) trendsDao.findTrendsInfo(flag, position, item_per_page);
	}

	@Override
	public T findTrendsInfoById(int id) {
		// TODO Auto-generated method stub
		return (T)trendsDao.findTrendsInfoById(id);
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		return trendsDao.addViewCount(id);
	}

	@Override
	public List<T> findLatestTrendsInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) trendsDao.findTrendsInfo(flag, position, item_per_page);
	}

	@Override
	public int findTrendsCount(String flag) {
		// TODO Auto-generated method stub
		return trendsDao.findTrendsCount(flag);
	}

	@Override
	public List<T> findHotTrendsInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)trendsDao.findHotTrendsInfo(flag, position, item_per_page);
	}

}
