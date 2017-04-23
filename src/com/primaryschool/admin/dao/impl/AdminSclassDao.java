package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminSclassDao;
@Repository
public class AdminSclassDao<T> implements IAdminSclassDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int addSclass(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public void deleteSclassById(List<?> ids) {
		// TODO Auto-generated method stub
		String hql = "delete from Sclass where id in (:ids)";
		 Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		 query.setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public int getSclassYear() {
		// TODO Auto-generated method stub
		String hql="select g.gradeCode from Grade g order by g.gradeCode desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(1);
		return (int) query.uniqueResult();
	}

	@Override
	public void addGradeInfo() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		 Date date = new Date();
	       String formatDate = sdf.format(date);
	       int d=Integer.parseInt(formatDate);
		if(getSclassYear() == d){
		
		}else{
			String gradeName=d+"年";
			String sql="insert into ps_grade(grade_name,grade_code) values (?,?)";
			Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setString(0, gradeName);
			query.setInteger(1, d);
			query.executeUpdate();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findClassInfoByClassId(int ClassId,int position,int item_per_page) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.ClassHomePage(t.id, t.itemTitle, t.itemContent, t.itemAuthor, t.typeId,t.addTime,t.isPublish) from ClassHomePage t where t.classId= ? order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, ClassId);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findSclassInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.ClassHomePage(t.id,t.itemAuthor,t.classId,t.itemTitle,t.itemContent,t.addTime,tt.itemTypeName,tt.itemTypeFlag,t.isPublish)from ClassHomePage t,ClassHomePageType tt  where tt.id=t.typeId and t.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public boolean updateSclassInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update ClassHomePage u set u.itemTitle=:itemTitle ,u.itemContent=:itemContent,u.typeId=:typeId,u.addTime=:addTime,u.isImage=:isImage,u.isPublish=:isPublish,u.itemAuthor=:itemAuthor  where u.id=:id";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public int addSclassInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result=sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public void deleteSclassInfoById(List<?> ids) {
		// TODO Auto-generated method stub
		String hql = "delete from ClassHomePage where id in (:ids)";
		 Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		 query.setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public int findSclassCount(int classId) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		String sql="select count(CASE WHEN t.class_id=? THEN 1 ELSE NULL END ) from ps_class_homepage t";
		Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setInteger(0, classId);
		count=(BigInteger)query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findSclassIntroById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.ClassSynopsis(t.id,t.classSynopsis)from ClassSynopsis t where t.classId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T)query.uniqueResult();
		
	}

	@Override
	public int addSclassIntro(T t) {
		// TODO Auto-generated method stub
		Serializable result=sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public boolean updateSclassIntroInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update ClassSynopsis c set c.classSynopsis=:classSynopsis ,c.classId=:classId where c.id=:id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public int findGradeIdByCode(int gradeCode) {
		// TODO Auto-generated method stub
		String hql="select t.id from Grade t where t.gradeCode=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, gradeCode);
		return (int) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findClassPageType() {
		// TODO Auto-generated method stub
		String hql="from ClassHomePageType";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (List<T>) query.list();
	}

	@Override
	public String findfindClassPageTypeByTypeId(int typeId) {
		// TODO Auto-generated method stub
		String hql="select l.itemTypeName from ClassHomePageType l where l.id=? ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, typeId);
		
		return (String) query.uniqueResult();
	}

	@Override
	public int findPageTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="select l.id from ClassHomePageType l where l.itemTypeFlag=? ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, flag);
		
		return (int) query.uniqueResult();
	}

	

}
