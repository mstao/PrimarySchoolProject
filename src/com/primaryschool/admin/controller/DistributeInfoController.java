package com.primaryschool.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.admin.entity.CourseScore;
import com.primaryschool.admin.entity.CourseStudentInfo;
import com.primaryschool.admin.service.IAdminCourseScoreService;
import com.primaryschool.admin.service.IAdminCultureService;
import com.primaryschool.admin.service.IAdminDepartmentService;
import com.primaryschool.admin.service.IAdminEducationService;
import com.primaryschool.admin.service.IAdminHeaderMasterService;
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
import com.primaryschool.home.entity.ClassHomePageType;
import com.primaryschool.home.entity.ClassSynopsis;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.DepartmentLinkContent;
import com.primaryschool.home.entity.DepartmentLinkContentType;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.HeadMaster;
import com.primaryschool.home.entity.HeadMasterPost;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLabMenuContent;
import com.primaryschool.home.entity.StudentLabMenuIntroduce;
import com.primaryschool.home.entity.StudentLabMenuType;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.TeachingResourcesContent;
import com.primaryschool.home.entity.TeachingResourcesContentType;
import com.primaryschool.home.entity.Trends;

/**
 * 
* @ClassName: DistributeInfoController
* @Description: TODO 分发数据
* @author Mingshan
* @date 2017年4月14日 下午3:37:58
*
 */

@Controller
@RequestMapping("/admin/distribute")
public class DistributeInfoController<T> {
	
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
    private IAdminStuInfoService<T> stuInfoService;
    
    @Autowired
    private IAdminCourseScoreService<T> courseScoreService;
    
    
	/**
	 * 
	* @Title: culture
	* @Description: TODO  分发校园文化数据
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/culture")
	public String  culture(int id,ModelMap map,HttpServletRequest request){
		String fileType="fculture";
		String durl="culture";
		Culture culture=(Culture) cultureService.findCultureInfoById(id);
		String SCHOOL_CULTURE=(String) request.getServletContext().getAttribute("SCHOOL_CULTURE");
		map.put("item", culture);
		map.put("fileType", fileType);
		map.put("durl", durl);
	    map.put("school_trends_c", SCHOOL_CULTURE);
		return "admin/details/detail";
	}
	/**
	 * 
	* @Title: trends
	* @Description: TODO  分发 校园动态数据
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/trends")
	public String  trends(int id,ModelMap map,HttpServletRequest request){
		String fileType="ftrends";
		String durl="trends";
		Trends trends=(Trends) trendsService.findTrendsInfoById(id);
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_TRENDS");
		map.put("item", trends);
		map.put("fileType", fileType);
		map.put("durl",durl);
	    map.put("school_trends_c", SCHOOL_TRENDS);
		return "admin/details/detail";
	}
	
	@RequestMapping("/education")
	public String  education(int id,ModelMap map,HttpServletRequest request){
		String fileType="feducation";
		String durl="education";
		Education education=(Education) educationService.findEducationInfoById(id);
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_EDUCATION");
		map.put("item", education);
		map.put("fileType", fileType);
		map.put("durl",durl);
	    map.put("school_trends_c", SCHOOL_TRENDS);
		return "admin/details/detail";
	}
	
	@RequestMapping("/student")
	public String  student(int id,ModelMap map,HttpServletRequest request){
		String fileType="fstudent";
		String durl="student";
		Student student=(Student) studentService.findStudentInfoById(id);
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_STUDENT");
		map.put("item", student);
		map.put("fileType", fileType);
		map.put("durl",durl);
	    map.put("school_trends_c", SCHOOL_TRENDS);
		return "admin/details/detail";
	}
	
	@RequestMapping("/teacher")
	public String  teacher(int id,ModelMap map,HttpServletRequest request){
		String fileType="fteacher";
		String durl="teacher";
		Teacher teacher=(Teacher) teacherService.findTeacherInfoById(id);
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_TEACHER");
		map.put("item", teacher);
		map.put("fileType", fileType);
		map.put("durl",durl);
	    map.put("school_trends_c", SCHOOL_TRENDS);
		return "admin/details/detail";
	}
	
	@RequestMapping("/party")
	public String  party(int id,ModelMap map,HttpServletRequest request){
		String fileType="fparty";
		String durl="party";
		Party party=(Party) partyService.findPartyInfoById(id);
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_PARTY");
		map.put("item", party);
		map.put("fileType", fileType);
		map.put("durl",durl);
	    map.put("school_trends_c", SCHOOL_TRENDS);
		return "admin/details/detail";
	}
	
	@RequestMapping("/manage")
	public String  manage(int id,ModelMap map,HttpServletRequest request){
		String fileType="fmanage";
		String durl="manage";
		Manage manage=(Manage) manageService.findManageInfoById(id);
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_MANAGE");
		map.put("item", manage);
		map.put("fileType", fileType);
		map.put("durl",durl);
	    map.put("school_trends_c", SCHOOL_TRENDS);
		return "admin/details/detail";
	}
	/**
	 * 
	 * @param id      信息编号
	 * @param classId  所属年级
	 * @param menuId   学科编号
	 * @param typeId   类型编号
	 * @param map
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/resource")
	public String  resource(int id,int classId,int menuId,int typeId,ModelMap map,HttpServletRequest request){
		String fileType="fteacher";
		String durl="resource";
		 //获取所有的资源类型
		ArrayList<TeachingResourcesContentType> resouceType=(ArrayList<TeachingResourcesContentType>) teachingResourcesService.findTeachingResourceTypeInfo();     
		
		TeachingResourcesContent teachingResourcesContent=(TeachingResourcesContent) teachingResourcesService.findTeachingResourceInfoById(id);
		//获取menuName用于辨别所属学科
		String menuName=teachingResourcesService.findTeachingResurceNameById(menuId);
		//获取typeName用于下拉列表框
		String typeName=teachingResourcesService.findTeachingResurceTypeById(typeId);
		
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_TEACHER_RESOURCES");
		map.put("classId", classId);
		map.put("menuId", menuId);
		map.put("typeName", typeName);
		map.put("resouceType", resouceType);
		map.put("menuName", menuName);
		map.put("item", teachingResourcesContent);
		map.put("fileType", fileType);
		map.put("durl",durl);
	    map.put("school_trends_c", SCHOOL_TRENDS);
		return "admin/details/resourceDetail";
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/department")
	public String  department(int id,int deptId,int typeId,ModelMap map,HttpServletRequest request){
		String fileType="fmanage";
		String durl="department";
		 //获取所有的资源类型
		ArrayList<DepartmentLinkContentType> resouceType=(ArrayList<DepartmentLinkContentType>) departmentService.findDepartmentType();     
		
		DepartmentLinkContent departmentLinkContent=(DepartmentLinkContent) departmentService.findDeptContentInfo(id);
		//获取所属部门
		String deptName=departmentService.findDepartmentNameById(deptId);
		
		//获取typeName用于下拉列表框
		String typeName=departmentService.findDepartmentTypeById(typeId);
		
		String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_MANAGE_DEPARTMENT");
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("typeName", typeName);
		map.put("resouceType", resouceType);
		map.put("item", departmentLinkContent);
		map.put("fileType", fileType);
		map.put("durl",durl);
	    map.put("school_trends_c", SCHOOL_TRENDS);
		return "admin/details/departmentDetail";
	}
	
		/**
		 * 
		 * @param id  信息编号
		 * @param labId		所属社团编号
		 * @param menuId	资源类型编号
		 * @param map
		 * @param request
		 * @return
		 */
		@SuppressWarnings("unchecked")
		@RequestMapping("/labclassinfo")
		public String  labclassinfo(int id,int labId,String labName,int menuId,ModelMap map,HttpServletRequest request){
			String fileType="fteacher";
			String durl="labclassinfo";
			 //获取所有的资源类型
			ArrayList<StudentLabMenuType> resouceType=(ArrayList<StudentLabMenuType>) labClassService.findLabClassMenuInfo();     
			
			StudentLabMenuContent studentLabMenuContent=(StudentLabMenuContent) labClassService.findLabClassInfoById(id);
			//获取menuName用于下拉列表框
			String menuName=labClassService.findLabClassMenuById(menuId);
			
			String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_STUDENT_LAB");
			map.put("menuId", menuId);
			map.put("labId", labId);
			map.put("labName", labName);
			map.put("resouceType", resouceType);
			map.put("menuName", menuName);
			map.put("item", studentLabMenuContent);
			map.put("fileType", fileType);
			map.put("durl",durl);
		    map.put("school_trends_c", SCHOOL_TRENDS);
			return "admin/details/labclassinfoDetail";
		}
		//修改班级主页内信息
		@SuppressWarnings("unchecked")
		@RequestMapping("/sclassHomePage")
		public String  sclassHomePage(int id,int grade,String className,int typeId,ModelMap map,HttpServletRequest request){
			String fileType="fstudent";
			String durl="sclassHomePage";
			 //获取所有的资源类型
			ArrayList<ClassHomePageType> resouceType=(ArrayList<ClassHomePageType>) classService.findClassPageType();     
			//根据信息ID获取其详细内容
			ClassHomePage classHomePage=(ClassHomePage) classService.findSclassInfoById(id);
			//获取menuName用于下拉列表框
			String menuName=classService.findfindClassPageTypeByTypeId(typeId);
			
			 //获取labName即社团名称
		       String labName=grade+"年级"+className;
			String SCHOOL_TRENDS=(String) request.getServletContext().getAttribute("SCHOOL_STUDENT_LAB");
			map.put("grade", grade);
			map.put("className", className);
			map.put("labName", labName);
			map.put("resouceType", resouceType);
			map.put("menuName", menuName);
			map.put("item", classHomePage);
			map.put("fileType", fileType);
			map.put("durl",durl);
			map.put("labId", typeId);
		    map.put("school_trends_c", SCHOOL_TRENDS);
			return "admin/details/labclassinfoDetail";
		}
		
		/*
		 * 修改社团简介信息
		 */
		@RequestMapping("/labintro")
		public String  labintro(int id,int labId,String labName,ModelMap map,HttpServletRequest request){
			String durl="labclassinfo";
			String introurl="labintro";
			//根据labId获取intro信息
			StudentLabMenuIntroduce studentLabMenuIntroduce=(StudentLabMenuIntroduce) labClassService.findLabMenuIntroById(labId);
			
			
			map.put("introurl", introurl);
			map.put("labId", labId);
			map.put("labName", labName);
			map.put("introduce", studentLabMenuIntroduce);
			map.put("durl",durl);
			return "admin/details/introDetail";
		}
		
		/*
		 * 修改班级简介信息
		 */
		@RequestMapping("/sclassintro")
		public String  sclassintro(int id,int labId,int grade,String className,ModelMap map,HttpServletRequest request){
			String durl="sclassHomePage";
			String introurl="sclassintro";
			//根据labId获取intro信息
			ClassSynopsis classSynopsis=(ClassSynopsis) classService.findSclassIntroById(labId);
			//获取labName即社团名称
		     String labName=grade+"年级"+className;
			
			map.put("introurl", introurl);
			map.put("labId", labId);
			map.put("labName", labName);
			map.put("grade", grade);
			map.put("className", className);
			map.put("introduce", classSynopsis);
			map.put("durl",durl);
			return "admin/details/introDetail";
		}
		
		/**
		 *校长信息
		 */
		@SuppressWarnings("unchecked")
		@RequestMapping("/headMaster")
		public String headMaster(int id,ModelMap map){
			HeadMaster h=(HeadMaster) headMasterService.findHeadMasterById(id);
			ArrayList<HeadMasterPost> post=(ArrayList<HeadMasterPost>) headMasterService.findHeadMasterPost();
			
			map.put("post", post);
			map.put("headMaster", h);
			return "admin/details/headMaster";
		}
		
		
		//修改学生信息
		@RequestMapping("/stuInfo")
		public String  stuInfo(int classId,String fullName,int id,ModelMap map,HttpServletRequest request){
			String durl="stuInfo";
			CourseStudentInfo courseStudentInfo=(CourseStudentInfo) stuInfoService.findStuInfoById(id);
			
			map.put("classId", classId);
			map.put("fullName", fullName);
			map.put("item", courseStudentInfo);
			map.put("durl",durl);
			return "admin/details/stuInfoDetail";
		}
		/**
		 * 
		 * @param classId  班级
		 * @param stuinfoId  学号
		 * @return
		 */
		@SuppressWarnings("unchecked")
		//修改学生成绩 scoreInfo
		@RequestMapping("/scoreInfo")
		public String  scoreInfo(int classId,String stuId,String addTime,String fullName,ModelMap map,HttpServletRequest request){
			String durl="scoreInfo";
			ArrayList<CourseScore> courseScore=(ArrayList<CourseScore>) courseScoreService.findScoreInfoById(classId, stuId, addTime);
			map.put("fullName", fullName);
			map.put("classId", classId);
			map.put("list", courseScore);
			map.put("durl",durl);
			return "admin/details/scoreInfoDetail";
		}
}
