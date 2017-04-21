package com.primaryschool.home.service;

import java.util.List;

public interface IBaseFileService<T> {

	//获取文件
	List<T>  findFile(String belongType);
}
