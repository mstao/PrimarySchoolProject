package com.primaryschool.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.primaryschool.admin.entity.SecurityResources;
import com.primaryschool.admin.entity.SecurityRole;
import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.admin.entity.SecurityUserToRole;
import com.primaryschool.admin.service.IAuthorityService;
import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.service.IPageHelperService;

/**
 * 
* @ClassName: AuthorityController
* @Description: TODO 权限管理控制器
* @author Mingshan
* @date 2017年4月23日 上午8:43:25
*
 */

@Controller
@RequestMapping("/admin/authority")
public class AuthorityController<T> {
    
    private  int pageSize=PageSizeConfig.ADMIN_LIST_PAGESIZE;
    
	@Autowired
	private IAuthorityService<T> authorityServcie;
	
	
	@Autowired
	private IPageHelperService pageHelperService;
	    
	/**
	 * 
	* @Title: showRoleList
	* @Description: TODO 角色列表
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/roleList")
	public String showRoleList(ModelMap map){
		
		//获取角色列表
		ArrayList<SecurityRole> roles=(ArrayList<SecurityRole>) authorityServcie.findAllRoles();
		
		map.put("roles", roles);
		return "admin/authority/role-list";
	}
	
	/**
	 * 
	* @Title: showAddRole
	* @Description: TODO 增加角色  显示
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/showAddRole")
	public String showAddRole(){
		return "admin/authority/add-role";
	}
	
	/**
	 * 
	* @Title: findRoleByName
	* @Description: TODO 模糊查询  根据name获取角色的信息
	* @param @param name    设定文件
	* @return void    返回类型
	* @throws
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/findRoleByName")
	public  void findRoleByName(String token,HttpServletResponse response){
		PrintWriter out=null;
		//获取权限列表
		ArrayList<SecurityRole> roles=(ArrayList<SecurityRole>) authorityServcie.findRoleByName(token);
		 //调用fastjson生成json信息
		String json = JSON.toJSONString(roles, true);
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
	* @Title: showAllotRole
	* @Description: TODO 分配角色
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/allocation")
	public String showAllotRole(int p,ModelMap map){
		 
		   String sp=p+"";
		   if(sp.equals("")){
				p=1;
		   }
		   //当前的url
		   String url="./allocation?p=";
			
		   //获取总记录量
		   int count=authorityServcie.findUserCount();
		   //计算偏移量
		   int position=(p-1)*pageSize;
		   ArrayList<SecurityUser> user=(ArrayList<SecurityUser>) authorityServcie.findAllUser(position, pageSize);
		 
		   //获取封装好的分页导航数据
	       String toolBar=pageHelperService.createToolBar(count,pageSize, url, p);		

			//获取角色列表
			ArrayList<SecurityRole> roles=(ArrayList<SecurityRole>) authorityServcie.findAllRoles();
			
		   map.put("roles", roles);
	       map.put("user", user);
	       map.put("toolBar", toolBar);

	       return "admin/authority/user-list";
	}
	
	
	/**
	 * 
	* @Title: updateUserRole
	* @Description: TODO 修改用户角色
	* @param @param userToRole
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/updateUserRole")
	@ResponseBody
	public String  updateUserRole(SecurityUserToRole userToRole){
		int r;
		//更新数据
		boolean result=authorityServcie.updateUserRole((T) userToRole);
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
	* @Title: findUserByName
	* @Description: TODO  模糊查询  -根据用户名获取用户信息
	* @param @param token
	* @param @param response    设定文件
	* @return void    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findUserByName")
	public  void findUserByName(String token,HttpServletResponse response){
		PrintWriter out=null;
		//获取权限列表
		ArrayList<SecurityUser> roles=(ArrayList<SecurityUser>) authorityServcie.findUserByName(token);
		 //调用fastjson生成json信息
		String json = JSON.toJSONString(roles, true);
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
	* @Title: resources
	* @Description: TODO 权限资源
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/resources")
	public String resources(ModelMap map){
		ArrayList<SecurityResources> resources=(ArrayList<SecurityResources>) authorityServcie.findResources();
	
		map.put("resources", resources);
		return "admin/authority/resources-list";
	}
	
}
