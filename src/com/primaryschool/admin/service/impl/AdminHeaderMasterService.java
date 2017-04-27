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

}
