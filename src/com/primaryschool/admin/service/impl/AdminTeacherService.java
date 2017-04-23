package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminTeacherDao;
import com.primaryschool.admin.service.IAdminTeacherService;
@Service
public class AdminTeacherService<T> implements IAdminTeacherService<T> {

	@Autowired
	private IAdminTeacherDao<T> teacherDao;
	@Override
	public List<T> findTeacherInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)teacherDao.findTeacherInfo(flag, position, item_per_page);
	}

	@Override
	public T findTeacherInfoById(int id) {
		// TODO Auto-generated method stub
		return teacherDao.findTeacherInfoById(id);
	}

	@Override
	public int findTeacherCount(String flag) {
		// TODO Auto-generated method stub
		return teacherDao.findTeacherCount(flag);
	}

	@Override
	public boolean updateTeacherInfo(T t) {
		// TODO Auto-generated method stub
		return teacherDao.updateTeacherInfo(t);
	}

	@Override
	public int addTeacherInfo(T t) {
		// TODO Auto-generated method stub
		return teacherDao.addTeacherInfo(t);
	}

	@Override
	public void deleteTeacherById(List<?> ids) {
		// TODO Auto-generated method stub
		teacherDao.deleteTeacherById(ids);
	}

}
