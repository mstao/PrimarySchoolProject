package com.primaryschool.admin.dao;

import java.util.List;
import java.util.Set;

/**
 * 
* @ClassName: IUserDao
* @Description: TODO  后台管理用户 DAO
* @author Mingshan
* @date 2017年4月18日 下午5:19:22
*
 */
public interface IUserDao<T> {

	/**查询用户**/
	T getByUerName(String userName);
	
	/**根据userName获取角色**/
	Set<String> getRoles(String userName);
	
	/**获取权限**/
	Set<String> getPermissions(String userName);
	
	/**获取权限资源**/	
	List<T> findResources();
}
