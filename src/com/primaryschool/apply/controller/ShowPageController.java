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
	* @Title: showLogin
	* @Description: TODO  学生报名登录 显示
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/stuLogin")
	public String showStudentLogin(){
		
		
		return "admin/loginOrregister/student-login";
	}
	
	
	/**
	 * 
	* @Title: showStudentRegister
	* @Description: TODO 学生注册 显示
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/stuRegister")
	public String showStudentRegister(){
		return "admin/loginOrregister/student-register";
	}
	

	
}
