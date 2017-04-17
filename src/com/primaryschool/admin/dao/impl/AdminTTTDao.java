package com.primaryschool.admin.dao.impl;

import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminDao;
import com.primaryschool.home.entity.Trends;

@Repository
public class AdminTTTDao extends BaseDaoImpl<Trends> implements IAdminDao{

	public AdminTTTDao(){
		System.out.println("ccccccccccccccccc");
	}

	//更新
	public boolean update(Trends t){
		return super.update(t);
	}
}
