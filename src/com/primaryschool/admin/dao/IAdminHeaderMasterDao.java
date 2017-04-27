package com.primaryschool.admin.dao;

import java.util.List;

/**
 * 
* @ClassName: IHeaderMasterDao
* @Description: TODO 校长信箱
* @author Mingshan
* @date 2017年4月27日 上午2:49:02
*
 */
public interface IAdminHeaderMasterDao<T> {

	 /**获取校园动态记录**/
    List<T> findHeaderMasterInfo(int position,int item_per_page);
    
    /**获取统计总数**/ 
	int findPartyCount();  
}
