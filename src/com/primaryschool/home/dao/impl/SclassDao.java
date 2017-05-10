package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ISclassDao;

@Repository
public class SclassDao<T> implements ISclassDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findClassInfo() {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.Sclass(c.id, c.className, c.gradeId, g.gradeCode)from Sclass c,Grade g where c.gradeId=g.id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findClassInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="from Sclass where gradeId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T findClassNameAndGradeIdByClassId(int classId) {
		// TODO Auto-generated method stub
		System.out.println("用于数据查询的参数===================="+classId);
		String hql="select new com.primaryschool.home.entity.Sclass(c.id, c.className, c.gradeId)from Sclass c where c.id=? ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, classId);
		return (T) query.uniqueResult();
	}


}
