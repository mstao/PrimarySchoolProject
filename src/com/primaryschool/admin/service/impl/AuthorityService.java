package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAuthorityDao;
import com.primaryschool.admin.service.IAuthorityService;
/**
 * 
* @ClassName: AuthorityService
* @Description: TODO  权限管理-service
* @author Mingshan
* @date 2017年4月23日 上午9:05:17
*
* @param <T>
 */

@Service
public class AuthorityService<T> implements IAuthorityService<T> {

	@Autowired
	private IAuthorityDao<T> authorityDao;
	
	@Override
	public List<T> findAllRoles() {
		// TODO Auto-generated method stub
		return authorityDao.findAllRoles();
	}

	@Override
	public void deleteRoleById(List<?> ids) {
		// TODO Auto-generated method stub
		authorityDao.deleteRoleById(ids);
	}

	@Override
	public int saveRole(T t) {
		// TODO Auto-generated method stub
		return authorityDao.saveRole(t);
	}

	@Override
	public List<T> findRoleByName(String name) {
		// TODO Auto-generated method stub
		return authorityDao.findRoleByName(name);
	}

	@Override
	public List<T> findAllUser(int position, int item_per_page) {
		// TODO Auto-generated method stub
		return authorityDao.findAllUser(position, item_per_page);
	}

	@Override
	public int findUserCount() {
		// TODO Auto-generated method stub
		return authorityDao.findUserCount();
	}

	@Override
	public boolean updateUserRole(T t) {
		// TODO Auto-generated method stub
		return authorityDao.updateUserRole(t);
	}

	@Override
	public List<T> findUserByName(String userName) {
		// TODO Auto-generated method stub
		return authorityDao.findUserByName(userName);
	}

}
