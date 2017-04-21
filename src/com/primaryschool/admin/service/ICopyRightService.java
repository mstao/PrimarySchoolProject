package com.primaryschool.admin.service;

public interface ICopyRightService<T> {

	//获取版权声明信息
	T findCopyRightInfo();
	
	//添加  信息
	int  saveCopyRightInfo(T t);
	
	//修改信息
	boolean updateCopyRightInfo(T t);
}
