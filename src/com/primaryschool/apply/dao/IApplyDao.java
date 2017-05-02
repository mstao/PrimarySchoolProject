package com.primaryschool.apply.dao;

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
	
	/**根据当前年份找 date ID**/
	int findDateIdByYear(int year);
}
