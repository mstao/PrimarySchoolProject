package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAuthorityDao;

/**
 * 
* @ClassName: AuthorityDao
* @Description: TODO 权限管理 -DAO
* @author Mingshan
* @date 2017年4月23日 上午8:59:35
*
* @param <T>
 */

@Repository
public class AuthorityDao<T> implements IAuthorityDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 获取所有角色列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllRoles() {
		// TODO Auto-generated method stub
		String  hql="from SecurityRole";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 删除角色
	 */
	@Override
	public void deleteRoleById(List<?> ids) {
		// TODO Auto-generated method stub
		String hql = "delete from SecurityRole where id in (:ids)";
		Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids).executeUpdate();
	}

	/**
	 * 保存角色
	 */
	@Override
	public int saveRole(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	/**
	 * 根据name 模糊查询角色
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findRoleByName(String name) {
		// TODO Auto-generated method stub
		String hql="from SecurityRole sr where sr.roleName like:name or sr.roleCode like:name";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);     
		query.setString("name", "%"+name+"%");  
		
		return query.list();
	}

	/**
	 * 获取所有用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllUser(int position, int item_per_page) {
		// TODO Auto-generated method stub
		
		String hql="select new com.primaryschool.admin.entity.SecurityUser(su.id,su.userName,su.status,su.email,su.number,sr.roleName) from SecurityUser su,SecurityUserToRole utr,SecurityRole sr  where su.id=utr.userId and sr.id=utr.roleId  order by su.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);

		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		
		return query.list();
	}

	/**
	 * 获取用户数量
	 */
	@Override
	public int findUserCount() {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		String sql="select count(*) from ps_security_user";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	/**
	 * 修改用户的角色
	 */
	@Override
	public boolean updateUserRole(T t) {
		// TODO Auto-generated method stub
		String hql="update SecurityUserToRole sur set sur.roleId=:roleId where sur.userId=:userId";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	/**
	 * 根据用户名模糊查询用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findUserByName(String userName) {
		// TODO Auto-generated method stub
       String hql="select new com.primaryschool.admin.entity.SecurityUser(su.id,su.userName,su.status,su.email,su.number,sr.roleName) from SecurityUser su,SecurityUserToRole utr,SecurityRole sr  where su.id=utr.userId and sr.id=utr.roleId and su.userName like:name  order by su.addTime desc";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);     
		query.setString("name", "%"+userName+"%");  
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findResources() {
		// TODO Auto-generated method stub
		String hql="from SecurityResources";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);     
		return query.list();
	}

}
