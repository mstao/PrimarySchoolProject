package com.primaryschool.home.service;

import java.util.List;

public interface IEducationService<T> {
	 /**获取阳光德育记录**/
    List<T> findEducationInfo(String type,int position,int item_per_page);
    /**根据id获获取详细信息**/
    List<T> findEducationInfoById(int id);
}
