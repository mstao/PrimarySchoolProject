package com.primaryschool.home.dao;

import java.util.List;

/**
 * 
* @ClassName: IFileDao
* @Description: TODO 文件读取
* @author Mingshan
* @date 2017年4月21日 下午5:27:25
*
 */
public interface IBaseFileDao<T> {

	//获取文件
	List<T>  findFile(String belongType);
}
