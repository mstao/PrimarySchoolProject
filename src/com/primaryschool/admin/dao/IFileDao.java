package com.primaryschool.admin.dao;

/**
 * 
* @ClassName: IFileDao
* @Description: TODO 文件的操作
* @author Mingshan
* @date 2017年4月15日 下午2:30:33
*
 */
public interface IFileDao<T> {

	/**添加校园动态相关联附件**/
	Integer addTrendsAttachment(T t);
	
	/**根据类型获取类型id**/
	Integer findBelongIdByTypeFlag(String flag);
}
