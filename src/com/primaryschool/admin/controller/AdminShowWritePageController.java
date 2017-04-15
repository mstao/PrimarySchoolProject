package com.primaryschool.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: AdminShowWritePageController
* @Description: TODO  显示 撰写页面
* @author Mingshan
* @date 2017年4月16日 上午12:27:07
*
 */

@Controller
@RequestMapping("/admin/write")
public class AdminShowWritePageController {

	/**
	 * 
	* @Title: trends
	* @Description: TODO 撰写页面
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/page")
	public String trends(String typeName,String typeFlag,String fileType,ModelMap map){
		map.put("typeName", typeName);
		map.put("typeFlag", typeFlag);
		map.put("fileType", fileType);
		return "admin/write/writeTrends";
	}
}
