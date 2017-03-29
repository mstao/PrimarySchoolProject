package com.primaryschool.home.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.IEducationService;
import com.primaryschool.home.service.IManageService;
import com.primaryschool.home.service.IPartyService;
import com.primaryschool.home.service.IStudentService;
import com.primaryschool.home.service.ITeacherService;
import com.primaryschool.home.service.ITrendsService;

/**
 * 
* @ClassName: DetailsController
* @Description: TODO 详细信息控制器
* @author Mingshan
 * @param <T>
* @date 2017年3月27日 上午10:27:18
*
 */

@Controller
@RequestMapping("/details")
public class DetailsController{

	@Autowired  
	private ITrendsService<Trends> trendsService;
	
	@Autowired
	private IEducationService<Education> educationService;
	
	@Autowired 
    private IStudentService<Student> studentService;
    
    @Autowired
    private ITeacherService<Teacher> teacherService;
    
    @Autowired
    private IManageService<Manage> manageService;
    
    @Autowired
    private IPartyService<Party> partyService;
	
    int position=0;
	int item_per_page=7;
	
	@RequestMapping("/trends")
	public String trends(int id,String flag,HttpServletRequest request){	
		
		//将浏览量+1
		trendsService.addViewCount(id);
		//根据id获取详细信息
        Trends trends=(Trends)trendsService.findTrendsInfoById(id);
        
        //获取该类型的最近更新
        ArrayList<Trends> latestTrends=(ArrayList<Trends>)trendsService.findLatestTrendsInfo(flag, position, item_per_page);
	    request.setAttribute("item", trends);
	    request.setAttribute("latestItem", latestTrends);
		return "home/details/trendsDetails";
	}
	
	@RequestMapping("/education")
	public String education(int id,String flag,HttpServletRequest request){
		//浏览量+1
		educationService.addViewCount(id);
		//根据id获取详细信息
		Education education=(Education)educationService.findEducationInfoById(id);
		
		//获取最近更新
		ArrayList<Education> latestEducation=(ArrayList<Education>)educationService.findLatestEducationInfo(flag,  position, item_per_page);
		
		request.setAttribute("item", education);
	    request.setAttribute("latestItem", latestEducation);
		return "home/details/trendsDetails";
	}
	
}
