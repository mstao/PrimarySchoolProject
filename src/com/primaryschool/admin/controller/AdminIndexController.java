package com.primaryschool.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: AdminIndexController
* @Description: TODO 后台主页控制器
* @author Mingshan
* @date 2017年4月14日 下午2:43:06
*
 */


@Controller
@RequestMapping("/admin")
public class AdminIndexController {

	
	/**
	 * 
	* @Title: index
	* @Description: TODO 指向主页
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/index")
	public String index(){
		
		return "admin/index";
	}
	
	
}
