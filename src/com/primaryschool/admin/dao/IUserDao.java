package com.primaryschool.admin.dao;

import java.util.List;
import java.util.Set;

import com.primaryschool.admin.entity.SecurityUser;

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
	/**添加用户**/
	int saveUser(T t);
	
	/**验证用户是否被注册**/
	T findUserByUserName(String userName);
	
	/**验证邮箱是否已被使用**/
	T findUserByEmail(String email);
	
	/**注册时将用户对应的角色置为游客**/
	void saveUserRole(T t);
	
	/**删除用户**/
    void deleteUserById(List<?> ids);     
    
    /**根据用户id修改密码**/ 
    void updateUserPassword(int uid,String userName,String password);
    
    /**获取原密码**/    
    T  findUserByUid(int uid);
    
}
