package com.primaryschool.home.service;

import java.util.List;

public interface IHeadMasterInfoService<T> {
	   //获取校长信息
		List<T> findHeadMasterInfo();
}
