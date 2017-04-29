package com.primaryschool.apply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: ShowPageController
* @Description: TODO 新生报名系统  显示界面
* @author Mingshan
* @date 2017年4月29日 下午9:00:18
*
 */

@Controller
@RequestMapping("/apply/show")
public class ShowPageController {


	/**
	 * 
	* @Title: message
	* @Description: TODO显示填写信息页面
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/message")
	public String message(ModelMap map){
		System.out.println("zzzzzzzzzzzz");
		return "apply/message";
	}
	
	
	/**
	 * 
	* @Title: status
	* @Description: TODO 显示状态
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/status")
	public String status(){
		return "apply/status";
	}
}
