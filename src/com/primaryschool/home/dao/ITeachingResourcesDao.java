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
}
