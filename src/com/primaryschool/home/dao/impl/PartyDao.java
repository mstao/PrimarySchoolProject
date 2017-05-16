package com.primaryschool.home.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IPartyDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;

@Repository
public class PartyDao<T> implements IPartyDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ITypeFlagToTypeIdDao typeFlagToTypeIdDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findPartyInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findPartyTypeIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.Party(p.id,p.itemTitle,p.addTime) from Party p where p.typeId=? and p.isPublish=1 order by p.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findPartyInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.Party(t.id,t.itemTitle,t.itemContent,t.addTime,t.viewCount,tt.itemTypeName,tt.itemTypeFlag,t.author)from Party t,PartyType tt  where tt.id=t.typeId and t.id=? and t.isPublish=1";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public boolean savePartyInfo(int id, String flag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addPartyInfo(String flag, String title, String content, String add_time, int is_publish, int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deletePartyById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		String hql="update Party t set t.viewCount=t.viewCount+1  where t.id=?";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setInteger(0,id);
		return (query.executeUpdate()>0);
	}

	@Override
	public int findPartyCount(String flag) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//根据类型获取id
		int id=typeFlagToTypeIdDao.findPartyTypeIdByTypeFlag(flag);
		String sql="select count(CASE WHEN t.type_id=? and t.is_publish=1 THEN 1 ELSE NULL END) from ps_party t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,id);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHotPartyInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findPartyTypeIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.Party(t.id,t.itemTitle,t.addTime) from Party t where t.typeId=? and t.isPublish=1 order by t.viewCount desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

	/**
	 * 获取轮播图
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findSliderPartyInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findPartyTypeIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.Party(t.id,t.itemTitle,tt.itemTypeFlag,t.imagePath) from Party t,PartyType tt where t.typeId=? and t.typeId=tt.id and t.isPublish=1 and t.isImage=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

}
