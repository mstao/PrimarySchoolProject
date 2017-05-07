package com.primaryschool.apply.dao;

import java.util.List;

/**
 * 
* @ClassName: IApplyDao
* @Description: TODO 信息
* @author Mingshan
* @date 2017年5月1日 下午3:13:20
*
* @param <T>
 */
public interface IApplyDao<T> {

	/**保存信息**/
	int  saveApplyInfo(T t);
	
	/**通过id获取信息**/
	T findApplyInfo(int id);
	
	/**通过cardCode获取信息**/
	T findApplyInfoByCardId(String cardCode);
	
	/**通过注册用户身份证获取相关联的 报名学生身份证**/
	T findApplyCardCodeByUserCardCode(String userCardCode);
	
	/**更新报名信息**/
	void updateApplyInfo(T t);
	
	/**根据当前年份找 date ID**/
	int findDateIdByYear(int year);
	
	/**根据当前年份获取报名时间信息**/
	T findDateInfoByYear(int year);
	
	/**根据当前年份获取报名的信息**/	
	List<T> findApplyInfoByYear(int year,int status,int position,int item_per_page);
	
	/**获取总记录量**/
	int findApplyCountByYear(int year);

	/**更改当前用户的报名状态**/
	boolean  updateApplyStatus(int id,int statusValue,String reason);
	
	/**添加报名日期**/
	void saveApplyDate(T t);
	
	/**修改报名日期**/
	void updateApplyDate(T t);
	
	/**根据状态进行模糊查询信息**/
	List<T> findApplyInfoByToken(String token,int status,int year);
		
	/**根据条件统计报名人数**/
	int findApplyCountByStatusYear(int status,int year);
	
	/**删除**/
	void  deleteApplyInfoById(List<?> ids);    
	
	/**开启，关闭报名**/
	void  updateBeginStatus(int year,int beginApply);
}
