package com.primaryschool.home.service;


public interface IClassSynopsisService<T> {
	/**获取班级主页中的班级简介**/
    T findClassSynopsisInfo(int classId);
}
