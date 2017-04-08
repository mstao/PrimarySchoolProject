package com.primaryschool.home.dao;

import java.util.List;

/**
 * 
* @ClassName: ITeachingResourcesDao
* @Description: TODO  教学资源
* @author Mingshan
* @date 2017年4月8日 下午2:09:07
*
 */

public interface ITeachingResourcesDao<T> {

	/**获取教学资源列表**/
	List<T> findTeachingResourcesClassList();
	
	/**获取教学资源的内容列表**/
	List<T> findTeachingResourcesMeun();
}
