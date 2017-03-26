package com.primaryschool.home.dao;

import java.util.List;

public interface ICultureDao<T> {
	 /**获取记录**/
    List<T> findCultureInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    List<T> findCultureInfoById(int id);
    /**根据id修改信息**/
    boolean saveCultureInfo(int id,String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**添加信息，返回值为该记录的主键值**/
    int addCultureInfo(String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**删除信息**/
    boolean deleteCultureById(String[] ids);
}
