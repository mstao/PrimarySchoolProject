package com.primaryschool.home.service;

import java.util.List;

import com.primaryschool.home.entity.Trends;

public interface ITrendsService<T> {
	 /**获取校园动态记录**/
    List<T> findTrendsInfo(String type,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findTrendsInfoById(int id);
    /**浏览量+1**/
    boolean addViewCount(int id);
    /**获取最近更新**/
    List<T> findLatestTrendsInfo(String flag,int position, int item_per_page);
    /**获取记录总数**/
    int  findTrendsCount(String flag);
    /**获取最近更新**/
    List<T>  findHotTrendsInfo(String flag,int position,int item_per_page);
    
}
