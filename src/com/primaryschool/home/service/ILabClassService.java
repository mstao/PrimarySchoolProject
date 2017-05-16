package com.primaryschool.home.service;

import java.util.List;

public interface ILabClassService<T> {
	
	/**获取综合实验课的课程列表**/
	List<T>  findLabClassListInfo();
	
	/**根据id获取实验课的名称**/
    T  findLabClassNameById(int id);	
    
	/**获取综合实验课 课程的介绍信息**/
	T  findLabClassIntroduce(int id);
	
	/**获取综合实验课 课程的详细信息**/
	List<T>  findLabClassContent(int id,String flag,int position,int item_per_page);
	
	  /**获取实验课热门详细栏目的列表**/
    List<T>  findHotLabClassContent(int id,String flag,int position,int item_per_page);
    
    /**浏览量+1**/
    boolean  addViewCount(int id);
   
    /**获取记录总数**/
    int  findLabClassContentCount(String flag);
    
    /**根据记录id获取记录的具体内容**/
    T  findLabClassContentById(int mid);
    
    /**获取综合实验课的轮播图**/
    List<T>  findSliderLabClassContent(int id,int position,int item_per_page);
}
