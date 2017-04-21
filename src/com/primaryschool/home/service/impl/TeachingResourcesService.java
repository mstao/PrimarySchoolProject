package com.primaryschool.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.home.dao.ITeachingResourcesDao;
import com.primaryschool.home.service.ITeachingResourcesService;

/**
 * 
* @ClassName: TeachingResourcesService
* @Description: TODO  课程资源 service
* @author Mingshan
* @date 2017年4月8日 下午8:07:49
*
* @param <T>
 */

@Service
public class TeachingResourcesService<T> implements ITeachingResourcesService<T> {

	@Autowired
	private   ITeachingResourcesDao<T> teachingResourcesDao;
	
	@Override
	public List<T> findTeachingResourcesClassList() {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesClassList();
	}

	@Override
	public List<T> findTeachingResourcesMenu() {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesMenu();
	}

	@Override
	public List<T> findTeachingResourcesContent(int menuId, int classId,String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesContent(menuId, classId, flag, position, item_per_page);
	}

	@Override
	public String findTeachingResourcesMenuNameByMenuId(int menuId) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesMenuNameByMenuId(menuId);
	}

	@Override
	public String findTeachingResourcesClassNameByClassId(int classId) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesClassNameByClassId(classId);
	}

	@Override
	public T findTeachingResourcesContentById(int id) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesContentById(id);
	}

	@Override
	public int findTeachingResourcesContentCount(int menuId, int classId, String flag) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesContentCount(menuId, classId, flag);
	}

	@Override
	public List<T> findHotTeachingResourcesContent(int menuId, int classId, String flag, int position,
			int item_per_page) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findHotTeachingResourcesContent(menuId, classId, flag, position, item_per_page);
	}

	@Override
	public List<T> findLatestTeachingResourcesContent(int menuId, int classId, String flag, int position,
			int item_per_page) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findTeachingResourcesContent(menuId, classId, flag, position, item_per_page);
	}

	/**
	 * 首页显示
	 */
	@Override
	public List<T> findHomeTeachingResourcesContent(int position, int item_per_page) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findHomeTeachingResourcesContent(position, item_per_page);
	}

	/**
	 * 教学资源轮播图
	 */
	@Override
	public List<T> findSliderTeachingResourcesContent(int menuId, int classId, String flag, int position,
			int item_per_page) {
		// TODO Auto-generated method stub
		return teachingResourcesDao.findSliderTeachingResourcesContent(menuId, classId, flag, position, item_per_page);
	}

}
