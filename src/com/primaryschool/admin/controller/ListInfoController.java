package com.primaryschool.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.admin.service.IAdminIndexImagesService;
import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.IndexImages;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.IPageHelperService;
import com.primaryschool.home.service.ITypeFlagToTypeNameService;

/**
 * 
* @ClassName: ListInfoController
* @Description: TODO 获取列表
* @author Mingshan
* @date 2017年4月14日 下午3:53:42
*
 */

@Controller
@RequestMapping("/admin/list")
public class ListInfoController<T> {

    @Autowired
    private  IAdminTrendsService<T> trendsService;
	
    @Autowired
    private IPageHelperService pageHelperService;
    
    @Autowired
    private IAdminIndexImagesService<T> indexImagesService;
    
    @Autowired
    private ITypeFlagToTypeNameService typeFlagToTypeNameService;
    
    
    
    private  int pageSize=PageSizeConfig.ADMIN_LIST_PAGESIZE;
    
	/**
	 * 
	* @Title: trends
	* @Description: TODO 校园动态列表
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
   @SuppressWarnings("unchecked")
   @RequestMapping("/trends")	
   public  String trends(String flag,int p,ModelMap map){
	   
	   
	   String sp=p+"";
	   if(sp.equals("")){
			p=1;
	   }
	   //查看详细信息url
	   String durl="trends";
		
	   //当前的url
	   String url="./list/trends?flag='"+flag+"'&p=";
		
	   //获取总记录量
	   int count=trendsService.findTrendsCount(flag);
	   //计算偏移量
	   int position=(p-1)*pageSize;
		
	   //根据偏移量获取数据
	   ArrayList<Trends> trends=(ArrayList<Trends>) trendsService.findTrendsInfo(flag, position, pageSize);
	   	
		//获取封装好的分页导航数据
       String toolBar=pageHelperService.createToolBar(count,pageSize, url, p);		
       
       //根据typeFlag获取typeName
       String typeName=typeFlagToTypeNameService.findTrendsTypeNameByTypeFlag(flag);
       
      
       map.put("durl",durl);
       map.put("toolBar", toolBar);
       map.put("typeName", typeName);
       map.put("typeFlag", flag);
       map.put("item", trends);  
	   return "admin/list/trendsList";
   }
   
   /**
    * 
   * @Title: indexImages
   * @Description: TODO 首页 大轮播图
   * @param @return    设定文件
   * @return String    返回类型
   * @throws
    */
   @RequestMapping("/indexImages")
   public  String indexImages(ModelMap map){
	   
	   //获取图片列表
	   ArrayList<IndexImages> list=(ArrayList<IndexImages>) indexImagesService.findImagesList();
	 
	   map.put("list", list);
	   return "admin/list/indexImagesList";
   }
}
