package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.primaryschool.admin.dao.IBaseDao;


public class BaseDaoImpl<T>  implements IBaseDao<T> {


	@Autowired
	private SessionFactory  sessionFactory;
	
	
	@SuppressWarnings("rawtypes")
	private final Class clazz;
	
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		// 通过反射机制获取子类传递过来的实体类的类型信息
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	@Override
	public boolean save(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("update "+this.clazz.getSimpleName());
		stringBuffer.append(" u set u.itemTitle=:itemTitle ,u.itemContent=:itemContent,u.addTime=:addTime,u.isImage=:isImage,u.isPublish=:isPublish,u.author=:author  where u.id=:id");
		System.out.println(stringBuffer.toString()); 
		Query query  = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString()); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
