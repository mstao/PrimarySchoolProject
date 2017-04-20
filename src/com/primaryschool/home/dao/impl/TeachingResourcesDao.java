package com.primaryschool.home.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ITeachingResourcesDao;
import com.primaryschool.home.dao.ITypeFlagToTypeIdDao;
import com.primaryschool.home.entity.TeachingResourcesClass;
import com.primaryschool.home.entity.TeachingResourcesMenu;

/**
 * 
* @ClassName: TeachingResourcesDao
* @Description: TODO 教学资源DAO
* @author Mingshan
* @date 2017年4月8日 下午2:13:08
*
* @param <T>
 */


@Repository
public class TeachingResourcesDao<T> implements ITeachingResourcesDao<T> {
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ITypeFlagToTypeIdDao typeFlagToTypeIdDao;
	/**
	 * 获取年级信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTeachingResourcesClassList() {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesClass";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	/**
	 * 获取菜单列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTeachingResourcesMenu() {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesMenu";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

    /**
     * 获取教学资源的内容
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findTeachingResourcesContent(int menuId, int classId,String flag, int position, int item_per_page) {
		// TODO Auto-generated method stub
		int typeId=typeFlagToTypeIdDao.findTeachingResourcesTypeFlag(flag);
		
		String hql="select new com.primaryschool.home.entity.TeachingResourcesContent(t.id,t.itemTitle,t.addTime,t.viewCount) from TeachingResourcesContent t where t.menuId=? and t.classId=? and t.typeId=? and t.isPublish=1 order by t.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, menuId);
		query.setInteger(1, classId);
		query.setInteger(2, typeId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

	/**
	 * 通过menuId获取menuName
	 */
	@Override
	public String findTeachingResourcesMenuNameByMenuId(int menuId) {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesMenu t where t.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setInteger(0, menuId);
		TeachingResourcesMenu tt=(TeachingResourcesMenu) query.uniqueResult();
		return tt.getResourceName();
	}

	/**
	 * 通过classId获取className
	 */

	@Override
	public String  findTeachingResourcesClassNameByClassId(int classId) {
		// TODO Auto-generated method stub
		String hql="from TeachingResourcesClass t where t.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, classId);
		TeachingResourcesClass tt=(TeachingResourcesClass) query.uniqueResult();
		return tt.getClassName();
	}

    /**
     * 根据id查询教学资源的具体内容
     */
	@SuppressWarnings("unchecked")
	@Override
	public T findTeachingResourcesContentById(int id) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.TeachingResourcesContent(t.id,t.itemTitle,t.itemContent,t.addTime,t.viewCount,t.author,tm.resourceName,tc.className,tct.itemTypeFlag,tct.itemTypeName) from TeachingResourcesContent t,TeachingResourcesMenu tm,TeachingResourcesContentType  tct,TeachingResourcesClass tc where t.menuId=tm.id and t.classId=tc.id and t.typeId=tct.id and t.isPublish=1 and t.id=? ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T)query.uniqueResult();
	}


	/**
	 * 根据条件获取教学资源 的数量
	 */
	@Override
	public int findTeachingResourcesContentCount(int menuId, int classId, String flag) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//根据类型获取id
		int typeId=typeFlagToTypeIdDao.findTeachingResourcesTypeFlag(flag);
		String sql="select count(CASE WHEN t.menu_id=? and class_id=? and t.type_id=? and t.is_publish=1 THEN 1 ELSE NULL END) from ps_teaching_resources_content t";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,menuId);
		query.setInteger(1,classId);
		query.setInteger(2,typeId);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}


	/**
	 * 根据id浏览量+1
	 */
	@Override
	public boolean addViewCount(int tid) {
		// TODO Auto-generated method stub
		String hql="update TeachingResourcesContent t set t.viewCount=t.viewCount+1  where t.id=?";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setInteger(0,tid);
		return (query.executeUpdate()>0);
	}

	/**
	 * 获取热门信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHotTeachingResourcesContent(int menuId, int classId, String flag, int position,
			int item_per_page) {
		// TODO Auto-generated method stub
		int typeId=typeFlagToTypeIdDao.findTeachingResourcesTypeFlag(flag);
		
		String hql="select new com.primaryschool.home.entity.TeachingResourcesContent(t.id,t.itemTitle,t.addTime,t.viewCount) from TeachingResourcesContent t where t.menuId=? and t.classId=? and t.typeId=? and t.isPublish=1 order by t.viewCount desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, menuId);
		query.setInteger(1, classId);
		query.setInteger(2, typeId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}


	/**
	 * 首页教学资源
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findHomeTeachingResourcesContent(int position, int item_per_page) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.TeachingResourcesContent(t.id,t.itemTitle,tm.id,t.addTime,tc.id,tct.itemTypeFlag) from TeachingResourcesContent t,TeachingResourcesMenu tm,TeachingResourcesContentType  tct,TeachingResourcesClass tc where t.menuId=tm.id and t.classId=tc.id and t.typeId=tct.id and t.isPublish=1 order by t.addTime desc ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return query.list();
	}

}
