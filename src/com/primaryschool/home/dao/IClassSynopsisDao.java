package com.primaryschool.home.dao;

public interface IClassSynopsisDao<T> {
	 /**获取班级简介**/
    T findClassSynopsisInfo(int classId);
}
