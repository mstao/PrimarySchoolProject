package com.primaryschool.home.service;

import java.util.List;

public interface ICultureService<T> {
	 /**获取记录**/
    List<T> findCultureInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findCultureInfoById(int id);
    /**获取最近更新**/
    List<T> findLatestCultureInfo(String flag,int position, int item_per_page);
   
    /**浏览量+1**/
    boolean  addViewCount(int id);
    /**获取记录总数**/
    int  findCultureCount(String flag);
    /**获取近期热点**/
    List<T>  findHotCultureInfo(String flag,int position,int item_per_page);
}
