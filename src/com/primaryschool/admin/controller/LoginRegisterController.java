package com.primaryschool.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: LoginRegisterController
* @Description: TODO  后台登录注册控制器
* @author Mingshan
* @date 2017年4月6日 下午2:02:51
*
 */


@Controller
@RequestMapping("/admin/loginRegister")
public class LoginRegisterController {

	/**
	 * 
	* @Title: showLogin
	* @Description: TODO  学生报名登录
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/showStuLogin")
	public String showStudentLogin(){
		
		
		return "admin/loginOrregister/student-login";
	}
	
	
	/**
	 * 
	* @Title: showStudentRegister
	* @Description: TODO 学生注册
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/showStuRegister")
	public String showStudentRegister(){
		return "admin/loginOrregister/student-register";
	}
	
	/**
	 * 
	* @Title: showTeacherLogin
	* @Description: TODO 教师登录
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@RequestMapping("/showTeaLogin")
	public String showTeacherLogin(){
		
		return "admin/loginOrregister/teacher-login";
	}
	
	/**
	 * 
	* @Title: showTeacherRegister
	* @Description: TODO 教师注册
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@RequestMapping("/showTeaRegister")
	public String showTeacherRegister(){
		return "admin/loginOrregister/teacher-register";
	}
	
	
}
