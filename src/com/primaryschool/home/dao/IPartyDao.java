package com.primaryschool.home.dao;

import java.util.List;

public interface IPartyDao<T> {
	 /**获取记录**/
    List<T> findPartyInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    List<T> findPartyInfoById(int id);
    /**根据id修改信息**/
    boolean savePartyInfo(int id,String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**添加信息，返回值为该记录的主键值**/
    int addPartyInfo(String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**删除信息**/
    boolean deletePartyById(String[] ids);
}
