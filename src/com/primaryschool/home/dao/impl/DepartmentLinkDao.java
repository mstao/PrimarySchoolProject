package com.primaryschool.home.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.IDepartmentLinkDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;

/*
 * 部门链接Dao类
 * */
@Repository
public class DepartmentLinkDao<T> implements IDepartmentLinkDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired 
	private ITypeFlagToTypeIdDao typeFlagToTypeIdDao;
	
	/*获取部门列表*/
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findDepartmentNameInfo() {
		// TODO Auto-generated method stub
		String hql="from DepartmentLinkNameList";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	/*通过部门名称和消息类型查询信息*/
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findDepartmentLinkInfo(String departmentNameType,String contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		//根据类型获取id
		int id=typeFlagToTypeIdDao.findDepartmentLinkIdByTypeFlag(contentFlag);
		int departmentId=typeFlagToTypeIdDao.findDepartmentNameIdByTypeFlag(departmentNameType);
		
		String hql="select new com.primaryschool.home.entity.DepartmentLinkContent(t.id,t.itemTitle,t.addTime,t.typeId,t.departmentId) from DepartmentLinkContent t where t.typeId=? and t.departmentId=? and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setInteger(1,departmentId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}
	
	/*通过部门ID和消息类型ID获取信息*/
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findDepartmentLinkInfo(int departmentId,int contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		//根据类型获取id
		String hql="select new com.primaryschool.home.entity.DepartmentLinkContent(t.id,t.itemTitle,t.addTime,t.typeId,t.departmentId) from DepartmentLinkContent t where t.typeId=? and t.departmentId=? and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, contentFlag);
		query.setInteger(1,departmentId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}
	
	/*通过部门id和消息类型获取信息*/
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findDepartmentLinkInfo(int departmentId,String contentFlag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		//根据类型获取id
		int id=typeFlagToTypeIdDao.findDepartmentLinkIdByTypeFlag(contentFlag);
		
		String hql="select new com.primaryschool.home.entity.DepartmentLinkContent(t.id,t.itemTitle,t.addTime,t.typeId,t.departmentId) from DepartmentLinkContent t where t.typeId=? and t.departmentId=? and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		query.setInteger(1,departmentId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findDepartmentLinkInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.DepartmentLinkContent(t.id,t.itemTitle,t.itemContent,t.addTime,t.viewCount,tt.itemTypeName,tt.itemTypeFlag)from DepartmentLinkContent t,DepartmentLinkContentType tt  where tt.id=t.typeId and t.id=? and t.isPublish=1";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public boolean saveDepartmentLinkInfo(int id, String contentFlag, String title, String content, String add_time,
			int is_publish, int is_image) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addDepartmentLinkInfo(int departmentId,String contentFlag, String title, String content, String add_time, int is_publish,
			int is_image) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteDepartmentLinkById(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addViewCount(int id) {
		// TODO Auto-generated method stub
		String hql="update DepartmentLinkContent t set t.viewCount=t.viewCount+1  where t.id=?";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setInteger(0,id);
		return (query.executeUpdate()>0);
	}

	@Override
	public int findDepartmentLinkContentCount(int departmentId,String contentFlag) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//根据类型获取id
		int typeId=typeFlagToTypeIdDao.findDepartmentLinkIdByTypeFlag(contentFlag);
		String sql="select count(CASE WHEN t.department_id=? and t.type_id=? and t.is_publish=1 THEN 1 ELSE NULL END) from ps_departmentLink_content t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,departmentId);
		query.setInteger(1,typeId);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHotDepartmentLinkInfo(int departmentId,String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int typeId=typeFlagToTypeIdDao.findDepartmentLinkIdByTypeFlag(flag);
		
		String hql="select new com.primaryschool.home.entity.DepartmentLinkContent(t.id,t.itemTitle,t.addTime,t.viewCount,t.typeId,t.departmentId) from DepartmentLinkContent t where t.departmentId=? and t.typeId=? and t.isPublish=1 order by t.viewCount desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, departmentId);
		query.setInteger(1, typeId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

	@Override
	public List<T> findSlideJobPlacementInfo(String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
