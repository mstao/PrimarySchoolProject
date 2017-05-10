package com.primaryschool.home.controller;

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
import com.primaryschool.admin.service.IAdminStuInfoService;
import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.DepartmentLinkContent;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Sclass;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLab;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.service.IDepartmentLinkService;
import com.primaryschool.home.service.IEducationService;
import com.primaryschool.home.service.ILabClassService;
import com.primaryschool.home.service.IManageService;
import com.primaryschool.home.service.IPartyService;
import com.primaryschool.home.service.ISclassService;
import com.primaryschool.home.service.IStudentService;
import com.primaryschool.home.service.ITeacherService;

/**
 * 
* @ClassName: ItemToJsonController
* @Description: TODO Json解析控制器
* @author Mingshan
* @date 2017年3月29日 上午8:59:23
*
 */

@Controller
@RequestMapping("/tojson")
public class ItemToJsonController<T> {
    @Autowired
    private IEducationService<Education> educationService;
    
    @Autowired
    private IStudentService<Student>  studentService;
     
    @Autowired
    private ITeacherService<Teacher>  teacherService;
    
    @Autowired
    private IPartyService<Party>  partyService;
    
    @Autowired
    private IManageService<Manage> manageService;
    
	@Autowired
	private ILabClassService<T> labClassService;
    
	@Autowired
	private IDepartmentLinkService<DepartmentLinkContent> departmentLinkService;
	    
	@Autowired
	private ISclassService<Sclass> sclassService;
    
    @Autowired
    private IAdminStuInfoService<CourseStudentInfo> stuInfoService;
    
    @Autowired
    private IAdminCourseScoreService<CourseScore> courseScoreService;
    
    
    int position=0;
	int item_per_page=PageSizeConfig.HOME_INDEX_PAGESIZE;
	
	@RequestMapping("/education")
    public void EducationToJSON(String  flag,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");  
		PrintWriter out=null;
		
		System.out.println(flag);
		//根据类型获取信息
		ArrayList<Education>  education=(ArrayList<Education>)educationService.findEducationInfo(flag, position, item_per_page);
        //调用fastjson生成json信息
		String json = JSON.toJSONString(education, true);
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
	
	@RequestMapping("/student")
	public void StudentToJson(String  flag,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");  
		
		PrintWriter out=null;
		
		System.out.println(flag);
		//根据类型获取信息
		ArrayList<Student>  student=(ArrayList<Student>)studentService.findStudentInfo(flag, position, item_per_page);
        //调用fastjson生成json信息
		String json = JSON.toJSONString(student, true);
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
	
	@RequestMapping("/teacher")
	public void TeacherToJson(String  flag,HttpServletResponse response){
	    response.setCharacterEncoding("UTF-8");  
		
		PrintWriter out=null;
		
		System.out.println(flag);
		//根据类型获取信息
		ArrayList<Teacher>  teacher=(ArrayList<Teacher>)teacherService.findTeacherInfo(flag, position, item_per_page);
        //调用fastjson生成json信息
		String json = JSON.toJSONString(teacher, true);
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
	
	
	@RequestMapping("/party")
	public void PartyToJson(String  flag,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");  
			
		PrintWriter out=null;
		
		System.out.println(flag);
		//根据类型获取信息
		ArrayList<Party>  party=(ArrayList<Party>)partyService.findPartyInfo(flag, position, item_per_page);
        //调用fastjson生成json信息
		String json = JSON.toJSONString(party, true);
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
	* @Title: ManageToJson
	* @Description: TODO 学校管理
	* @param @param flag
	* @param @param response    设定文件
	* @return void    返回类型
	* @throws
	 */
	@RequestMapping("/manage")
	public void ManageToJson(String  flag,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");  
		
		PrintWriter out=null;
		
		System.out.println(flag);
		//根据类型获取信息
		ArrayList<Manage>  manage=(ArrayList<Manage>)manageService.findManageInfo(flag, position, item_per_page); //调用fastjson生成json信息
		String json = JSON.toJSONString(manage, true);
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
	* @Title: labClassToJson
	* @Description: TODO 综合实验课
	* @param @param response    设定文件
	* @return void    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/labclass")
	public void labClassToJson(HttpServletResponse response){
		
		response.setCharacterEncoding("UTF-8");  
		
		PrintWriter out=null;
		ArrayList<StudentLab> labClass=(ArrayList<StudentLab>) labClassService.findLabClassListInfo();
		String json = JSON.toJSONString(labClass, true);
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
	* @Title: JobPlacementToJSON
	* @Description: TODO  部门链接各部门信息加载
	* @param @param departmentNameType
	* @param @param flag
	* @param @param response    设定文件
	* @return void    返回类型
	* @throws
	 */
	@RequestMapping("/departmentLink")
    public void JobPlacementToJSON(int departmentId,String  flag,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");  
		PrintWriter out=null;
		
		System.out.println(flag);
		//根据类型id获取信息
		ArrayList<DepartmentLinkContent>  departmentlinkStaff=(ArrayList<DepartmentLinkContent>)departmentLinkService.findDepartmentLinkInfo(departmentId,flag, position, item_per_page);
        //调用fastjson生成json信息
		String json = JSON.toJSONString(departmentlinkStaff, true);
		System.out.println("下面开始打印json了========"+json);
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
	
	
	//切换班级ByGradeID  findClass
	@RequestMapping("/findClass")
	@ResponseBody
	public void findClass(int gradeId,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=null;
		ArrayList<Sclass> sclass=(ArrayList<Sclass>) sclassService.findClassInfoById(gradeId);
		String json=JSON.toJSONString(sclass,true);
		
		//System.out.println(json);
		response.setContentType("application/json");
		try{
			out=response.getWriter();
	        out.write(json);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
	//查询学生成绩
	@SuppressWarnings("unchecked")
	@RequestMapping("/findScore")
	@ResponseBody
	public void findScore(int classId,String info,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=null;
	try{
		int stuinfoId=stuInfoService.findIdByStuIdOrStuName(info);
	
		ArrayList<CourseScore> sclass=(ArrayList<CourseScore>) courseScoreService.findScoreInfoByTimeAndId(stuinfoId, classId);
	 	//获取考试的科目数
	 	long sum=courseScoreService.findTypeCount();
	 	//获取考试类别
	 	ArrayList<CourseType> courseType=(ArrayList<CourseType>) courseScoreService.findCourseType();
	    @SuppressWarnings("rawtypes")
		HashMap map =new HashMap();
	    map.put("sum", sum);
	    map.put("sclass", sclass);
	    map.put("courseType", courseType);
	    
		String json=JSON.toJSONString(map,true);
		System.out.println(json);
		response.setContentType("application/json");
		
			out=response.getWriter();
	        out.write(json);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
