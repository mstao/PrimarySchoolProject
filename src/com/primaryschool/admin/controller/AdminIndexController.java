package com.primaryschool.admin.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.admin.service.IUserService;

/**
 * 
* @ClassName: AdminIndexController
* @Description: TODO 后台主页控制器
* @author Mingshan
* @date 2017年4月14日 下午2:43:06
*
 */


@Controller
@RequestMapping("/admin")
public class AdminIndexController {

	@Autowired
	private IUserService<SecurityUser> userService;
	/**
	 * 
	* @Title: index
	* @Description: TODO 指向主页
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		//获取当前用户所拥有的角色
		
		Subject currentUser = SecurityUtils.getSubject();
		String userName=currentUser.getPrincipal().toString();
		Set<String> role= userService.getRoles(userName);
		//获取SESSION对象
	    HttpSession session=request.getSession();
	    //将用户信息保存到session中
		session.setAttribute("role", role);
		System.out.println(role);
		return "admin/index";
	}
	
	
}
