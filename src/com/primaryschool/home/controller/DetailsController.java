package com.primaryschool.home.controller;

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
	public String trends(int id,HttpServletRequest request){	
		
		//根据id获取详细信息
        Trends trends=(Trends)trendsService.findTrendsInfoById(id);
	    request.setAttribute("trends", trends);
		return "home/details/trendsDetails";
	}
}
