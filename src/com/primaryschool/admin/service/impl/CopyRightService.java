package com.primaryschool.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.ICopyRightDao;
import com.primaryschool.admin.service.ICopyRightService;

@Service
public class CopyRightService<T> implements ICopyRightService<T> {

	@Autowired
	private ICopyRightDao<T> copyRightDao;
	
	@Override
	public T findCopyRightInfo() {
		// TODO Auto-generated method stub
		return copyRightDao.findCopyRightInfo();
	}

	@Override
	public int saveCopyRightInfo(T t) {
		// TODO Auto-generated method stub
		return copyRightDao.saveCopyRightInfo(t);
	}

	@Override
	public boolean updateCopyRightInfo(T t) {
		// TODO Auto-generated method stub
		return copyRightDao.updateCopyRightInfo(t);
	}

}
