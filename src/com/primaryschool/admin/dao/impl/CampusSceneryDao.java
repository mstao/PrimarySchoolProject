package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.ICampusSceneryDao;

/**
 * 
* @ClassName: CampusSceneryDao
* @Description: TODO 校园风光  DAO
* @author Mingshan
* @date 2017年4月18日 下午8:12:34
*
* @param <T>
 */

@Repository
public class CampusSceneryDao<T> implements ICampusSceneryDao<T> {

	@Autowired
	private  SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findCampusSceneryList() {
		// TODO Auto-generated method stub
		String hql="from CampusScenery order by addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public int saveCampusScenery(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public void deleteCampusScenery(int id) {
		// TODO Auto-generated method stub
		String hql   = "delete from CampusScenery where id=:id";
		Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id).executeUpdate();
	}

}
