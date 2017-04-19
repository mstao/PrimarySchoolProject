package com.primaryschool.home.dao;

import java.util.List;

public interface ITeacherDao<T> {
	 /**获取记录**/
    List<T> findTeacherInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findTeacherInfoById(int id);
    /**根据id修改信息**/
    boolean saveTeacherInfo(int id,String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**添加信息，返回值为该记录的主键值**/
    int addTeacherInfo(String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**删除信息**/
    boolean deleteTeacherById(String[] ids);
    
    /**浏览量+1**/
    boolean  addViewCount(int id);
    /**获取记录总数**/
    int  findTeacherCount(String flag);
    /**获取近期热点**/
    List<T>  findHotTeacherInfo(String flag,int position,int item_per_page);
    
    /**获取轮播图信息**/
    List<T>  findSliderTreacherInfo(String flag,int position,int item_per_page);

}
