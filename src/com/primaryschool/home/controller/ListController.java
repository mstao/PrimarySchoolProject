package com.primaryschool.home.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.IPageHelperService;
import com.primaryschool.home.service.ITrendsService;
import com.primaryschool.home.service.ITypeFlagToTypeNameService;

@Controller
@RequestMapping("/list")
public class ListController {
    @Autowired
    private ITrendsService<Trends> trendsService;
	@Autowired
	private IPageHelperService pageHelperService;
	@Autowired
	private ITypeFlagToTypeNameService typeFlagToTypeNameService;
	
	@RequestMapping("/trends")
	public String details(String flag, int p ,HttpServletRequest request){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//当前的url
		String url="./list/trends?flag='"+flag+"'&p=";
		//获取总记录量
		int count=trendsService.findTrendsCount(flag);
		//设置每页显示的数据量
		int item_pre_page=PageSizeConfig.HOME_LIST_PAGESIZE;
		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<Trends>  trends=(ArrayList<Trends>) trendsService.findTrendsInfo(flag, position, item_pre_page);
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findTrendsTypeNameByTypeFlag(flag);
        
        //获取该类型的热点信息
        ArrayList<Trends> hotTrends=(ArrayList<Trends>)trendsService.findHotTrendsInfo(flag, 0, PageSizeConfig.HOME_HOT_PAGESIZE);
        request.setAttribute("toolBar", toolBar);
        request.setAttribute("typeName", typeName);
        request.setAttribute("typeFlag", flag);
        request.setAttribute("trends", trends);
        request.setAttribute("hotTrends", hotTrends);
		return "home/list/trendsList";
	}
}
