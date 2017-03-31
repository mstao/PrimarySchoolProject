package com.primaryschool.home.service;

import java.util.List;

public interface IPartyService<T> {
	 /**获取记录**/
    List<T> findPartyInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findPartyInfoById(int id);
    /**浏览量+1**/
    boolean addViewCount(int id);
    /**获取最近更新**/
    List<T> findLatestPartyInfo(String flag,int position, int item_per_page);
    /**获取记录总数**/
    int  findPartyCount(String flag);
    /**获取最近更新**/
    List<T>  findHotPartyInfo(String flag,int position,int item_per_page);
}
