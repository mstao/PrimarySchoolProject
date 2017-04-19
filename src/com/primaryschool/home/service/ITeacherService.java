package com.primaryschool.home.service;

import java.util.List;

public interface ITeacherService<T> {
	 /**获取记录**/
    List<T> findTeacherInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findTeacherInfoById(int id);
    /**浏览量+1**/
    boolean addViewCount(int id);
    /**获取最近更新**/
    List<T> findLatestTeacherInfo(String flag,int position, int item_per_page);
    /**获取记录总数**/
    int  findTeacherCount(String flag);
    /**获取最近更新**/
    List<T>  findHotTeacherInfo(String flag,int position,int item_per_page);
    /**获取轮播图信息**/
    List<T>  findSliderTreacherInfo(String flag,int position,int item_per_page);
}
