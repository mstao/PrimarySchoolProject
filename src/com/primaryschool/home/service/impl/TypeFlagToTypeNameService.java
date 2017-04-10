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
		return typeFlagToTypeNameDao.findTeacherTypeNameByTypeFlag(flag);
	}

	@Override
	public String findManageTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findManageTypeNameByTypeFlag(flag);
	}

	@Override
	public String findPartyTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findPartyTypeNameByTypeFlag(flag);
	}

	@Override
	public String findEducationTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findEducationTypeNameByTypeFlag(flag);
	}

	@Override
	public String findStudentTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findStudentTypeNameByTypeFlag(flag);
	}

	@Override
	public String findCultureTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findCultureTypeNameByTypeFlag(flag);
	}

	@Override
	public String findLabClassTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findLabClassTypeNameByTypeFlag(flag);
	}

	@Override
	public String findClassTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findClassTypeNameByTypeFlag(flag);
	}

	@Override
	public String findTeachingResourcesContentTypeNameByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return typeFlagToTypeNameDao.findTeachingResourcesContentTypeNameByTypeFlag(flag);
	}

}
