package com.primaryschool.admin.service.impl;


import java.util.List;


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
	public int addTrendsInfo(T t) {
		// TODO Auto-generated method stub
		return trendsDao.addTrendsInfo(t);
	}

	@Override
	public void deleteTrendsById(List<?> ids) {
		// TODO Auto-generated method stub
		trendsDao.deleteTrendsById(ids);
	}

	@Override
	public int findTrendsCount(String flag) {
		// TODO Auto-generated method stub
		return trendsDao.findTrendsCount(flag);
	}

	@Override
	public boolean updateTrendsInfo(T t) {
		// TODO Auto-generated method stub
		return trendsDao.updateTrendsInfo(t);
	}

}
