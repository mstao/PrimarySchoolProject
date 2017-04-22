package com.primaryschool.admin.service;

import java.util.List;
import java.util.Set;

/**
 * 
* @ClassName: IUserService
* @Description: TODO 后台管理用户   service
* @author Mingshan
* @date 2017年4月18日 下午6:35:42
*
 */
public interface IUserService<T> {
	/**查询用户**/
	T getByUerName(String userName);
	
	/**根据userName获取角色**/
	Set<String> getRoles(String userName);
	
	/**获取权限**/
	Set<String> getPermissions(String userName);
	
	/**获取权限资源**/	
	List<T> findResources();
	
	/**注册用户**/
	void saveUser(T t);
	
	/**验证用户是否被注册**/
	T findUserByUserName(String userName);
	
	/**验证邮箱是否已被使用**/
	T findUserByEmail(String email);
}
