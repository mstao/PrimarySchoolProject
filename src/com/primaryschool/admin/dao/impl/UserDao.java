package com.primaryschool.admin.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IUserDao;
import com.primaryschool.admin.entity.SecurityUser;

/**
 * 
* @ClassName: UserDao
* @Description: TODO 后台用户  管理DAO
* @author Mingshan
* @date 2017年4月18日 下午5:22:53
*
* @param <T>
 */

@Repository
public class UserDao<T> implements IUserDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	/**
	 * 查询用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getByUerName(String userName) {
		// TODO Auto-generated method stub
		String hql="from SecurityUser u where u.userName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		return (T) query.uniqueResult();
	}

	/**
	 * 根据用户获取其角色
	 */
	@Override
	public Set<String> getRoles(String userName) {
		// TODO Auto-generated method stub
		Set<String>  roles =new HashSet<String>();
		String hql="select new com.primaryschool.admin.entity.SecurityUser(u.id,u.userName,r.roleName) from SecurityUser u,SecurityRole r,SecurityUserToRole ur where u.id=ur.userId and r.id=ur.roleId  and u.userName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		SecurityUser  u=(SecurityUser)query.uniqueResult();	
       
		
		roles.add(u.getRoleName());
		
		return roles;
	}

	/**
	 * 根据用户获取其权限
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> getPermissions(String userName) {
		// TODO Auto-generated method stub
        Set<String>  permissions =new HashSet<String>();
		
		String hql="select new com.primaryschool.admin.entity.SecurityUser(u.id,u.userName,r.roleName,p.permissionName) from SecurityUser u,SecurityRole r,SecurityPermission p,SecurityUserToRole ur,SecurityRoleToPermission rp where u.id=ur.userId and r.id=ur.roleId and p.id=rp.permissionId and r.id=rp.roleId  and u.userName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		List<SecurityUser> list=(List<SecurityUser>)query.list();
		
		
		for(SecurityUser u:list){
			permissions.add(u.getPermissionName());
		}
		
		return permissions;               
	}

	/**
	 * 获取所有资源   key => val    
	 * key =>url
	 * val =>permission
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findResources() {
		// TODO Auto-generated method stub
		String hql="from SecurityResources order by id asc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
