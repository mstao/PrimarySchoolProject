package com.primaryschool.admin.dao;

import java.util.List;

/**
 * 
* @ClassName: IAuthorityDao
* @Description: TODO 权限管理
* @author Mingshan
* @date 2017年4月23日 上午8:57:39
*
 */
public interface IAuthorityDao<T> {

	/**获取所有角色**/
	List<T> findAllRoles();
    /**删除角色**/
    void deleteRoleById(List<?> ids);    
    /**增加角色**/
    int  saveRole(T t);
    /**根据角色名称模糊查询**/
    List<T> findRoleByName(String name);
    
    /**获取所有用户**/
    List<T> findAllUser(int position,int item_per_page);
    
    /**获取用户数量**/
    int findUserCount();
    
    /**修改用户的角色**/
    boolean updateUserRole(T t);
    
    /**根据用户名称模糊查询**/
    List<T> findUserByName(String userName);
}
