package com.primaryschool.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.primaryschool.apply.entity.Apply;
import com.primaryschool.apply.entity.ApplyDate;
import com.primaryschool.apply.service.IApplyService;
import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.global.util.GetDateUtil;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.service.IPageHelperService;

/**
 * 
* @ClassName: AdminApplyController
* @Description: TODO 报名后台处理   ---独立出来
* @author Mingshan
* @date 2017年5月3日 下午5:19:49
*
 */

@Controller
@RequestMapping("/admin/apply")
public class AdminApplyController<T> {

	 //在线报名
    @Autowired
    private IApplyService<T> applyService;
    
    @Autowired
    private IPageHelperService pageHelperService;
    
    private  int pageSize=PageSizeConfig.ADMIN_LIST_PAGESIZE;
    
 	/**
   	 * 
   	* @Title: applyList
   	* @Description: TODO 报名列表
   	* @param @return    设定文件
   	* @return String    返回类型
   	* @throws
   	 */
   	
   	@SuppressWarnings("unchecked")
	@RequestMapping("/listAll")
    public String applyList(int status,int p,ModelMap map){
   		//获取当前年份
		String s_year=GetDateUtil.getYear();
		int year=Integer.parseInt(s_year);
		
		//根据年份找到报名日期信息		
		ApplyDate dateInfo=(ApplyDate) applyService.findDateInfoByYear(year);
		
		String sp=p+"";
	    if(sp.equals("")){
			p=1;
	    }
	   
	    //当前的url
	    String url="./listAll?status='"+status+"'&p=";
		
	    //获取总记录量
		int count=applyService.findApplyCountByStatusYear(status, year);
		//计算偏移量
		int position=(p-1)*pageSize;
		//根据年份获取所有的报名信息
		ArrayList<Apply> apply=(ArrayList<Apply>) applyService.findApplyInfoByYear(year,status, position, pageSize);
		
	    //获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,pageSize, url, p);	
   	    
        /**
         * 获取统计数据
         */
        
        //获取全部统计数
        int zstatus=3;
        int allCount=applyService.findApplyCountByStatusYear(zstatus, year);
        //报名成功 
        zstatus=1;
        System.out.println("zz"+status);
        int completeCount=applyService.findApplyCountByStatusYear(zstatus, year);
        //报名失败
        zstatus=2;
        int failCount=applyService.findApplyCountByStatusYear(zstatus, year);
        //等待审核
        zstatus=0;
        int waitCount=applyService.findApplyCountByStatusYear(zstatus, year);
       
        map.put("apply", apply);
   	    map.put("toolBar", toolBar);
		map.put("dateInfo", dateInfo);
		
		map.put("allCount", allCount);
		map.put("completeCount", completeCount);
		map.put("failCount", failCount);
		map.put("waitCount", waitCount);
		map.put("status", status);
    	return "admin/list/applyList";
    }
   	
   	/**
   	 * 
   	* @Title: loadApplyInfo
   	* @Description: TODO 根据id  ajax加载数据
   	* @param @param id    设定文件
   	* @return void    返回类型
   	* @throws
   	 */
   	@RequestMapping("/loadinfo")
   	public void  loadApplyInfo(int id,HttpServletResponse response){
   		   	
   		response.setCharacterEncoding("UTF-8");  
		PrintWriter out=null;
		Apply apply=(Apply) applyService.findApplyInfo(id);	
        //调用fastjson生成json信息
		String json = JSON.toJSONString(apply, true);
		System.out.println(json);
		response.setContentType("application/json");
		try {
			out=response.getWriter();
			out.write(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
   	}
   	
   	/**
   	 * 
   	* @Title: updateApplyStatusById
   	* @Description: TODO 根据id 更新状态值
   	* @param @param id
   	* @param @param statusValue
   	* @param @param reason
   	* @param @return    设定文件
   	* @return String    返回类型
   	* @throws
   	 */
   	@RequestMapping("/updateStatus")
   	@ResponseBody
   	public String updateApplyStatusById(int id,int statusValue,@RequestParam(required=false) String reason){
 
   		int r;
   		
		//更新数据
		boolean result= applyService.updateApplyStatus(id, statusValue,reason);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
   	}
   
   	
   	/**
   	 * 
   	* @Title: dealApplyDate
   	* @Description: TODO 对报名日期进行处理 ，包括修改和增加
   	* @param @param flag
   	* @param @param date
   	* @param @return    设定文件
   	* @return String    返回类型
   	* @throws
   	 */
   	@SuppressWarnings("unchecked")
   	@RequestMapping("/dealApplyDate")
   	@ResponseBody
   	public String dealApplyDate(int flag,@RequestParam(required=false) Integer  id, ApplyDate date){
   		String result="";
   		//flag等于1，代表此时已有记录，将要进行修改操作
   		if(flag==1){
   			try{
   	   			applyService.updateApplyDate((T) date);
   	   		    result= "1";
   	   		}catch(RuntimeException e){
   	   			e.printStackTrace();
   	   		    result= "0";
   	   		}
   		}else if(flag==0){
   			//代表此时无记录，将要进行新增操作
   			try{
   	   			applyService.saveApplyDate((T) date);
   	   			result= "1";
   	   		}catch(RuntimeException e){
   	   		    e.printStackTrace();
   	   		    result= "0";
   	   		}
   		}
   		return result;
   	}
   	
   	@SuppressWarnings("unchecked")
	@RequestMapping("/findApplyInfoByToken")
   	public void findApplyInfoByToken(String token,int status,HttpServletResponse response){
   		response.setCharacterEncoding("UTF-8");  
		PrintWriter out=null;
   	    //获取当前年份
		String s_year=GetDateUtil.getYear();
		int year=Integer.parseInt(s_year);
		ArrayList<Apply> apply=(ArrayList<Apply>) applyService.findApplyInfoByToken(token, status, year);
		 //调用fastjson生成json信息
		String json = JSON.toJSONString(apply, true);
		System.out.println("下面开始打印json了----"+json);
		response.setContentType("application/json");
		try {
			out=response.getWriter();
			out.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
   	
   	}
   	
   	/**
   	 * 
   	* @Title: deleteApplyInfo
   	* @Description: TODO 删除
   	* @param @param ids
   	* @param @return    设定文件
   	* @return String    返回类型
   	* @throws
   	 */
   	@RequestMapping("/delete")
   	@ResponseBody
   	public String deleteApplyInfo(String ids){
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
	        applyService.deleteApplyInfoById(idList);
	        return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
   	}
}
