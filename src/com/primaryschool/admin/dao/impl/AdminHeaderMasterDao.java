package com.primaryschool.admin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminHeaderMasterDao;

/**
 * 
* @ClassName: AdminHeaderMasterDao
* @Description: TODO  校长信箱
* @author Mingshan
* @date 2017年4月27日 上午2:51:23
*
 */
@Repository
public class AdminHeaderMasterDao<T> implements IAdminHeaderMasterDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHeaderMasterInfo(int position, int item_per_page) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.HeadMaster(hm.id,hm.name,hm.work,hm.email,hm.avatar,hmp.postName) from HeadMaster hm,HeadMasterPost hmp where hm.postId=hmp.id order by hm.postId asc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public int findPartyCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
