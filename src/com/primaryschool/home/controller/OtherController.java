package com.primaryschool.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: OtherController
* @Description: TODO  其他未归类   联系我们  等
* @author Mingshan
* @date 2017年4月20日 下午8:35:00
*
 */
@Controller
public class OtherController {

	/**
	 * 
	* @Title: contact
	* @Description: TODO 联系我们
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/contact")
	public String contact(ModelMap map){
		return "home/contact/contact";
		
	}
	
	/**
	 * 
	* @Title: copyRight
	* @Description: TODO 版权声明
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/copyright")
	public  String copyRight(ModelMap map){
		return "home/copyright/copyright";
	}
}
