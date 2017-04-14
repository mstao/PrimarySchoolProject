package com.primaryschool.admin.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminTrendsDao;
import com.primaryschool.admin.service.IAdminTrendsService;

/**
 * 
* @ClassName: TrendsService
* @Description: TODO 校园动态 service层
* @author Mingshan
* @date 2017年4月14日 下午4:12:14
*
* @param <T>
 */

@Service
public class AdminTrendsService<T> implements IAdminTrendsService<T> {

	@Autowired
	private IAdminTrendsDao<T> trendsDao;
	
	/**
	 * 
	 * 获取 校园动态列表
	 */
	@Override
	public List<T> findTrendsInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) trendsDao.findTrendsInfo(flag, position, item_per_page);
	}

	@Override
	public T findTrendsInfoById(int id) {
		// TODO Auto-generated method stub
		return (T) trendsDao.findTrendsInfoById(id);
	}

	@Override
	public boolean saveTrendsInfo(int id, String flag, String title, String content, String addTime, int isPublish,
			int isImage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addTrendsInfo(String flag, String title, String content, String addTime, int isPublish, int isImage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteTrendsById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findTrendsCount(String flag) {
		// TODO Auto-generated method stub
		return trendsDao.findTrendsCount(flag);
	}

}
