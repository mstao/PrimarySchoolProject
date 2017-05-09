package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminSclassDao;
import com.primaryschool.admin.service.IAdminSclassService;
@Service
public class AdminSclassService<T> implements IAdminSclassService<T> {

	@Autowired
	private IAdminSclassDao<T> sclassDao;
	@Override
	public int addSclass(T t) {
		// TODO Auto-generated method stub
		return sclassDao.addSclass(t);
	}

	@Override
	public void deleteSclassById(List<?> ids) {
		// TODO Auto-generated method stub
		sclassDao.deleteSclassById(ids);
	}

	@Override
	public int getSclassYear() {
		// TODO Auto-generated method stub
		return sclassDao.getSclassYear();
	}

	@Override
	public void addGradeInfo() {
		// TODO Auto-generated method stub
		sclassDao.addGradeInfo();
	}

	@Override
	public T findSclassInfoById(int id) {
		// TODO Auto-generated method stub
		return sclassDao.findSclassInfoById(id);
	}

	@Override
	public boolean updateSclassInfo(T t) {
		// TODO Auto-generated method stub
		return sclassDao.updateSclassInfo(t);
	}

	@Override
	public int addSclassInfo(T t) {
		// TODO Auto-generated method stub
		return sclassDao.addSclassInfo(t);
	}

	@Override
	public void deleteSclassInfoById(List<?> ids) {
		// TODO Auto-generated method stub
		 sclassDao.deleteSclassInfoById(ids);
	}

	@Override
	public int findSclassCount(int classId) {
		// TODO Auto-generated method stub
		return sclassDao.findSclassCount(classId);
	}

	@Override
	public T findSclassIntroById(int id) {
		// TODO Auto-generated method stub
		return sclassDao.findSclassIntroById(id);
	}

	@Override
	public int addSclassIntro(T t) {
		// TODO Auto-generated method stub
		return sclassDao.addSclassIntro(t);
	}

	@Override
	public boolean updateSclassIntroInfo(T t) {
		// TODO Auto-generated method stub
		return sclassDao.updateSclassIntroInfo(t);
	}

	@Override
	public int findGradeIdByCode(int gradeCode) {
		// TODO Auto-generated method stub
		return sclassDao.findGradeIdByCode(gradeCode);
	}

	@Override
	public List<T> findClassInfoByClassId(int ClassId,int position,int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>)sclassDao.findClassInfoByClassId(ClassId,position,item_per_page);
	}

	@Override
	public List<T> findClassPageType() {
		// TODO Auto-generated method stub
		return (List<T>)sclassDao.findClassPageType();
	}

	@Override
	public String findfindClassPageTypeByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return sclassDao.findfindClassPageTypeByTypeId(typeId);
	}

	@Override
	public int findPageTypeIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		return sclassDao.findPageTypeIdByTypeFlag(flag);
	}

	@Override
	public List<T> searchInfo(int flag, String token) {
		// TODO Auto-generated method stub
		return sclassDao.searchInfo(flag, token);
	}

	@Override
	public int ifClassExists(int GradeId,int className) {
		// TODO Auto-generated method stub
		return sclassDao.ifClassExists(GradeId,className);
	}

}
