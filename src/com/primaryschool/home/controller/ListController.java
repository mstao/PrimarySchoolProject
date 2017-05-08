package com.primaryschool.home.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.admin.entity.CourseType;
import com.primaryschool.admin.service.IAdminCourseScoreService;
import com.primaryschool.admin.service.ICampusSceneryService;
import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.CampusScenery;
import com.primaryschool.home.entity.ClassHomePage;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.DepartmentLinkContent;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Grade;
import com.primaryschool.home.entity.HeadMaster;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Sclass;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLab;
import com.primaryschool.home.entity.StudentLabMenuContent;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.TeachingResourcesClass;
import com.primaryschool.home.entity.TeachingResourcesContent;
import com.primaryschool.home.entity.TeachingResourcesMenu;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.IClassHomePageService;
import com.primaryschool.home.service.ICultureService;
import com.primaryschool.home.service.IDepartmentLinkService;
import com.primaryschool.home.service.IEducationService;
import com.primaryschool.home.service.IGradeService;
import com.primaryschool.home.service.IHeadMasterInfoService;
import com.primaryschool.home.service.ILabClassService;
import com.primaryschool.home.service.IManageService;
import com.primaryschool.home.service.IPageHelperService;
import com.primaryschool.home.service.IPartyService;
import com.primaryschool.home.service.ISclassService;
import com.primaryschool.home.service.IStudentService;
import com.primaryschool.home.service.ITeacherService;
import com.primaryschool.home.service.ITeachingResourcesService;
import com.primaryschool.home.service.ITrendsService;
import com.primaryschool.home.service.ITypeFlagToTypeNameService;

@Controller
@RequestMapping("/list")
public class ListController<T> {
	
	@Autowired
	private ICultureService<Culture> cultureService;
	
    @Autowired
    private ITrendsService<Trends> trendsService;
	
    @Autowired
    private IEducationService<Education> educationService;
    
    @Autowired
    private IStudentService<Student> studentService;
    
    @Autowired
    private ITeacherService<Teacher>  teacherService;
    
    @Autowired
    private IPartyService<Party> partyService;
    
    @Autowired
    private IManageService<Manage> manageService;
    
    @Autowired
    private IHeadMasterInfoService<HeadMaster> headMasterService;
    
    @Autowired
	private IPageHelperService pageHelperService;
    
	@Autowired
	private ITypeFlagToTypeNameService typeFlagToTypeNameService;
	
	@Autowired
	private ILabClassService<T> labClassService;
	
	@Autowired
	private ITeachingResourcesService<T> teachingResourcesService;
	
    @Autowired
    private IClassHomePageService<ClassHomePage> classHomePageService;
    
    @Autowired
    private IGradeService<Grade> gradeService;
	
	@Autowired
	private ISclassService<Sclass> sclassService;
	
	@Autowired
	private ICampusSceneryService<T> campusSceneryService;
	
	@Autowired
	private IDepartmentLinkService<DepartmentLinkContent> departmentLinkService;
	
	@Autowired
	private IAdminCourseScoreService<T> courseScoreService;
	
	//设置每页显示的数据量
	int item_pre_page=PageSizeConfig.HOME_LIST_PAGESIZE;
	
	@RequestMapping("/trends")
	public String details(String flag, int p ,HttpServletRequest request){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="trends";
		
		//当前的url
		String url="./trends?flag='"+flag+"'&p=";
		
		//获取总记录量
		int count=trendsService.findTrendsCount(flag);
		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<Trends>  trends=(ArrayList<Trends>) trendsService.findTrendsInfo(flag, position, item_pre_page);
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findTrendsTypeNameByTypeFlag(flag);
        
        //获取该类型的热点信息
        ArrayList<Trends> hotTrends=(ArrayList<Trends>)trendsService.findHotTrendsInfo(flag, 0, PageSizeConfig.HOME_HOT_PAGESIZE);
        request.setAttribute("durl",durl);
        request.setAttribute("toolBar", toolBar);
        request.setAttribute("typeName", typeName);
        request.setAttribute("typeFlag", flag);
        request.setAttribute("item", trends);
        request.setAttribute("hotItem", hotTrends);
		return "home/list/trendsList";
	}
	
	
	@RequestMapping("/education")
	public String education(String flag, int p ,HttpServletRequest request){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="education";
		
		//当前的url
		String url="./enducation?flag='"+flag+"'&p=";
		//获取总记录量
		int count=educationService.findEducationCount(flag);
		
		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<Education>  education=(ArrayList<Education>) educationService.findEducationInfo(flag, position, item_pre_page);
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findEducationTypeNameByTypeFlag(flag);
        
        //获取该类型的热点信息
        ArrayList<Education> hotEducation=(ArrayList<Education>)educationService.findHotEducationInfo(flag, 0, PageSizeConfig.HOME_HOT_PAGESIZE);
        
        request.setAttribute("durl", durl);
        request.setAttribute("toolBar", toolBar);
        request.setAttribute("typeName", typeName);
        request.setAttribute("typeFlag", flag);
        request.setAttribute("item", education);
        request.setAttribute("hotItem", hotEducation);
		
		return "home/list/trendsList";
	}
	
	
	@RequestMapping("/student")
	public String student(String flag, int p ,HttpServletRequest request){
		
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="student";
		
		//当前的url
		String url="./student?flag='"+flag+"'&p=";
		//获取总记录量
		int count=studentService.findStudentCount(flag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<Student>  student=(ArrayList<Student>) studentService.findStudentInfo(flag, position, item_pre_page);
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findStudentTypeNameByTypeFlag(flag);
        
        //获取该类型的热点信息
        ArrayList<Student> hotStudent=(ArrayList<Student>)studentService.findHotStudentInfo(flag, 0, PageSizeConfig.HOME_HOT_PAGESIZE);
        
        request.setAttribute("durl", durl);
        request.setAttribute("student", student);
        request.setAttribute("toolBar", toolBar);
        request.setAttribute("typeName", typeName);
        request.setAttribute("typeFlag", flag);
        request.setAttribute("item", student);
        request.setAttribute("hotItem", hotStudent);
		
		return "home/list/trendsList";
	}
	
	@RequestMapping("/teacher")
	public String teacher(String flag, int p ,HttpServletRequest request){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="teacher";
		
		//当前的url
		String url="./teacher?flag='"+flag+"'&p=";
		//获取总记录量
		int count=teacherService.findTeacherCount(flag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<Teacher>  teacher=(ArrayList<Teacher>) teacherService.findTeacherInfo(flag, position, item_pre_page);
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findTeacherTypeNameByTypeFlag(flag);
        
        //获取该类型的热点信息
        ArrayList<Teacher> hotTeacher=(ArrayList<Teacher>)teacherService.findHotTeacherInfo(flag, 0, PageSizeConfig.HOME_HOT_PAGESIZE);
        
        request.setAttribute("durl", durl);
        request.setAttribute("toolBar", toolBar);
        request.setAttribute("typeName", typeName);
        request.setAttribute("typeFlag", flag);
        request.setAttribute("item", teacher);
        request.setAttribute("hotItem", hotTeacher);
		
		return "home/list/trendsList";
	}
	
	@RequestMapping("/party")
	public String party(String flag, int p ,HttpServletRequest request){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="party";
		
		//当前的url
		String url="./party?flag='"+flag+"'&p=";
		//获取总记录量
		int count=partyService.findPartyCount(flag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<Party>  party=(ArrayList<Party>) partyService.findPartyInfo(flag, position, item_pre_page);
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findPartyTypeNameByTypeFlag(flag);
        
        //获取该类型的热点信息
        ArrayList<Party> hotParty=(ArrayList<Party>)partyService.findHotPartyInfo(flag, 0, PageSizeConfig.HOME_HOT_PAGESIZE);
        
        request.setAttribute("durl", durl);
        request.setAttribute("toolBar", toolBar);
        request.setAttribute("typeName", typeName);
        request.setAttribute("typeFlag", flag);
        request.setAttribute("item", party);
        request.setAttribute("hotItem", hotParty);
        
        return "home/list/trendsList";
	}
	
	@RequestMapping("/manage")
	public String manage(String flag, int p ,HttpServletRequest request){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="manage";
		
		//当前的url
		String url="./manage?flag='"+flag+"'&p=";
		//获取总记录量
		int count=manageService.findManageCount(flag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<Manage>  manage=(ArrayList<Manage>) manageService.findManageInfo(flag, position,item_pre_page );
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findManageTypeNameByTypeFlag(flag);
        
        //获取热点信息
        ArrayList<Manage> hotManage= (ArrayList<Manage> ) manageService.findHotManageInfo(flag,  0, PageSizeConfig.HOME_HOT_PAGESIZE);
        
        request.setAttribute("durl", durl);
        request.setAttribute("toolBar", toolBar);
        request.setAttribute("typeName", typeName);
        request.setAttribute("typeFlag", flag);
        request.setAttribute("item", manage);
        request.setAttribute("hotItem", hotManage);
        return "home/list/trendsList";
	}
	
	/**
	 * 
	* @Title: heademaster
	* @Description: TODO   映射到校长信箱
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/headmaster-email")
	public String heademaster(ModelMap map){
		
		//获取校长的信息
		ArrayList<HeadMaster>  headMasterInfo=(ArrayList<HeadMaster>) headMasterService.findHeadMasterInfo();
		map.put("headMasterInfo",  headMasterInfo);
		
		return "home/list/headmaster";
	}
	
	
	@RequestMapping("/culture")
	public String culture(String flag, int p ,ModelMap map){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="culture";
		
		//当前的url
		String url="./culture?flag='"+flag+"'&p=";
		//获取总记录量
		int count=cultureService.findCultureCount(flag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<Culture>  culture=(ArrayList<Culture>) cultureService.findCultureInfo(flag, position,item_pre_page );
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findCultureTypeNameByTypeFlag(flag);
        
        //获取热点信息
        ArrayList<Culture> hotCulture= (ArrayList<Culture> ) cultureService.findHotCultureInfo(flag,  0, PageSizeConfig.HOME_HOT_PAGESIZE);
        
        map.put("durl", durl);
        map.put("toolBar", toolBar);
        map.put("typeName", typeName);
        map.put("typeFlag", flag);
        map.put("item", culture);
        map.put("hotItem", hotCulture);
        return "home/list/trendsList";
	}
	

	/**
	 * 
	* @Title: imglist
	* @Description: TODO 校园风光
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/imglist")
	public  String imglist(ModelMap map){
	    ArrayList<CampusScenery> campusScenery=(ArrayList<CampusScenery>) campusSceneryService.findCampusSceneryList();
		
	    map.put("list",campusScenery);
	    return "home/list/imageList";
	}
	

	/**
	 * 
	* @Title: classList
	* @Description: TODO 班级列表
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/class")
	public String classList(ModelMap map){
		ArrayList<Grade> grade=(ArrayList<Grade>) gradeService.findGradeCode();
		ArrayList<Sclass> sclass=(ArrayList<Sclass>) sclassService.findClassInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String formatDate = sdf.format(date);
        int d=Integer.parseInt(formatDate);
		map.put("year", d);
		map.put("sclass", sclass);
		map.put("grade", grade);
		return "/home/list/classList";
	}
	

	/**
	 * 
	* @Title: labClassList
	* @Description: TODO 综合实验课列表
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/labclass")
	public String labClassList(ModelMap map){
		
		ArrayList<StudentLab> labClass=(ArrayList<StudentLab>) labClassService.findLabClassListInfo();
		
		map.put("labClass", labClass);
		
		return "home/list/labClassList";
	}
	
	

	/**
	 * 
	* @Title: labClassMenuList
	* @Description: TODO 获取实验课子栏目的列表信息
	* @param @param id 为实验课的id
	* @param @param p
	* @param @param flag
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/labClassMenu")
	public String labClassMenuList(int id,String flag,int p,ModelMap map){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="labClassMenu";
		
		//当前的url
		String url="./labClassMenu?flag='"+flag+"'&p=";
		//获取总记录量
		int count=labClassService.findLabClassContentCount(flag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
		
        //根据typeFlag  获取 typeName
        String typeName=typeFlagToTypeNameService.findLabClassTypeNameByTypeFlag(flag);
      
        //获取信息
		ArrayList<StudentLabMenuContent>  list=(ArrayList<StudentLabMenuContent>) labClassService.findLabClassContent(id, flag, position, item_pre_page);
		
		//获取该类型的热门信息
		ArrayList<StudentLabMenuContent>  hotlist=(ArrayList<StudentLabMenuContent>) labClassService.findHotLabClassContent(id, flag, position, item_pre_page);
		
		map.put("durl", durl);
        map.put("toolBar", toolBar);
        map.put("typeName", typeName);
        map.put("typeFlag", flag);
        map.put("item", list);
        map.put("hotItem", hotlist);
        map.put("cid", id);
		return "home/list/trendsList";
	}
	
	/**
	 * 
	* @Title: teachingResources
	* @Description: TODO 教学资源列表
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/teachingResources")
	public String teachingResources(ModelMap map){
		
		//获取班级列表
		ArrayList<TeachingResourcesClass> classlist=(ArrayList<TeachingResourcesClass>)  teachingResourcesService.findTeachingResourcesClassList();
		
		//获取教学资源项目列表
		ArrayList<TeachingResourcesMenu>   menu=(ArrayList<TeachingResourcesMenu>) teachingResourcesService.findTeachingResourcesMenu();
		
		map.put("classlist", classlist);
		map.put("menu", menu);
		return "home/list/teachingResources";
	}
	
	
	/**
	 * 
	* @Title: mainClass
	* @Description: TODO 
	* @param @param classId
	* @param @param gradeFlag
	* @param @param classFlag
	* @param @param flag
	* @param @param p
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/mainClass")
	public String mainClass(int classId,int gradeFlag,String classFlag,String flag, int p ,ModelMap map){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="mainClass";
		
		//当前的url
		String url="./mainclass?classId='"+classId+"'&gradeFlag='"+gradeFlag+"'&classFlag='"+classFlag+"'&flag='"+flag+"'&p=";
		//获取总记录量
		int count=classHomePageService.findClassHomePageCount(flag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		
		//根据偏移量获取数据
		ArrayList<ClassHomePage>  mainClass=(ArrayList<ClassHomePage>) classHomePageService.findClassHomePageInfo(classId, flag, position, item_pre_page);
	   	
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
        
        //根据typeFlag获取typeName
        String typeName=typeFlagToTypeNameService.findClassTypeNameByTypeFlag(flag);
        
        //获取热点信息
        List<ClassHomePage> hotClass= (List<ClassHomePage> ) classHomePageService.findHotClasshomepageInfo(flag, position, item_pre_page);
        map.put("classId",classId);
        map.put("grade",gradeFlag);
        map.put("className",classFlag);
        map.put("durl", durl);
        map.put("toolBar", toolBar);
        map.put("typeName", typeName);
        map.put("typeFlag", flag);
        map.put("item", mainClass);
        map.put("hotItem", hotClass);
        return "home/list/mainClass";
	}
	
	/**
	 * 
	* @Title: teachingResources
	* @Description: TODO 教学资源 - 子目录 -列表
	* @param @param menuId
	* @param @param classId
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/teachingResourcesContent")
	public String teachingResourcesContent(int menuId,int classId,	String flag,int p,ModelMap map){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="teachingResources";
		
		//当前的url
		String url="./teachngResources?menuId='"+menuId+"'&classId='"+classId+"'&flag='"+flag+"'&p=";
		//获取总记录量
		int count=teachingResourcesService.findTeachingResourcesContentCount(menuId, classId, flag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		//根据flag获取name
		String typeName=typeFlagToTypeNameService.findTeachingResourcesContentTypeNameByTypeFlag(flag);
		
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
		
        //根据类型与当前页码来获取记录量
		ArrayList<TeachingResourcesContent> list=(ArrayList<TeachingResourcesContent>)teachingResourcesService.findTeachingResourcesContent(menuId, classId, flag, position, item_pre_page);
		//获取 对应的热门的记录
		
		ArrayList<TeachingResourcesContent> hotlist=(ArrayList<TeachingResourcesContent>) teachingResourcesService.findHotTeachingResourcesContent(menuId, classId, flag, position, item_pre_page);
		
		map.put("durl", durl);
        map.put("toolBar", toolBar);
        map.put("typeName", typeName);
        map.put("typeFlag", flag);
        map.put("item", list);
        map.put("hotItem", hotlist);
        map.put("menuId", menuId);
        map.put("classId", classId);
		return "home/list/teachingResourcesContentList";
	}
	
	
	
	/**
	 * 
	* @Title: teachingResources
	* @Description: TODO 部门链接列表
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@RequestMapping("/departmentLink")
	public String departmentLink(int departmentId,ModelMap map){
		
		String StaffFlag="staff";
		String JobFlag="job";
		int position=0;
		int item_per_page=PageSizeConfig.HOME_INDEX_PAGESIZE;
		//获取部门列表
		List<DepartmentLinkContent> departmentName= departmentLinkService.findDepartmentNameInfo();
		
		//获取人员设置列表
		ArrayList<DepartmentLinkContent>   departmentLinkStaff=(ArrayList<DepartmentLinkContent>) departmentLinkService.findDepartmentLinkInfo(departmentId, StaffFlag, position, item_per_page);
		
		//获取工作安排列表
		ArrayList<DepartmentLinkContent>   departmentLinkJob=(ArrayList<DepartmentLinkContent>) departmentLinkService.findDepartmentLinkInfo(departmentId, JobFlag, position, item_per_page);
		
		map.put("departmentName", departmentName);
		map.put("departmentLinkStaff", departmentLinkStaff);
		map.put("departmentLinkJob", departmentLinkJob);
		map.put("departmentId", departmentId);
		map.put("staffFlag", StaffFlag);
		map.put("jobFlag", JobFlag);
		return "home/list/departmentlink";
	}
	
	/**
	 * 
	* @Title: teachingResources
	* @Description: TODO 部门链接 - 子目录 -列表
	* @param @param menuId
	* @param @param classId
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/departmentLinkContent")
	public String departmentLinkContent(int departmentId,String contentFlag,int p,ModelMap map){
		String sp=p+"";
		if(sp.equals("")){
			p=1;
		}
		//查看详细信息url
		String durl="departmentLink";
		//当前的url
		String url="./departmentLinkContent?departmentId='"+departmentId+"'&contentFlag='"+contentFlag+"'&p=";
		//获取总记录量
		int count=departmentLinkService.findDepartmentLinkContentCount(departmentId, contentFlag);

		//计算偏移量
		int position=(p-1)*item_pre_page;
		//根据flag获取name
		String typeName=typeFlagToTypeNameService.findDepartmentLinkContentTypeNameByTypeFlag(contentFlag);
		
		//获取封装好的分页导航数据
        String toolBar=pageHelperService.createToolBar(count,item_pre_page, url, p);		
		
        //根据类型与当前页码来获取记录量
		ArrayList<DepartmentLinkContent> list=(ArrayList<DepartmentLinkContent>) departmentLinkService.findDepartmentLinkInfo(departmentId, contentFlag, position, item_pre_page);
		//获取 对应的热门的记录
		
		ArrayList<DepartmentLinkContent> hotlist= (ArrayList<DepartmentLinkContent>) departmentLinkService.findHotDepartmentLinkInfo(departmentId, contentFlag, position, item_pre_page);
	
		map.put("durl", durl);
        map.put("toolBar", toolBar);
        map.put("typeName", typeName);
        map.put("typeFlag", contentFlag);
        map.put("item", list);
        map.put("hotItem", hotlist);
        map.put("departmentId", departmentId);
		return "home/list/departmentLinkContentList";
	}
	
	/**
	 * 
	* @Title: findScore
	* @Description: TODO 查询成绩
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findScore")
	public String findScore(ModelMap map){
		String durl="findScore";
		int id = 0;
		ArrayList<Grade> grade=(ArrayList<Grade>) gradeService.findGradeCode();
		//获取考试类别
	 	ArrayList<CourseType> courseType=(ArrayList<CourseType>) courseScoreService.findCourseType();
		
	//	ArrayList<Sclass> sclass=(ArrayList<Sclass>) sclassService.findClassInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String formatDate = sdf.format(date);
        int d=Integer.parseInt(formatDate);
        //获取默认年级
        for(Grade list:grade){
        	if(list.getGradeCode()==d)
			id=list.getId();
		}
        ArrayList<Sclass> sclass=(ArrayList<Sclass>) sclassService.findClassInfoById(id);
		map.put("courseType", courseType);
        map.put("durl", durl);
        map.put("year", d);
		map.put("sclass", sclass);
		map.put("grade", grade);
		return "/home/list/findScore";
	}
	
	/**
	 * 
	* @Title: classList
	* @Description: TODO 班级列表
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/classTable")
	public String classTable(ModelMap map){
		String fileType="fstudent";
		ArrayList<Grade> grade=(ArrayList<Grade>) gradeService.findGradeCode();
		ArrayList<Sclass> sclass=(ArrayList<Sclass>) sclassService.findClassInfo();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String formatDate = sdf.format(date);
        int d=Integer.parseInt(formatDate);
		map.put("year", d);
		map.put("fileType", fileType);
		map.put("sclass", sclass);
		map.put("grade", grade);
		return "/home/list/classTable";
	}
	
	
}
