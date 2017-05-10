package com.primaryschool.home.service;

import java.util.List;

public interface IClassHomePageService<T> {
	 /**获取班级主页记录**/
    List<T> findClassHomePageInfo(int classId,String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findClassHomePageInfoById(int id);
    /**浏览量+1**/
    boolean addViewCount(int id);
    /**获取最近更新**/
    List<T> findLatestClassHomePageInfo(int classId,String flag,int position, int item_per_page);
    /**获取记录总数**/
    int  findClassHomePageCount(String flag);
    /**获取最近更新**/
    List<T>  findHotClasshomepageInfo(String flag,int position,int item_per_page);
    
    /*获取班级主页记录，按时间降序排序*/
    List<T>  findClassHomePageListInfo();
    /**获取班级主页的轮播图**/
    List<T>  findSilderClassHomePageInfo();
}
