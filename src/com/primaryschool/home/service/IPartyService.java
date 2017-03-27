package com.primaryschool.home.service;

import java.util.List;

public interface IPartyService<T> {
	 /**获取记录**/
    List<T> findPartyInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    List<T> findPartyInfoById(int id);
}
