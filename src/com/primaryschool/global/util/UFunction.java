package com.primaryschool.global.util;


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
    public static String substr(String str, int start, int end) { 
    	int len=str.length();
    	if(len<end){
    		return str;
    	}else{
    		return str.substring(start, end)+"...";	
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
}  
