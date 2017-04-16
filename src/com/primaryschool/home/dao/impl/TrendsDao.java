package com.primaryschool.home.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ITrendsDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;
import com.primaryschool.home.entity.Trends;

/**
 * 
* @ClassName: TrendsDao
* @Description: TODO  校园动态 -DAOIMPL
* @author Mingshan
* @date 2017年3月26日 下午4:04:51
*
* @param <T>
 */

@Repository
public class TrendsDao<T> implements ITrendsDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired 
	private ITypeFlagToTypeIdDao typeFlagToTypeId;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTrendsInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		//根据类型获取id
		int id=typeFlagToTypeId.findTrendsTypeIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.Trends(t.id,t.itemTitle,t.addTime) from Trends t where t.typeId=? and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findTrendsInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.Trends(t.id,t.itemTitle,t.itemContent,t.addTime,t.viewCount,tt.itemTypeName,tt.itemTypeFlag)from Trends t,TrendsType tt  where tt.id=t.typeId and t.id=? and t.isPublish=1";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

    @Override
	public boolean saveTrendsInfo(int id, String type, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addTrendsInfo(String type, String title, String content, String add_time, int is_publish, int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteTrendsById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		String hql="update Trends t set t.viewCount=t.viewCount+1  where t.id=?";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setInteger(0,id);
		return (query.executeUpdate()>0);
	}

	@Override
	public int findTrendsCount(String flag) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//根据类型获取id
		int id=typeFlagToTypeId.findTrendsTypeIdByTypeFlag(flag);
		String sql="select count(CASE WHEN t.type_id=? and t.is_publish=1 THEN 1 ELSE NULL END) from ps_trends t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,id);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHotTrendsInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeId.findTrendsTypeIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.Trends(t.id,t.itemTitle,t.addTime,t.viewCount) from Trends t where t.typeId=? and t.isPublish=1 order by t.viewCount desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findSlideTrendsInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		//根据类型获取id
		int id=typeFlagToTypeId.findTrendsTypeIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.Trends(t.id,t.itemTitle,t.itemContent,t.addTime) from Trends t where t.typeId=? and t.isImage=1 and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	

}
