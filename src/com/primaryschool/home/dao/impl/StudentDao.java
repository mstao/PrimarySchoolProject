package com.primaryschool.home.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IStudentDao;

@Repository
public class StudentDao<T> implements IStudentDao<T> {

	@Override
	public List<T> findStudentInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findStudentInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveStudentInfo(int id, String flag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addStudentInfo(String flag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteStudentById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

}
