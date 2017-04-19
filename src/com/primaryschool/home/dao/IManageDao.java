package com.primaryschool.home.dao;

import java.util.List;

public interface IManageDao<T> {
	 /**获取记录**/
    List<T> findManageInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findManageInfoById(int id);
    /**根据id修改信息**/
    boolean saveManageInfo(int id,String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**添加信息，返回值为该记录的主键值**/
    int addManageInfo(String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**删除信息**/
    boolean deleteManageById(String[] ids);
    /**浏览量+1**/
    boolean  addViewCount(int id);
    /**获取记录总数**/
    int  findManageCount(String flag);
    /**获取近期热点**/
    List<T>  findHotManageInfo(String flag,int position,int item_per_page);
    /**获取轮播图**/
    List<T> findSliderManageInfo(String flag,int position,int item_per_page);
}
