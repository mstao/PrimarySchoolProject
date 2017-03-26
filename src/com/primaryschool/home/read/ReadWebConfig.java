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
    private static final String BUNDLE_NAM="/web.properties";
    /*网站的配置信息声明*/
   	private String  WEBSITE_NAME;
   	private String  SCHOOL_ADDRESS;
   	private String  SCHOOL_TEL;
   	private String  SCHOOL_POSTCODE;
    /*导航栏配置信息声明*/
	
	
	static {   
		
		  //获取当前年份
		 /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	      Date date = new Date();
	      String formatDate = sdf.format(date);
	      WEB_CURRENT_YEAR=formatDate;*/
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
	          /*实验室简介配置信息*/
	        //  WEB_INTRO_NAVI = prop.getProperty("WEB_INTRO_NAVI").trim();   
	        
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
		
	}
	 

	
	  
	  
}
