package com.primaryschool.admin.service;

import java.util.List;

public interface IAdminDepartmentService<T> {
	//部门分类
		/**获取所有部门名称**/
		List<?> findDepartmentNameList();
		/**根据Id获取部门名称**/
		String findDepartmentNameById(int id);
		/**增加部门**/
		int addDepartmentName(T t);
		/**删除部门**/
		void deleteDepartmentName(List<?> ids);
		//详细内容
		/**根据部门类型获取信息**/
		List<?> findDepartmentContentInfo(int deptId,int position,int item_per_page);
		/**获取信息总量ByDeptId**/
		int findDepartmentContentCount(int deptId);
		/**获取详细内容ByID**/
		T findDeptContentInfo(int id);
		/**增加新信息**/
		int addDepartmentContent(T t);
		/**删除信息ByID**/
		void deleteDepartmentContent(List<?> ids);
		/**更新信息ByID**/
		boolean updateDeparmentContent(T t);
		//信息分类
		/**获取所有信息分类**/
		List<?> findDepartmentType();
		/**根据ID获取分类**/
		String findDepartmentTypeById(int id);
		/**根据flag获取ID**/
		int findDepartmentTypeIdByTypeFlag(String flag);
		
}
