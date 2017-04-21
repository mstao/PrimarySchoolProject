package com.primaryschool.home.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.admin.entity.FileBean;
import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.ClassHomePage;
import com.primaryschool.home.entity.ClassSynopsis;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLabMenuContent;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.TeachingResourcesContent;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.IBaseFileService;
import com.primaryschool.home.service.IClassHomePageService;
import com.primaryschool.home.service.IClassSynopsisService;
import com.primaryschool.home.service.ICultureService;
import com.primaryschool.home.service.IEducationService;
import com.primaryschool.home.service.ILabClassService;
import com.primaryschool.home.service.IManageService;
import com.primaryschool.home.service.IPartyService;
import com.primaryschool.home.service.IStudentService;
import com.primaryschool.home.service.ITeacherService;
import com.primaryschool.home.service.ITeachingResourcesService;
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
public class DetailsController<T>{

	@Autowired
	private ICultureService<Culture> cultureService;
	
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
	
    @Autowired
    private ILabClassService<T> labClassService;
    
    @Autowired
   	private IClassHomePageService<ClassHomePage> classhomepageService;
       
    @Autowired
   	private IClassSynopsisService<ClassSynopsis> classSynopsisService;
       
    @Autowired
    private ITeachingResourcesService<T>  teachingResourcesService;
  
    @Autowired
    private IBaseFileService<T> baseFileServcie;
    
    int position=0;
	int item_per_page=7;
	
	int pageSize=PageSizeConfig.HOME_CATEGORY_PAGESIZE;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/trends")
	public String trends(int id,String flag,HttpServletRequest request){	
		String url="trends";
		
		//将浏览量+1
		trendsService.addViewCount(id);
		//根据id获取详细信息
        Trends trends=(Trends)trendsService.findTrendsInfoById(id);
        
        //获取该类型的最近更新
        ArrayList<Trends> latestTrends=(ArrayList<Trends>)trendsService.findLatestTrendsInfo(flag, position, item_per_page);
	    
        //文件类型
        String belongType="ftrends";
        //获取文件列表
        ArrayList<FileBean> filelist=(ArrayList<FileBean>) baseFileServcie.findFile(belongType,id);
        
        request.setAttribute("filelist", filelist);
        request.setAttribute("item", trends);
	    request.setAttribute("latestItem", latestTrends);
	    request.setAttribute("url", url);
		return "home/details/trendsDetails";
	}
	
	@RequestMapping("/education")
	public String education(int id,String flag,HttpServletRequest request){
		
		String url="education";
		//浏览量+1
		educationService.addViewCount(id);
		//根据id获取详细信息
		Education education=(Education)educationService.findEducationInfoById(id);
		
		//获取最近更新
		ArrayList<Education> latestEducation=(ArrayList<Education>)educationService.findLatestEducationInfo(flag,  position, item_per_page);
		
		request.setAttribute("item", education);
	    request.setAttribute("latestItem", latestEducation);
	    request.setAttribute("url", url);
	    return "home/details/trendsDetails";
	}
	
	@RequestMapping("/student")
	public  String student(int id,String flag,HttpServletRequest request){
		String url="student";
		//浏览量+1
		studentService.addViewCount(id);
		//根据id获取详细信息
		Student student=(Student)studentService.findStudentInfoById(id);
		
		//获取最近更新
		ArrayList<Student>  latestStudent=(ArrayList<Student>) studentService.findLatestStudentInfo(flag, position, item_per_page);
		
		request.setAttribute("item", student);
	    request.setAttribute("latestItem", latestStudent);
	    request.setAttribute("url", url);
	    return "home/details/trendsDetails";
	}
	
   @RequestMapping("/teacher")
   public String teacher(int id,String flag,HttpServletRequest request){
	    String url="teacher";
		//浏览量+1
		teacherService.addViewCount(id);
		//根据id获取详细信息
		Teacher teacher=(Teacher)teacherService.findTeacherInfoById(id);
		
		//获取最近更新
		ArrayList<Teacher>  latestTeacher=(ArrayList<Teacher>) teacherService.findLatestTeacherInfo(flag, position, item_per_page);
		
		request.setAttribute("item", teacher);
	    request.setAttribute("latestItem", latestTeacher);
	    request.setAttribute("url", url);
	    return "home/details/trendsDetails";
	    
   }
   
   @RequestMapping("/party")
   public String party(int id,String flag,HttpServletRequest request){
	    String url="party";
		//浏览量+1
		partyService.addViewCount(id);
		//根据id获取详细信息
		Party party=(Party)partyService.findPartyInfoById(id);
		
		//获取最近更新
		ArrayList<Party>  latestParty=(ArrayList<Party>) partyService.findLatestPartyInfo(flag, position, item_per_page);
		
		request.setAttribute("item", party);
	    request.setAttribute("latestItem", latestParty);
	    request.setAttribute("url", url);
	    return "home/details/trendsDetails";
   }
   
   @RequestMapping("/manage")
   public String manage(int id,String flag,HttpServletRequest request){
	   
	    String url="manage";
		//浏览量+1
		manageService.addViewCount(id);
		//根据id获取详细信息
		Manage manage=(Manage)manageService.findManageInfoById(id);
		
		//获取最近更新
		ArrayList<Manage>  latestManage=(ArrayList<Manage>) manageService.findLatestManageInfo(flag, position, item_per_page);
		
		request.setAttribute("item", manage);
	    request.setAttribute("latestItem", latestManage);
	    request.setAttribute("url", url);
	    return "home/details/trendsDetails";
   }
   
   @RequestMapping("/culture")
   public String culture(int id,String flag,HttpServletRequest request){
	    String url="culture";
		//浏览量+1
		cultureService.addViewCount(id);
		//根据id获取详细信息
		Culture culture=(Culture)cultureService.findCultureInfoById(id);
		
		//获取最近更新
		ArrayList<Culture>  latestCulture=(ArrayList<Culture>) cultureService.findLatestCultureInfo(flag, position, item_per_page);
		
		request.setAttribute("item", culture);
	    request.setAttribute("latestItem", latestCulture);
	    request.setAttribute("url", url);
	   return "home/details/trendsDetails";
   }
   
   /**
    * 
   * @Title: labClassMenu
   * @Description: TODO 综合实验课
   * @param @param cid
   * @param @param id
   * @param @param flag
   * @param @param request
   * @param @return    设定文件
   * @return String    返回类型
   * @throws
    */
   @SuppressWarnings("unchecked")
   @RequestMapping("/labClassMenu")
   public String  labClassMenu(int cid,int id,String flag,HttpServletRequest request){
	   
	   String url="labClassMenu";
	   labClassService.addViewCount(id);
	   //根据id获取信息
	   StudentLabMenuContent content=(StudentLabMenuContent)labClassService.findLabClassContentById(id);
	//   System.out.println("flag=="+flag);
	   //获取最近更新
	   ArrayList<StudentLabMenuContent> latestContent=(ArrayList<StudentLabMenuContent>) labClassService.findLabClassContent(cid, flag, position, item_per_page);
	   
	   request.setAttribute("item", content);
	   request.setAttribute("latestItem", latestContent);
	   request.setAttribute("url", url);
	   request.setAttribute("cid", cid);
	   request.setAttribute("id", id);
	   return "home/details/trendsDetails";
   }
   
   
   //班级主页详细内容
   
   @RequestMapping("/classhomepage")
   public  String classhomepage(int classId, int gradeFlag,String classFlag,ModelMap model){
		
		String synopsisFlag="synopsis";
		String dynamicFlag="dynamic";
		String growthstoryFlag="growthstory";
		String articleFlag="article";
		String styleFlag="style";
		int classidFlag = classId;
		
		//获取班级简介
		ClassSynopsis synopsis=(ClassSynopsis) classSynopsisService.findClassSynopsisInfo(classidFlag);
	    //获取班级动态
		ArrayList<ClassHomePage>  dynamic=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,dynamicFlag, 0, pageSize);
		//获取成长故事
		ArrayList<ClassHomePage>  growthstory=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,growthstoryFlag, 0, pageSize);
		//获取学生文章
		ArrayList<ClassHomePage>  article=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,articleFlag, 0, pageSize);
		//获取班级风采
		ArrayList<ClassHomePage>  style=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,styleFlag, 0, pageSize);
		//获取所在班级
		
		
		model.put("synopsis", synopsis);
		model.put("dynamic", dynamic);
		model.put("growthstory", growthstory);
		model.put("article", article);
		model.put("style", style);
		model.put("grade", gradeFlag);
		model.put("className", classFlag);
		model.put("classId", classidFlag);
		
		model.put("synopsisFlag",synopsisFlag);
		model.put("dynamicFlag", dynamicFlag);
		model.put("growthstoryFlag", growthstoryFlag);
		model.put("articleFlag", articleFlag);
		model.put("styleFlag", styleFlag);
		
		return "home/details/classDetails";
	}
   
   
    @RequestMapping("/mainClass")
	public  String mainClass(int classId, int gradeFlag,String classFlag,String type,ModelMap model){
		
		String synopsisFlag="synopsis";
		String dynamicFlag="dynamic";
		String growthstoryFlag="growthstory";
		String articleFlag="article";
		String styleFlag="style";
		int classidFlag = classId;
		if(type.equals("班级动态")){
			 //获取班级动态
			ArrayList<ClassHomePage>  dynamic=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,dynamicFlag, 0, pageSize);
			model.put("tongyi", dynamic);
		}else if(type.equals("班级风采")){
			//获取班级风采
			ArrayList<ClassHomePage>  style=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,styleFlag, 0, pageSize);
			model.put("tongyi", style);
		}else if(type.equals("成长故事")){
			//获取成长故事
			ArrayList<ClassHomePage>  growthstory=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,growthstoryFlag, 0, pageSize);
			model.put("tongyi", growthstory);
		}else if(type.equals("学生文章")){
			//获取学生文章
			ArrayList<ClassHomePage>  article=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,articleFlag, 0, pageSize);
			model.put("tongyi", article);
		}
		ArrayList<ClassHomePage>  style=(ArrayList<ClassHomePage>)classhomepageService.findClassHomePageInfo(classidFlag,styleFlag, 0, pageSize);
		ClassSynopsis synopsis=(ClassSynopsis) classSynopsisService.findClassSynopsisInfo(classidFlag);
		model.put("style", style);
		model.put("synopsis", synopsis);
		model.put("classtype", type);
		model.put("grade", gradeFlag);
		model.put("className", classFlag);
		model.put("classId", classidFlag);
		
		return "home/details/mainClass";
	}
    
    
   @RequestMapping("/newsinfo")
   public String newsinfo(int id,int gradeFlag,String classFlag,int classId,ModelMap model){
	   
	   ClassHomePage info=classhomepageService.findClassHomePageInfoById(id);
	   model.put("classId", classId);
	   model.put("newsinfo", info);
	   model.put("grade", gradeFlag);
	   model.put("className", classFlag);
	   return "home/details/classNewsDetail";
   }
   
   @SuppressWarnings("unchecked")
   @RequestMapping("/teachingResources")
   public String  teachingResourcesDetails(int menuId,int classId,int tid,String flag,ModelMap map){
	  
	  String url="teachingResources"; 
	  //根据id获取具体内容
	  TeachingResourcesContent content=(TeachingResourcesContent) teachingResourcesService.findTeachingResourcesContentById(tid);
	   
	  //获取该类型最近更新的信息
	  
	  ArrayList<TeachingResourcesContent> latest=(ArrayList<TeachingResourcesContent>)teachingResourcesService.findLatestTeachingResourcesContent(menuId, classId, flag, 0, pageSize);
	  
	  map.put("item",content);
	  map.put("latestItem", latest);
	  map.put("url",url);
	  map.put("menuId", menuId);
	  map.put("classId", classId);
	  return "home/details/teachingResourcesContentDetail";
   }
   
}
