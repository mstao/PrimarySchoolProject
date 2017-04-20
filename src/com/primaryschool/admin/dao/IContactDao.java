package com.primaryschool.admin.dao;

/**
 * 
* @ClassName: IContactDao
* @Description: TODO 联系我们
* @author Mingshan
* @date 2017年4月20日 下午10:24:39
*
* @param <T>
 */
public interface IContactDao<T> {

	//获取联系我们信息
	T findContactInfo();
}
