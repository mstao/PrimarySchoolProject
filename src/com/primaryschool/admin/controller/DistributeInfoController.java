package com.primaryschool.admin.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String  trends(int id,ModelMap map,HttpServletRequest request){
		Trends trends=(Trends) trendsService.findTrendsInfoById(id);
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_TRENDS");
		String fileType="ftrends";
		String durl="trends";
		map.put("item", trends);
	    map.put("school_trends_c", SCHOOL_TRENDS);
	    map.put("fileType", fileType);
	    map.put("durl", durl);
		return "admin/details/trendsDetail";
	}
}
