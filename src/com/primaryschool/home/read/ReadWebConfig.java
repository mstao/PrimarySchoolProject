package com.primaryschool.home.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 
* @ClassName: ReadWebConfig
* @Description: TODO 读取网站的基础配置信息，并将其加入到上下文中
* @author Mingshan
* @date 2017年3月25日 下午9:59:19
*
 */
public class ReadWebConfig extends HttpServlet implements Serializable{

	private static final long serialVersionUID = 1L;

    //网站配置文件路径
    private static final String BUNDLE_NAM="/config/web.properties";
    /*网站的配置信息声明*/
   	private static  String  WEBSITE_NAME;
   	private static  String  SCHOOL_ADDRESS;
   	private static  String  SCHOOL_TEL;
   	private static  String  SCHOOL_POSTCODE;
    /*导航栏配置信息声明*/
   	
   	/**学校文化**/
   	private static  String  SCHOOL_CULTURE;
   	private static  String  SCHOOL_CULTURE_INTRODUCE;
   	private static  String  SCHOOL_CULTURE_AFFAIRS;
   	private static  String  SCHOOL_CULTURE_SIGHT;
	
	/**校园动态**/
   	private static  String  SCHOOL_TRENDS;
   	private static  String  SCHOOL_TRENDS_NEWS;
   	private static  String  SCHOOL_TRENDS_NOTICE;
	
	/**阳光德育**/
   	private static  String  SCHOOL_EDUCATION;
   	private static  String  SCHOOL_EDUCATION_MAIN;
   	private static  String  SCHOOL_EDUCATION_SPEAK;
   	private static  String  SCHOOL_EDUCATION_ACTIVE;
   	private static  String  SCHOOL_EDUCATION_PARENTS;
   	private static  String  SCHOOL_EDUACTION_STAGENT;
	
	/**学生天地**/
   	private static  String  SCHOOL_STUDENT;
   	private static  String  SCHOOL_STUDENT_BOOK;
   	private static  String  SCHOOL_STUDENT_ACTIVITY;
   	private static  String  SCHOLL_STUDENT_CLASS;
   	private static  String  SCHOOL_STUDENT_LAB;
	
	/**教师园地**/
   	private static  String  SCHOOL_TEACHER;
   	private static  String  SCHOOL_TEACHER_RESOURCES;
   	private static  String  SCHOOL_TEACHER_TEACHERS;
   	private static  String  SCHOOL_TEACHER_TRAIN;
   	private static  String  SCHOOL_TEACHER_PRIZE;
	
	/**党务工会**/
   	private static  String  SCHOOL_PARTY;
   	private static  String  SCHOOL_PARTY_BRANCH;
   	private static  String  SCHOOL_PARTY_TRADE_UNION;
	
	/**学校管理**/
   	private static  String  SCHOOL_MANAGE;
   	private static  String  SCHOOL_MANAGE_DEPARTMENT;
   	private static  String  SCHOOL_MANAGE_RECOMMENDATION;
   	private static  String  SCHOOL_MANAGE_NOTICE;
   	private static  String  SCHOOL_MANAGE_RULES;
   	private static  String  SCHOOL_MANAGE_EMAIL;
	
   	/**综合实验课  课程信息**/
   	private static  String  LABCLASS_INTRO;
   	private static  String  LABCLASS_TOPIC;
   	private static  String  LABCLASS_SHOW;
   	
   	/**教学资源    具体信息**/
   	private static  String  TEACHER_RESOURCES_DISCUSS;
   	private static  String  TEACHER_RESOURCES_DESIGN;
   	private static  String  TEACHER_RESOURCES_COURSEWARE;
   	private static  String  TEACHER_RESOURCES_MICROLECTURE;
   	private static  String  TEACHER_RESOURCES_QUESTION_BANK;
   	
   	/**班级主页**/
   	private static  String CLASS_MAINPAGE;
   	private static  String CLASS_SYNOPSIS;
   	private static  String CLASS_PHOTO;
   	private static  String CLASS_ACIVITY;
   	private static  String CLASS_STORY;
   	private static  String CLASS_ARTICLE;
	
   	
	/**当前年份**/
	private static  String  WEB_CURRENT_YEAR;
	static {   
		
		  //获取当前年份
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	      Date date = new Date();
	      String formatDate = sdf.format(date);
	      WEB_CURRENT_YEAR=formatDate;
	      //读取网站配置文件
	      Properties prop = new Properties();   
	      InputStream in = null;
		  in =ReadWebConfig.class.getResourceAsStream(ReadWebConfig.BUNDLE_NAM); 
		  BufferedReader bf = null;
		  try {
			//解决中文乱码 须将其转为字符流形式读取，中文不支持字节流读取
			bf = new BufferedReader(new InputStreamReader(in,"UTF-8"));
		   } catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		  }
		  try {   
	          prop.load(bf);   
	          /*简介配置信息*/
	        //  WEB_INTRO_NAVI = prop.getProperty("WEB_INTRO_NAVI").trim();   
	          WEBSITE_NAME=prop.getProperty("WEBSITE_NAME").trim();
	          SCHOOL_ADDRESS=prop.getProperty("SCHOOL_ADDRESS").trim();
	          SCHOOL_TEL=prop.getProperty("SCHOOL_TEL").trim();
	          SCHOOL_POSTCODE=prop.getProperty("SCHOOL_POSTCODE").trim();
	          
	          /*学校文化*/
	          SCHOOL_CULTURE=prop.getProperty("SCHOOL_CULTURE").trim();
	          SCHOOL_CULTURE_INTRODUCE=prop.getProperty("SCHOOL_CULTURE_INTRODUCE").trim();
	          SCHOOL_CULTURE_AFFAIRS=prop.getProperty("SCHOOL_CULTURE_AFFAIRS").trim();
	          SCHOOL_CULTURE_SIGHT=prop.getProperty("SCHOOL_CULTURE_SIGHT").trim();
	          
	          /*校园动态*/
	          SCHOOL_TRENDS=prop.getProperty("SCHOOL_TRENDS").trim();
	          SCHOOL_TRENDS_NEWS=prop.getProperty("SCHOOL_TRENDS_NEWS").trim();
	          SCHOOL_TRENDS_NOTICE=prop.getProperty("SCHOOL_TRENDS_NOTICE").trim();
	          
	          /*阳光德育*/
	          SCHOOL_EDUCATION=prop.getProperty("SCHOOL_EDUCATION").trim();
	          SCHOOL_EDUCATION_MAIN=prop.getProperty("SCHOOL_EDUCATION_MAIN").trim();
	          SCHOOL_EDUCATION_SPEAK=prop.getProperty("SCHOOL_EDUCATION_SPEAK").trim();
	          SCHOOL_EDUCATION_ACTIVE=prop.getProperty("SCHOOL_EDUCATION_ACTIVE").trim();
	          SCHOOL_EDUCATION_PARENTS=prop.getProperty("SCHOOL_EDUCATION_PARENTS").trim();
	          SCHOOL_EDUACTION_STAGENT=prop.getProperty("SCHOOL_EDUACTION_STAGENT").trim();
	          
	          /*学生天地*/
	          SCHOOL_STUDENT=prop.getProperty("SCHOOL_STUDENT").trim();
	          SCHOOL_STUDENT_BOOK=prop.getProperty("SCHOOL_STUDENT_BOOK").trim();
	          SCHOOL_STUDENT_ACTIVITY=prop.getProperty("SCHOOL_STUDENT_ACTIVITY").trim();
	          SCHOLL_STUDENT_CLASS=prop.getProperty("SCHOLL_STUDENT_CLASS").trim();
	          SCHOOL_STUDENT_LAB=prop.getProperty("SCHOOL_STUDENT_LAB").trim();
	          
	          /*教师园地*/
	          SCHOOL_TEACHER=prop.getProperty("SCHOOL_TEACHER").trim();
	          SCHOOL_TEACHER_RESOURCES=prop.getProperty("SCHOOL_TEACHER_RESOURCES").trim();
	          SCHOOL_TEACHER_TEACHERS=prop.getProperty("SCHOOL_TEACHER_TEACHERS").trim();
	          SCHOOL_TEACHER_TRAIN=prop.getProperty("SCHOOL_TEACHER_TRAIN").trim();
	          SCHOOL_TEACHER_PRIZE=prop.getProperty("SCHOOL_TEACHER_PRIZE").trim();
	          
	          /*党务工会*/
	          SCHOOL_PARTY=prop.getProperty("SCHOOL_PARTY").trim();
	          SCHOOL_PARTY_BRANCH=prop.getProperty("SCHOOL_PARTY_BRANCH").trim();
	          SCHOOL_PARTY_TRADE_UNION=prop.getProperty("SCHOOL_PARTY_TRADE_UNION").trim();
	          
	          /*学校管理*/
	          SCHOOL_MANAGE=prop.getProperty("SCHOOL_MANAGE").trim();
	          SCHOOL_MANAGE_DEPARTMENT=prop.getProperty("SCHOOL_MANAGE_DEPARTMENT").trim();
	          SCHOOL_MANAGE_RECOMMENDATION=prop.getProperty("SCHOOL_MANAGE_RECOMMENDATION").trim();
	          SCHOOL_MANAGE_NOTICE=prop.getProperty("SCHOOL_MANAGE_NOTICE").trim();
	          SCHOOL_MANAGE_RULES=prop.getProperty("SCHOOL_MANAGE_RULES").trim();
	          SCHOOL_MANAGE_EMAIL=prop.getProperty("SCHOOL_MANAGE_EMAIL").trim();
	          
	          /*综合实验课  课程信息*/
	          LABCLASS_INTRO=prop.getProperty("LABCLASS_INTRO").trim();
	          LABCLASS_TOPIC=prop.getProperty("LABCLASS_TOPIC").trim();
	          LABCLASS_SHOW=prop.getProperty("LABCLASS_SHOW").trim();
	          
	          /*教学资源    具体信息*/
	          TEACHER_RESOURCES_DISCUSS=prop.getProperty("TEACHER_RESOURCES_DISCUSS").trim();
	          TEACHER_RESOURCES_DESIGN=prop.getProperty("TEACHER_RESOURCES_DESIGN").trim();
	          TEACHER_RESOURCES_COURSEWARE=prop.getProperty("TEACHER_RESOURCES_COURSEWARE").trim();
	          TEACHER_RESOURCES_MICROLECTURE=prop.getProperty("TEACHER_RESOURCES_MICROLECTURE").trim();
	          TEACHER_RESOURCES_QUESTION_BANK=prop.getProperty("TEACHER_RESOURCES_QUESTION_BANK").trim();
	          
	          /**班级主页**/
	          CLASS_MAINPAGE=prop.getProperty("CLASS_MAINPAGE").trim();
	          CLASS_SYNOPSIS=prop.getProperty("CLASS_SYNOPSIS").trim();
	          CLASS_PHOTO=prop.getProperty("CLASS_PHOTO").trim();
	          CLASS_ACIVITY=prop.getProperty("CLASS_ACIVITY").trim();
	          CLASS_STORY=prop.getProperty("CLASS_STORY").trim();
	          CLASS_ARTICLE=prop.getProperty("CLASS_ARTICLE").trim();
	          
	          in.close();
	          bf.close();
	      } catch (IOException e) {   
	          e.printStackTrace();   
	      }   
	           
	  }
	//初始化信息
	public void init() throws ServletException{
		/*实验室简介配置信息*/
		//getServletContext().setAttribute("WEB_INTRO_NAVI",WEB_INTRO_NAVI);
		getServletContext().setAttribute("WEBSITE_NAME",WEBSITE_NAME);
		getServletContext().setAttribute("SCHOOL_ADDRESS",SCHOOL_ADDRESS);
		getServletContext().setAttribute("SCHOOL_TEL",SCHOOL_TEL);
		getServletContext().setAttribute("SCHOOL_POSTCODE",SCHOOL_POSTCODE);
		
		
		getServletContext().setAttribute("SCHOOL_CULTURE",SCHOOL_CULTURE);
		getServletContext().setAttribute("SCHOOL_CULTURE_INTRODUCE",SCHOOL_CULTURE_INTRODUCE);
		getServletContext().setAttribute("SCHOOL_CULTURE_AFFAIRS",SCHOOL_CULTURE_AFFAIRS);
		getServletContext().setAttribute("SCHOOL_CULTURE_SIGHT",SCHOOL_CULTURE_SIGHT);
		
		
		getServletContext().setAttribute("SCHOOL_TRENDS",SCHOOL_TRENDS);
		getServletContext().setAttribute("SCHOOL_TRENDS_NEWS",SCHOOL_TRENDS_NEWS);
		getServletContext().setAttribute("SCHOOL_TRENDS_NOTICE",SCHOOL_TRENDS_NOTICE);
		
		
		getServletContext().setAttribute("SCHOOL_EDUCATION",SCHOOL_EDUCATION);
		getServletContext().setAttribute("SCHOOL_EDUCATION_MAIN",SCHOOL_EDUCATION_MAIN);
		getServletContext().setAttribute("SCHOOL_EDUCATION_SPEAK",SCHOOL_EDUCATION_SPEAK);
		getServletContext().setAttribute("SCHOOL_EDUCATION_ACTIVE",SCHOOL_EDUCATION_ACTIVE);
		getServletContext().setAttribute("SCHOOL_EDUCATION_PARENTS",SCHOOL_EDUCATION_PARENTS);
		getServletContext().setAttribute("SCHOOL_EDUACTION_STAGENT",SCHOOL_EDUACTION_STAGENT);
		
		
		getServletContext().setAttribute("SCHOOL_STUDENT",SCHOOL_STUDENT);
		getServletContext().setAttribute("SCHOOL_STUDENT_BOOK",SCHOOL_STUDENT_BOOK);
		getServletContext().setAttribute("SCHOOL_STUDENT_ACTIVITY",SCHOOL_STUDENT_ACTIVITY);
		getServletContext().setAttribute("SCHOLL_STUDENT_CLASS",SCHOLL_STUDENT_CLASS);
		getServletContext().setAttribute("SCHOOL_STUDENT_LAB",SCHOOL_STUDENT_LAB);
		
		
		getServletContext().setAttribute("SCHOOL_TEACHER",SCHOOL_TEACHER);	
		getServletContext().setAttribute("SCHOOL_TEACHER_RESOURCES",SCHOOL_TEACHER_RESOURCES);
		getServletContext().setAttribute("SCHOOL_TEACHER_TEACHERS",SCHOOL_TEACHER_TEACHERS);
		getServletContext().setAttribute("SCHOOL_TEACHER_TRAIN",SCHOOL_TEACHER_TRAIN);
		getServletContext().setAttribute("SCHOOL_TEACHER_PRIZE",SCHOOL_TEACHER_PRIZE);
		
		
		getServletContext().setAttribute("SCHOOL_PARTY",SCHOOL_PARTY);
		getServletContext().setAttribute("SCHOOL_PARTY_BRANCH",SCHOOL_PARTY_BRANCH);
		getServletContext().setAttribute("SCHOOL_PARTY_TRADE_UNION",SCHOOL_PARTY_TRADE_UNION);
		
		
		getServletContext().setAttribute("SCHOOL_MANAGE",SCHOOL_MANAGE);
		getServletContext().setAttribute("SCHOOL_MANAGE_DEPARTMENT",SCHOOL_MANAGE_DEPARTMENT);
		getServletContext().setAttribute("SCHOOL_MANAGE_RECOMMENDATION",SCHOOL_MANAGE_RECOMMENDATION);
		getServletContext().setAttribute("SCHOOL_MANAGE_NOTICE",SCHOOL_MANAGE_NOTICE);
		getServletContext().setAttribute("SCHOOL_MANAGE_RULES",SCHOOL_MANAGE_RULES);
		getServletContext().setAttribute("SCHOOL_MANAGE_EMAIL",SCHOOL_MANAGE_EMAIL);
		
		
		
		getServletContext().setAttribute("LABCLASS_INTRO",LABCLASS_INTRO);
		getServletContext().setAttribute("LABCLASS_TOPIC",LABCLASS_TOPIC);
		getServletContext().setAttribute("LABCLASS_SHOW",LABCLASS_SHOW);
		
		
		getServletContext().setAttribute("TEACHER_RESOURCES_DISCUSS",TEACHER_RESOURCES_DISCUSS);
		getServletContext().setAttribute("TEACHER_RESOURCES_DESIGN",TEACHER_RESOURCES_DESIGN);
		getServletContext().setAttribute("TEACHER_RESOURCES_COURSEWARE",TEACHER_RESOURCES_COURSEWARE);
		getServletContext().setAttribute("TEACHER_RESOURCES_MICROLECTURE",TEACHER_RESOURCES_MICROLECTURE);
		getServletContext().setAttribute("TEACHER_RESOURCES_QUESTION_BANK",TEACHER_RESOURCES_QUESTION_BANK);
		
		getServletContext().setAttribute("CLASS_MAINPAGE",CLASS_MAINPAGE);
		getServletContext().setAttribute("CLASS_SYNOPSIS",CLASS_SYNOPSIS);
		getServletContext().setAttribute("CLASS_PHOTO",CLASS_PHOTO);
		getServletContext().setAttribute("CLASS_ACIVITY",CLASS_ACIVITY);
		getServletContext().setAttribute("CLASS_STORY",CLASS_STORY);
		getServletContext().setAttribute("CLASS_ARTICLE",CLASS_ARTICLE);
		
		
		getServletContext().setAttribute("WEB_CURRENT_YEAR",WEB_CURRENT_YEAR);
	
	}
	 

	
	  
	  
}
