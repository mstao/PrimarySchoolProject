package com.primaryschool.global.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* 定义EL自定义函数
*
*/  
public class UFunction{   
  
 

	/**
      * 获取一个字符串的长度
      *
      * @param str
      * @return int
      */  
    public static int getLen(String str) {   
        return str.length();   
     }   
  
    /**
      * 截取字符串
      *
      * @param str
      * @param start
      * @param end
      * @return String
      */  
    public static String substr(String str, int start, int end,boolean isDot) { 
    	int len=str.length();
    	if(len<end){
    		return str;
    	}else{
    		if(isDot==true){
    			return str.substring(start, end)+"...";	
    		}else{
    			return str.substring(start, end);	
    		}
    	}
          
     }
    
    
  
    /**
      * 两数相除获取整数结果
      *  
      * @param first
      * @param second
      * @return int
      */  
    public static int chufa(int first, int second) {   
        return first / second;   
     }   
    
    /**
     * 
    * @Title: dateSub
    * @Description: TODO 首页日期整理
    * @param @param dateStr
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    public static String dateSub(String dateStr){ 
    	return  dateStr.substring(5);
    }
    
    /**
     * @throws ParseException 
     * 
    * @Title: dateToString
    * @Description: TODO 日期格式化
    * @param @param strDate
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    public static String dateToString(String strDate) throws ParseException{
    	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
    	 
    	 //将string类型转为date类型

    	 Date strtodate = formatter.parse(strDate);
    	 
    	 System.out.println(strtodate);
    	 //进行日期格式化
    	 String condate=formatter.format(strtodate);
   	     return condate;
    }
    
}  
