
package com.primaryschool.home.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.IEducationService;
import com.primaryschool.home.service.IStudentService;
import com.primaryschool.home.service.ITrendsService;

/**
* @ClassName: CategoryController
* @Description: TODO  类别分发控制器
* @author Mingshan
* @date 2017年3月28日 下午6:15:30
*
*/

@Controller
@RequestMapping("/category")
public class CategoryController {
    
	@Autowired  
	private ITrendsService<Trends> trendsService;
	
	@Autowired
	private IEducationService<Education> educationService;
	
	@Autowired
	private IStudentService<Student>  studentService;
	
	int pageSize=PageSizeConfig.HOME_CATEGORY_PAGESIZE;
	@RequestMapping("/trends")
	public String trends(ModelMap model){
		
		
		//获取该类型的热点信息
        ArrayList<Trends> hotTrends=(ArrayList<Trends>)trendsService.findHotTrendsInfo("news", 0, pageSize);
		
        //获取校园新闻
        String newsFlag="news";
   	 
		ArrayList<Trends>  news=(ArrayList<Trends>) trendsService.findTrendsInfo(newsFlag, 0, pageSize);
        
		//获取通知公告
		String noticeFlag="notice";
		ArrayList<Trends>  notice=(ArrayList<Trends>) trendsService.findTrendsInfo(noticeFlag, 0, pageSize);
		

		model.put("hotTrends", hotTrends);
		model.put("news", news);
		model.put("notice", notice);
		model.put("newsFlag", newsFlag);
		model.put("noticeFlag", noticeFlag);
		
		return "home/category/trends";
	}
	
	@RequestMapping("/education")
	public  String education(ModelMap model){
		
		String educationFlag="education";
		String activeFlag="active";
		String speakFlag="speak";
		String parentsFlag="parents";
		String stagentFlag="stagent";
		
		//获取主题教育
		ArrayList<Education>  education=(ArrayList<Education>)educationService.findEducationInfo(educationFlag, 0, pageSize);
 	    //获取国旗下讲话
		ArrayList<Education>  speak=(ArrayList<Education>)educationService.findEducationInfo(speakFlag, 0, pageSize);
		//获取少先队活动
		ArrayList<Education>  active=(ArrayList<Education>)educationService.findEducationInfo(activeFlag, 0, pageSize);
		//获取家长委员会
		ArrayList<Education>  parents=(ArrayList<Education>)educationService.findEducationInfo(parentsFlag, 0, pageSize);
		//获取心灵驿站
		ArrayList<Education>  stagent=(ArrayList<Education>)educationService.findEducationInfo(stagentFlag, 0, pageSize);
		
		
		model.put("education", education);
		model.put("speak", speak);
		model.put("active", active);
		model.put("parents", parents);
		model.put("stagent", stagent);
		
		model.put("educationFlag", educationFlag);
		model.put("activeFlag", activeFlag);
		model.put("speakFlag", speakFlag);
		model.put("parentsFlag", parentsFlag);
		model.put("stagentFlag", stagentFlag);
		
		return "home/category/education";
	}
	
	
	@RequestMapping("/student")
	public String student(ModelMap map){
		
		String bookFlag="book";
		String activityFlag="activity";
		String labFlag="lab";
		
		//获取沐浴书香
		ArrayList<Student> book=(ArrayList<Student>)studentService.findStudentInfo(bookFlag, 0, pageSize);
		
		//获取活动风彩
		ArrayList<Student> activity=(ArrayList<Student>)studentService.findStudentInfo(activityFlag, 0, pageSize);
		
		//获取综合实验课
		
		ArrayList<Student> lab=(ArrayList<Student>)studentService.findStudentInfo(activityFlag, 0, pageSize);
		
		map.put("bookFlag", bookFlag);
		map.put("activityFlag", activityFlag);
		map.put("labFlag", labFlag);
		
		map.put("book", book);
		map.put("activity", activity);
		map.put("lab", lab);
		
		return "home/category/student";
	}
}
