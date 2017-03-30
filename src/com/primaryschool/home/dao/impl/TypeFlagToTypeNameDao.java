package com.primaryschool.home.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ITypeFlagToTypeNameDao;
import com.primaryschool.home.entity.EducationType;
import com.primaryschool.home.entity.ManageType;
import com.primaryschool.home.entity.PartyType;
import com.primaryschool.home.entity.StudentType;
import com.primaryschool.home.entity.TeacherType;
import com.primaryschool.home.entity.TrendsType;

@Repository
public class TypeFlagToTypeNameDao implements ITypeFlagToTypeNameDao {

	@Autowired
	private SessionFactory sessionFactory;
	/*
	 * (non-Javadoc)
	 * 通过typeFlag找到typeName
	 */
	@Override
	public String findTrendsTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from TrendsType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		TrendsType tt=(TrendsType)query.uniqueResult();
		return tt.getItemTypeName();
		
	}
	@Override
	public String findTeacherTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from TeacherType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		TeacherType tt=(TeacherType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	@Override
	public String findManageTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from ManageType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		ManageType tt=(ManageType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	@Override
	public String findPartyTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from PartyType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		PartyType tt=(PartyType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	
	
	@Override
	public String findEducationTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from EducationType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		EducationType tt=(EducationType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	
	
	@Override
	public String findStudentTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from StudentType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		StudentType tt=(StudentType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	
	
}
