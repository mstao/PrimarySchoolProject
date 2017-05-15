package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminStuInfoDao;
@Repository
public class AdminStuInfoDao<T> implements IAdminStuInfoDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findStuInfo(int classId, int position, int item_per_page) {
		
		// TODO Auto-generated method stub
		String hql="from CourseStudentInfo c where c.classId=? order by c.stuBirthday desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, classId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return (List<T>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findStuInfoById(int id) {
		// TODO Auto-generated method stub
		String hql="from CourseStudentInfo c where c.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@Override
	public int findStuCount(int classId) {
		// TODO Auto-generated method stub
		BigInteger count=null;
		int r;
		String sql="select count(CASE WHEN c.class_id=? THEN 1 ELSE NULL END) from ps_course_studentinfo c";
		Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setInteger(0, classId);
		count=(BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}
	@Override
	public boolean updateStuInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update CourseStudentInfo t set t.stuName=:stuName,t.classId=:classId,t.stuId=:stuId,t.stuCardId=:stuCardId,t.stuSex=:stuSex,t.stuAge=:stuAge,t.stuNation=:stuNation,t.stuAddress=:stuAddress,t.stuParent=:stuParent,t.stuBirthday=:stuBirthday,t.stuPhone=:stuPhone,t.stuAuthor=:stuAuthor where t.id=:id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

	@Override
	public int addStuInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result=sessionFactory.getCurrentSession().save(t);
		return (Integer) result;
	}

	@Override
	public void deleteStuById(List<?> ids) {
		// TODO Auto-generated method stub
		String hql="delete from CourseStudentInfo where id in (:ids)";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findStuInfoByCardId(String cardId) {
		// TODO Auto-generated method stub
		String hql="from CourseStudentInfo c where c.stuCardId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, cardId);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findStuInfoByStuId(String stuId) {
		// TODO Auto-generated method stub
		String hql="from CourseStudentInfo c where c.stuId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, stuId);
		return (T) query.uniqueResult();
	}

	@Override
	public int findIdByStuIdOrStuName(String info) {
		// TODO Auto-generated method stub
		String hql="select c.id from CourseStudentInfo c where c.stuId=? or c.stuName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0,info);
		query.setString(1,info);
		return (Integer)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchInfo(int flag, String token) {
		// TODO Auto-generated method stub
		String hql="from CourseStudentInfo c where c.classId=? and c.stuId like ? or  c.stuName like ? or  c.stuCardId like ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, flag);
		query.setString(1, "%"+token+"%");
		query.setString(2, "%"+token+"%");
		query.setString(3, "%"+token+"%");
		return (List<T>)query.list();
	}

}
