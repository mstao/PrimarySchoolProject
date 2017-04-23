package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminTeachingResourceDao;
@Repository
public class AdminTeachingResourceDao<T> implements IAdminTeachingResourceDao<T> {

	@Autowired
	private SessionFactory  sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTeachingResourceInfo(int classId,int menuId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.TeachingResourcesContent(t.id,t.itemTitle,t.addTime,t.isPublish,t.author,t.typeId) from TeachingResourcesContent t where t.classId= ? and t.menuId= ? order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, classId);
		query.setInteger(1, menuId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findTeachingResourceInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.TeachingResourcesContent(t.id,t.author,t.itemTitle,t.itemContent,t.addTime,t.viewCount,tt.itemTypeName,tt.itemTypeFlag,t.isPublish)from TeachingResourcesContent t,TeachingResourcesContentType tt  where tt.id=t.typeId and t.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public int findTeachingResourceCount(int classId,int menuId) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		String sql="select count(CASE WHEN t.class_id=? and t.menu_id=? THEN 1 ELSE NULL END) from ps_teaching_resources_content t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,classId);
		query.setInteger(1,menuId);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@Override
	public boolean updateTeachingResourceInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update TeachingResourcesContent u set u.itemTitle=:itemTitle ,u.itemContent=:itemContent,u.classId=:classId,u.menuId=:menuId,u.typeId=:typeId,u.addTime=:addTime,u.isImage=:isImage,u.isPublish=:isPublish,u.author=:author  where u.id=:id";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public int addTeachingResourceInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public void deleteTeachingResourceById(List<?> ids) {
		// TODO Auto-generated method stub
		 String hql = "delete from TeachingResourcesContent where id in (:ids)";
		 Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		 query.setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public String findTeachingResurceNameById(int menuId) {
		// TODO Auto-generated method stub
		String hql="select r.resourceName from TeachingResourcesMenu r where r.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, menuId);
		return (String) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTeachingResourceTypeInfo() {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesContentType";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (List<T>) query.list();
	}

	@Override
	public String findTeachingResurceTypeById(int typeId) {
		// TODO Auto-generated method stub
		String hql="select r.itemTypeName from TeachingResourcesContentType r where r.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, typeId);
		return (String) query.uniqueResult();
	}

	@Override
	public int addTeachingResourceMenuInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public void deleteTeachingResourceMenuById(List<?> ids) {
		// TODO Auto-generated method stub
		String hql = "delete from TeachingResourcesMenu where id in (:ids)";
		 Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		 query.setParameterList("ids", ids).executeUpdate();
	}

}
