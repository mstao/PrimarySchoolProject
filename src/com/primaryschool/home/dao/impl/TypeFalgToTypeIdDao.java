package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;
import com.primaryschool.home.entity.CultureType;
import com.primaryschool.home.entity.EducationType;
import com.primaryschool.home.entity.ManageType;
import com.primaryschool.home.entity.PartyType;
import com.primaryschool.home.entity.StudentLabMenuType;
import com.primaryschool.home.entity.StudentType;
import com.primaryschool.home.entity.TeacherType;
import com.primaryschool.home.entity.TeachingResourcesContentType;
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
	
	@Override
	public int findEducationTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from EducationType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		EducationType tt=(EducationType)query.uniqueResult();
		
	//	System.out.println("类型转换获取Id"+tt);
		
		return tt.getId();
	}


	@Override
	public int findStudentTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from StudentType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		StudentType tt=(StudentType)query.uniqueResult();
		return tt.getId();
	}
	
	@Override
	public int findTeacherTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from TeacherType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);	//?设值
		
		TeacherType tt=(TeacherType)query.uniqueResult();
		return tt.getId();
	}


	@Override
	public int findManageTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from ManageType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);	//?设值
		
		ManageType tt=(ManageType)query.uniqueResult();
		return tt.getId();
	}


	@Override
	public int findPartyTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from PartyType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);	//?设值
		
		PartyType tt=(PartyType)query.uniqueResult();
		return tt.getId();
	}

	@Override
	public int findCultureTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from CultureType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);	//?设值
		
		CultureType tt=(CultureType)query.uniqueResult();
		return tt.getId();
	}

	@Override
	public int findLabClassTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from StudentLabMenuType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);	//?设值
		
		StudentLabMenuType tt=(StudentLabMenuType)query.uniqueResult();
		return tt.getId();
	}

	@Override
	public int findTeachingResourcesTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesContentType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);	//?设值
		
		TeachingResourcesContentType tt=(TeachingResourcesContentType)query.uniqueResult();
		return tt.getId();
	}

}
