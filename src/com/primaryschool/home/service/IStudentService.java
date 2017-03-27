package com.primaryschool.home.service;

import java.util.List;

public interface IStudentService<T> {

	 /**获取学生天地记录**/
    List<T> findStudentInfo(String type,int position,int item_per_page);
    /**根据id获获取详细信息**/
    List<T> findStudentInfoById(int id);
}
