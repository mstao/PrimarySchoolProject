package com.primaryschool.admin.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.ICopyRightDao;

/**
 * 
* @ClassName: CopyRightDao
* @Description: TODO 版权声明
* @author Mingshan
* @date 2017年4月21日 下午1:53:15
*
* @param <T>
 */

@Repository
public class CopyRightDao<T> implements ICopyRightDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public T findCopyRightInfo() {
		// TODO Auto-generated method stub
		String hql="from CopyRight";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (T) query.uniqueResult();
	}

	@Override
	public int saveCopyRightInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public boolean updateCopyRightInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update CopyRight c set c.content=:content, c.addTime=:addTime,c.author=:author,c.isPublish=:isPublish  where c.id=:id";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

}
