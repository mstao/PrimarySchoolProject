package com.primaryschool.admin.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
	 /** 
     * 插入指定的持久化对象 
     * @param obj 
     * @return 
     */  
	boolean save(T t);  
    /** 
     * 修改指定的持久化对象 
     * @param obj 
     */  
    boolean update(T t);  
    /** 
     * 删除指定的持久化对象 
     * @param id 
     */  
    boolean delete(T t);  
    /** 
     * 删除指定id的持久化对象 
     * @param id 
     */  
    boolean delete(Serializable id);  
    /** 
     * 全部删除持久化对象 
     */  
    boolean deleteAll();  
    /** 
     * 根据ID检索持久化对象 
     */  
    T findById(Serializable id);  
    /** 
     * 检索所有持久化对象 
     */  
    List<T> findAll();  
}
