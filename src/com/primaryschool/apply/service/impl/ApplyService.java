package com.primaryschool.apply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.apply.dao.IApplyDao;
import com.primaryschool.apply.service.IApplyService;
/**
 * 
* @ClassName: ApplyService
* @Description: TODO APPLY SERVICE
* @author Mingshan
* @date 2017年5月1日 下午3:16:21
*
* @param <T>
 */

@Service
public class ApplyService<T> implements IApplyService<T> {

	@Autowired
	private IApplyDao<T> applyDao;
	
	@Override
	public int saveApplyInfo(T t) {
		// TODO Auto-generated method stub
		return applyDao.saveApplyInfo(t);
	}

	@Override
	public T findApplyInfo(int id) {
		// TODO Auto-generated method stub
		return applyDao.findApplyInfo(id);
	}

	@Override
	public T findApplyInfoByCardId(String cardCode) {
		// TODO Auto-generated method stub
		return applyDao.findApplyInfoByCardId(cardCode);
	}

	@Override
	public T findApplyCardCodeByUserCardCode(String userCardCode) {
		// TODO Auto-generated method stub
		return applyDao.findApplyCardCodeByUserCardCode(userCardCode);
	}

	@Override
	public int findDateIdByYear(int year) {
		// TODO Auto-generated method stub
		return applyDao.findDateIdByYear(year);
	}

	@Override
	public T findDateInfoByYear(int year) {
		// TODO Auto-generated method stub
		return applyDao.findDateInfoByYear(year);
	}

	@Override
	public int findApplyCountByYear(int year) {
		// TODO Auto-generated method stub
		return applyDao.findApplyCountByYear(year);
	}

	@Override
	public List<T> findApplyInfoByYear(int year,int status, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return applyDao.findApplyInfoByYear(year,status, position, item_per_page);
	}

	@Override
	public boolean updateApplyStatus(int id, int statusValue,String reason) {
		// TODO Auto-generated method stub
		return applyDao.updateApplyStatus(id, statusValue,reason);
	}

	@Override
	public void saveApplyDate(T t) {
		// TODO Auto-generated method stub
		applyDao.saveApplyDate(t);
	}

	@Override
	public void updateApplyDate(T t) {
		// TODO Auto-generated method stub
		applyDao.updateApplyDate(t);
	}

	@Override
	public List<T> findApplyInfoByToken(String token, int status, int year) {
		// TODO Auto-generated method stub
		return applyDao.findApplyInfoByToken(token, status, year);
	}

	@Override
	public int findApplyCountByStatusYear(int status, int year) {
		// TODO Auto-generated method stub
		return applyDao.findApplyCountByStatusYear(status, year);
	}

	@Override
	public void deleteApplyInfoById(List<?> ids) {
		// TODO Auto-generated method stub
		applyDao.deleteApplyInfoById(ids);
	}

	@Override
	public void updateBeginStatus(int year, int beginApply) {
		// TODO Auto-generated method stub
		applyDao.updateBeginStatus(year, beginApply);
	}

	

}
