package com.primaryschool.apply.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.admin.service.IUserService;
import com.primaryschool.apply.entity.ApplyUser;
import com.primaryschool.apply.service.IApplyUserService;
import com.primaryschool.global.util.CrypographyUtil;
import com.primaryschool.global.util.EmailUtil;
import com.primaryschool.global.util.MD5Util;



/**
 * ToDo 密码找回
 * @author hlf
 *
 */
@Controller
@RequestMapping("/applyHelp")
public class findPassWordController<T> {
	
	@Autowired
	private IUserService<T> userService;
	
	@Autowired
	private IApplyUserService<T> applyService;
	
	//找回密码界面
	@RequestMapping("/findTeaPass")
	public String findPass(ModelMap map){
		//检测账号
		String durl="checkUser";
		//账户与邮箱匹配
		String murl="checkUserEmail";
		//发送消息
		String surl="sendUserInfo";
		
		map.put("durl", durl);
		map.put("murl", murl);
		map.put("surl", surl);
		return "apply/findPassWord/findPass";
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
	@RequestMapping("/checkUserEmail")
	@ResponseBody
	public String checkEmail(String email,String userName){
		SecurityUser user=(SecurityUser) userService.findUserByInfo(email,userName);
	      
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
	 * @param email    用户邮箱地址
	 * @param userName      用户名
	 * @param request
	 * @return
	 * ToDo  将验证信息发往用户邮箱
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/sendUserInfo")
	@ResponseBody
	public String sendUserInfo(String email,String userName,HttpServletRequest request){
		String result=null;
        SecurityUser user=(SecurityUser) userService.findUserByUserName(userName);
        //生成密钥    
	    String secretKey=UUID.randomUUID().toString();    
	    //设置过期时间    
	    Date outDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期    
	    
	    long date =outDate.getTime() / 1000 * 1000;// 忽略毫秒数  mySql 取出时间是忽略毫秒数的    
	     //此处应该更新Studentinfo表中的过期时间、密钥信息    
	    user.setOutDate(date);    
	    user.setValidataCode(secretKey);   
	    
	    
	    userService.updateUser(user);
	    //将用户名、过期时间、密钥生成链接密钥    
	    String key =user.getId() + "$" + date + "$" + secretKey; 
        EmailUtil emailUtil=new EmailUtil();
        
        result=emailUtil.sendEmail(user, email,key,request);
        return result;
	}
	
	
	
	/**
	 * 
	 * @param sid   用户获得的数字签名
	 * @param id    用户id
	 * @param map
	 * @return      修改密码界面
	 * ToDo			判断用户所点击链接是否合法
	 */
	@RequestMapping("/findTeacherPass")
	public String findTeacherPass(String sid,int id,ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String message=null;
		if(sid==null||id==0){
			message="请求的链接不正确,请重新操作";
		}else{
		}
		SecurityUser user=(SecurityUser) userService.findUserByUid(id);
		if(user!=null){
			if(user.getOutDate()<=System.currentTimeMillis()){
	              message="链接已经过期"; 
			}
			//获取数据库中的内容加密后与sid对比
			String key=id+"$" + user.getOutDate() + "$" + user.getValidataCode();
			if(MD5Util.validPassword(key,sid)){
				map.put("user", user);
			}else{
	             message="链接加密密码不正确";
			}
			
		}else{
            message="用户信息不存在";  
		}
		//修改密码
		String nurl="updateTeaPass";
		//登录界面
		String durl="showTeaLogin";
				
		map.put("nurl", nurl);
		map.put("durl", durl);
		map.put("message", message);
		return "apply/findPassWord/findTeacherPass";
	}
	
	@RequestMapping("/updateTeaPass")
	@ResponseBody
	public String updateTeaPass(SecurityUser user){
		try{
			String username=user.getUserName();
			String password=user.getPassword();
			System.out.println(username+"  "+password+"   "+username);
			Object object=CrypographyUtil.MD5(username, password, username);
			String pass=object.toString();
			user.setPassword(pass);
			userService.updateUser(user);
			return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
	}
	
	//找回密码界面
	@RequestMapping("/findStuPass")
	public String findStuPass(ModelMap map){
		//检测账号
		String durl="checkStuUser";
		//账户与邮箱匹配
		String murl="checkStuEmail";
		//发送消息
		String surl="sendStuInfo";
		
		map.put("durl", durl);
		map.put("murl", murl);
		map.put("surl", surl);
		return "apply/findPassWord/findPass";
	}
	
	 
	@RequestMapping("/checkStuUser")
	@ResponseBody
	public String checkStuUser(String userName){
		ApplyUser user=(ApplyUser) applyService.getByUserName(userName);
      
        String result=""; 
        if(user==null){
        	result="1";
        }else{
        	result="0";
        }
		return result;
	}
	
	//检查用户邮箱
	@RequestMapping("/checkStuEmail")
	@ResponseBody
	public String checkStuEmail(String email,String userName){
		ApplyUser user=(ApplyUser) applyService.getByInfo(userName, email);
	      
        String result=""; 
        if(user==null){
        	result="1";
        }else{
        	result="0";
        }
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/sendStuInfo")
	@ResponseBody
	public String sendStuInfo(String email,String userName,HttpServletRequest request){
		String result=null;
		ApplyUser user=(ApplyUser) applyService.getByUserName(userName);
	      
        //生成密钥    
	    String secretKey=UUID.randomUUID().toString();    
	    //设置过期时间    
	    Date outDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期    
	    
	    long date =outDate.getTime() / 1000 * 1000;// 忽略毫秒数  mySql 取出时间是忽略毫秒数的    
	     //此处应该更新Studentinfo表中的过期时间、密钥信息    
	    user.setOutDate(date);    
	    user.setValidataCode(secretKey);   
	    
	    
	    applyService.updateStuInfo(user);
	    //将用户名、过期时间、密钥生成链接密钥    
	    String key =user.getId() + "$" + date + "$" + secretKey; 
        EmailUtil emailUtil=new EmailUtil();
        
        result=emailUtil.sendStuEmail(user, email,key,request);
        return result;
	}
	
	
	@RequestMapping("/findStudentPass")
	public String findStudentPass(String sid,int id,ModelMap map) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String message=null;
		if(sid==null||id==0){
			message="请求的链接不正确,请重新操作";
		}else{
		}
		ApplyUser user=(ApplyUser) applyService.findUserById(id);
		if(user!=null){
			if(user.getOutDate()<=System.currentTimeMillis()){
	              message="链接已经过期"; 
			}
			//获取数据库中的内容加密后与sid对比
			String key=id+"$" + user.getOutDate() + "$" + user.getValidataCode();
			if(MD5Util.validPassword(key,sid)){
				map.put("user", user);
			}else{
	             message="链接加密密码不正确";
			}
			
		}else{
            message="用户信息不存在";  
		}
		//修改密码
		String nurl="updateStuPass";
		//登录界面
		String durl="stuLogin";
				
		map.put("nurl", nurl);
		map.put("durl", durl);
		map.put("message", message);
		return "apply/findPassWord/findTeacherPass";
	}
	
	@RequestMapping("/updateStuPass")
	@ResponseBody
	public String updateStuPass(ApplyUser user){
		try{
			String username=user.getUserName();
			String password=user.getPassword();
			System.out.println(username+"  "+password+"   "+username);
			Object object=CrypographyUtil.MD5(username, password, username);
			String pass=object.toString();
			System.out.println("pass"+pass);
			user.setPassword(pass);
			applyService.updateStuInfo(user);
			return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
	}
	
}
