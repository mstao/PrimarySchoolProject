package com.primaryschool.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.home.entity.Trends;

/**
 * 
* @ClassName: DistributeInfoController
* @Description: TODO 分发数据
* @author Mingshan
* @date 2017年4月14日 下午3:37:58
*
 */

@Controller
@RequestMapping("/admin/distribute")
public class DistributeInfoController<T> {
    @Autowired
    private IAdminTrendsService<T> trendsService;
	
	/**
	 * 
	* @Title: trends
	* @Description: TODO  分发 校园动态数据
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/trends")
	public String  trends(int id,ModelMap map){
		Trends trends=(Trends) trendsService.findTrendsInfoById(id);
	    
	    map.put("item", trends);
		return "admin/details/trendsDetail";
	}
}
