package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminTeachingResourceDao;
import com.primaryschool.admin.service.IAdminTeachingResourceService;
@Service
public class AdminTeachingResourceService<T> implements IAdminTeachingResourceService<T> {

	@Autowired
	private IAdminTeachingResourceDao<T> teachingResource;
	@Override
	public List<T> findTeachingResourceInfo(int classId,int menuId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) teachingResource.findTeachingResourceInfo(classId,menuId, position, item_per_page);
	}

	@Override
	public T findTeachingResourceInfoById(int id) {
		// TODO Auto-generated method stub
		return teachingResource.findTeachingResourceInfoById(id);
	}

	@Override
	public int findTeachingResourceCount(int classId,int menuId) {
		// TODO Auto-generated method stub
		return teachingResource.findTeachingResourceCount(classId, menuId);
	}

	@Override
	public boolean updateTeachingResourceInfo(T t) {
		// TODO Auto-generated method stub
		return teachingResource.updateTeachingResourceInfo(t);
	}

	@Override
	public int addTeachingResourceInfo(T t) {
		// TODO Auto-generated method stub
		return teachingResource.addTeachingResourceInfo(t);
	}

	@Override
	public void deleteTeachingResourceById(List<?> ids) {
		// TODO Auto-generated method stub
		teachingResource.deleteTeachingResourceById(ids);
	}

	@Override
	public String findTeachingResurceNameById(int menuId) {
		// TODO Auto-generated method stub
		return teachingResource.findTeachingResurceNameById(menuId);
	}

	@Override
	public List<T> findTeachingResourceTypeInfo() {
		// TODO Auto-generated method stub
		return (List<T>)teachingResource.findTeachingResourceTypeInfo();
	}

	@Override
	public String findTeachingResurceTypeById(int typeId) {
		// TODO Auto-generated method stub
		return teachingResource.findTeachingResurceTypeById(typeId);
	}

	@Override
	public int addTeachingResourceMenuInfo(T t) {
		// TODO Auto-generated method stub
		return teachingResource.addTeachingResourceMenuInfo(t);
	}

	@Override
	public void deleteTeachingResourceMenuById(List<?> ids) {
		// TODO Auto-generated method stub
		teachingResource.deleteTeachingResourceMenuById(ids);
	}

}
