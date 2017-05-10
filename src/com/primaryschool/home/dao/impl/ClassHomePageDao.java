package com.primaryschool.home.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IClassHomePageDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;

@Repository
public class ClassHomePageDao<T> implements IClassHomePageDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private ITypeFlagToTypeIdDao typeFlagToTypeId;
	
	/**获取班级主页中的班级动态，成长故事，学生文章**/
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findClassHomePageInfo(int classId,String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeId.findClasshomepageIdByTypeFlag(flag);
		String hql="select new com.primaryschool.home.entity.ClassHomePage(t.id,t.itemTitle,t.addTime,t.itemAuthor) from ClassHomePage t where t.typeId= ? and t.classId= ? and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setInteger(1, classId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T findClassHomePageInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.ClassHomePage(t.id,t.itemTitle,t.itemContent,t.itemAuthor,t.addTime,t.viewCount,tt.itemTypeName,tt.itemTypeFlag)from ClassHomePage t,ClassHomePageType tt  where tt.id=t.typeId and t.id=? and t.isPublish=1";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public boolean saveClassHomePageInfo(int id, String flag, String title, String content, String add_time,
			int is_publish, int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addClassHomePageInfo(String flag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteClassHomePageById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		String hql="update ClassHomePage t set t.viewCount=t.viewCount+1  where t.id=?";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setInteger(0,id);
		return (query.executeUpdate()>0);
	}

	@Override
	public int findClassHomePageCount(String flag) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//根据类型获取id
		int id=typeFlagToTypeId.findClasshomepageIdByTypeFlag(flag);
		String sql="select count(CASE WHEN t.type_id=? and t.is_publish=1 THEN 1 ELSE NULL END) from ps_class_homepage t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,id);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHotClassHomePageInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int id=typeFlagToTypeId.findClasshomepageIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.ClassHomePage(t.id,t.itemTitle,t.addTime,t.itemAuthor) from ClassHomePage t where t.typeId=? and t.isPublish=1 order by t.viewCount desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findClassHomePageListInfo() {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.ClassHomePage(hp.id, hp.itemTitle, hp.classId, g.gradeCode, sc.className,hp.addTime)  from ClassHomePage hp,Sclass sc,Grade g  where hp.classId=sc.id  and g.id=sc.gradeId   order by hp.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(8);
		return query.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findSilderClassHomePageInfo() {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.ClassHomePage(hp.id, hp.itemTitle,hp.itemContent, hp.classId, g.gradeCode, sc.className)  from ClassHomePage hp,Sclass sc,Grade g  where hp.classId=sc.id  and g.id=sc.gradeId  and  hp.isImage=1  order by hp.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(5);
		return query.list();
	}
	
	
}
