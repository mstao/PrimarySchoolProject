package com.primaryschool.admin.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IBaseDao;
import com.primaryschool.admin.service.IBaseService;

@Service
public class BaseService<T> implements IBaseService<T> {

	@Autowired
	private  IBaseDao<T> baseDao;
	
	@Override
	public boolean save(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return baseDao.update(t);
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
