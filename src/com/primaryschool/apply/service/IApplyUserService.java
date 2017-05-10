package com.primaryschool.apply.service;

import com.primaryschool.apply.entity.ApplyUser;

public interface IApplyUserService<T> {
	/**添加用户**/
	int saveUser(T t);
	
	/**验证用户是否被注册**/
	T findUserByCard(String card);
	
	/**根据Id查找用户**/
	T findUserById(int id);
	
	/**用来登录**/
	T findUserByCardPassword(String card,String password);
	
	/**验证邮箱是否已被使用**/
	T findUserByEmail(String email);
	
	/**检测用户名是否存在**/
	T getByUserName(String userName);
	
	/**检测用户名与邮箱是否匹配**/
	T getByInfo(String userName,String email);
	
	/**更新用户**/
	void updateStuInfo(ApplyUser user);
}
