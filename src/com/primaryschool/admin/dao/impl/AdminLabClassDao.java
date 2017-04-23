package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminLabClassDao;
@Repository
public class AdminLabClassDao<T> implements IAdminLabClassDao<T> {

	@Autowired
	private SessionFactory  sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLabClassInfo(int labId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.StudentLabMenuContent(t.id,t.itemTitle,t.author,t.menuId,t.addTime,t.isPublish) from StudentLabMenuContent t where t.labId= ? order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, labId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findLabClassInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.StudentLabMenuContent(t.id,t.author,t.itemTitle,t.itemContent,t.addTime,tt.itemTypeName,tt.itemTypeFlag,t.isPublish)from StudentLabMenuContent t,StudentLabMenuType tt  where tt.id=t.labId and t.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public int findLabClassCount(int labId) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		String sql="select count(CASE WHEN t.lab_id=? THEN 1 ELSE NULL END) from ps_student_lab_menu_content t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,labId);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@Override
	public boolean updateLabClassInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update StudentLabMenuContent u set u.itemTitle=:itemTitle ,u.itemContent=:itemContent,u.labId=:labId,u.menuId=:menuId,u.addTime=:addTime,u.isImage=:isImage,u.isPublish=:isPublish,u.author=:author  where u.id=:id";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public int addLabClassInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public void deleteLabClassById(List<?> ids) {
		// TODO Auto-generated method stub
		 String hql = "delete from StudentLabMenuContent where id in (:ids)";
		 Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		 query.setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public String findLabClassNameById(int menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findLabClassTypeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLabClassTypeById(int typeId) {
		// TODO Auto-generated method stub
		String hql="select l.labName from StudentLab l where l.id=? ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, typeId);
		return (String) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLabClassMenuInfo() {
		// TODO Auto-generated method stub
		String hql="from StudentLabMenuType";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (List<T>) query.list();
	}

	@Override
	public String findLabClassMenuById(int menuId) {
		// TODO Auto-generated method stub
		String hql="select l.itemTypeName from StudentLabMenuType l where l.id=? ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, menuId);
		
		return (String) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findLabMenuIntroById(int labId) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.StudentLabMenuIntroduce(t.id,t.introduce)from StudentLabMenuIntroduce t where t.menuId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, labId);
		return (T) query.uniqueResult();
	}

	@Override
	public int addLabIntroInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public boolean updateLabIntroInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update StudentLabMenuIntroduce u set u.introduce=:introduce ,u.menuId=:menuId where u.id=:id";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public void deleteLabById(List<?> ids) {
		// TODO Auto-generated method stub
		String hql = "delete from StudentLab where id in (:ids)";
		 Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		 query.setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public int addLabInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

}
