package com.primaryschool.apply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.apply.entity.Apply;
import com.primaryschool.apply.entity.ApplyDate;
import com.primaryschool.apply.service.IApplyService;
import com.primaryschool.global.util.GetDateUtil;

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
public class ShowPageController<T> {

	  @Autowired
	  private IApplyService<T> applyService;
	    
	
	/**
	 * 
	* @Title: showLogin
	* @Description: TODO  学生报名登录 显示
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/stuLogin")
	public String showStudentLogin(ModelMap map){
		//获取当前年份
		String s_year=GetDateUtil.getYear();
		int year=Integer.parseInt(s_year);
		
		//根据年份找到报名日期信息		
		ApplyDate dateInfo=(ApplyDate) applyService.findDateInfoByYear(year);
		
		map.put("dateInfo",dateInfo);
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
	public String showStudentRegister(ModelMap map){
		//获取当前年份
		String s_year=GetDateUtil.getYear();
		int year=Integer.parseInt(s_year);
		
		//根据年份找到报名日期信息		
		ApplyDate dateInfo=(ApplyDate) applyService.findDateInfoByYear(year);
		
		map.put("dateInfo",dateInfo);
		return "admin/loginOrregister/student-register";
	}
	

	/**
	 * 
	* @Title: showUpdate
	* @Description: TODO  更新
	* @param @param id
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/update")
	public String showUpdate(int id,ModelMap map){
		Apply apply=(Apply) applyService.findApplyInfo(id);
		//获取当前年份
		String s_year=GetDateUtil.getYear();
		int year=Integer.parseInt(s_year);
		
		//根据年份找到报名日期信息		
		ApplyDate dateInfo=(ApplyDate) applyService.findDateInfoByYear(year);
		
		map.put("dateInfo",dateInfo);
		map.put("apply", apply);
		map.put("id", id);
		return "apply/update";
	}
	
}
