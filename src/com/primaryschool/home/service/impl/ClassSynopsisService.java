package com.primaryschool.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IClassSynopsisDao;
import com.primaryschool.home.service.IClassSynopsisService;

@Service
public class ClassSynopsisService<T> implements IClassSynopsisService<T> {
	
	@Autowired 
    private IClassSynopsisDao<T> classSynopsisDao;
	
	@Override
	public T findClassSynopsisInfo(int classId) {
		// TODO Auto-generated method stub
		return (T) classSynopsisDao.findClassSynopsisInfo(classId);

	}

}
