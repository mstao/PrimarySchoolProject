package com.primaryschool.home.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IClassSynopsisDao;

@Repository
public class ClassSynopsisDao<T> implements IClassSynopsisDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public T findClassSynopsisInfo(int classId) {
		// TODO Auto-generated method stub
		/**获取班级简介**/
		String hql="select new com.primaryschool.home.entity.ClassSynopsis(t.classSynopsis) from ClassSynopsis t where t.classId= ? ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, classId);
		return (T)query.uniqueResult();
		}
}
	
