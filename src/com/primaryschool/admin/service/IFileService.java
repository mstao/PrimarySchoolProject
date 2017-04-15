package com.primaryschool.admin.service;

public interface IFileService<T> {
	/**添加校园动态相关联附件**/
	Integer addTrendsAttachment(T t);
	/**根据类型获取类型id**/
	Integer findBelongIdByTypeFlag(String flag);
}
