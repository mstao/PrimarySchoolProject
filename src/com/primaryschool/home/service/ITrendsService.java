package com.primaryschool.home.service;

import java.util.List;

import com.primaryschool.home.entity.Trends;

public interface ITrendsService<T> {
	 /**获取校园动态记录**/
    List<T> findTrendsInfo(String type,int position,int item_per_page);
    /**根据id获获取详细信息**/
    Trends findTrendsInfoById(int id);
}
