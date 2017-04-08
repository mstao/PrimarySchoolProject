package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ITeachingResourcesDao;

/**
 * 
* @ClassName: TeachingResourcesDao
* @Description: TODO 教学资源DAO
* @author Mingshan
* @date 2017年4月8日 下午2:13:08
*
* @param <T>
 */


@Repository
public class TeachingResourcesDao<T> implements ITeachingResourcesDao<T> {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 获取年级信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTeachingResourcesClassList() {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesClass";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	/**
	 * 获取菜单列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTeachingResourcesMeun() {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesMenu";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
