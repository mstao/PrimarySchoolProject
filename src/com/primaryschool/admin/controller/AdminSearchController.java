package com.primaryschool.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.primaryschool.admin.entity.CourseScore;
import com.primaryschool.admin.entity.CourseStudentInfo;
import com.primaryschool.admin.entity.CourseType;
import com.primaryschool.admin.service.IAdminCourseScoreService;
import com.primaryschool.admin.service.IAdminCultureService;
import com.primaryschool.admin.service.IAdminDepartmentService;
import com.primaryschool.admin.service.IAdminEducationService;
import com.primaryschool.admin.service.IAdminLabClassService;
import com.primaryschool.admin.service.IAdminManageService;
import com.primaryschool.admin.service.IAdminPartyService;
import com.primaryschool.admin.service.IAdminSclassService;
import com.primaryschool.admin.service.IAdminStuInfoService;
import com.primaryschool.admin.service.IAdminStudentService;
import com.primaryschool.admin.service.IAdminTeacherService;
import com.primaryschool.admin.service.IAdminTeachingResourceService;
import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.home.entity.ClassHomePage;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.DepartmentLinkContent;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Grade;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Sclass;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLabMenuContent;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.TeachingResourcesContent;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.IBaseFileService;
import com.primaryschool.home.service.IGradeService;
import com.primaryschool.home.service.ILabClassService;
import com.primaryschool.home.service.IPageHelperService;
import com.primaryschool.home.service.ISclassService;
import com.primaryschool.home.service.ITeachingResourcesService;
import com.primaryschool.home.service.ITypeFlagToTypeNameService;

/**
 * Todo list界面查询功能
 * @author hlf
 * @param <T>
 *
 */
@Controller
@RequestMapping("/admin/ajax")
public class AdminSearchController<T> {
	
	    @Autowired
	    private IAdminCultureService<T> cultureService;
	   
	    @Autowired
	    private  IAdminTrendsService<T> trendsService;
		
	    @Autowired
	    private IAdminEducationService<T> educationService;
	    
	    @Autowired
	    private IAdminStudentService<T> studentService;
	    
	    @Autowired
	    private IGradeService<Grade> gradeService;
		//前台Service,用于classList.jsp页面
		@Autowired
		private ISclassService<Sclass> sclassService;
		//后台Service,用于后台班级主页管理
		@Autowired
		private IAdminSclassService<T> classService;
	    
	    @Autowired
	    private IAdminTeacherService<T> teacherService;
	    
	    @Autowired
	    private IAdminCourseScoreService<T> courseScoreService;
	    
	    @Autowired
	    private IAdminPartyService<T> partyService;
	    
	    @Autowired
	    private IAdminDepartmentService<T> departmentService;
	    
	    @Autowired
	    private IAdminManageService<T> manageService;
	    
	    
	    @Autowired
		private IAdminTeachingResourceService<T> teachingResourcesService;
	    
	    @Autowired
	    private IAdminLabClassService<T> labClassService;
	    
	    @Autowired
	    private IPageHelperService pageHelperService;
	    
	    @Autowired
	    private ITypeFlagToTypeNameService typeFlagToTypeNameService;
	    
		//获取所有的resource类型
	    @Autowired
		private ITeachingResourcesService<T> teachingResources;
	    //获取所有的lab类型
	    @Autowired
		private ILabClassService<T> labService;
	    
	    @Autowired
	    private IAdminStuInfoService<T> stuInfoService;
	    
	    @Autowired
	    private IBaseFileService<T> baseFileServcie;

	//校园文化
	@SuppressWarnings("unchecked")
	@RequestMapping("/culture")
	@ResponseBody
	public void culture(String flag,String token,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=null;
	try{
		ArrayList<Culture> culture=(ArrayList<Culture>) cultureService.searchInfo(flag,token);
		
		//根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findCultureTypeNameByTypeFlag(flag);
		System.out.println(typeName);
        @SuppressWarnings("rawtypes")
		HashMap map=new HashMap();
        map.put("typeName", typeName);
        map.put("culture", culture);
        String json=JSON.toJSONString(map,true);
        response.setContentType("application/json");
		System.out.println(json);
		
			out=response.getWriter();
	        out.write(json);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
	
		//校园动态
		@SuppressWarnings("unchecked")
		@RequestMapping("/trends")
		@ResponseBody
		public void trends(String flag,String token,HttpServletResponse response){
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=null;
		try{
			ArrayList<Trends> culture=(ArrayList<Trends>) trendsService.searchInfo(flag,token);
			
			//根据typeFlag获取typeName
	        String typeName=typeFlagToTypeNameService.findTrendsTypeNameByTypeFlag(flag);
			System.out.println(typeName);
	        @SuppressWarnings("rawtypes")
			HashMap map=new HashMap();
	        map.put("typeName", typeName);
	        map.put("culture", culture);
	        String json=JSON.toJSONString(map,true);
	        response.setContentType("application/json");
			System.out.println(json);
			
				out=response.getWriter();
		        out.write(json);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		//阳光德育
		@SuppressWarnings("unchecked")
		@RequestMapping("/education")
		@ResponseBody
		public void education(String flag,String token,HttpServletResponse response){
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=null;
		try{
			ArrayList<Education> culture=(ArrayList<Education>) educationService.searchInfo(flag,token);
			
			//根据typeFlag获取typeName
	        String typeName=typeFlagToTypeNameService.findEducationTypeNameByTypeFlag(flag);
			System.out.println(typeName);
	        @SuppressWarnings("rawtypes")
			HashMap map=new HashMap();
	        map.put("typeName", typeName);
	        map.put("culture", culture);
	        String json=JSON.toJSONString(map,true);
	        response.setContentType("application/json");
			System.out.println(json);
			
				out=response.getWriter();
		        out.write(json);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		//学生天地
		@SuppressWarnings("unchecked")
		@RequestMapping("/student")
		@ResponseBody
		public void student(String flag,String token,HttpServletResponse response){
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=null;
		try{
			ArrayList<Student> culture=(ArrayList<Student>) studentService.searchInfo(flag,token);
			
			//根据typeFlag获取typeName
	        String typeName=typeFlagToTypeNameService.findStudentTypeNameByTypeFlag(flag);
			System.out.println(typeName);
	        @SuppressWarnings("rawtypes")
			HashMap map=new HashMap();
	        map.put("typeName", typeName);
	        map.put("culture", culture);
	        String json=JSON.toJSONString(map,true);
	        response.setContentType("application/json");
			System.out.println(json);
			
				out=response.getWriter();
		        out.write(json);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		//教师园地
		@SuppressWarnings("unchecked")
		@RequestMapping("/teacher")
		@ResponseBody
		public void teacher(String flag,String token,HttpServletResponse response){
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=null;
		try{
			ArrayList<Teacher> culture=(ArrayList<Teacher>) teacherService.searchInfo(flag,token);
			
			//根据typeFlag获取typeName
	        String typeName=typeFlagToTypeNameService.findTeacherTypeNameByTypeFlag(flag);
			System.out.println(typeName);
	        @SuppressWarnings("rawtypes")
			HashMap map=new HashMap();
	        map.put("typeName", typeName);
	        map.put("culture", culture);
	        String json=JSON.toJSONString(map,true);
	        response.setContentType("application/json");
			System.out.println(json);
			
				out=response.getWriter();
		        out.write(json);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		
		//党务工会
		@SuppressWarnings("unchecked")
		@RequestMapping("/party")
		@ResponseBody
		public void party(String flag,String token,HttpServletResponse response){
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=null;
		try{
			ArrayList<Party> culture=(ArrayList<Party>) partyService.searchInfo(flag,token);
			
			//根据typeFlag获取typeName
	        String typeName=typeFlagToTypeNameService.findPartyTypeNameByTypeFlag(flag);
			System.out.println(typeName);
	        @SuppressWarnings("rawtypes")
			HashMap map=new HashMap();
	        map.put("typeName", typeName);
	        map.put("culture", culture);
	        String json=JSON.toJSONString(map,true);
	        response.setContentType("application/json");
			System.out.println(json);
			
				out=response.getWriter();
		        out.write(json);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		
		//党务工会
		@SuppressWarnings("unchecked")
		@RequestMapping("/manage")
		@ResponseBody
		public void manage(String flag,String token,HttpServletResponse response){
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=null;
		try{
			ArrayList<Manage> culture=(ArrayList<Manage>) manageService.searchInfo(flag,token);
			
			//根据typeFlag获取typeName
	        String typeName=typeFlagToTypeNameService.findManageTypeNameByTypeFlag(flag);
			System.out.println(typeName);
	        @SuppressWarnings("rawtypes")
			HashMap map=new HashMap();
	        map.put("typeName", typeName);
	        map.put("culture", culture);
	        String json=JSON.toJSONString(map,true);
	        response.setContentType("application/json");
			System.out.println(json);
			
				out=response.getWriter();
		        out.write(json);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		
		//党务工会
		@SuppressWarnings("unchecked")
		@RequestMapping("/department")
		@ResponseBody
		public void department(String flag,String token,HttpServletResponse response){
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=null;
		try{
			ArrayList<DepartmentLinkContent> departmentLinkContent=(ArrayList<DepartmentLinkContent>) departmentService.searchInfo(flag,token);
			
	        String json=JSON.toJSONString(departmentLinkContent,true);
	        response.setContentType("application/json");
			System.out.println(json);
			
				out=response.getWriter();
		        out.write(json);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		
		//综合实验课
		@SuppressWarnings("unchecked")
		@RequestMapping("/labclassinfo")
		@ResponseBody
		public void labclassinfo(String flag,String token,HttpServletResponse response) throws IOException{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=null;
			try{
				ArrayList<StudentLabMenuContent> studentLabMenuContent=(ArrayList<StudentLabMenuContent>) labClassService.searchInfo(flag,token);
				String json=JSON.toJSONString(studentLabMenuContent,true);
				System.out.println(json);
				
				response.setContentType("application/json");
				out=response.getWriter();
				out.write(json);
			}catch(RuntimeException e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		
		//教学资源管理
		@SuppressWarnings("unchecked")
		@RequestMapping("/resource")
		@ResponseBody
		public void resource(int flag,String token,HttpServletResponse response) throws IOException{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=null;
			try{
				ArrayList<TeachingResourcesContent> teachingResourcesContent=(ArrayList<TeachingResourcesContent>)teachingResourcesService.searchInfo(flag,token);
				String json=JSON.toJSONString(teachingResourcesContent,true);
				System.out.println(json);
				out=response.getWriter();
				out.write(json);
				response.setContentType("application/json");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		//班级主页
		@SuppressWarnings("unchecked")
		@RequestMapping("/sclassHomePage")
		@ResponseBody
		public void sclassHomePage(int flag,String token,HttpServletResponse response) throws IOException{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=null;
			try{
				ArrayList<ClassHomePage> sclassHomePage=(ArrayList<ClassHomePage>)classService.searchInfo(flag,token);
				String json=JSON.toJSONString(sclassHomePage,true);
				System.out.println(json);
				out=response.getWriter();
				out.write(json);
				response.setContentType("application/json");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
		
		//学生信息 
		@SuppressWarnings("unchecked")
		@RequestMapping("/stuInfo")
		@ResponseBody
		public void stuInfo(int flag,String token,HttpServletResponse response) throws IOException{
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=null;
			try{
				
				ArrayList<CourseStudentInfo> courseStudentInfo=(ArrayList<CourseStudentInfo>)stuInfoService.searchInfo(flag,token);
				String json=JSON.toJSONString(courseStudentInfo,true);
				System.out.println(json);
				out=response.getWriter();
				out.write(json);
				response.setContentType("application/json");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}
}
