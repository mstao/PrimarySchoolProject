package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ISclassDao;
import com.primaryschool.home.service.ISclassService;

@Service
public class SclassService<T> implements ISclassService<T> {

	@Autowired
	private ISclassDao classDao;
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findClassInfo() {
		// TODO Auto-generated method stub
		return (List<T>)classDao.findClassInfo();
	}

}
