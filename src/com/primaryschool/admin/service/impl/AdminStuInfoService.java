package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IAdminStuInfoDao;
import com.primaryschool.admin.service.IAdminStuInfoService;
@Service
public class AdminStuInfoService<T> implements IAdminStuInfoService<T> {

	@Autowired
	private IAdminStuInfoDao<T> stuInfo;

	@Override
	public List<T> findStuInfo(int classId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return (List<T>) stuInfo.findStuInfo(classId, position, item_per_page);
	}

	@Override
	public T findStuInfoById(int id) {
		// TODO Auto-generated method stub
		return (T)stuInfo.findStuInfoById(id);
	}

	@Override
	public int findStuCount(int classId) {
		// TODO Auto-generated method stub
		return stuInfo.findStuCount(classId);
	}

	@Override
	public boolean updateStuInfo(T t) {
		// TODO Auto-generated method stub
		return stuInfo.updateStuInfo(t);
	}

	@Override
	public int addStuInfo(T t) {
		// TODO Auto-generated method stub
		return stuInfo.addStuInfo(t);
	}

	@Override
	public void deleteStuById(List<?> ids) {
		// TODO Auto-generated method stub
		stuInfo.deleteStuById(ids);
	}

	@Override
	public T findStuInfoByCardId(String cardId) {
		// TODO Auto-generated method stub
		return (T)stuInfo.findStuInfoByCardId(cardId);
	}

	@Override
	public T findStuInfoByStuId(String stuId) {
		// TODO Auto-generated method stub
		return (T)stuInfo.findStuInfoByStuId(stuId);
	}

	@Override
	public int findIdByStuIdOrStuName(String info) {
		// TODO Auto-generated method stub
		return stuInfo.findIdByStuIdOrStuName(info);
	}

	@Override
	public List<T> searchInfo(int flag, String token) {
		// TODO Auto-generated method stub
		return stuInfo.searchInfo(flag, token);
	}
	

}
