package com.primaryschool.admin.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IUserDao;
import com.primaryschool.admin.service.IUserService;
/**
 * 
* @ClassName: UserService
* @Description: TODO USER SERVICE
* @author Mingshan
* @date 2017年4月18日 下午6:37:01
*
* @param <T>
 */

@Service
public class UserService<T> implements IUserService<T> {

	@Autowired
	private  IUserDao<T> userDao;
	@Override
	public T getByUerName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getByUerName(userName);
	}

	@Override
	public Set<String> getRoles(String userName) {
		// TODO Auto-generated method stub
		return userDao.getRoles(userName);
	}

	@Override
	public Set<String> getPermissions(String userName) {
		// TODO Auto-generated method stub
		return userDao.getPermissions(userName);
	}

	@Override
	public List<T> findResources() {
		// TODO Auto-generated method stub
		return userDao.findResources();
	}

	@Override
	public void saveUser(T t) {
		// TODO Auto-generated method stub
		userDao.saveUser(t);
	}

	@Override
	public T findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserName(userName);
	}

	@Override
	public T findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserByEmail(email);
	}

}
