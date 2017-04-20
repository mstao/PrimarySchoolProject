package com.primaryschool.home.dao;

import java.util.List;

/**
 * 
* @ClassName: ILabClassDao
* @Description: TODO 综合实验课
* @author Mingshan
* @date 2017年4月6日 下午8:17:35
*
 */
public interface ILabClassDao<T> {
    /**获取综合实验课的所有信息**/
	List<T>  findLabClassListInfo();
   
	/**根据id获取实验课的名称**/
    T   findLabClassNameById(int id);	
    
    /**获取每个实验课的详细内容**/
    List<T>  findLabClassContent(int id, String flag,int position,int item_per_page);
   
    /**获取实验课的介绍**/
    T findLabClassIntroduce(int id);
    
    /**获取实验课热门详细栏目的列表**/
    List<T>  findHotLabClassContent(int id,String flag,int position,int item_per_page);
    
    /**浏览量+1**/
    boolean  addViewCount(int id);
   
    /**获取记录总数**/
    int  findLabClassContentCount(String flag);
    
    /**根据记录id获取记录的具体内容**/
    T  findLabClassContentById(int mid);
    
    /**获取综合实验课的轮播图**/
    List<T>  findSliderLabClassContent(int id, String flag,int position,int item_per_page);
}
