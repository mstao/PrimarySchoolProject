package com.primaryschool.apply.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.apply.dao.IApplyDao;
import com.primaryschool.apply.entity.ApplyDate;

/**
 * 
* @ClassName: ApplyDao
* @Description: TODO APPLY DAO
* @author Mingshan
* @date 2017年5月1日 下午3:14:23
*
* @param <T>
 */

@Repository
public class ApplyDao<T> implements IApplyDao<T> {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveApplyInfo(T t) {
		// TODO Auto-generated method stub
		Serializable res=sessionFactory.getCurrentSession().save(t);
		return (int) res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findApplyInfo(int id) {
		// TODO Auto-generated method stub
		
		String hql="from Apply a where a.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findApplyInfoByCardId(String  cardCode) {
		// TODO Auto-generated method stub
		String hql="from Apply a where a.stuIdNum=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, cardCode);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findApplyCardCodeByUserCardCode(String userCardCode) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.apply.entity.Apply(a.id,a.stuIdNum) from Apply a, ApplyUser au where a.uid=au.id and au.cardCode=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userCardCode);
		return (T) query.uniqueResult();
	}

	@Override
	public int findDateIdByYear(int year) {
		// TODO Auto-generated method stub
		String hql="from ApplyDate where year=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, year);
		ApplyDate date= (ApplyDate) query.uniqueResult();
		return date.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findDateInfoByYear(int year) {
		// TODO Auto-generated method stub
		String hql="from ApplyDate where year=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, year);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findApplyInfoByYear(int year,int status,int position,int item_per_page) {
		// TODO Auto-generated method stub
		String hql="";
		if(status==3){
			hql="select new com.primaryschool.apply.entity.Apply(a.id,a.stuName,a.stuSex,a.stuNation,a.stuIdNum,a.addTime,a.status,a.reason,a.imgPath) from Apply a,ApplyDate ae where a.dateId=ae.id and ae.year=?";
		}else{
			hql="select new com.primaryschool.apply.entity.Apply(a.id,a.stuName,a.stuSex,a.stuNation,a.stuIdNum,a.addTime,a.status,a.reason,a.imgPath) from Apply a,ApplyDate ae where a.dateId=ae.id and ae.year=? and a.status=?";
		}

		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, year);
		if(status!=3){
			query.setInteger(1, status);
		}
		return query.list();
	}

	@Override
	public int findApplyCountByYear(int year) {
		// TODO Auto-generated method stub
		BigInteger count;
		int r;
		//将年份换成id
		//int dateId=this.findDateIdByYear(year);
		String sql="select count(CASE WHEN t.date_id=pa.id and pa.year=?   THEN 1 ELSE NULL END) from ps_apply t,ps_apply_date pa";
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,year);
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;
	}

	/**
	 * 根据id更改状态值
	 */
	@Override
	public boolean updateApplyStatus(int id,int statusValue,String reason) {
		// TODO Auto-generated method stub
		String hql="update Apply a set a.status=?,a.reason=? where a.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, statusValue);
		query.setString(1, reason);
		query.setInteger(2, id);
		return query.executeUpdate()>0;
	}

	@Override
	public void saveApplyDate(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void updateApplyDate(T t) {
		// TODO Auto-generated method stub
		String hql="update ApplyDate a set a.year=:year,a.startDate=:startDate,a.endDate=:endDate where a.id=:id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setProperties(t);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findApplyInfoByToken(String token, int status,int year) {
		// TODO Auto-generated method stub
		//status 有4种码  0,1,2  3代表模糊查询全部
		String hql="";
		if(status==3){
			hql="select new com.primaryschool.apply.entity.Apply(a.id,a.stuName,a.stuSex,a.stuNation,a.stuIdNum,a.addTime,a.status,a.reason) from Apply a,ApplyDate ad where a.dateId=ad.id and ad.year=:year and (a.stuName like:token or a.stuIdNum like:token)";	
		}else{
			hql="select new com.primaryschool.apply.entity.Apply(a.id,a.stuName,a.stuSex,a.stuNation,a.stuIdNum,a.addTime,a.status,a.reason) from Apply a,ApplyDate ad where a.status=:status and a.dateId=ad.id and ad.year=:year and (a.stuName like:token or a.stuIdNum like:token)";	
		}
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);     
		if(status!=3){
			query.setInteger("status", status);	
		}	
		query.setInteger("year", year);
		query.setString("token", "%"+token+"%");  
		
		return query.list();
	}

	@Override
	public int findApplyCountByStatusYear(int status, int year) {
		// TODO Auto-generated method stub
		
		//status 有4种码  0,1,2  3代表查询全部
		
		BigInteger count;
		int r;
		String sql="";
		if(status==3){
			sql="select count(CASE WHEN pa.date_id=pad.id and pad.year=? THEN 1 ELSE NULL END) from ps_apply pa,ps_apply_date pad";
		}else{
			sql="select count(CASE WHEN pa.date_id=pad.id and pad.year=? and pa.status=? THEN 1 ELSE NULL END) from ps_apply pa,ps_apply_date pad";
		}
		
		Query query  = sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.setInteger(0,year);
		if(status!=3){
			query.setInteger(1, status);	
		}
	    
		count= (BigInteger) query.uniqueResult();
		r=count.intValue();
		return r;

	}

	@Override
	public void deleteApplyInfoById(List<?> ids) {
		// TODO Auto-generated method stub
		 String hql = "delete from Apply where id in (:ids)";
		 Query query  =  sessionFactory.getCurrentSession().createQuery(hql);
		 query.setParameterList("ids", ids).executeUpdate();
	}

	/**
	 * 开启，关闭报名功能
	 */
	@Override
	public void updateBeginStatus(int year,int beginApply) {
		// TODO Auto-generated method stub
		String hql="update ApplyDate a set a.beginApply=? where a.year=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0,beginApply);
		query.setInteger(1, year);
		query.executeUpdate();
	}

	@Override
	public void updateApplyInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update Apply a set  a.stuName=:stuName,a.stuNation=:stuNation,a.stuSex=:stuSex,a.stuIdNum=:stuIdNum,a.originalSchool=:originalSchool,a.address=:address,a.register=:register,a.fatherName=:fatherName,a.fatherIdNum=:fatherIdNum,a.fatherPhone=:fatherPhone,a.motherName=:motherName,a.motherIdNum=:motherIdNum,a.motherPhone=:motherPhone,a.status=:status,a.imgPath=:imgPath where a.id=:id";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		query.executeUpdate();
		
	}

}
