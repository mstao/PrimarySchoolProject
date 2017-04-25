package com.primaryschool.home.service;

import java.util.List;
/**
 * 部门链接中的工作安排
 * */
public interface IDepartmentLinkService<T> {
	/**获取部门链接中的各个部门名称**/
	List<T> findDepartmentNameInfo();
	/*通过部门名称和内容类型名称获取部门链接中的工作安排和人员安排记录*/
	List<T> findDepartmentLinkInfo(String departmentNameType,String contentFlag,int position,int item_per_page);
	
	/*通过部门名称和内容类型id获取信息*/
	List<T> findDepartmentLinkInfo(int departmentId, int contentFlag, int position, int item_per_page);
	/**通过部门ID获取部门链接中的工作安排和人员安排记录**/
    List<T> findDepartmentLinkInfo(int departmentId,String contentFlag,int position,int item_per_page);
    /**根据id获取详细信息**/
    T findDepartmentLinkInfoById(int id);
    /**浏览量+1**/
    boolean addViewCount(int id);
    /**部门名称和内容类型名称获取最近更新**/
    List<T> findLatestDepartmentLinkInfo(int departmentId,String contentFlag,int position, int item_per_page);
    /**通过部门名称和内容类型id利用获取最近更新**/
    List<T> findLatestDepartmentLinkInfo(int departmentId,int contentFlag,int position, int item_per_page);
    /**获取记录总数**/
    int  findDepartmentLinkContentCount(int departmentId,String contentFlag);
    /**获取最近更新**/
    List<T>  findHotDepartmentLinkInfo(int departmentId,String contentFlag,int position,int item_per_page);
    /**用于轮播图片**/
    List<T> findSlideTrendsInfo(String contentFlag,int position,int item_per_page);
	
}
