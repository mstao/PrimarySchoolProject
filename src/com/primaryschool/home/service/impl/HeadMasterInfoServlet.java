package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IHeadMasterInfoDao;
import com.primaryschool.home.entity.HeadMaster;
import com.primaryschool.home.service.IHeadMasterInfoService;

@Service
public class HeadMasterInfoServlet<T> implements IHeadMasterInfoService<T> {

	@Autowired
	private IHeadMasterInfoDao<HeadMaster> headMasterDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHeadMasterInfo() {
		// TODO Auto-generated method stub
		return (List<T>) headMasterDao.findHeadMasterInfo();
	}

}
