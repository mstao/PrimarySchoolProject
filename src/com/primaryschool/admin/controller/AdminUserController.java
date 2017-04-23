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

	
	/**
	 * 
	* @Title: showUpdatePassword
	* @Description: TODO 显示修改 密码页面
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/showUpdatePassword")
	public String showUpdatePassword(){
		return "admin/user/updatePassword";
	}
}
