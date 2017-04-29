package com.primaryschool.admin.dao.impl;

import java.math.BigInteger;
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
		String hql="select new com.primaryschool.home.entity.HeadMaster(hm.id,hm.name,hm.work,hm.email,hm.avatar,hmp.postName,hm.isPublish) from HeadMaster hm,HeadMasterPost hmp where hm.postId=hmp.id order by hm.postId asc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	/**
	 * 获取记录总数
	 */
	@Override
	public int findHeadMasterCount() {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		
		String sql="select count(*) from ps_headmaster";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void deleteHeadMasterById(List<?> ids) {
		// TODO Auto-generated method stub
		
		String hql = "delete from HeadMaster where id in (:ids)";
		Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids).executeUpdate();
	}

	/**
	 * 获取职位信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHeadMasterPost() {
		// TODO Auto-generated method stub
		String hql="from HeadMasterPost";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
				
		return query.list();
	}

	@Override
	public int saveHeadMaster(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
