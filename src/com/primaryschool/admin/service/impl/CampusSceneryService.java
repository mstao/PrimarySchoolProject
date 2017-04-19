package com.primaryschool.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primaryschool.admin.dao.ICampusSceneryDao;
import com.primaryschool.admin.service.ICampusSceneryService;

/**
 * 
* @ClassName: CampusSceneryService
* @Description: TODO 校园 风光  service
* @author Mingshan
* @date 2017年4月18日 下午8:25:45
*
* @param <T>
 */

@Service
public class CampusSceneryService<T> implements ICampusSceneryService<T> {

	@Autowired
	private ICampusSceneryDao<T> campusScenery;
	
	@Override
	public List<T> findCampusSceneryList() {
		// TODO Auto-generated method stub
		return campusScenery.findCampusSceneryList();
	}

	@Override
	public int saveCampusScenery(T t) {
		// TODO Auto-generated method stub
		return campusScenery.saveCampusScenery(t);
	}

	@Override
	public void deleteCampusScenery(int id) {
		// TODO Auto-generated method stub
		campusScenery.deleteCampusScenery(id);
	}

}
