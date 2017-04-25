package com.primaryschool.home.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ITypeFlagToTypeNameDao;
import com.primaryschool.home.entity.ClassHomePageType;
import com.primaryschool.home.entity.CultureType;
import com.primaryschool.home.entity.DepartmentLinkContentType;
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
* @ClassName: TypeFlagToTypeNameDao
* @Description: TODO  通过类型flag获取类型name
* @author Mingshan
* @date 2017年4月10日 上午8:20:22
*
 */

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
	
	
	@Override
	public String findCultureTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from CultureType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		CultureType tt=(CultureType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	
	
	@Override
	public String findLabClassTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from StudentLabMenuType  tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		StudentLabMenuType tt=(StudentLabMenuType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	
	@Override
	public String findClassTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from ClassHomePageType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		ClassHomePageType tt=(ClassHomePageType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	
	/**
	 * 获取教学资源 类型名称
	 */
	@Override
	public String findTeachingResourcesContentTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesContentType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		TeachingResourcesContentType tt=(TeachingResourcesContentType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	
	/**
	 * 获取部门链接 消息类型名称
	 */
	@Override
	public String findDepartmentLinkContentTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from DepartmentLinkContentType tt where tt.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		DepartmentLinkContentType tt=(DepartmentLinkContentType)query.uniqueResult();
		return tt.getItemTypeName();
	}
	
}
