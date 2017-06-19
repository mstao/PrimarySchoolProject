package com.primaryschool.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.admin.service.IAdminCultureService;
import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.Trends;

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
public class AdminIndexController<T> {

	
	@Autowired
    private  IAdminTrendsService<T> trendsService;
	
	@Autowired
	private IAdminCultureService<T> cultureService;
	/**
	 * 
	* @Title: index
	* @Description: TODO 指向主页
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
	
		
		//获取最近新闻
		ArrayList<Trends> news = (ArrayList<Trends>) trendsService.findTrendsInfo("news", 0, 8);
		
		//获取最近公告
		ArrayList<Trends> notice = (ArrayList<Trends>) trendsService.findTrendsInfo("notice", 0, 8);
		
		//获取校务公开
		ArrayList<Culture> affairs = (ArrayList<Culture>) cultureService.findCultureInfo("affairs", 0, 8);
		
		
		request.setAttribute("news", news);
		request.setAttribute("notice", notice);
		request.setAttribute("affairs", affairs);
		
		return "admin/index";
	}
	
	
}
