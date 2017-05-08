package com.primaryschool.admin.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IAdminCourseScoreDao;
import com.primaryschool.admin.entity.CourseScore;
@Repository
public class AdminCourseScoreDao<T> implements IAdminCourseScoreDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<?> findCourseType() {
		// TODO Auto-generated method stub
		String hql="from CourseType";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (List<T>) query.list();
	}

	@Override
	public int addCourseType(T t) {
		// TODO Auto-generated method stub
		Serializable result=sessionFactory.getCurrentSession().save(t);
		return (Integer) result;
	}

	@Override
	public void deleteCourseType(List<?> ids) {
		// TODO Auto-generated method stub
		String hql="delete from CourseType where id in (:ids)";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids).executeUpdate();
	}
	
	@Override
	public long findTypeCount() {
		// TODO Auto-generated method stub

		String hql="select count(id) from CourseType";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (long) query.uniqueResult();
	}


	@Override
	public List<?> findScoreInfo(int classId, int position, int item_per_page) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.admin.entity.CourseScore(cs.id,cs.stuinfoId,cs.courseId,cs.score, cs.author, cs.addTime,t.courseName, s.stuName,s.stuId) from CourseStudentInfo s,CourseScore cs,CourseType t where cs.courseId=t.id and cs.stuinfoId=s.id and cs.classId=? GROUP BY cs.addTime,cs.stuinfoId,cs.courseId ORDER BY cs.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, classId);
		query.setFirstResult(position);
		query.setMaxResults(item_per_page);
		return (List<?>)query.list();
	}

	@Override
	public int findScoreCount(int classId) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		String sql="select count(CASE WHEN c.class_id=? THEN 1 ELSE NULL END) from ps_course_score c GROUP BY c.course_id";
		Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setInteger(0, classId);
		count=(BigInteger)query.uniqueResult();
		r=count.intValue();
		return r;
	}
	

	@Override
	public List<?> findScoreInfoById(int classId,String stuId,String addTime) {
		// TODO Auto-generated method stub

		String hql="select new com.primaryschool.admin.entity.CourseScore(cs.id,cs.stuinfoId,cs.courseId,cs.score, cs.author, cs.addTime,t.courseName, s.stuName,s.stuId) from CourseStudentInfo s,CourseScore cs,CourseType t where cs.courseId=t.id and cs.stuinfoId=s.id and cs.classId=? and s.stuId=? and cs.addTime=? ORDER BY cs.courseId asc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, classId);
		query.setString(1, stuId);
		query.setString(2, addTime);
		return (List<?>)query.list();
	}

	@Override
	public void updateScoreInfo(List<CourseScore> t) {
		// TODO Auto-generated method stub
	//	[score, classId, addTime, author, stuinfoId, courseId] [update CourseScore c set c.stuinfoId=:stuinfoId,c.classId=:classId,c.courseId=:courseId,c.score=:score,c.addTime=:addTime,c.author=:author]
		String hql="update CourseScore c set c.stuinfoId=:stuinfoId,c.classId=:classId,c.courseId=:courseId,c.score=:score,c.addTime=:addTime,c.author=:author where c.id=:id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		for(CourseScore tt:t){
			query.setProperties(tt);
			query.executeUpdate();
		}
		
	}

	@Override
	public void addScoreInfo(List<CourseScore> t) {
		// TODO Auto-generated method stub
		for(CourseScore list:t){
			sessionFactory.getCurrentSession().save(list);
		}
	}

	@Override
	public void deleteScoreInfo(List<?> ids) {
		// TODO Auto-generated method stub
		String hql="delete from CourseScore where id in (:ids)";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids).executeUpdate();
	}

	@Override
	public boolean scoreExist(int stuinfoId, String addTime) {
		// TODO Auto-generated method stub
		String hql="from CourseScore c where c.stuinfoId=? and c.addTime=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, stuinfoId);
		query.setString(1, addTime);
		return (query.executeUpdate()>0);
	}

	@Override
	public List<?> findScoreInfoByTimeAndId(int stuinfoId,int classId) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.admin.entity.CourseScore(cs.id,cs.stuinfoId,cs.courseId,cs.score, cs.author, cs.addTime,t.courseName, s.stuName,s.stuId) from CourseStudentInfo s,CourseScore cs,CourseType t where cs.courseId=t.id and cs.stuinfoId=s.id and cs.stuinfoId=? and cs.classId=? ORDER BY cs.addTime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, stuinfoId);
		query.setInteger(1, classId);
		return (List<?>)query.list();
	}

}
