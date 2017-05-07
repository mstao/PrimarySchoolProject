package com.primaryschool.apply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.apply.entity.Apply;
import com.primaryschool.apply.entity.ApplyDate;
import com.primaryschool.apply.service.IApplyService;
import com.primaryschool.global.util.GetDateUtil;


/**
 * 
* @ClassName: ApplyIndexController
* @Description: TODO 首页
* @author Mingshan
* @date 2017年4月30日 下午7:15:01
*
 */

@Controller
@RequestMapping("/apply/index")
public class ApplyIndexController<T> {

	@Autowired
	private IApplyService<T> applyService;
	
	@RequestMapping("/message")
	public String index(int uid,ModelMap map){
	
		//获取当前年份
		String s_year=GetDateUtil.getYear();
		int year=Integer.parseInt(s_year);
		//根据年份找到报名日期信息		
		ApplyDate dateInfo=(ApplyDate) applyService.findDateInfoByYear(year);
		
		map.put("uid", uid);
		map.put("dateInfo", dateInfo);
		return "apply/message";
	}
	
	/**
	 * 
	* @Title: status
	* @Description: TODO 显示状态
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/status")
	public String status(int id,ModelMap map){
		//获取当前年份
		String s_year=GetDateUtil.getYear();
		int year=Integer.parseInt(s_year);
		//根据年份找到报名日期信息		
		ApplyDate dateInfo=(ApplyDate) applyService.findDateInfoByYear(year);
		

		Apply apply=(Apply) applyService.findApplyInfo(id);
		map.put("apply", apply);
		map.put("id", id);
		map.put("dateInfo",dateInfo);
		return "apply/status";
	}
	
	/**
	 *
	* @Title: saveApplyInfo
	* @Description: TODO  用户填写报名信息
	* @param @param uid
	* @param @param apply
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveApplyInfo")
	@ResponseBody
	public String saveApplyInfo(int uid,Apply apply){
		//获取当前时间
        int id=0;
		try{
			String c_data=GetDateUtil.getData();
			apply.setAddTime(c_data);
			apply.setUid(uid);
			
		    //获取当前年份
			String s_year=GetDateUtil.getYear();
			int year=Integer.parseInt(s_year);
			//根据当前时间找到 dateID
			int dateId=applyService.findDateIdByYear(year);
			//设置日期id
			apply.setDateId(dateId);
			//设置报名状态
			apply.setStatus(0);
			id=applyService.saveApplyInfo((T) apply);
			return id+"";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
		
		
	
	}
	
	
	/**
	 * 
	* @Title: checkCard
	* @Description: TODO 检查身份证
	* @param @param cardCode
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/checkCard")
	@ResponseBody
	public String checkCard(String cardCode){
		String result="";
		Apply apply=(Apply) applyService.findApplyInfoByCardId(cardCode);
		if(apply==null){
			result="0";
		}else{
			result="1";
		}
		return result;
	}
	
}
