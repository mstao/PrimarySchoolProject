package com.primaryschool.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ITypeFlagToTypeNameDao;
import com.primaryschool.home.service.ITypeFlagToTypeNameService;

@Service
public class TypeFlagToTypeNameService implements ITypeFlagToTypeNameService {

	@Autowired
	private ITypeFlagToTypeNameDao  typeFlagToTypeNameDao;
	
	@Override
	public String findTrendsTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findTrendsTypeNameByTypeFlag(flag);
	}

	@Override
	public String findTeacherTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findManageTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPartyTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findEducationTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findEducationTypeNameByTypeFlag(flag);
	}

}
