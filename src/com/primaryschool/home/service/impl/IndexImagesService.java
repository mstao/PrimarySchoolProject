package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IIndexImagesDao;
import com.primaryschool.home.service.IIndexImagesService;

@Service
public class IndexImagesService<T> implements IIndexImagesService<T> {

	@Autowired
	private IIndexImagesDao<T> indexImagesDao;
	
	@Override
	public List<T> findIndexImages(int position, int pageSize) {
		// TODO Auto-generated method stub
		return indexImagesDao.findIndexImages(position, pageSize);
	}

}
