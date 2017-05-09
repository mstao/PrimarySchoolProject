package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminLabClassDao;
import com.primaryschool.admin.service.IAdminLabClassService;
@Service
public class AdminLabClassService<T> implements IAdminLabClassService<T> {

	@Autowired
	private IAdminLabClassDao<T> labClass;
	@Override
	public List<T> findLabClassInfo(int labId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return labClass.findLabClassInfo(labId, position, item_per_page);
	}

	@Override
	public T findLabClassInfoById(int id) {
		// TODO Auto-generated method stub
		return labClass.findLabClassInfoById(id);
	}

	@Override
	public int findLabClassCount(int labId) {
		// TODO Auto-generated method stub
		return labClass.findLabClassCount(labId);
	}

	@Override
	public boolean updateLabClassInfo(T t) {
		// TODO Auto-generated method stub
		return labClass.updateLabClassInfo(t);
	}

	@Override
	public int addLabClassInfo(T t) {
		// TODO Auto-generated method stub
		return labClass.addLabClassInfo(t);
	}

	@Override
	public void deleteLabClassById(List<?> ids) {
		// TODO Auto-generated method stub
		labClass.deleteLabClassById(ids);
	}

	@Override
	public List<T> findLabClassTypeInfo() {
		// TODO Auto-generated method stub
		return labClass.findLabClassTypeInfo();
	}

	@Override
	public String findLabClassNameById(int menuId) {
		// TODO Auto-generated method stub
		return labClass.findLabClassNameById(menuId);
	}

	@Override
	public String findLabClassTypeById(int typeId) {
		// TODO Auto-generated method stub
		return labClass.findLabClassTypeById(typeId);
	}

	@Override
	public List<T> findLabClassMenuInfo() {
		// TODO Auto-generated method stub
		return labClass.findLabClassMenuInfo();
	}

	@Override
	public String findLabClassMenuById(int menuId) {
		// TODO Auto-generated method stub
		return labClass.findLabClassMenuById(menuId);
	}

	@Override
	public T findLabMenuIntroById(int labId) {
		// TODO Auto-generated method stub
		return labClass.findLabMenuIntroById(labId);
	}

	@Override
	public int addLabIntroInfo(T t) {
		// TODO Auto-generated method stub
		return labClass.addLabIntroInfo(t);
	}

	@Override
	public boolean updateLabIntroInfo(T t) {
		// TODO Auto-generated method stub
		return labClass.updateLabIntroInfo(t);
	}

	@Override
	public void deleteLabById(List<?> ids) {
		// TODO Auto-generated method stub
		labClass.deleteLabById(ids);
	}

	@Override
	public int addLabInfo(T t) {
		// TODO Auto-generated method stub
		return labClass.addLabClassInfo(t);
	}
	
	@Override
	public List<T> searchInfo(String flag, String token) {
		// TODO Auto-generated method stub
		return labClass.searchInfo(flag, token);
	}
}
