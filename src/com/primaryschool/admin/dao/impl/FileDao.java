package com.primaryschool.admin.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IFileDao;
import com.primaryschool.admin.entity.FileBelong;
import com.primaryschool.home.entity.TrendsType;

/**
 * 
* @ClassName: FileDao
* @Description: TODO 附件相关操作
* @author Mingshan
* @date 2017年4月15日 下午2:45:05
*
 */
@Repository
public class FileDao<T> implements IFileDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 保存校园动态的附件
	 * @return 生成的主键值
	 */
	@Override
	public Integer addTrendsAttachment(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}

	/**
	 * 根据类型获取id
	 * @return 类型id
	 */
	@Override
	public Integer findBelongIdByTypeFlag(String flag) {
		// TODO Auto-generated method stub
		String hql="from FileBelong  tt where tt.typeFlag=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);		
		query.setString(0, flag);
		
		FileBelong tt=(FileBelong)query.uniqueResult();
		return tt.getId();
	}

}
