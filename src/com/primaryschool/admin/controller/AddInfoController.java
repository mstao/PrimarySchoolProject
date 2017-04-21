package com.primaryschool.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.service.IAdminIndexImagesService;
import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.admin.service.ICampusSceneryService;
import com.primaryschool.home.entity.CampusScenery;
import com.primaryschool.home.entity.IndexImages;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.ITypeFlagToTypeIdService;

/**
 * 
* @ClassName: AddInfoServlet
* @Description: TODO 添加信息控制器
* @author Mingshan
* @date 2017年4月14日 下午3:35:40
*
 */

@Controller
@RequestMapping("/admin/add")
public class AddInfoController<T> {
    @Autowired
    private IAdminTrendsService<T> trendsService;
	
    @Autowired
    private IAdminIndexImagesService<T> indexImagesService;
    
    @Autowired
    private ICampusSceneryService<T> campusSceneryService;
    
    @Autowired
    private ITypeFlagToTypeIdService typeFlagToTypeIdService; 
	
    /**
	 * 
	* @Title: addTrends
	* @Description: TODO 添加 校园动态
	* @param @param trends
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
    
    @SuppressWarnings("unchecked")
	@RequestMapping("/trends")
    @ResponseBody
	public  String addTrends(Trends trends){
    	
    	//由typeFlag获取typeid
    	int typeId =typeFlagToTypeIdService.findTrendsTypeIdByTypeFlag(trends.getItemTypeFlag());
		
    	//赋值
    	trends.setTypeId(typeId);
    	
    	int result= trendsService.addTrendsInfo((T)trends);
		return result+"";
	}
	
    
    /**
     * 
    * @Title: addIndexImages
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param indexImages
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/indexImages")
    @ResponseBody
	public String addIndexImages(IndexImages indexImages){
    	
    	int result=indexImagesService.addImage((T)indexImages);

    	return result+"";
    	
    }
    
    /**
     * 
    * @Title: addCampusScenery
    * @Description: TODO 添加校园风光
    * @param @param campusScenery
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    
    @SuppressWarnings("unchecked")
	@RequestMapping("/campusScenery")
    @ResponseBody
    public String addCampusScenery(CampusScenery campusScenery){
    	int result =campusSceneryService.saveCampusScenery((T)campusScenery);
    	return result+"";
    }
}
