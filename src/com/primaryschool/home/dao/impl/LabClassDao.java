package com.primaryschool.home.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ILabClassDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;

/**
 * 
* @ClassName: LabClassDao
* @Description: TODO 综合实验课DAO
* @author Mingshan
* @date 2017年4月6日 下午8:19:34
*
* @param <T>
 */

@Repository
public class LabClassDao<T> implements ILabClassDao<T> {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private ITypeFlagToTypeIdDao  typeFlagToTypeIdDao;
    
    
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLabClassListInfo() {
		// TODO Auto-generated method stub
		String hql="from StudentLab";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLabClassContent(int lid ,String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findLabClassTypeIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.StudentLabMenuContent(t.id,t.itemTitle,t.addTime,t.viewCount) from StudentLabMenuContent t where t.menuId=? and t.labId=? and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setInteger(1, lid);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public T findLabClassIntroduce(int id) {
		// TODO Auto-generated method stub
		String hql="from StudentLabMenuIntroduce st where st.menuId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T)query.uniqueResult();
	}


	@SuppressWarnings("unchecked")
	@Override
	public T findLabClassNameById(int id) {
		// TODO Auto-generated method stub
		
		String hql="from StudentLab where id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setInteger(0, id);
		query.uniqueResult();
		return (T) query.uniqueResult();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHotLabClassContent(int lid, String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findLabClassTypeIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.StudentLabMenuContent(t.id,t.itemTitle,t.addTime,t.viewCount) from StudentLabMenuContent t where t.menuId=? and t.labId=? and t.isPublish=1 order by t.viewCount desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setInteger(1, lid);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}


	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		String hql="update StudentLabMenuContent t set t.viewCount=t.viewCount+1  where t.id=?";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setInteger(0,id);
		return (query.executeUpdate()>0);
	}


	@Override
	public int findLabClassContentCount(String flag) {
		// TODO Auto-generated method stub

		BigInteger count;
		int r;
		int id=typeFlagToTypeIdDao.findLabClassTypeIdByTypeFlag(flag);
		String sql="select count(CASE WHEN t.menu_id=? and t.is_publish=1 THEN 1 ELSE NULL END) from ps_student_lab_menu_content t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,id);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}


	@SuppressWarnings("unchecked")
	@Override
	public T findLabClassContentById(int mid) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.StudentLabMenuContent(t.id,t.itemTitle,t.itemContent,t.author,t.addTime,t.viewCount,tt.itemTypeFlag,tt.itemTypeName)from StudentLabMenuContent t,StudentLabMenuType tt  where tt.id=t.menuId and t.id=? and t.isPublish=1";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, mid);
		return (T) query.uniqueResult();
	}

	/**
	 * 轮播
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findSliderLabClassContent(int lid, String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeIdDao.findLabClassTypeIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.StudentLabMenuContent(t.id,t.itemTitle,t.itemContent,t.addTime,tt.itemTypeFlag) from StudentLabMenuContent t,StudentLabMenuType tt where t.menuId=? and tt.id=t.menuId and t.labId=? and t.isPublish=1 and t.isImage=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setInteger(1, lid);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}
	
	

	
	

}
