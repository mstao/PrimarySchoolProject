package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ILabClassDao;

/**
 * 
* @ClassName: LabClassDao
* @Description: TODO 综合实验课DAO
* @author Mingshan
* @date 2017年4月6日 下午8:19:34
*
* @param <T>
 */

@Repository
public class LabClassDao<T> implements ILabClassDao<T> {
    @Autowired
    private SessionFactory sessionFactory;
    
    
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLabClassListinfo() {
		// TODO Auto-generated method stub
		String hql="from StudentLab";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T findLabClassInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="from StudentLab sl where sl.id=? ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}
	
	

}
