package com.primaryschool.admin.dao;

import java.util.List;

/**
 * 
* @ClassName: ICampusSceneryDao
* @Description: TODO 校园风光
* @author Mingshan
* @date 2017年4月18日 下午8:06:56
*
 */
public interface ICampusSceneryDao<T> {

	/**获取校园风光列表**/
	List<T> findCampusSceneryList();
	
	/**添加校园风光图片**/
	int saveCampusScenery(T t);
	
	/**删除校园风光**/
	void deleteCampusScenery(int id);
}
