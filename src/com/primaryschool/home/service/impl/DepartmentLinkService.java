package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IDepartmentLinkDao;
import com.primaryschool.home.service.IDepartmentLinkService;

@Service
public class DepartmentLinkService<T> implements IDepartmentLinkService<T> {

	@Autowired 
    private IDepartmentLinkDao<T> departmentLinkDao;
	
	/*获取部门链接中部门的名称*/
	@Override
	public List<T> findDepartmentNameInfo() {
		// TODO Auto-generated method stub
		return departmentLinkDao.findDepartmentNameInfo();
	}
	@Override
	public List<T> findDepartmentLinkInfo(String departmentNameType,String contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) departmentLinkDao.findDepartmentLinkInfo(departmentNameType,contentFlag, position, item_per_page);
	}

	@Override
	public List<T> findDepartmentLinkInfo(int departmentId,int contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) departmentLinkDao.findDepartmentLinkInfo(departmentId,contentFlag, position, item_per_page);
	}
	
	@Override
	public List<T> findDepartmentLinkInfo(int departmentId,String contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) departmentLinkDao.findDepartmentLinkInfo(departmentId,contentFlag, position, item_per_page);
	}

	@Override
	public T findDepartmentLinkInfoById(int id) {
		// TODO Auto-generated method stub
		return (T)departmentLinkDao.findDepartmentLinkInfoById(id);
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		return departmentLinkDao.addViewCount(id);
	}

	@Override
	public List<T> findLatestDepartmentLinkInfo(int departmentId,String contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)departmentLinkDao.findDepartmentLinkInfo(departmentId,contentFlag, position, item_per_page);
	}
	
	@Override
	public List<T> findLatestDepartmentLinkInfo(int departmentId,int contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)departmentLinkDao.findDepartmentLinkInfo(departmentId,contentFlag, position, item_per_page);
	}
	

	@Override
	public int findDepartmentLinkContentCount(int departmentId,String contentFlag) {
		// TODO Auto-generated method stub
		return departmentLinkDao.findDepartmentLinkContentCount(departmentId,contentFlag);
	}

	@Override
	public List<T> findHotDepartmentLinkInfo(int departmentId,String contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)departmentLinkDao.findHotDepartmentLinkInfo(departmentId,contentFlag, position, item_per_page);
	}

	@Override
	public List<T> findSlideTrendsInfo(String contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return departmentLinkDao.findSlideJobPlacementInfo(contentFlag, position, item_per_page);
	}
	
	
	@Override
	public List<T> findIndexDepartmentLinkInfo(int position, int item_per_page) {
		// TODO Auto-generated method stub
		return departmentLinkDao.findIndexDepartmentLinkInfo(position, item_per_page);
	}

	

}
