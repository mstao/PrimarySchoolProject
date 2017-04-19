package com.primaryschool.home.service;

import java.util.List;

public interface IStudentService<T> {

	 /**获取学生天地记录**/
    List<T> findStudentInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findStudentInfoById(int id);
    /**浏览量+1**/
    boolean addViewCount(int id);
    /**获取最近更新**/
    List<T> findLatestStudentInfo(String flag,int position, int item_per_page);
    /**获取记录总数**/
    int  findStudentCount(String flag);
    /**获取最近更新**/
    List<T>  findHotStudentInfo(String flag,int position,int item_per_page);
    /**获取轮播图信息**/
    List<T>  findSliderStudentInfo(String flag,int position,int item_per_page);
}
