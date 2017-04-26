package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IUserDao;
import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.home.entity.TrendsType;

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
		String hql="select new com.primaryschool.admin.entity.SecurityUser(u.id,u.userName,r.roleName,r.roleCode) from SecurityUser u,SecurityRole r,SecurityUserToRole ur where u.id=ur.userId and r.id=ur.roleId  and u.userName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		SecurityUser  u=(SecurityUser)query.uniqueResult();	
      		
		roles.add(u.getRoleCode());
		
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
		
		String hql="select new com.primaryschool.admin.entity.SecurityUser(u.id,u.userName,p.permissionName) from SecurityUser u,SecurityRole r,SecurityPermission p,SecurityUserToRole ur,SecurityRoleToPermission rp where u.id=ur.userId and r.id=ur.roleId and p.id=rp.permissionId and r.id=rp.roleId  and u.userName=?";
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

	/**
	 * 添加用户
	 */
	@Override
	public int saveUser(T t) {
		// TODO Auto-generated method stub
		Serializable res=sessionFactory.getCurrentSession().save(t);
		return (int) res;
	}

	/**
	 * 验证用户名是否已被注册
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		String hql="from SecurityUser u where u.userName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		
		return (T) query.uniqueResult();
	}

	/**
	 * 验证邮箱是否被使用
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findUserByEmail(String email) {
		// TODO Auto-generated method stub
		String hql="from SecurityUser u where u.email=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, email);
		
		return (T) query.uniqueResult();
	}
	
	/**
	 * 注册将用户角色 置为游客
	 */
	@Override
	public void saveUserRole(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(t);
	}

	
	/**
	 * 删除用户
	 */
	@Override
	public void deleteUserById(List<?> ids) {
		// TODO Auto-generated method stub
		String hql = "delete from SecurityUser where id in (:ids)";
		Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids).executeUpdate();
	}

		
	

}
