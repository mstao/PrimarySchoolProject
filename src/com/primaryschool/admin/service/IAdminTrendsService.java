package com.primaryschool.admin.service;

import java.util.List;

import com.primaryschool.home.entity.Trends;

/**
 * 
* @ClassName: ITrendsService
* @Description: TODO 校园动态  service层
* @author Mingshan
* @date 2017年4月14日 下午4:08:55
*
 */

public interface IAdminTrendsService<T> {
	 /**获取校园动态记录**/
    List<T> findTrendsInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
	 T findTrendsInfoById(int id);
	/**根据 类型获取统计总数**/ 
	int findTrendsCount(String flag);  
    /**根据id修改信息**/
	 boolean updateTrendsInfo(T t);
    /**添加信息，返回值为该记录的主键值**/
    int addTrendsInfo(T t);
    /**删除信息**/
    void deleteTrendsById(List<?> ids);
    /**模糊查询**/
	List<T> searchInfo(String flag, String token);    
}
