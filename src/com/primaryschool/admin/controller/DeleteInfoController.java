package com.primaryschool.admin.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.service.IAdminCultureService;
import com.primaryschool.admin.service.IAdminDepartmentService;
import com.primaryschool.admin.service.IAdminEducationService;
import com.primaryschool.admin.service.IAdminIndexImagesService;
import com.primaryschool.admin.service.IAdminLabClassService;
import com.primaryschool.admin.service.IAdminManageService;
import com.primaryschool.admin.service.IAdminPartyService;
import com.primaryschool.admin.service.IAdminSclassService;
import com.primaryschool.admin.service.IAdminStudentService;
import com.primaryschool.admin.service.IAdminTeacherService;
import com.primaryschool.admin.service.IAdminTeachingResourceService;
import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.admin.service.IAuthorityService;
import com.primaryschool.admin.service.ICampusSceneryService;
import com.primaryschool.admin.service.IUserService;

/**
 * 
* @ClassName: DeleteInfoController
* @Description: TODO 删除控制器 
* @author Mingshan
* @date 2017年4月14日 下午3:36:54
*
 */

@Controller
@RequestMapping("/admin/delete")
public class DeleteInfoController<T> {
   
	
    @Autowired
    private IAdminIndexImagesService<T> indexImagesService;
    
    @Autowired
    private ICampusSceneryService<T> campusSceneryService;
	
    @Autowired
    private IAuthorityService<T> authorityService;
    
    @Autowired
    private IUserService<T> userService;
    
    ////
    @Autowired
    private IAdminCultureService<T> cultureService;
   
	@Autowired
    private IAdminTrendsService<T> trendsService;
	
	@Autowired
    private IAdminEducationService<T> educationService;
    
    @Autowired
    private IAdminStudentService<T> studentService;
    
    @Autowired
    private IAdminTeacherService<T> teacherService;
    
    @Autowired
    private IAdminPartyService<T> partyService;
    
    @Autowired
    private IAdminManageService<T> manageService;
    
    @Autowired
    private IAdminDepartmentService<T> departmentService;
    
    @Autowired
    private IAdminTeachingResourceService<T> resourceService;
    
    @Autowired
    private IAdminLabClassService<T> labClassService;
    
    @Autowired
    private IAdminSclassService<T> sclassService;
    
	
	/**
	 * 
	* @Title: deleteIndexImage
	* @Description: TODO 删除   首页大轮播图
	* @param @param id
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@RequestMapping("/indexImages")
	@ResponseBody
	public String deleteIndexImage(int id){
		
		try{
			indexImagesService.deleteImage(id);
			return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";

		}
	}
	
	/**
	 * 
	* @Title: deleteCampusScenery
	* @Description: TODO 删除  校园风光
	* @param @param id
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/campusScenery")
	@ResponseBody
	public String deleteCampusScenery(int id){
		try{
		
			campusSceneryService.deleteCampusScenery(id);
			return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
		
	}
	
	/**
	 * 
	* @Title: deleteRole
	* @Description: TODO 删除角色
	* @param @param ids
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/role")
	@ResponseBody
	public String deleteRole(String ids){
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
	        authorityService.deleteRoleById(idList);
	        return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
	}
	
	/**
	 * 
	* @Title: deleteUser
	* @Description: TODO 删除用户
	* @param @param ids
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/user")
	@ResponseBody
	public String deleteUser(String ids){
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
	        userService.deleteUserById(idList);
	        return "1";
		}catch(RuntimeException e){
			e.printStackTrace();
			return "0";
		}
	}
	
	
	//////////////////////////////
	@RequestMapping("/culture")
	@ResponseBody
	public  String  culture(String ids){
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
	        cultureService.deleteCultureById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	/**
	 * 
	* @Title: trends
	* @Description: TODO 删除校园动态
	* 这里由于用到事务处理，根据有无抛出异常来判断是否删除成功                             
	* @param @param ids
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/trends")
	@ResponseBody
	public  String  trends(String ids){
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
	        trendsService.deleteTrendsById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	@RequestMapping("/education")
	@ResponseBody
	public  String  education(String ids){
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
	        educationService.deleteEducationById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	@RequestMapping("/student")
	@ResponseBody
	public  String  student(String ids){
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
	        studentService.deleteStudentById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
	}
	
	
	@RequestMapping("/teacher")
	@ResponseBody
	public  String  teacher(String ids){
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
	        teacherService.deleteTeacherById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	@RequestMapping("/party")
	@ResponseBody
	public  String  party(String ids){
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
	        partyService.deletePartyById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	@RequestMapping("/manage")
	@ResponseBody
	public  String  manage(String ids){
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
	        manageService.deleteManageById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	
	//删除资源详细信息ById  
	@RequestMapping("/resource")
	@ResponseBody
	public  String  resource(String ids){
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
	        resourceService.deleteTeachingResourceById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	//删除教学资源名称
	@RequestMapping("/manageResource")
	@ResponseBody
	public  String  manageResource(String ids){
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
	        resourceService.deleteTeachingResourceMenuById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	//删除资源详细信息ById
		@RequestMapping("/department")
		@ResponseBody
		public  String  department(String ids){
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
		        departmentService.deleteDepartmentContent(idList);
		        return "1";
			}catch(RuntimeException e){
				return "0";
			}
	        
		}
	
	//删除部门链接 manageDepartment
	@RequestMapping("/manageDepartment")
	@ResponseBody
	public  String  manageDepartment(String ids){
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
	        departmentService.deleteDepartmentName(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	//删除社团内的信息
	@RequestMapping("/labclassinfo")
	@ResponseBody
	public  String  labclassinfo(String ids){
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
	        labClassService.deleteLabClassById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	

	//删除社团名称
	@RequestMapping("/managelablist")
	@ResponseBody
	public  String  managelablist(String ids){
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
	        labClassService.deleteLabById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	
	//删除班级内信息
	@RequestMapping("/sclassHomePage")
	@ResponseBody
	public  String  sclassHomePage(String ids){
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
	        sclassService.deleteSclassInfoById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
	//删除班级
	@RequestMapping("/manageSclass")
	@ResponseBody
	public  String  manageSclass(String ids){
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
	        sclassService.deleteSclassById(idList);
	        return "1";
		}catch(RuntimeException e){
			return "0";
		}
        
	}
	
}
