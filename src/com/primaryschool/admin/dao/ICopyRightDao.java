package com.primaryschool.admin.dao;

/**
 * 
* @ClassName: ICopyRightDao
* @Description: TODO 版权声明
* @author Mingshan
* @date 2017年4月21日 下午1:50:54
*
* @param <T>
 */

public interface ICopyRightDao<T> {
	//获取版权声明信息
	T findCopyRightInfo();
	
	//添加  信息
	int  saveCopyRightInfo(T t);
	
	//修改信息
	boolean updateCopyRightInfo(T t);
}
