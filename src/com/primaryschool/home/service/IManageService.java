package com.primaryschool.home.service;

import java.util.List;

public interface IManageService<T> {
	 /**获取记录**/
    List<T> findManageInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findManageInfoById(int id);
    /**浏览量+1**/
    boolean addViewCount(int id);
    /**获取最近更新**/
    List<T> findLatestManageInfo(String flag,int position, int item_per_page);
    /**获取记录总数**/
    int  findManageCount(String flag);
    /**获取最近更新**/
    List<T>  findHotManageInfo(String flag,int position,int item_per_page);
    /**获取轮播图**/
    List<T> findSliderManageInfo(String flag,int position,int item_per_page);
}
