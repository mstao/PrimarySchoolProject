package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminDepartmentDao;
import com.primaryschool.admin.service.IAdminDepartmentService;


@Service
public class AdminDepartmentService<T> implements IAdminDepartmentService<T> {

	@Autowired
	private IAdminDepartmentDao<T> departmentDao;
	@Override
	public List<?> findDepartmentNameList() {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentNameList();
	}

	@Override
	public int addDepartmentName(T t) {
		// TODO Auto-generated method stub
		return departmentDao.addDepartmentName(t);
	}

	@Override
	public void deleteDepartmentName(List<?> ids) {
		// TODO Auto-generated method stub
		departmentDao.deleteDepartmentName(ids);
	}

	@Override
	public List<?> findDepartmentContentInfo(int deptId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentContentInfo(deptId, position, item_per_page);
	}

	@Override
	public T findDeptContentInfo(int id) {
		// TODO Auto-generated method stub
		return departmentDao.findDeptContentInfo(id);
	}

	@Override
	public int addDepartmentContent(T t) {
		// TODO Auto-generated method stub
		return departmentDao.addDepartmentContent(t);
	}

	@Override
	public void deleteDepartmentContent(List<?> ids) {
		// TODO Auto-generated method stub
		departmentDao.deleteDepartmentContent(ids);
	}

	@Override
	public boolean updateDeparmentContent(T t) {
		// TODO Auto-generated method stub
		return departmentDao.updateDeparmentContent(t);
	}

	@Override
	public List<?> findDepartmentType() {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentType();
	}

	@Override
	public String findDepartmentTypeById(int id) {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentTypeById(id);
	}

	@Override
	public int findDepartmentTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentTypeIdByTypeFlag(flag);
	}

	@Override
	public String findDepartmentNameById(int id) {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentNameById(id);
	}

	@Override
	public int findDepartmentContentCount(int deptId) {
		// TODO Auto-generated method stub
		return departmentDao.findDepartmentContentCount(deptId);
	}

	

}
