package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IEducationDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;


@Repository
public class EducationDao<T> implements IEducationDao<T> {

	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired 
	private ITypeFlagToTypeIdDao typeFlagToTypeId;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEducationInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		//根据类型获取id
	
		int id=typeFlagToTypeId.findEducationTypeIdByTypeFlag(flag);

		String hql="select new com.primaryschool.home.entity.Education(t.id,t.itemTitle,t.addTime) from Education t where t.typeId=? and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

	@Override
	public List<T> findEducationInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveEducationInfo(int id, String flag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addEducationInfo(String flag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteEducationById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

}
