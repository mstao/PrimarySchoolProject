package com.primaryschool.home.dao.impl;

import java.util.List;

import com.primaryschool.home.dao.ICultureDao;

public class CultrueDao implements ICultureDao {

	@Override
	public List findCultureInfo(String type, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findCultureInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveCultureInfo(int id, String type, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addCultureInfo(String type, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCultureById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

}
