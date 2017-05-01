package com.primaryschool.apply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
* @ClassName: ApplyIndexController
* @Description: TODO 首页
* @author Mingshan
* @date 2017年4月30日 下午7:15:01
*
 */

@Controller
@RequestMapping("/apply/index")
public class ApplyIndexController {

	@RequestMapping("/message")
	public String index(){
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
