package com.primaryschool.apply.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.apply.dao.IApplyUserDao;

/**
 * 
* @ClassName: ApplyUserDao
* @Description: TODO 学生报名用户
* @author Mingshan
* @date 2017年4月30日 下午4:14:04
*
* @param <T>
 */

@Repository
public class ApplyUserDao<T> implements IApplyUserDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveUser(T t) {
		// TODO Auto-generated method stub
		Serializable res=sessionFactory.getCurrentSession().save(t);
		return (int) res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findUserByCard(String card) {
		// TODO Auto-generated method stub
		String hql="from ApplyUser u where u.cardCode=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, card);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findUserByCardPassword(String card, String password) {
		// TODO Auto-generated method stub
		String hql="from ApplyUser u where u.cardCode=? and password=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, card);
		query.setString(1, password);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findUserByEmail(String email) {
		// TODO Auto-generated method stub
		String hql="from ApplyUser u where u.email=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, email);
		
		return (T) query.uniqueResult();
	}

}
