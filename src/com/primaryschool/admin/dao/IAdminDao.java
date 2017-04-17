package com.primaryschool.admin.dao;

import com.primaryschool.home.entity.Trends;

public interface IAdminDao extends IBaseDao<Trends>{

	public boolean update(Trends t);
}
