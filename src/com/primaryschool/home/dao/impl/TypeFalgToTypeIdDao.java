package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;
import com.primaryschool.home.entity.TrendsType;

/**
 * 
* @ClassName: TypeFalgToTypeIdDao
* @Description: TODO 根据类型flag 获取类型id
* @author Mingshan
* @date 2017年3月26日 下午7:06:51
*
 */

@Repository
public class TypeFalgToTypeIdDao implements ITypeFlagToTypeIdDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	/* (非 Javadoc)
	* Title: findTrendsTypeIdByTypeFlag
	* Description: 通过类型flag获取类型id --<trends>
	* @param flag
	* @return id
	* @see com.primaryschool.home.dao.ITypeFlagToTypeIdDao#findTrendsTypeIdByTypeFlag(java.lang.String)
	*/ 
	@Override
	public int findTrendsTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from TrendsType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		TrendsType tt=(TrendsType)query.uniqueResult();
		return tt.getId();
	}

}
