package com.primaryschool.home.service;

import java.util.List;

public interface IManageService<T> {
	 /**获取记录**/
    List<T> findManageInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    List<T> findManageInfoById(int id);
}
