package com.primaryschool.apply.dao;

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
	
	/**用来登录**/
	T findUserByCardPassword(String card,String password);
}
