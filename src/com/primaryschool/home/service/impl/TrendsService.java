package com.primaryschool.home.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ITrendsDao;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.ITrendsService;


@Service
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
	public Trends findTrendsInfoById(int id) {
		// TODO Auto-generated method stub
		return (Trends)trendsDao.findTrendsInfoById(id);
	}

}
