package com.primaryschool.home.dao;

import java.util.List;


public interface ITrendsDao<T> {
	 /**获取校园动态记录**/
     List<T> findTrendsInfo(String flag,int position,int item_per_page);
     /**根据id获获取详细信息**/
	 T findTrendsInfoById(int id);
     /**根据id修改信息**/
     boolean saveTrendsInfo(int id,String flag,String title,String content,String add_time,int is_publish,int is_image);
     /**添加信息，返回值为该记录的主键值**/
     int addTrendsInfo(String flag,String title,String content,String add_time,int is_publish,int is_image);
     /**删除信息**/
     boolean deleteTrendsById(String[] ids);     
     /**浏览量+1**/
     boolean  addViewCount(int id);

}
