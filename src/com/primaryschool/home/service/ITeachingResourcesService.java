package com.primaryschool.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 
* @ClassName: ITeachingResourcesService
* @Description: TODO 教学资源service
* @author Mingshan
* @date 2017年4月8日 下午7:53:13
*
 */

@Service
public interface ITeachingResourcesService<T> {

	/**获取教学资源列表**/
	List<T> findTeachingResourcesClassList();
	
	/**获取教学资源的内容列表**/
	List<T> findTeachingResourcesMeun();
}
