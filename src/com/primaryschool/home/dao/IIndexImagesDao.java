package com.primaryschool.home.dao;

import java.util.List;

public interface IIndexImagesDao<T> {

	/**获取首页轮播图片信息**/
	
	List<T>  findIndexImages(int position,int pageSize);
}
