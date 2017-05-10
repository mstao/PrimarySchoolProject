package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IClassStyleDao;

@Repository
public class ClassStyleDao<T> implements IClassStyleDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findClassStyleList(int classId) {
		// TODO Auto-generated method stub
		String hql="from ClassStyle c where c.classId= ? order by addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, classId);
		
		return query.list();
	}

	@Override
	public int saveClassStyle(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public void deleteClassStyle(int id) {
		// TODO Auto-generated method stub
		String hql   = "delete from ClassStyle where id=:id";
		Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id).executeUpdate();
	}

}
