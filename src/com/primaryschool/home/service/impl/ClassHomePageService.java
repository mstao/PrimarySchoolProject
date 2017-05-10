package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IClassHomePageDao;
import com.primaryschool.home.service.IClassHomePageService;

@Service
public class ClassHomePageService<T> implements IClassHomePageService<T> {

	@Autowired 
    private IClassHomePageDao<T> classhomepageDao;
	
	@Override
	public List<T> findClassHomePageInfo(int classId,String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) classhomepageDao.findClassHomePageInfo(classId,flag, position, item_per_page);
	}

	@Override
	public T findClassHomePageInfoById(int id) {
		// TODO Auto-generated method stub
		return (T)classhomepageDao.findClassHomePageInfoById(id);
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		return classhomepageDao.addViewCount(id);
	}

	@Override
	public List<T> findLatestClassHomePageInfo(int classId,String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)classhomepageDao.findClassHomePageInfo(classId,flag, position, item_per_page);
	}

	@Override
	public int findClassHomePageCount(String flag) {
		// TODO Auto-generated method stub
		return classhomepageDao.findClassHomePageCount(flag);
	}

	@Override
	public List<T> findHotClasshomepageInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)classhomepageDao.findHotClassHomePageInfo(flag, position, item_per_page);
	}

	@Override
	public List<T> findClassHomePageListInfo() {
		// TODO Auto-generated method stub
		return classhomepageDao.findClassHomePageListInfo();
	}

}
