package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminHeaderMasterService<T> {
	 /**获取校园动态记录**/
    List<T> findHeaderMasterInfo(int position,int item_per_page);
}
