package com.primaryschool.admin.service;

import java.util.List;

public interface ICampusSceneryService<T> {

	/**获取校园风光列表**/
	List<T> findCampusSceneryList();
	
	/**添加校园风光图片**/
	int saveCampusScenery(T t);
	
	/**删除校园风光**/
	void deleteCampusScenery(int id);
}
