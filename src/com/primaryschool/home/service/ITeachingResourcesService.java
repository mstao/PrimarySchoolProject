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
	List<T> findTeachingResourcesMenu();
	
	/**获取教学资源的内容**/
	List<T> findTeachingResourcesContent(int menuId,int classId,String flag,int position,int item_per_page);
	
	/**根据menuId 来获取menuName**/
	String findTeachingResourcesMenuNameByMenuId(int menuId);
	
	/**根据年级id获取年级名称**/
	String findTeachingResourcesClassNameByClassId(int classId);
	
	/**根据id获取详细内容**/
	T findTeachingResourcesContentById(int id);
	
	/**根据类型获取教学资源内容的数量**/
	int  findTeachingResourcesContentCount(int menuId,int classId,String flag);

	/**获取人们教学资源**/
	List<T> findHotTeachingResourcesContent(int menuId,int classId,String flag,int position,int item_per_page);
	
	/**获取最近更新**/
	List<T> findLatestTeachingResourcesContent(int menuId,int classId,String flag,int position,int item_per_page);

	/***首页的教学资源信息***/
	List<T> findHomeTeachingResourcesContent(int position,int item_per_page);
	
	/**教学资源轮播图**/
	List<T> findSliderTeachingResourcesContent(int menuId,int classId,int position,int item_per_page);
}
