package com.primaryschool.admin.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminTrendsDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;



/**
 * 
* @ClassName: TrendsDao
* @Description: TODO 校园动态 DAO
* @author Mingshan
* @date 2017年4月14日 下午3:56:14
*
* @param <T>
 */

@Repository
public class AdminTrendsDao<T> implements IAdminTrendsDao<T> {

	@Autowired
	private SessionFactory  sessionFactory;
	
	@Autowired
	private ITypeFlagToTypeIdDao  typeFlagToTypeIdDao;
	
	
	/**
	 * 获取 校园动态 列表信息 不过滤 草稿
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTrendsInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		
		//根据类型获取id
		int id=typeFlagToTypeIdDao.findTrendsTypeIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.Trends(t.id,t.itemTitle,t.addTime) from Trends t where t.typeId=?  order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	/**
	 * 获取校园动态的具体信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findTrendsInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.Trends(t.id,t.itemTitle,t.itemContent,t.addTime,t.viewCount,tt.itemTypeName,tt.itemTypeFlag)from Trends t,TrendsType tt  where tt.id=t.typeId and t.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public boolean saveTrendsInfo(int id, String flag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addTrendsInfo(String flag, String title, String content, String add_time, int is_publish, int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteTrendsById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 统计数量
	 */
	@Override
	public int findTrendsCount(String flag) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//根据类型获取id
		int id=typeFlagToTypeIdDao.findTrendsTypeIdByTypeFlag(flag);
		String sql="select count(CASE WHEN t.type_id=?  THEN 1 ELSE NULL END) from ps_trends t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,id);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}


}
