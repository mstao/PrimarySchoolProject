package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IGradeDao;
@Repository
public class GradeDao<T> implements IGradeDao<T>{

		@Autowired
		private SessionFactory sessionFactory;
		@Override
		public List<T> findGradeCode() {
			// TODO Auto-generated method stub
			String hql="from Grade g order by g.gradeCode desc";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			query.setMaxResults(6);
			return query.list();
		}

}
