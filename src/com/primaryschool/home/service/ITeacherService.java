package com.primaryschool.home.service;

import java.util.List;

public interface ITeacherService<T> {
	 /**获取记录**/
    List<T> findTeacherInfo(String flag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    List<T> findTeacherInfoById(int id);
}
