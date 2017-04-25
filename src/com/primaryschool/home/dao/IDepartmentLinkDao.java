package com.primaryschool.home.dao;

import java.util.List;

public interface IDepartmentLinkDao<T> {
	/*获取部门列表*/
	List<T>findDepartmentNameInfo();
	/*通过部门名字,内容类型获取记录*/
	List <T> findDepartmentLinkInfo(String departmentNameType,String contentFlag,int position,int item_per_page);
	/**通过部门ID，内容类型获取记录**/
    List<T> findDepartmentLinkInfo(int departmentId,String contentFlag,int position,int item_per_page);
    /**通过部门ID，内容类型ID获取记录**/
    List<T> findDepartmentLinkInfo(int departmentId,int contentFlag,int position,int item_per_page);
    /**根据id获获取详细信息**/
    T findDepartmentLinkInfoById(int id);
    /**根据id修改信息**/
    boolean saveDepartmentLinkInfo(int id,String contentFlag,String title,String content,String add_time,int is_publish,int is_image);
    /**添加信息，返回值为该记录的主键值**/
    int addDepartmentLinkInfo(int departmentId,String contentFlag,String title,String content,String add_time,int is_publish,int is_image);
    /**删除信息**/
    boolean deleteDepartmentLinkById(String[] ids);
    
    /**浏览量+1**/
    boolean  addViewCount(int id);
    /**获取记录总数**/
    int  findDepartmentLinkContentCount(int departmentId,String contentFlag);
    /**获取近期热点**/
    List<T>  findHotDepartmentLinkInfo(int departmentId,String contentFlag,int position,int item_per_page);
    /**用于轮播图片**/
    List<T> findSlideJobPlacementInfo(String contentFlag,int position,int item_per_page);
}
