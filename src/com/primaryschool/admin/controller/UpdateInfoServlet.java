package com.primaryschool.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.home.entity.Trends;

/**
 * 
* @ClassName: UpdateInfoServlet
* @Description: TODO 更新数据
* @author Mingshan
* @date 2017年4月14日 下午3:40:20
*
 */

@Controller
@RequestMapping("/admin/update")
public class UpdateInfoServlet<T> {

	@Autowired
    private IAdminTrendsService<T> trendsService;
	
	/**
	 * 
	* @Title: updateTrends
	* @Description: TODO 更新校园动态数据
	* @param @param trends    设定文件
	* @return boolean   返回类型
	* @throws
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping("/trends")
	@ResponseBody
	public String  updateTrends(Trends trends){
		int r;
		//更新数据
		boolean result=trendsService.updateTrendsInfo((T) trends);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
}
