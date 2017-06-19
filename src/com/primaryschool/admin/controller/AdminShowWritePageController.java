package com.primaryschool.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.admin.entity.CourseType;
import com.primaryschool.admin.service.IAdminCourseScoreService;
import com.primaryschool.admin.service.IAdminDepartmentService;
import com.primaryschool.admin.service.IAdminHeaderMasterService;
import com.primaryschool.admin.service.IAdminLabClassService;
import com.primaryschool.admin.service.IAdminSclassService;
import com.primaryschool.admin.service.IAdminTeachingResourceService;
import com.primaryschool.home.entity.ClassHomePageType;
import com.primaryschool.home.entity.DepartmentLinkContentType;
import com.primaryschool.home.entity.HeadMasterPost;
import com.primaryschool.home.entity.StudentLab;
import com.primaryschool.home.entity.TeachingResourcesContentType;

/**
 * 
* @ClassName: AdminShowWritePageController
* @Description: TODO  显示 撰写页面
* @author Mingshan
* @date 2017年4月16日 上午12:27:07
*
 */

@Controller
@RequestMapping("/admin/write")
public class AdminShowWritePageController<T> {

	@Autowired
	private IAdminTeachingResourceService<T> teachingResourcesService;
	
	@Autowired
	private IAdminLabClassService<T> labClassService;
	
	@Autowired
    private IAdminSclassService<T>	classService;
	
	@Autowired
	private IAdminDepartmentService<T> departmentService;
	
	@Autowired
	private IAdminHeaderMasterService<T> headMasterService;
	
	@Autowired
	private IAdminCourseScoreService<T> courseScoreService;
	
	/**
	 * 
	* @Title: indexImage
	* @Description: TODO 首页图片上传
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/indexImages")
	public String IndexImages(ModelMap map) {
		
		String  title = "首页大轮播图";
		String  url = "indexImages";
		
		map.put("title", title);
		map.put("url", url);
		
		return "admin/write/writeIndexImages";
	}
	
	/**
	 * 
	* @Title: campusScenery
	* @Description: TODO 校园风光  
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/campusScenery")
	public String campusScenery(ModelMap map) {
		
		String  title = "校园风光";
		String  url = "campusScenery";
			
	    map.put("title", title);
	    map.put("url", url);
		return "admin/write/writeIndexImages";
	}
	
	/////////////////////////////////////////
	/**
	 * 
	* @Title: trends
	* @Description: TODO 撰写页面
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/culture")
	public String culture(String typeName,String typeFlag,String fileType,ModelMap map) {
		String durl = "culture";
		map.put("durl", durl);
		map.put("typeName", typeName);
		map.put("typeFlag", typeFlag);
		map.put("fileType", fileType);
		return "admin/write/write";
	}

	/**
	 * 
	* @Title: trends
	* @Description: TODO 撰写页面
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/trends")
	public String trends(String typeName,String typeFlag,String fileType,ModelMap map) {
		String durl = "trends";
		map.put("durl", durl);
		map.put("typeName", typeName);
		map.put("typeFlag", typeFlag);
		map.put("fileType", fileType);
		return "admin/write/write";
	}
	
	@RequestMapping("/education")
	public String education(String typeName,String typeFlag,String fileType,ModelMap map) {
		String durl = "education";
		map.put("durl", durl);
		map.put("typeName", typeName);
		map.put("typeFlag", typeFlag);
		map.put("fileType", fileType);
		return "admin/write/write";
	}
	
	@RequestMapping("/student")
	public String student(String typeName,String typeFlag,String fileType,ModelMap map) {
		String durl = "student";
		map.put("durl", durl);
		map.put("typeName", typeName);
		map.put("typeFlag", typeFlag);
		map.put("fileType", fileType);
		return "admin/write/write";
	}
	
	@RequestMapping("/teacher")
	public String teacher(String typeName,String typeFlag,String fileType,ModelMap map) {
		String durl = "teacher";
		map.put("durl", durl);
		map.put("typeName", typeName);
		map.put("typeFlag", typeFlag);
		map.put("fileType", fileType);
		return "admin/write/write";
	}
	
	@RequestMapping("/party")
	public String party(String typeName,String typeFlag,String fileType,ModelMap map) {
		String durl = "party";
		map.put("durl", durl);
		map.put("typeName", typeName);
		map.put("typeFlag", typeFlag);
		map.put("fileType", fileType);
		return "admin/write/write";
	}
	
	@RequestMapping("/manage")
	public String manage(String typeName,String typeFlag,String fileType,ModelMap map) {
		String durl = "manage";
		map.put("durl", durl);
		map.put("typeName", typeName);
		map.put("typeFlag", typeFlag);
		map.put("fileType", fileType);
		return "admin/write/write";
	}
	
	//增加部门信息
	@SuppressWarnings("unchecked")
	@RequestMapping("/department")
	public String department(int deptId,String fileType,ModelMap map) {
		String durl = "department";
		//获取menuName
	    String menuName = departmentService.findDepartmentNameById(deptId);
		 //获取type
        ArrayList<DepartmentLinkContentType> resouceType = (ArrayList<DepartmentLinkContentType>) departmentService.findDepartmentType();     
        map.put("resouceType", resouceType);
        map.put("deptId", deptId);
        map.put("menuName", menuName);
		map.put("durl", durl);
		map.put("classId", deptId);
		map.put("resouceType", resouceType);
		map.put("fileType", fileType);
		return "admin/write/departmentWrite";
	}
	
	//增加资源信息
	@SuppressWarnings("unchecked")
	@RequestMapping("/resource")
	public String resource(int classId,int menuId,String fileType,ModelMap map) {
		String durl = "resource";
		//获取menuName
	    String menuName = teachingResourcesService.findTeachingResurceNameById(menuId);
		 //获取type
        ArrayList<TeachingResourcesContentType> resouceType = (ArrayList<TeachingResourcesContentType>) teachingResourcesService.findTeachingResourceTypeInfo();     
        map.put("resouceType", resouceType);
        map.put("menuName", menuName);
		map.put("durl", durl);
		map.put("classId", classId);
		map.put("resouceType", resouceType);
		map.put("menuId", menuId);
		map.put("fileType", fileType);
		return "admin/write/resourceWrite";
	}
	/*
	 * 显示修改社团信息页面
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/labclassinfo")
	public String labclassinfo(int labId,String labName,String fileType,ModelMap map) {
		String durl="labclassinfo";
		 //获取所有的文档分类
        ArrayList<StudentLab> resourceType = (ArrayList<StudentLab>) labClassService.findLabClassMenuInfo();   
        map.put("resouceType", resourceType);
        map.put("labName", labName);
      //  map.put("labId", labId);
		map.put("durl", durl);
		map.put("labId", labId);
		map.put("fileType", fileType);
		return "admin/write/labClassWrite";
	}
	/*
	 * 显示修改社团简介页面
	 */
	@RequestMapping("/labintro")
	public String labintro(int labId,String labName,ModelMap map) {
		String introurl = "labintro";
		String durl = "labclassinfo";
		map.put("durl", durl);
		map.put("introurl", introurl);
		map.put("labId", labId);
		map.put("labName", labName);
		return "admin/write/introWrite";
	}

	/*
	 * 显示修改班级简介页面
	 */
	@RequestMapping("/sclassintro")
	public String sclassintro(int labId,int grade,String className,ModelMap map) {
		String introurl = "sclassintro";
		String durl = "sclassHomePage";
		//获取labName即社团名称
	    String labName = grade+"年级"+className;
		map.put("durl", durl);
		map.put("introurl", introurl);
		map.put("grade", grade);
		map.put("className", className);
		map.put("labId", labId);
		map.put("labName", labName);
		return "admin/write/introWrite";
	}
	
	/*
	 * 显示修改班级信息页面
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/sclassHomePage")
	public String sclassHomePage(int classId,int grade,String className,String fileType,ModelMap map) {
		String durl = "sclassHomePage";
		 //获取所有的资源类型
		ArrayList<ClassHomePageType> resourceType = (ArrayList<ClassHomePageType>) classService.findClassPageType();     
		//获取labName即社团名称
	    String labName = grade+"年级"+className;
		map.put("resouceType", resourceType);
        map.put("labName", labName);
      //  map.put("labId", labId);
		map.put("durl", durl);
		map.put("labId", classId);
		map.put("grade", grade);
		map.put("labId", classId);
		map.put("className", className);
		return "admin/write/labClassWrite";
	}
	
	/**
	 * 
	* @Title: headMaster
	* @Description: TODO 获取校长职位
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/headMaster")
	public String headMaster(ModelMap map) {
		
		ArrayList<HeadMasterPost> post = (ArrayList<HeadMasterPost>) headMasterService.findHeadMasterPost();
		
		map.put("post", post);
		return "admin/write/headMaster";
	}
	
	/**
	 * TODO 新增学生信息
	 */
	@RequestMapping("/stuInfo")
	public String stuInfo(int classId,String fullName,ModelMap map) {
		String durl = "stuInfo";
        map.put("fullName", fullName);
		map.put("durl", durl);
		map.put("classId", classId);
		return "admin/write/stuInfoWrite";
	}
	
	/**
	 * TODO 新增学生成绩
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/scoreInfo")
	public String scoreInfo(int classId,String fullName,ModelMap map) {
		String durl = "scoreInfo";
		ArrayList<CourseType> courseType = (ArrayList<CourseType>) courseScoreService.findCourseType();
        map.put("fullName", fullName);
		map.put("durl", durl);
		map.put("courseType", courseType);
		map.put("classId", classId);
		return "admin/write/scoreInfoWrite";
	}
	/**
	 * 
	* @Title: classStyle
	* @Description: TODO 显示班级风采
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/classStyle")
	public String classStyle(int classId,ModelMap map) {
		
		map.put("classId", classId);
		return "admin/write/writeClassStyle";
	}
}
