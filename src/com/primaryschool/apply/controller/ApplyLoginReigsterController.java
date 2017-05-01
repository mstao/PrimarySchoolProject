package com.primaryschool.apply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.apply.entity.ApplyUser;
import com.primaryschool.apply.service.IApplyUserService;
import com.primaryschool.global.util.CrypographyUtil;
import com.primaryschool.global.util.GetDateUtil;

/**
 * 
* @ClassName: ApplyLoginReigsterController
* @Description: TODO 报名系统登录注册控制器
* @author Mingshan
* @date 2017年4月30日 上午7:51:27
*
 */

@Controller
@RequestMapping("/apply")
public class ApplyLoginReigsterController<T> {

	@Autowired
	private IApplyUserService<T> userService;
	
	/**
	 * 
	* @Title: checkUser
	* @Description: TODO 检查用户是否注册
	* @param @param card
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public String checkUser(String card){
		
		ApplyUser user=(ApplyUser) userService.findUserByCard(card);
		String result=""; 
        if(user==null){
        	result="1";
        }else{
        	result="0";
        }
		return result;
		

		
	}
	
	
	//添加用户
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveUser")
	@ResponseBody
	public String saveUser(ApplyUser user){
		try{
			//获取当前时间
			String c_data=GetDateUtil.getData();
			user.setAddTime(c_data);
			//获取原始密码
			String pw=user.getPassword();
			//获取用户名
			String userName=user.getUserName();
			//密码用MD5加密，并且需要加点盐
			user.setSalt(userName);
			Object object=CrypographyUtil.MD5(userName, pw, userName);
			
			user.setPassword(object.toString());

			userService.saveUser((T) user);
			
			return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
	}
	
	
	/**
	 * 
	* @Title: login
	* @Description: TODO 登录处理
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@RequestMapping("/login")
	@ResponseBody
	public  String login(String userName,String cardCode,String password,HttpServletRequest request){
		String MD5Pw="";	
		Object object=CrypographyUtil.MD5(userName, password, userName);
		MD5Pw=object.toString();
		System.out.println("pw--"+MD5Pw);
		ApplyUser user=(ApplyUser) userService.findUserByCardPassword(cardCode, MD5Pw);
		
		if(user==null){
			return "0";
		}else{
			//保存session
			HttpSession session=request.getSession();
			session.setAttribute("cardCode", cardCode);
			//设置最大session保存时间，时间为秒
  		    session.setMaxInactiveInterval(60*60*24*1);//一天
			return "1";
		}
			
		
	}
}
