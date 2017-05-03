
package com.primaryschool.apply.service;

import java.util.List;

public interface IApplyService<T> {
	/**保存信息**/
	int  saveApplyInfo(T t);
	/**通过id获取信息**/
	T findApplyInfo(int id);
	/**通过cardCode获取信息**/
	T findApplyInfoByCardId(String cardCode);
	
	/**通过注册用户身份证获取相关联的 报名学生身份证**/
	T findApplyCardCodeByUserCardCode(String userCardCode);
	
	/**根据当前年份找 date ID**/
	int findDateIdByYear(int year);
	/**根据当前年份获取报名时间信息**/
	T findDateInfoByYear(int year);
	
	/**根据当前年份获取报名的信息**/	
	List<T> findApplyInfoByYear(int year,int position,int item_per_page);
	
	/**获取总记录量**/
	int findApplyCountByYear(int year);
	/**更改当前用户的报名状态**/
	boolean  updateApplyStatus(int id,int statusValue);
}
