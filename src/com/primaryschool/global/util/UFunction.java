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
    	return  dateStr.substring(5,10);
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
    
    
    /**
     * 将阿拉伯数字转化为汉字
     * @param r
     * @return
     */
    public static String numToChinese(int r){
    	  String[] s1 = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
          String[] s2 = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };

          String result = "";
          String s=String.valueOf(r);
          int n = s.length();
          for (int i = 0; i < n; i++) {

              int num = s.charAt(i) - '0';

              if (i != n - 1 && num != 0) {
                  result += s1[num] + s2[n - 2 - i];
              } else {
                  result += s1[num];
              }

          }

          System.out.println(result);
          return result;
    }
}  
