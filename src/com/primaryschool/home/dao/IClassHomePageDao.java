package com.primaryschool.home.dao;

import java.util.List;

public interface IClassHomePageDao <T> {
	/**获取班级主页中的班级动态，成长故事，学生文章**/
    List<T> findClassHomePageInfo(int classId,String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findClassHomePageInfoById(int id);
    /**根据id修改信息**/
    boolean saveClassHomePageInfo(int id,String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**添加信息，返回值为该记录的主键值**/
    int addClassHomePageInfo(String flag,String title,String content,String add_time,int is_publish,int is_image);
    /**删除信息**/
    boolean deleteClassHomePageById(String[] ids);
    
    /**浏览量+1**/
    boolean  addViewCount(int id);
    /**获取记录总数**/
    int  findClassHomePageCount(String flag);
    /**获取近期热点**/
    List<T>  findHotClassHomePageInfo(String flag,int position,int item_per_page);
}
