package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IIndexImagesDao;

@Repository
public class IndexImagesDao<T> implements IIndexImagesDao<T> {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findIndexImages(int position, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from IndexImages order by addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(position);
		query.setMaxResults(pageSize);
		return query.list();
	}

}
