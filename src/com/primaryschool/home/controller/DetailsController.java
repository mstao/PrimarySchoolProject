package com.primaryschool.home.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.ITrendsService;

/**
 * 
* @ClassName: DetailsController
* @Description: TODO 详细信息控制器
* @author Mingshan
 * @param <T>
* @date 2017年3月27日 上午10:27:18
*
 */

@Controller
@RequestMapping("/details")
public class DetailsController{

	@Autowired  
	private ITrendsService<Trends> trendsService;
	
	@RequestMapping("/trends")
	public String trends(int id,String flag,HttpServletRequest request){	
		int position=0;
		int item_per_page=7;
		//将浏览量+1
		trendsService.addViewCount(id);
		//根据id获取详细信息
        Trends trends=(Trends)trendsService.findTrendsInfoById(id);
        
        //获取该类型的最近更新
        ArrayList<Trends> latestTrends=(ArrayList<Trends>)trendsService.findLatestTrendsInfo(flag, position, item_per_page);
	    request.setAttribute("trends", trends);
	    request.setAttribute("latestTrends", latestTrends);
		return "home/details/trendsDetails";
	}
}
