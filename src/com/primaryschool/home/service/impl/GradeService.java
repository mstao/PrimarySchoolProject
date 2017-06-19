package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.IGradeDao;
import com.primaryschool.home.service.IGradeService;
@Service
@SuppressWarnings({"unchecked","rawtypes"})
public class GradeService<T> implements IGradeService<T> {

	@Autowired
	private IGradeDao gradeDao;

	@Override
	public List<T> findGradeCode() {
		// TODO Auto-generated method stub
		
		return (List<T>)gradeDao.findGradeCode();
		
	}
	

}
