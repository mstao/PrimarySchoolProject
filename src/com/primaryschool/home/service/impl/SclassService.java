package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ISclassDao;
import com.primaryschool.home.service.ISclassService;

@Service
public class SclassService<T> implements ISclassService<T> {

	@Autowired
	private ISclassDao<T> classDao;
	

	@Override
	public List<T> findClassInfo() {
		// TODO Auto-generated method stub
		return (List<T>)classDao.findClassInfo();
	}
	
	
	@Override
	public List<T> findClassInfoById(int id) {
		// TODO Auto-generated method stub
		return (List<T>)classDao.findClassInfoById(id);
	}
	
	@Override
	public T findClassNameAndGradeIdByClassId(int classId) {
		// TODO Auto-generated method stub
		return (T) classDao.findClassNameAndGradeIdByClassId(classId);
	}
}
