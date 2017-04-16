package com.primaryschool.home.service;

import java.util.List;

public interface IEducationService<T> {
	 /**获取阳光德育记录**/
    List<T> findEducationInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findEducationInfoById(int id);
    /**浏览量+1**/
    boolean addViewCount(int id);
    /**获取最近更新**/
    List<T> findLatestEducationInfo(String flag,int position, int item_per_page);
    /**获取记录总数**/
    int  findEducationCount(String flag);
    /**获取最近更新**/
    List<T>  findHotEducationInfo(String flag,int position,int item_per_page);
    /**用于轮播图片**/
    List<T> findSlideTrendsInfo(String flag,int position,int item_per_page);
}
