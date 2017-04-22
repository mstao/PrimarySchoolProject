package com.primaryschool.home.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IManageDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;

@Repository
public class ManageDao<T> implements IManageDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ITypeFlagToTypeIdDao typeFlagToTypeIdDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findManageInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findManageTypeIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.Manage(m.id,m.itemTitle,m.addTime) from Manage m where m.typeId=? and m.isPublish=1 order by m.addTime desc";
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
		String hql="select new com.primaryschool.home.entity.Manage(t.id,t.itemTitle,t.itemContent,t.addTime,t.viewCount,tt.itemTypeName,tt.itemTypeFlag,t.author)from Manage t,ManageType tt  where tt.id=t.typeId and t.id=? and t.isPublish=1";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public boolean saveManageInfo(int id, String flag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addManageInfo(String flag, String title, String content, String add_time, int is_publish, int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteManageById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		String hql="update Manage t set t.viewCount=t.viewCount+1  where t.id=?";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setInteger(0,id);
		return (query.executeUpdate()>0);
	}

	@Override
	public int findManageCount(String flag) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//根据类型获取id
		int id=typeFlagToTypeIdDao.findManageTypeIdByTypeFlag(flag);
		String sql="select count(CASE WHEN t.type_id=? and t.is_publish=1 THEN 1 ELSE NULL END) from ps_manage t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,id);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHotManageInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findManageTypeIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.Manage(t.id,t.itemTitle,t.addTime) from Manage t where t.typeId=? and t.isPublish=1 order by t.viewCount desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findSliderManageInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findManageTypeIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.Manage(t.id,t.itemTitle,t.itemContent,t.addTime,tt.itemTypeFlag) from Manage t,ManageType tt  where t.typeId=? and t.typeId=tt.id and t.isPublish=1 and t.isImage=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

}
