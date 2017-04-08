package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ITeachingResourcesDao;
import com.primaryschool.home.service.ITeachingResourcesService;

/**
 * 
* @ClassName: TeachingResourcesService
* @Description: TODO  课程资源 service
* @author Mingshan
* @date 2017年4月8日 下午8:07:49
*
* @param <T>
 */

@Service
public class TeachingResourcesService<T> implements ITeachingResourcesService<T> {

	@Autowired
	private   ITeachingResourcesDao<T> teachingResourcesDao;
	
	@Override
	public List<T> findTeachingResourcesClassList() {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesClassList();
	}

	@Override
	public List<T> findTeachingResourcesMeun() {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesMeun();
	}

}
