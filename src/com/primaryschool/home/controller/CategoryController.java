
package com.primaryschool.home.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.ITrendsService;

/**
* @ClassName: CategoryController
* @Description: TODO  类别分发控制器
* @author Mingshan
* @date 2017年3月28日 下午6:15:30
*
*/

@Controller
@RequestMapping("/category")
public class CategoryController {
    
	@Autowired  
	private ITrendsService<Trends> trendsService;

	@RequestMapping("/trends")
	public String trends(HttpServletRequest request){
		int pageSize=PageSizeConfig.HOME_CATEGORY_PAGESIZE;
		
		//获取该类型的热点信息
        ArrayList<Trends> hotTrends=(ArrayList<Trends>)trendsService.findHotTrendsInfo("news", 0, pageSize);
		
        //获取校园新闻
        String newsFlag="news";
   	 
		ArrayList<Trends>  news=(ArrayList<Trends>) trendsService.findTrendsInfo(newsFlag, 0, pageSize);
        
		//获取通知公告
		String noticeFlag="notice";
		ArrayList<Trends>  notice=(ArrayList<Trends>) trendsService.findTrendsInfo(noticeFlag, 0, pageSize);
		
		request.setAttribute("hotTrends", hotTrends);
		request.setAttribute("news", news);
		request.setAttribute("notice", notice);
		request.setAttribute("newsFlag", newsFlag);
		request.setAttribute("noticeFlag", noticeFlag);
		return "home/category/trends";
	}
	
}
