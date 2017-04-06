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
	List<T>   findLabClassListinfo();
    
	/**根据id获取综合实验课的信息**/
    T findLabClassInfoById(int id);
}
