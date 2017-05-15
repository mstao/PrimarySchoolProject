
package com.primaryschool.home.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.primaryschool.global.config.PageSizeConfig;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLab;
import com.primaryschool.home.entity.StudentLabMenuContent;
import com.primaryschool.home.entity.StudentLabMenuIntroduce;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.TeachingResourcesContent;
import com.primaryschool.home.entity.Trends;
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
* @ClassName: CategoryController
* @Description: TODO  类别分发控制器
* @author Mingshan
 * @param <T>
* @date 2017年3月28日 下午6:15:30
*
*/

@Controller
@RequestMapping("/category")
public class CategoryController<T> {
    
	@Autowired  
	private ITrendsService<Trends> trendsService;
	
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
	private ICultureService<Culture> cultureService;
	
	@Autowired
	private ILabClassService<T>  labClassService;
	
	@Autowired
	private ITeachingResourcesService<T> teachingResourcesService;
	
	private int pageSize=PageSizeConfig.HOME_CATEGORY_PAGESIZE;
	private int slidePageSize=PageSizeConfig.HOME_SLIDE_PAGESIZE;
	
	/**
	 * 
	* @Title: trends
	* @Description: TODO 校园动态
	* @param @param model
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
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
		
		//获取轮播
		//获取校内新闻  图片轮播   --新闻
		ArrayList<Trends> slideNews=(ArrayList<Trends>) trendsService.findSlideTrendsInfo(newsFlag, 0, slidePageSize);

		model.put("hotTrends", hotTrends);
		model.put("news", news);
		model.put("notice", notice);
		model.put("newsFlag", newsFlag);
		model.put("noticeFlag", noticeFlag);
		model.put("slideNews", slideNews);
		
		return "home/category/trends";
	}
	
	/**
	 * 
	* @Title: education
	* @Description: TODO 阳光德育
	* @param @param model
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
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
		
		//获取阳光德育 图片轮播 --主题教育
		ArrayList<Education>  slideEdu=(ArrayList<Education>)educationService.findSlideTrendsInfo(educationFlag,  0, slidePageSize);
		
		model.put("education", education);
		model.put("speak", speak);
		model.put("active", active);
		model.put("parents", parents);
		model.put("stagent", stagent);
		model.put("slideEdu", slideEdu);
		
		model.put("educationFlag", educationFlag);
		model.put("activeFlag", activeFlag);
		model.put("speakFlag", speakFlag);
		model.put("parentsFlag", parentsFlag);
		model.put("stagentFlag", stagentFlag);
		
		return "home/category/education";
	}
	
	/**
	 * 
	* @Title: student
	* @Description: TODO 学生天地
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
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
		
		//获取学生天地轮播   --活动风采
		ArrayList<Student>  slideStudent=(ArrayList<Student>) studentService.findSliderStudentInfo("activity", 0, slidePageSize);
		
		map.put("bookFlag", bookFlag);
		map.put("activityFlag", activityFlag);
		map.put("labFlag", labFlag);
		map.put("slideStudent", slideStudent);
		
		map.put("book", book);
		map.put("activity", activity);
		map.put("lab", lab);
		
		return "home/category/student";
	}
	
	/**
	 * 
	* @Title: teacher
	* @Description: TODO 教师园地
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/teacher")
	public String  teacher(ModelMap map){
		String resourcesFlag="resources";
		String teachersFlag="teachers";
		String trainFlag="train";
		String prizeFlag="prize";
		
		//获取教学资源
		ArrayList<Teacher> resources=(ArrayList<Teacher>)teacherService.findTeacherInfo(resourcesFlag, 0, pageSize);
		
		//获取教师风采
		ArrayList<Teacher> teachers=(ArrayList<Teacher>)teacherService.findTeacherInfo(teachersFlag, 0, pageSize);
		
		//获取教师培训
		ArrayList<Teacher> train=(ArrayList<Teacher>)teacherService.findTeacherInfo(trainFlag, 0, pageSize);
				
		//获取获奖登记
		ArrayList<Teacher> prize=(ArrayList<Teacher>)teacherService.findTeacherInfo(prizeFlag, 0, pageSize);
						
		//获取教师园地轮播图 --教师风采
		ArrayList<Teacher>  slideTeacher=(ArrayList<Teacher>) teacherService.findSliderTreacherInfo("teachers", 0, slidePageSize);
		
		
		map.put("resourcesFlag", resourcesFlag);
		map.put("teachersFlag", teachersFlag);
		map.put("trainFlag", trainFlag);
		map.put("prizeFlag", prizeFlag);
		map.put("slideTeacher", slideTeacher);
		
		
		map.put("resources", resources);
		map.put("teachers", teachers);
		map.put("train", train);
		map.put("prize", prize);
		
		return "home/category/teacher";
	}
	
	/**
	 * 
	* @Title: party
	* @Description: TODO 党务工会
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/party")
	public String party(ModelMap map){
		String branchFlag="branch";
		String tradeUnionFlag="trade_union";
		
		//获取热门
		ArrayList<Party>  hotBranch=(ArrayList<Party>) partyService.findHotPartyInfo(branchFlag, 0, pageSize);
		
		//获取支部活动
		ArrayList<Party>  branch=(ArrayList<Party>) partyService.findPartyInfo(branchFlag, 0, pageSize);
		
		//获取工会活动
		ArrayList<Party>  tradeUnion=(ArrayList<Party>) partyService.findPartyInfo(tradeUnionFlag, 0, pageSize);
	
		//轮播 图  --支部活动
		ArrayList<Party>  sildeParty=(ArrayList<Party>) partyService.findSliderPartyInfo(branchFlag,  0, slidePageSize);
	    
		map.put("branchFlag", branchFlag);
	    map.put("tradeUnionFlag", tradeUnionFlag);
	    
	    map.put("hotBranch", hotBranch);
	    map.put("branch", branch);
	    map.put("tradeUnion",tradeUnion);
	    map.put("sildeParty", sildeParty);
	    return "home/category/party";
	}
	
	/**
	 * 
	* @Title: manage
	* @Description: TODO 学校管理
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/manage")
	public String manage(ModelMap map){
		
		String departmentFlag="department";
		String recommendationFlag="recommendation";
		String noticeFlag="notice";
		String rulesFlag="rules";
		
		//获取部门链接
		ArrayList<Manage>  department=(ArrayList<Manage>) manageService.findManageInfo(departmentFlag, 0, pageSize);
	
	    //获取评职评优
		ArrayList<Manage>  recommendation=(ArrayList<Manage>) manageService.findManageInfo(recommendationFlag, 0, pageSize);
	
	    //获取教师会议
		ArrayList<Manage>  notice=(ArrayList<Manage>) manageService.findManageInfo(noticeFlag, 0, pageSize);
		
		//获取规章制度
		
		ArrayList<Manage>  rules=(ArrayList<Manage>) manageService.findManageInfo(rulesFlag, 0, pageSize);
	
		//轮播
		ArrayList<Manage> slideManage= (ArrayList<Manage>) manageService.findSliderManageInfo(noticeFlag, 0, slidePageSize);
	    
		map.put("departmentFlag", departmentFlag);
	    map.put("recommendationFlag",recommendationFlag);
	    map.put("noticeFlag", noticeFlag);
	    map.put("rulesFlag", rulesFlag);
	    
	    map.put("department", department);
	    map.put("recommendation", recommendation);
	    map.put("notice", notice);
	    map.put("rules", rules);
	    map.put("slideManage", slideManage);
	    
	    return "home/category/manage";
	}
	
	
	/**
	 * 
	* @Title: culture
	* @Description: TODO 学校文化列表
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/culture")
	public String culture(ModelMap map){
		String introduceFlag="introduce";
		String affairsFlag="affairs";
		
		//获取学校介绍
		ArrayList<Culture> introduce=(ArrayList<Culture>) cultureService.findCultureInfo(introduceFlag,  0, pageSize);
		
		//获取校务公开
		ArrayList<Culture> affairs=(ArrayList<Culture>) cultureService.findCultureInfo(affairsFlag,  0, pageSize);
		
		//获取热门
		ArrayList<Culture> hot=(ArrayList<Culture>) cultureService.findHotCultureInfo(introduceFlag, 0, pageSize);
		
		//轮播
		ArrayList<Culture> slideContent=(ArrayList<Culture>) cultureService.findSliderCultureInfo(introduceFlag, 0, slidePageSize);
		
		map.put("introduceFlag", introduceFlag);
		map.put("affairsFlag", affairsFlag);
		
		map.put("introduce", introduce);
		map.put("affairs", affairs);
		map.put("hot", hot);
		map.put("slideContent",slideContent);
		
		return "home/category/culture";
	}
	
	

	/**
	 * 
	* @Title: labClass
	* @Description: TODO综合实验课 详细信息
	* @param @param id 为实验课的id
	* @param @param map
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/labclass")
	public String labClass(int id,ModelMap map){
		String topicFlag="topic";
		String showFlag="show";
		//获取实验课简介
	    StudentLabMenuIntroduce introduce=(StudentLabMenuIntroduce)labClassService.findLabClassIntroduce(id);
		//获取实验课-每周主题列表

		ArrayList<StudentLabMenuContent> content=(ArrayList<StudentLabMenuContent>)labClassService.findLabClassContent(id,topicFlag, 0, pageSize);
		
		//获取实验课-成果展示列表
		ArrayList<StudentLabMenuContent> show=(ArrayList<StudentLabMenuContent>)labClassService.findLabClassContent(id,showFlag, 0, pageSize);
		
		//根据id获取实验课名称
		StudentLab labname=(StudentLab)labClassService.findLabClassNameById(id);
		
		//获取 轮播  --成果展示 
		ArrayList<StudentLabMenuContent> slideContent=(ArrayList<StudentLabMenuContent>) labClassService.findSliderLabClassContent(id, 0, slidePageSize);
		
		map.put("topicFlag", topicFlag);
		map.put("showFlag", showFlag);
		
		map.put("slideContent", slideContent);
		map.put("introduce", introduce);
		map.put("content", content);
		map.put("show", show);
		map.put("labname", labname);
		map.put("id", id);
		
		return "home/category/labclass";
		
	}
	
	/**
	 * 
	* @Title: teachingResources
	* @Description: TODO 教学资源
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/teachingResources")
	public  String teachingResources(int classId,int menuId,ModelMap map){
		String discussFlag="discuss";
		String designFlag="design";
		String coursewareFlag="courseware";
		String microlectureFlag="microlecture";
		String questionBankFlag="question-bank";
		
		//获取教学研讨
		ArrayList<TeachingResourcesContent> discuss=(ArrayList<TeachingResourcesContent>)teachingResourcesService.findTeachingResourcesContent(menuId, classId, discussFlag, 0, pageSize);
		
		//获取教学设计
		ArrayList<TeachingResourcesContent> design=(ArrayList<TeachingResourcesContent>)teachingResourcesService.findTeachingResourcesContent(menuId, classId, designFlag, 0, pageSize);
		
		//课件
		ArrayList<TeachingResourcesContent> courseware=(ArrayList<TeachingResourcesContent>)teachingResourcesService.findTeachingResourcesContent(menuId, classId, coursewareFlag, 0, pageSize);
		
		//微课
		ArrayList<TeachingResourcesContent> microlecture=(ArrayList<TeachingResourcesContent>)teachingResourcesService.findTeachingResourcesContent(menuId, classId, microlectureFlag, 0, pageSize);
		
		//题库
		ArrayList<TeachingResourcesContent> questionBank=(ArrayList<TeachingResourcesContent>)teachingResourcesService.findTeachingResourcesContent(menuId, classId, questionBankFlag, 0, pageSize);
		
		//教学资源  轮播图 --教学研讨
		ArrayList<TeachingResourcesContent>  slideContent=(ArrayList<TeachingResourcesContent>) teachingResourcesService.findSliderTeachingResourcesContent(menuId, classId, 0, slidePageSize);
		//年级名称
		String className=teachingResourcesService.findTeachingResourcesClassNameByClassId(classId);
		
		String menuName=teachingResourcesService.findTeachingResourcesMenuNameByMenuId(menuId);
		
		
		map.put("discussFlag", discussFlag);
		map.put("designFlag", designFlag);
		map.put("coursewareFlag", coursewareFlag);
		map.put("microlectureFlag", microlectureFlag);
		map.put("questionBankFlag", questionBankFlag);
		
		
		map.put("discuss", discuss);
		map.put("design", design);
		map.put("courseware", courseware);
		map.put("microlecture", microlecture);
		map.put("questionBank", questionBank);
		map.put("slideContent", slideContent);
		
		
		map.put("className", className);
		map.put("menuName", menuName);
		
		map.put("classId", classId);
		map.put("menuId",menuId);
		return "home/category/teachingResources";
	}
}
