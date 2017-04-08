package com.primaryschool.home.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.HeadMaster;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLab;
import com.primaryschool.home.entity.StudentLabMenuContent;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.TeachingResourcesClass;
import com.primaryschool.home.entity.TeachingResourcesMenu;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.ICultureService;
import com.primaryschool.home.service.IEducationService;
import com.primaryschool.home.service.IHeadMasterInfoService;
import com.primaryschool.home.service.ILabClassService;
import com.primaryschool.home.service.IManageService;
import com.primaryschool.home.service.IPageHelperService;
import com.primaryschool.home.service.IPartyService;
import com.primaryschool.home.service.IStudentService;
import com.primaryschool.home.service.ITeacherService;
import com.primaryschool.home.service.ITeachingResourcesService;
import com.primaryschool.home.service.ITrendsService;
import com.primaryschool.home.service.ITypeFlagToTypeNameService;
import com.primaryschool.home.service.impl.LabClassService;

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
		String url="./list/trends?flag='"+flag+"'&p=";
		
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
		String url="./list/enducation?flag='"+flag+"'&p=";
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
		String url="./list/student?flag='"+flag+"'&p=";
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
		String url="./list/teacher?flag='"+flag+"'&p=";
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
		String url="./list/party?flag='"+flag+"'&p=";
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
		String url="./list/manage?flag='"+flag+"'&p=";
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
		String url="./list/culture?flag='"+flag+"'&p=";
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
	
	//校园风光
	@RequestMapping("/imglist")
	public  String imglist(ModelMap map){
		return "home/list/imageList";
	}
	
	//班级列表
	@RequestMapping("/class")
	public String classList(ModelMap map){
		
		
		return "home/list/classList";
	}
	
	//综合实验课列表
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
		String url="./list/labClassMenu?flag='"+flag+"'&p=";
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
		/*ArrayList<TeachingResourcesClass> classlist=(ArrayList<TeachingResourcesClass>)  teachingResourcesService.findTeachingResourcesClassList();
		
		//获取教学资源项目列表
		ArrayList<TeachingResourcesMenu>   menu=(ArrayList<TeachingResourcesMenu>) teachingResourcesService.findTeachingResourcesMeun();
		
		map.put("classlist", classlist);*/
		return "home/list/teachingResources";
	}
	
}
