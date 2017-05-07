package com.primaryschool.apply.service;

public interface IApplyUserService<T> {
	/**添加用户**/
	int saveUser(T t);
	
	/**验证用户是否被注册**/
	T findUserByCard(String card);
	
	/**用来登录**/
	T findUserByCardPassword(String card,String password);
	
	/**验证邮箱是否已被使用**/
	T findUserByEmail(String email);
}
