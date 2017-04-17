package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminIndexImagesDao;
import com.primaryschool.admin.service.IAdminIndexImagesService;

/**
 * 
* @ClassName: AdminIndexImagesService
* @Description: TODO 首页轮播 后台  -service
* @author Mingshan
* @date 2017年4月16日 下午7:42:01
*
* @param <T>
 */
@Service
public class AdminIndexImagesService<T> implements IAdminIndexImagesService<T> {

	/**
	 * 添加
	 */
	@Autowired 
	private IAdminIndexImagesDao<T> indexImagesDao;
	@Override
	public int addImage(T t) {
		// TODO Auto-generated method stub
		return indexImagesDao.addImage(t);
	}
	@Override
	public List<T> findImagesList() {
		// TODO Auto-generated method stub
		return indexImagesDao.findImagesList();
	}
	
	@Override
	public void deleteImage(int id) {
		// TODO Auto-generated method stub
		indexImagesDao.deleteImage(id);
	}

}
