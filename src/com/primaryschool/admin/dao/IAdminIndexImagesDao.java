package com.primaryschool.admin.dao;

import java.util.List;

/**
 * 
* @ClassName: IIndexImagesDao
* @Description: TODO 首页轮播
* @author Mingshan
* @date 2017年4月16日 下午6:15:34
*
 */
public interface IAdminIndexImagesDao<T> {

	//添加图片信息
	int  addImage(T t);
	
   //获取图片列表
	List<T> findImagesList();
	//通过id删除信息
	void  deleteImage(int id);
}
