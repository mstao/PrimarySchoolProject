package com.primaryschool.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IFileDao;
import com.primaryschool.admin.service.IFileService;


@Service
public class FileService<T> implements IFileService<T> {

	@Autowired	
	private IFileDao<T> fileDao;
	
	@Override
	public Integer addTrendsAttachment(T t) {
		// TODO Auto-generated method stub
		return fileDao.addTrendsAttachment(t);
	}

	@Override
	public Integer findBelongIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return fileDao.findBelongIdByTypeFlag(flag);
	}

}
