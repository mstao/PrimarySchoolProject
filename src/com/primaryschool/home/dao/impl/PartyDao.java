package com.primaryschool.home.dao.impl;

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

	@Override
	public List<T> findPartyInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
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

}
