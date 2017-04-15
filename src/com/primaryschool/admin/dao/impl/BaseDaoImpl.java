package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IBaseDao;
import com.primaryschool.global.util.GenericsUtils;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;

@Repository
public class BaseDaoImpl<T> implements IBaseDao<T> {

	@Autowired
	private SessionFactory  sessionFactory;
	
	@Autowired
	private ITypeFlagToTypeIdDao  typeFlagToTypeIdDao;
	
	private static final long serialVersionUID = -2539079802815261559L;

	
	@Override
	public boolean save(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		Class<T> entityClass = GenericsUtils.getSuperClassGenricType(BaseDaoImpl.class, 0);
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("update "+entityClass.getSimpleName());
		stringBuffer.append(" u set u.itemTitle=:itemTitle ,u.itemContent=:itemContent,u.addTime=:addTime,u.isImage=:isImage,u.isPublish=:isPublish,u.author=:author  where u.id=:id");
		System.out.println(stringBuffer.toString()); 
		Query query  = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString()); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
