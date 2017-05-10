package com.primaryschool.apply.dao;

import com.primaryschool.apply.entity.ApplyUser;

/**
 * 
* @ClassName: ApplyUser
* @Description: TODO 学生报名用户
* @author Mingshan
* @date 2017年4月30日 下午4:10:00
*
 */
public interface IApplyUserDao<T> {

	/**添加用户**/
	int saveUser(T t);
	
	/**验证用户是否被注册**/
	T findUserByCard(String card);
	
	/**验证用户是否被注册**/
	T findUserByEamil(String email);
	
	/**根据Id查找用户**/
	T findUserById(int id);
	
	/**用来登录**/
	T findUserByCardPassword(String card,String password);
	
	/**检测用户名是否存在**/
	T getByUserName(String userName);
	
	/**检测用户名与邮箱是否匹配**/
	T getByInfo(String userName,String email);
	
	/**更新用户**/
	void updateStuInfo(ApplyUser user);
}
