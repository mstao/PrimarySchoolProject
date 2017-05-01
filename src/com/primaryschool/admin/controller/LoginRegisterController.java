package com.primaryschool.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.admin.entity.SecurityUserToRole;
import com.primaryschool.admin.service.IUserService;
import com.primaryschool.global.util.CrypographyUtil;
import com.primaryschool.global.util.GetDateUtil;

/**
 * 
* @ClassName: LoginRegisterController
* @Description: TODO  后台登录注册控制器
* @author Mingshan
* @date 2017年4月6日 下午2:02:51
*
 */


@Controller
@RequestMapping("/admin/loginRegister")
public class LoginRegisterController<T> {

	@Autowired
	private IUserService<T> userService;
	
	
	
	
	/**
	 * 
	* @Title: showTeacherLogin
	* @Description: TODO 教师登录 显示
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@RequestMapping("/showTeaLogin")
	public String showTeacherLogin(){
		
		return "admin/loginOrregister/teacher-login";
	}
	
	/**
	 * 
	* @Title: showTeacherRegister
	* @Description: TODO 教师注册 显示
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@RequestMapping("/showTeaRegister")
	public String showTeacherRegister(){
		return "admin/loginOrregister/teacher-register";
	}
	
	/**
	 * 
	* @Title: unauthorized
	* @Description: TODO 认证未通过，权限不足
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/unauthorized")
	public  String unauthorized(){
		return "admin/loginOrregister/unauthorized";
	}
	
	
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
			int uid=userService.saveUser((T) user);
			
			//将用户的角色置为游客
			SecurityUserToRole userToRole=new SecurityUserToRole();
			userToRole.setRoleId(2);
			userToRole.setUserId(uid);
			userService.saveUserRole((T) userToRole);
			
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
	
	/**
	 * 
	* @Title: login
	* @Description: TODO 执行登录
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/login")
	public String login(String userName,String password,HttpServletRequest request){
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
        	// 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            // rememberme
            //token.setRememberMe(true);
            try {
            	System.out.println("1. " + token.hashCode());
            	// 执行登录. 
                currentUser.login(token);
               
        		Set<String> role= userService.getRoles(userName);
        		
        		SecurityUser user=(SecurityUser) userService.getByUerName(userName);
        		//获取uid
        		int uid=user.getId();
        		HttpSession session =request.getSession();
        		//将用户信息保存到session 中
                session.setAttribute("role", role);
                session.setAttribute("uid", uid);
            } 
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("登录失败: " + ae.getMessage());
            	request.setAttribute("error", "用户名或密码错误");
            	return "admin/loginOrregister/teacher-login";
            }
        }
		
		
		return "redirect:/admin/index";
	}
	
	/**
	 * 
	* @Title: ajaxLogin
	* @Description: TODO ajax登录后台
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/ajaxLogin")
	public void ajaxLogin(String userName,String password,HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json");
		PrintWriter out=null;
		String flag="1";
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
        	// 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            // rememberme
            //token.setRememberMe(true);
            try {
            	System.out.println("1. " + token.hashCode());
            	// 执行登录. 
                currentUser.login(token);
                
        		Set<String> role= userService.getRoles(userName);
        		
                SecurityUser user=(SecurityUser) userService.getByUerName(userName);
        		//获取uid
        		int uid=user.getId();
        		HttpSession session =request.getSession();
        		//将用户信息保存到session 中
                session.setAttribute("role", role);
                session.setAttribute("uid", uid);
            } 
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("登录失败: " + ae.getMessage());
            	flag="0";
        		
            }
        }
		
		
		try {
			out=response.getWriter();
			out.write(flag);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	
	}
	
	/**
	 * 
	* @Title: logout
	* @Description: TODO 登出
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/logout")
	public String logout(){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:showTeaLogin";
	}
}
