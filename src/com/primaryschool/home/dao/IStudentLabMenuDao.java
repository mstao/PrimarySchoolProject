package com.primaryschool.home.dao;

import java.util.List;

/**
 * 
* @ClassName: IStudentLabMenuDao
* @Description: TODO 综合实验课详细信息
* @author Mingshan
* @date 2017年4月6日 下午10:00:28
*
* @param <T>
 */
public interface IStudentLabMenuDao<T> {
      List<T> findStudentLabMenuContentByMenuId();
}
