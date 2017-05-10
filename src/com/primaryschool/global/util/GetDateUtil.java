package com.primaryschool.global.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * @ClassName: GetDateUtil 
 * @Description: TODO 获取系统时间
 * @date 2016年12月26日 下午8:56:36  
 */
public class GetDateUtil {
	
	/**
	 * 
	* @Title: getData
	* @Description: TODO 获取yyyy-MM-dd形式日期
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
     public static String getData(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
 	    String condate=df.format(new Date());// new Date()为获取当前系统时间
 	    return condate;
     }
     
     
     public static String getAllDate(){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
  	    String condate=df.format(new Date());// new Date()为获取当前系统时间
  	    return condate;
     }
     
     /**
      * 
     * @Title: getYear
     * @Description: TODO 获取当前年份
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
      */
     public static String getYear(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
  	    String condate=df.format(new Date());// new Date()为获取当前系统时间
  	    return condate;
     }
}
