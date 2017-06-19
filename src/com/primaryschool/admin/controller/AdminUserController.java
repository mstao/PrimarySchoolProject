package com.primaryschool.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.admin.service.IUserService;
import com.primaryschool.global.util.CrypographyUtil;


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
	* @Title: showUpdatePassword
	* @Description: TODO 显示修改 密码页面
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/showUpdatePassword")
	public String showUpdatePassword() {
		return "admin/user/updatePassword";
	}
	
	
	/**
	 * 
	* @Title: updatwePassword
	* @Description: TODO 更新密码
	* @param @param userName
	* @param @param password
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/updatePassword")
	@ResponseBody
	public String updatwePassword(int uid,String userName,String oldPassword,String newPassword) {
		String result = "";
		
		SecurityUser user = (SecurityUser) userService.findUserByUid(uid);
		//先获取原始密码
		String oldpw = user.getPassword();
		System.out.println(oldpw);
		//获取原始用户名
		String oldUsername = user.getUserName();
		//需要将传过来的比对的密码进行加密
		Object object = CrypographyUtil.MD5(oldUsername, oldPassword, oldUsername);
		String oldMD5Pw = object.toString();
		if(oldMD5Pw.equals(oldpw)){
			//此时密码比对正确，进行更改密码和用户名操作
	
			 //将密码进行MD5加密保存
			 Object object2 = CrypographyUtil.MD5(userName, newPassword, userName);
			 String MD5Pw = object2.toString();
		
			 
			 try{
				 //执行更新操作
				 userService.updateUserPassword(uid, userName, MD5Pw);
				 return "1";
			 }catch(RuntimeException e){
				 result="2";
			 }
		}else{
			result = "0";
		}
		return result;
	}
}
