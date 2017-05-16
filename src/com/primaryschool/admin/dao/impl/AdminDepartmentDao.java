package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminDepartmentDao;


@Repository
public class AdminDepartmentDao<T> implements IAdminDepartmentDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<?> findDepartmentNameList() {
		// TODO Auto-generated method stub
		String hql="from DepartmentLinkNameList";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (List<T>)query.list();
	}

	@Override
	public String findDepartmentNameById(int id) {
		// TODO Auto-generated method stub
		String hql="select d.departmentName from DepartmentLinkNameList d where d.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (String)query.uniqueResult();
	}
	
	@Override
	public int findDepartmentIdByName(String flag) {
		// TODO Auto-generated method stub
		String hql="select d.id from DepartmentLinkNameList d where d.departmentName=? or d.departmentType=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, flag);
		query.setString(1, flag);
		return (int)query.uniqueResult();
	}
	
	@Override
	public int addDepartmentName(T t) {
		// TODO Auto-generated method stub
		Serializable result=sessionFactory.getCurrentSession().save(t);
		return (Integer) result;
	}

	@Override
	public void deleteDepartmentName(List<?> ids) {
		// TODO Auto-generated method stub
		String hql="delete from DepartmentLinkNameList where id in (:ids)";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findDepartmentContentInfo(int deptId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.DepartmentLinkContent(d.id, d.itemTitle, d.typeId, d.addTime, d.isPublish, d.itemAuthor) from DepartmentLinkContent d where d.departmentId=? order by d.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, deptId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return (List<T>)query.list();
	}

	@Override
	public int findDepartmentContentCount(int deptId) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		String sql="select count(CASE WHEN d.department_id=? THEN 1 ELSE NULL END) from ps_departmentlink_content d";
		Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setInteger(0, deptId);
		count=(BigInteger)query.uniqueResult();
		r=count.intValue();
		return r;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public T findDeptContentInfo(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.DepartmentLinkContent(d.id, d.itemTitle, d.itemContent,d.typeId, d.addTime, d.isPublish,d.itemAuthor, d.departmentId, dd.itemTypeFlag, dd.itemTypeName) from DepartmentLinkContent d,DepartmentLinkContentType dd where d.typeId=dd.id and d.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public int addDepartmentContent(T t) {
		// TODO Auto-generated method stub
		Serializable result=sessionFactory.getCurrentSession().save(t);
		
		return (Integer)result;
	}

	@Override
	public void deleteDepartmentContent(List<?> ids) {
		// TODO Auto-generated method stub
		String hql="delete from DepartmentLinkContent where id in (:ids)";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public boolean updateDeparmentContent(T t) {
		// TODO Auto-generated method stub
		String hql="update DepartmentLinkContent u set u.itemTitle=:itemTitle ,u.itemContent=:itemContent,u.departmentId=:departmentId,u.typeId=:typeId,u.addTime=:addTime,u.isImage=:isImage,u.isPublish=:isPublish,u.itemAuthor=:itemAuthor  where u.id=:id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> findDepartmentType() {
		// TODO Auto-generated method stub
		String hql="from DepartmentLinkContentType";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (List<T>)query.list();
	}

	@Override
	public String findDepartmentTypeById(int id) {
		// TODO Auto-generated method stub
		String hql="select d.itemTypeName from DepartmentLinkContentType d where d.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (String)query.uniqueResult();
	}

	@Override
	public int findDepartmentTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="select d.id from DepartmentLinkContentType d where d.itemTypeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, flag);
		return (int)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchInfo(String flag, String token) {
		// TODO Auto-generated method stub
		int id=findDepartmentIdByName(flag);
		String hql="select new com.primaryschool.home.entity.DepartmentLinkContent(d.id, d.itemTitle, d.typeId, d.addTime, d.isPublish, d.itemAuthor) from DepartmentLinkContent d where d.departmentId=? and d.itemTitle like ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setString(1, "%"+token+"%");
		return (List<T>)query.list();
	}

	
}
