package com.primaryschool.admin.dao;

import java.util.List;

/**
 * 
* @ClassName: ITrendsDao
* @Description: TODO 校园动态   不过滤  信息
* @author Mingshan
* @date 2017年4月14日 下午3:32:13
*
 */
public interface IAdminTrendsDao<T> {

	 /**获取校园动态记录**/
    List<T> findTrendsInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
	 T findTrendsInfoById(int id);
	/**根据 类型获取统计总数**/ 
	int findTrendsCount(String flag);  
    /**根据id修改信息**/
    boolean saveTrendsInfo(int id,String flag,String title,String content,String addTime,int isPublish,int isImage);
    /**添加信息，返回值为该记录的主键值**/
    int addTrendsInfo(String flag,String title,String content,String addTime,int isPublish,int isImage);
    /**删除信息**/
    boolean deleteTrendsById(String[] ids);     
}
