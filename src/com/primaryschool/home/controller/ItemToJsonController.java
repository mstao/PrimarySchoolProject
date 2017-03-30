package com.primaryschool.home.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.service.IEducationService;
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
public class ItemToJsonController {
    @Autowired
    private IEducationService<Education> educationService;
    
    @Autowired
    private IStudentService<Student>  studentService;
     
    @Autowired
    private ITeacherService<Teacher>  teacherService;
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
}
