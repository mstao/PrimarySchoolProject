package com.primaryschool.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.IContactDao;
import com.primaryschool.admin.service.IContactService;

/**
 * 
* @ClassName: ContactServcie
* @Description: TODO 联系 我们
* @author Mingshan
* @date 2017年4月20日 下午10:49:22
*
* @param <T>
 */

@Service
public class ContactServcie<T> implements IContactService<T> {

	@Autowired
	private  IContactDao<T> contactDao;
	
	@Override
	public T findContactInfo() {
		// TODO Auto-generated method stub
		return contactDao.findContactInfo();
	}

	@Override
	public int saveContactInfo(T t) {
		// TODO Auto-generated method stub
		return contactDao.saveContactInfo(t);
	}

	@Override
	public boolean updateContactInfo(T t) {
		// TODO Auto-generated method stub
		return contactDao.updateContactInfo(t);
	}

}
