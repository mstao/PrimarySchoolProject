package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.primaryschool.home.dao.IHeadMasterInoDao;

/**
 * 
* @ClassName: HeadMasterInfoDao
* @Description: TODO 获取校长信息
* @author Mingshan
* @date 2017年4月1日 上午9:33:58
*
 */
public class HeadMasterInfoDao<T> implements IHeadMasterInoDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHeadMasterInfo() {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.HeadMaster(hm.id,hm.name,hm.work,hm.email,hm.avatar,hmp.postName) from HeadMaster hm,HeadMasterPost hmp where hm.postId=hmp.id order by hm.postId asc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
