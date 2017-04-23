package com.primaryschool.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.service.IAdminCultureService;
import com.primaryschool.admin.service.IAdminDepartmentService;
import com.primaryschool.admin.service.IAdminEducationService;
import com.primaryschool.admin.service.IAdminLabClassService;
import com.primaryschool.admin.service.IAdminManageService;
import com.primaryschool.admin.service.IAdminPartyService;
import com.primaryschool.admin.service.IAdminSclassService;
import com.primaryschool.admin.service.IAdminStudentService;
import com.primaryschool.admin.service.IAdminTeacherService;
import com.primaryschool.admin.service.IAdminTeachingResourceService;
import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.home.entity.ClassHomePage;
import com.primaryschool.home.entity.ClassSynopsis;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.DepartmentLinkContent;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLabMenuContent;
import com.primaryschool.home.entity.StudentLabMenuIntroduce;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.TeachingResourcesContent;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.ITypeFlagToTypeIdService;

/**
 * 
* @ClassName: UpdateInfoServlet
* @Description: TODO 更新数据
* @author Mingshan
* @date 2017年4月14日 下午3:40:20
*
 */

@Controller
@RequestMapping("/admin/update")
public class UpdateInfoServlet<T> {

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
   	private IAdminLabClassService<T> labClassService;
    
    @Autowired
    private IAdminSclassService<T>	classService;
    
    @Autowired
	private IAdminTeachingResourceService<T> teachingResourcesService;
    
    @Autowired
    private ITypeFlagToTypeIdService typeFlagToTypeIdService; 
	/**
	 * @Title: updateCulture
	 * @Description: TODO 更新校园文化数据
	 * @param culture   设定文件
	 * @return boolean   返回类型
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/culture")
	@ResponseBody
	public String  updateCulture(Culture culture){
		int r;
		//更新数据
		boolean result=cultureService.updateCultureInfo((T) culture);
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
	* @Title: updateTrends
	* @Description: TODO 更新校园动态数据
	* @param @param trends    设定文件
	* @return boolean   返回类型
	* @throws
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping("/trends")
	@ResponseBody
	public String  updateTrends(Trends trends){
		int r;
		//更新数据
		boolean result=trendsService.updateTrendsInfo((T) trends);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/education")
	@ResponseBody
	public String  updateEducation(Education education){
		int r;
		//更新数据
		boolean result=educationService.updateEducationInfo((T) education);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/student")
	@ResponseBody
	public String  updateStudent(Student student){
		int r;
		//更新数据
		boolean result=studentService.updateStudentInfo((T) student);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/teacher")
	@ResponseBody
	public String  updateTeacher(Teacher teacher){
		int r;
		//更新数据
		boolean result=teacherService.updateTeacherInfo((T) teacher);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/party")
	@ResponseBody
	public String  updateParty(Party party){
		int r;
		//更新数据
		boolean result=partyService.updatePartyInfo((T) party);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/manage")
	@ResponseBody
	public String  updateManage(Manage manage){
		int r;
		//更新数据
		boolean result=manageService.updateManageInfo((T) manage);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	//修改部门发布的信息
	@SuppressWarnings("unchecked")
	@RequestMapping("/department")
	@ResponseBody
	public String  department(String typeFlag,DepartmentLinkContent departmentLinkContent){
		int r;
		//由typeFlag获取typeid
    	int typeId =departmentService.findDepartmentTypeIdByTypeFlag(typeFlag);
    	//赋值
    	departmentLinkContent.setTypeId(typeId);
		//更新数据
		boolean result=departmentService.updateDeparmentContent((T) departmentLinkContent);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	//修改教学资源信息
	@SuppressWarnings("unchecked")
	@RequestMapping("/resource")
	@ResponseBody
	public String  updateResource(String typeFlag,TeachingResourcesContent teachingResourcesContent){
		int r;
		//由typeFlag获取typeid
    	int typeId =typeFlagToTypeIdService.findTeachingResourcesTypeIdByTypeFlag(typeFlag);
    	//赋值
    	teachingResourcesContent.setTypeId(typeId);
		//更新数据
		boolean result=teachingResourcesService.updateTeachingResourceInfo((T) teachingResourcesContent);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	//修改社团内信息
	@SuppressWarnings("unchecked")
	@RequestMapping("/labclassinfo")
	@ResponseBody
	public String  updateLabclassinfo(String typeFlag,StudentLabMenuContent studentLabMenuContent){
		int r;
		//由typeFlag获取typeid
    	int typeId =typeFlagToTypeIdService.findLabClassMenuIdByTypeFlag(typeFlag);
    	//赋值
    	studentLabMenuContent.setMenuId(typeId);
		//更新数据
		boolean result=labClassService.updateLabClassInfo((T) studentLabMenuContent);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	
	//修改班级内信息
	@SuppressWarnings("unchecked")
	@RequestMapping("/sclassHomePage")
	@ResponseBody
	public String updateSclassHomePage(int labId,String typeFlag,String author,ClassHomePage classHomePage){
		int r;
		//由typeFlag获取typeid
    	int typeId =classService.findPageTypeIdByTypeFlag(typeFlag);
    	//赋值
    	classHomePage.setClassId(labId);
    	classHomePage.setTypeId(typeId);
    	classHomePage.setItemAuthor(author);
		//更新数据
		boolean result=classService.updateSclassInfo((T) classHomePage);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/labintro")
	@ResponseBody
	public String  updateLabintro(String intro,int foreignId,StudentLabMenuIntroduce studentLabMenuIntroduce){
		int r;
		studentLabMenuIntroduce.setIntroduce(intro);
		studentLabMenuIntroduce.setMenuId(foreignId);
		//更新数据
		boolean result=labClassService.updateLabIntroInfo((T) studentLabMenuIntroduce);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
	//修改班级简介
	@SuppressWarnings("unchecked")
	@RequestMapping("/sclassintro")
	@ResponseBody
	public String  sclassintro(String intro,int foreignId,ClassSynopsis classSynopsis){
		int r;
		classSynopsis.setClassSynopsis(intro);
		classSynopsis.setClassId(foreignId);
		//更新数据
		boolean result=classService.updateSclassIntroInfo((T) classSynopsis);
		//返回结果
		if(result==true){
			r=1;
		}else{
			r=0;
		}
		return r+"";
		
	}
}
