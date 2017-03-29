package com.primaryschool.home.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ITypeNameToTypeFlagDao;
import com.primaryschool.home.entity.ManageType;
import com.primaryschool.home.entity.PartyType;
import com.primaryschool.home.entity.TeacherType;
import com.primaryschool.home.entity.TrendsType;

@Repository
public class TypeNameToTypeFlagDao implements ITypeNameToTypeFlagDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * (non-Javadoc)
	 * 通过typeName找到typeFlag
	 */
	@Override
	public String findTrendsTypeFlagByTypeName(String name) {
		// TODO Auto-generated method stub
		String hql="from TrendsType  tt where tt.itemTypeName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, name );
		
		TrendsType tt=(TrendsType)query.uniqueResult();
		return tt.getItemTypeFlag();
	}

	@Override
	public String findTeacherTypeFlagByTypeName(String name) {
		// TODO Auto-generated method stub
		String hql="from TeacherType  tt where tt.itemTypeName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, name );
		
		TeacherType tt=(TeacherType)query.uniqueResult();
		return tt.getItemTypeFlag();
	}

	@Override
	public String findManageTypeFlagByTypeName(String name) {
		// TODO Auto-generated method stub
		String hql="from ManageType  tt where tt.itemTypeName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, name );
		
		ManageType tt=(ManageType)query.uniqueResult();
		return tt.getItemTypeFlag();
	}

	@Override
	public String findPartyTypeFlagByTypeName(String name) {
		// TODO Auto-generated method stub
		String hql="from PartyType  tt where tt.itemTypeName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, name );
		
		PartyType tt=(PartyType)query.uniqueResult();
		return tt.getItemTypeFlag();
	}

	@Override
	public String findEducationTypeFlagByTypeName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
