package com.primaryschool.home.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.IEducationService;
import com.primaryschool.home.service.ITrendsService;

/**
 * 主页控制器
* @ClassName: IndexController
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Mingshan
* @date 2017年3月26日 下午2:28:44
*
 */

@Controller
@RequestMapping("/main")
public class IndexController {
    @Autowired  
    private ITrendsService<Trends> trendsService;
   
    @Autowired 
    private IEducationService<Education> educationService;
    
    
    /**
     * 
    * @Title: index
    * @Description: TODO 首页内容加载
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		int position=0;
		int item_per_page=7;
		//获取校园动态信息
		
		//获取校内新闻信息
		String newsFlag="news";
	 
		ArrayList<Trends>  news=(ArrayList<Trends>) trendsService.findTrendsInfo(newsFlag, position, item_per_page);
 		/*for(Trends t:news){
 			System.out.println("id--"+t.getId());
 		}*/
		//获取校内通知
		String noticeFlag="notice";
		ArrayList<Trends>  notice=(ArrayList<Trends>) trendsService.findTrendsInfo(noticeFlag, position, item_per_page);
		
		//获取阳光教育-主题教育
		String educationType="education";
		ArrayList<Education>  education=(ArrayList<Education>)educationService.findEducationInfo(educationType, position, item_per_page);
		
		request.setAttribute("news", news);
		request.setAttribute("notice", notice);		
		request.setAttribute("education", education);
		
		
		request.setAttribute("newsFlag", newsFlag);
		request.setAttribute("noticeFlag", noticeFlag);
		
		
		return "home/index";
	}
	

	
}
