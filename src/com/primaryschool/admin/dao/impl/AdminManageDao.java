package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminManageDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;
@Repository
public class AdminManageDao<T> implements IAdminManageDao<T> {

	@Autowired
	private SessionFactory  sessionFactory;
	
	@Autowired
	private ITypeFlagToTypeIdDao  typeFlagToTypeIdDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findManageInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		//根据类型获取id
		int id=typeFlagToTypeIdDao.findManageTypeIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.Manage(t.id,t.itemTitle,t.addTime,t.isPublish,t.author) from Manage t where t.typeId=?  order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findManageInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.Manage(t.id,t.author,t.itemTitle,t.itemContent,t.addTime,t.viewCount,tt.itemTypeName,tt.itemTypeFlag,t.isPublish)from Manage t,ManageType tt  where tt.id=t.typeId and t.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public int findManageCount(String flag) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//根据类型获取id
		int id=typeFlagToTypeIdDao.findManageTypeIdByTypeFlag(flag);
		String sql="select count(CASE WHEN t.type_id=?  THEN 1 ELSE NULL END) from ps_manage t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,id);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@Override
	public boolean updateManageInfo(T t) {
		// TODO Auto-generated method stub
	    String hql="update Manage u set u.itemTitle=:itemTitle ,u.itemContent=:itemContent,u.addTime=:addTime,u.isImage=:isImage,u.isPublish=:isPublish,u.author=:author,u.imagePath=:imagePath  where u.id=:id";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public int addManageInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	@Override
	public void deleteManageById(List<?> ids) {
		// TODO Auto-generated method stub
		 String hql = "delete from Manage where id in (:ids)";
		 Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		 query.setParameterList("ids", ids).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchInfo(String flag, String token) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findManageTypeIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.Manage(c.id,c.itemTitle,c.addTime,c.isPublish,c.author) from Manage c where c.typeId=? and c.itemTitle like ? order by c.addTime desc";
		//String hql="from Culture c where c.typeId=? and c.itemTitle like ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setString(1, "%"+token+"%");
		return query.list();
	}
}
