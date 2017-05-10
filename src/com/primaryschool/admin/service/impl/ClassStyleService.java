package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IClassStyleDao;
import com.primaryschool.admin.service.IClassStyleService;

@Service
public class ClassStyleService<T> implements IClassStyleService<T> {

	@Autowired
	private IClassStyleDao<T> classStyleDao;
	
	@Override
	public List<T> findClassStyleList(int classId) {
		// TODO Auto-generated method stub
		return classStyleDao.findClassStyleList(classId);
	}

	@Override
	public int saveClassStyle(T t) {
		// TODO Auto-generated method stub
		return classStyleDao.saveClassStyle(t);
	}

	@Override
	public void deleteClassStyle(int id) {
		// TODO Auto-generated method stub
		classStyleDao.deleteClassStyle(id);
	}

}
