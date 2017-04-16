package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminIndexImagesDao;

@Repository
public class AdminIndexImagesDao<T> implements  IAdminIndexImagesDao<T>{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addImage(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}
	

}
