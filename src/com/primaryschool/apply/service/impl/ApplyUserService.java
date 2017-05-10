package com.primaryschool.apply.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.apply.dao.IApplyUserDao;
import com.primaryschool.apply.entity.ApplyUser;
import com.primaryschool.apply.service.IApplyUserService;

@Service
public class ApplyUserService<T> implements IApplyUserService<T> {

	@Autowired
	private IApplyUserDao<T> userDao;
	
	@Override
	public int saveUser(T t) {
		// TODO Auto-generated method stub
		return userDao.saveUser(t);
	}

	@Override
	public T findUserByCard(String card) {
		// TODO Auto-generated method stub
		return userDao.findUserByCard(card);
	}

	@Override
	public T findUserByCardPassword(String card, String password) {
		// TODO Auto-generated method stub
		return userDao.findUserByCardPassword(card, password);
	}

	@Override
	public T findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserByEamil(email);
	}


	@Override
	public T findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}

	@Override
	public T getByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(userName);
	}

	@Override
	public T getByInfo(String userName, String email) {
		// TODO Auto-generated method stub
		return userDao.getByInfo(userName, email);
	}

	@Override
	public void updateStuInfo(ApplyUser user) {
		// TODO Auto-generated method stub
		userDao.updateStuInfo(user);
	}

}
