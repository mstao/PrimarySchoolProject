package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminIndexImagesService<T> {

	//添加图片信息
	int  addImage(T t);
	//获取图片列表
    List<T> findImagesList();
    //通过id删除信息
  	void  deleteImage(int id);
}
