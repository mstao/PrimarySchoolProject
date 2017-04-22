package com.primaryschool.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.admin.service.IUserService;
import com.primaryschool.global.util.CrypographyUtil;
import com.primaryschool.global.util.GetDateUtil;


/**
 * 
* @ClassName: AdminUserController
* @Description: TODO 后台用户控制器
* @author Mingshan
* @date 2017年4月21日 下午9:45:57
*
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController<T> {

	@Autowired
	private IUserService<T> userService;
	
	/**
	 * 
	* @Title: saveUser
	* @Description: TODO 添加用户
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	public String saveUser(SecurityUser user){
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
			//将用户状态置为1
			user.setStatus(1);
			userService.saveUser((T) user);
			return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
		
	}
	
	/**
	 * 
	* @Title: checkUser
	* @Description: TODO  检查用户名是否存在
	* @param @param userName
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public String checkUser(String userName){
		SecurityUser user=(SecurityUser) userService.findUserByUserName(userName);
      
        String result=""; 
        if(user==null){
        	result="1";
        }else{
        	result="0";
        }
		return result;
	}
	
	/**
	 * 
	* @Title: checkEmail
	* @Description: TODO 检查邮箱
	* @param @param email
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(String email){
		SecurityUser user=(SecurityUser) userService.findUserByEmail(email);
	      
        String result=""; 
        if(user==null){
        	result="1";
        }else{
        	result="0";
        }
		return result;
	}
}
