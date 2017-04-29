package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminHeaderMasterDao;
import com.primaryschool.admin.service.IAdminHeaderMasterService;

/**
 * 
* @ClassName: AdminHeaderMasterService
* @Description: TODO 校长
* @author Mingshan
* @date 2017年4月27日 上午2:55:42
*
* @param <T>
 */
@Service
public class AdminHeaderMasterService<T> implements IAdminHeaderMasterService<T> {

	@Autowired
	private IAdminHeaderMasterDao<T>  headerMasterDao;
	
	@Override
	public List<T> findHeaderMasterInfo(int position, int item_per_page) {
		// TODO Auto-generated method stub
		return headerMasterDao.findHeaderMasterInfo(position, item_per_page);
	}

	@Override
	public int findHeadMasterCount() {
		// TODO Auto-generated method stub
		return headerMasterDao.findHeadMasterCount();
	}

	@Override
	public void deleteHeadMasterById(List<?> ids) {
		// TODO Auto-generated method stub
		headerMasterDao.deleteHeadMasterById(ids);
	}

	@Override
	public List<T> findHeadMasterPost() {
		// TODO Auto-generated method stub
		return headerMasterDao.findHeadMasterPost();
	}

	@Override
	public int saveHeadMaster(T t) {
		// TODO Auto-generated method stub
		return headerMasterDao.saveHeadMaster(t);
	}

	@Override
	public int findPostIdByPostName(String name) {
		// TODO Auto-generated method stub
		return headerMasterDao.findPostIdByPostName(name);
	}

	@Override
	public T findHeadMasterById(int id) {
		// TODO Auto-generated method stub
		return headerMasterDao.findHeadMasterById(id);
	}

	@Override
	public boolean updateHeadMasterInfo(T t) {
		// TODO Auto-generated method stub
		return headerMasterDao.updateHeadMasterInfo(t);
	}

}
