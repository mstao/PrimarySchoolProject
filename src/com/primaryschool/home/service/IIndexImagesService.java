package com.primaryschool.home.service;

import java.util.List;

public interface IIndexImagesService<T> {
    /**获取首页轮播图片信息**/
	
	List<T>  findIndexImages(int position,int pageSize);
}
