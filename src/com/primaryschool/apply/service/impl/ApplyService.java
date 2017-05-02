package com.primaryschool.apply.service.impl;

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

	

}
