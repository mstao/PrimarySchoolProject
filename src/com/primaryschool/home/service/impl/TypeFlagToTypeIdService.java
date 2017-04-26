package com.primaryschool.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;
import com.primaryschool.home.service.ITypeFlagToTypeIdService;

@Service
public class TypeFlagToTypeIdService implements ITypeFlagToTypeIdService {

	@Autowired
	private ITypeFlagToTypeIdDao typeFlagToTypeIdDao;
	@Override
	public int findCultureTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findCultureTypeIdByTypeFlag(flag);
	}

	@Override
	public int findTrendsTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findTrendsTypeIdByTypeFlag(flag);
	}

	@Override
	public int findEducationTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findEducationTypeIdByTypeFlag(flag);
	}

	@Override
	public int findStudentTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findStudentTypeIdByTypeFlag(flag);
	}

	@Override
	public int findTeacherTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findTeacherTypeIdByTypeFlag(flag);
	}

	@Override
	public int findManageTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findManageTypeIdByTypeFlag(flag);
	}

	@Override
	public int findPartyTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findPartyTypeIdByTypeFlag(flag);
	}

	@Override
	public int findLabClassTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findLabClassTypeIdByTypeFlag(flag);
	}

	@Override
	public int findTeachingResourcesTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findTeachingResourcesTypeFlag(flag);
	}

	@Override
	public int findClasshomepageIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findClasshomepageIdByTypeFlag(flag);
	}
	
	
	@Override
	public int findTeachingResourcesTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findTeachingResourcesTypeFlag(flag);
	}

	@Override
	public int findLabClassMenuIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeIdDao.findLabClassMenuIdByTypeFlag(flag);
	}
}
