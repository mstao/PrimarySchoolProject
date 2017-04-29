package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminHeaderMasterService<T> {
	 /**获取校园动态记录**/
    List<T> findHeaderMasterInfo(int position,int item_per_page);
    /**获取统计总数**/ 
	int findHeadMasterCount();  
	/**删除信息**/
	void deleteHeadMasterById(List<?> ids);
	/**获取职位**/
	List<T> findHeadMasterPost();
	/**保存**/
	int  saveHeadMaster(T t);
    /**由职位获取职位id**/
	
	int findPostIdByPostName(String name);
	
	/**由id获取内容**/
	T findHeadMasterById(int id);
	
	/**根据id修改信息**/
	boolean updateHeadMasterInfo(T t);
}
