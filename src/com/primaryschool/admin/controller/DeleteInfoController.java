package com.primaryschool.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.service.IAdminIndexImagesService;
import com.primaryschool.admin.service.IAdminTrendsService;

/**
 * 
* @ClassName: DeleteInfoController
* @Description: TODO 删除控制器 
* @author Mingshan
* @date 2017年4月14日 下午3:36:54
*
 */

@Controller
@RequestMapping("/admin/delete")
public class DeleteInfoController<T> {
   
	@Autowired
    private IAdminTrendsService<T> trendsService;
	
    @Autowired
    private IAdminIndexImagesService<T> indexImagesService;
    
	
	/**
	 * 
	* @Title: trends
	* @Description: TODO 删除校园动态
	* 这里由于用到事务处理，根据有无抛出异常来判断是否删除成功                             
	* @param @param ids
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("trends")
	@ResponseBody
	public  String  trends(String ids){
		try{
		    //将字符串转为字符串数组
	        String[] idArray = ids.split(","); 
	        //将字符串数组转为整形数组
	        Integer[] iid=new Integer[idArray.length];
	        for(int i=0;i<iid.length;i++){
	        	iid[i]=Integer.parseInt(idArray[i]);
	        }
	        //将数组转为list
	        List<Integer> idList = new ArrayList<Integer>();	
	        Collections.addAll(idList, iid);
	        //执行删除语句
	        trendsService.deleteTrendsById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	
	/**
	 * 
	* @Title: deleteIndexImage
	* @Description: TODO 删除   首页大轮播图
	* @param @param id
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@RequestMapping("indexImage")
	@ResponseBody
	public String deleteIndexImage(int id){
		
		try{
			indexImagesService.deleteImage(id);
			return "1";
		}catch(RuntimeException e){
			return "0";

		}
	}
}
