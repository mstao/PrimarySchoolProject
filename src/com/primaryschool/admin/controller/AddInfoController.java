package com.primaryschool.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.entity.SecurityRole;
import com.primaryschool.admin.service.IAdminCultureService;
import com.primaryschool.admin.service.IAdminDepartmentService;
import com.primaryschool.admin.service.IAdminEducationService;
import com.primaryschool.admin.service.IAdminHeaderMasterService;
import com.primaryschool.admin.service.IAdminIndexImagesService;
import com.primaryschool.admin.service.IAdminLabClassService;
import com.primaryschool.admin.service.IAdminManageService;
import com.primaryschool.admin.service.IAdminPartyService;
import com.primaryschool.admin.service.IAdminSclassService;
import com.primaryschool.admin.service.IAdminStudentService;
import com.primaryschool.admin.service.IAdminTeacherService;
import com.primaryschool.admin.service.IAdminTeachingResourceService;
import com.primaryschool.admin.service.IAdminTrendsService;
import com.primaryschool.admin.service.IAuthorityService;
import com.primaryschool.admin.service.ICampusSceneryService;
import com.primaryschool.home.entity.CampusScenery;
import com.primaryschool.home.entity.ClassHomePage;
import com.primaryschool.home.entity.ClassSynopsis;
import com.primaryschool.home.entity.Culture;
import com.primaryschool.home.entity.DepartmentLinkContent;
import com.primaryschool.home.entity.DepartmentLinkNameList;
import com.primaryschool.home.entity.Education;
import com.primaryschool.home.entity.HeadMaster;
import com.primaryschool.home.entity.IndexImages;
import com.primaryschool.home.entity.Manage;
import com.primaryschool.home.entity.Party;
import com.primaryschool.home.entity.Sclass;
import com.primaryschool.home.entity.Student;
import com.primaryschool.home.entity.StudentLab;
import com.primaryschool.home.entity.StudentLabMenuContent;
import com.primaryschool.home.entity.StudentLabMenuIntroduce;
import com.primaryschool.home.entity.Teacher;
import com.primaryschool.home.entity.TeachingResourcesContent;
import com.primaryschool.home.entity.TeachingResourcesMenu;
import com.primaryschool.home.entity.Trends;
import com.primaryschool.home.service.ITypeFlagToTypeIdService;

/**
 * 
* @ClassName: AddInfoServlet
* @Description: TODO 添加信息控制器
* @author Mingshan
* @date 2017年4月14日 下午3:35:40
*
 */

@Controller
@RequestMapping("/admin/add")
public class AddInfoController<T> {
    @Autowired
    private IAdminTrendsService<T> trendsService;
	
    @Autowired
    private IAdminIndexImagesService<T> indexImagesService;
    
    @Autowired
    private ICampusSceneryService<T> campusSceneryService;

	
    @Autowired
    private IAuthorityService<T> authorityService;
    
    //////////////////////
	@Autowired
	private IAdminCultureService<T> cultureService;
	
   
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
   private IAdminSclassService<T> sclassService;
   
   @Autowired
   private IAdminDepartmentService<T> departmentService;
   
   @Autowired
   private IAdminTeachingResourceService<T> teachingResourcesService;
   
   @Autowired
   private IAdminLabClassService<T> labClassService;
	
   @Autowired
   private ITypeFlagToTypeIdService typeFlagToTypeIdService; 
    
   @Autowired 
   private IAdminHeaderMasterService<T> headMasterService;
    
    /**
     * 
    * @Title: addIndexImages
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param indexImages
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/indexImages")
    @ResponseBody
	public String addIndexImages(IndexImages indexImages){
    	
    	int result=indexImagesService.addImage((T)indexImages);

    	return result+"";
    	
    }
    
    /**
     * 
    * @Title: addCampusScenery
    * @Description: TODO 添加校园风光
    * @param @param campusScenery
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    
    @SuppressWarnings("unchecked")
	@RequestMapping("/campusScenery")
    @ResponseBody
    public String addCampusScenery(CampusScenery campusScenery){
    	int result =campusSceneryService.saveCampusScenery((T)campusScenery);
    	return result+"";
    }
    
    /**
     * 
    * @Title: saveRole
    * @Description: TODO 添加角色
    * @param @param role
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    @SuppressWarnings("unchecked")
  	@RequestMapping("/role")
    @ResponseBody
    public String saveRole(SecurityRole role){
    	int result =authorityService.saveRole((T) role);
    	return result+"";
    }
    
    
    /**
   	 * 
   	* @Title: addTrends
   	* @Description: TODO 添加 校园动态
   	* @param @param trends
   	* @param @return    设定文件
   	* @return String    返回类型
   	* @throws
   	 */
       
    @SuppressWarnings("unchecked")
   	@RequestMapping("/culture")
    @ResponseBody
   	public  String addCulture(Culture culture){
    	   
    	System.out.println("---Type---"+culture.getItemTypeFlag());
    	   
       	//由typeFlag获取typeid
       	int typeId=typeFlagToTypeIdService.findCultureTypeIdByTypeFlag(culture.getItemTypeFlag());
       	//赋值
       	culture.setTypeId(typeId);
       	
       	int result= cultureService.addCultureInfo((T) culture);
   		return result+"";
   	}
   	
       
   	/**
   	 * 
   	* @Title: addTrends
   	* @Description: TODO 添加 校园动态
   	* @param @param trends
   	* @param @return    设定文件
   	* @return String    返回类型
   	* @throws
   	 */
       @SuppressWarnings("unchecked")
      	@RequestMapping("/trends")
          @ResponseBody
      	public  String addTrends(Trends trends){
          	
          	//由typeFlag获取typeid
          	int typeId =typeFlagToTypeIdService.findTrendsTypeIdByTypeFlag(trends.getItemTypeFlag());

          	//赋值
          	trends.setTypeId(typeId);
          	
          	int result= trendsService.addTrendsInfo((T)trends);
      		return result+"";
      	}
       
       
       @SuppressWarnings("unchecked")
   	@RequestMapping("/education")
       @ResponseBody
   	public  String addEducation(Education education){
       	
       	//由typeFlag获取typeid
       	int typeId =typeFlagToTypeIdService.findEducationTypeIdByTypeFlag(education.getItemTypeFlag());

       	//赋值
       	education.setTypeId(typeId);
       	
       	int result= educationService.addEducationInfo((T)education);
   		return result+"";
   	}
       
       @SuppressWarnings("unchecked")
   	@RequestMapping("/student")
       @ResponseBody
   	public  String addStudent(Student student){
       	
       	//由typeFlag获取typeid
       	int typeId =typeFlagToTypeIdService.findStudentTypeIdByTypeFlag(student.getItemTypeFlag());

       	//赋值
       	student.setTypeId(typeId);
       	
       	int result= studentService.addStudentInfo((T)student);
   		return result+"";
   	}
       
       @SuppressWarnings("unchecked")
   	@RequestMapping("/teacher")
       @ResponseBody
   	public  String addTeacher(Teacher teacher){
       	
       	//由typeFlag获取typeid
       	int typeId =typeFlagToTypeIdService.findTeacherTypeIdByTypeFlag(teacher.getItemTypeFlag());

       	//赋值
       	teacher.setTypeId(typeId);
       	
       	int result= teacherService.addTeacherInfo((T)teacher);
   		return result+"";
   	}
       
       @SuppressWarnings("unchecked")
   	@RequestMapping("/party")
       @ResponseBody
   	public  String addParty(Party party){
       	
       	//由typeFlag获取typeid
       	int typeId =typeFlagToTypeIdService.findPartyTypeIdByTypeFlag(party.getItemTypeFlag());

       	//赋值
       	party.setTypeId(typeId);
       	
       	int result= partyService.addPartyInfo((T)party);
   		return result+"";
   	}
       
       @SuppressWarnings("unchecked")
   	@RequestMapping("/manage")
       @ResponseBody
   	public  String addManage(Manage manage){
       	
       	//由typeFlag获取typeid
       	int typeId =typeFlagToTypeIdService.findManageTypeIdByTypeFlag(manage.getItemTypeFlag());

       	//赋值
       	manage.setTypeId(typeId);
       	
       	int result= manageService.addManageInfo((T)manage);
   		return result+"";
   	}
       
       @SuppressWarnings("unchecked")
   	@RequestMapping("/resource")
       @ResponseBody
   	public  String addResource(String typeFlag,TeachingResourcesContent teachingResourcesContent){
       	
       	//由typeFlag获取typeid
       	int typeId =typeFlagToTypeIdService.findTeachingResourcesTypeIdByTypeFlag(typeFlag);
       	//赋值
       	teachingResourcesContent.setTypeId(typeId);
       	
       	int result= teachingResourcesService.addTeachingResourceInfo((T)teachingResourcesContent);
   		return result+"";
   	}
       
       /**添加教学资源类别Menu**/
       @SuppressWarnings("unchecked")
      	@RequestMapping("/manageResource")
       @ResponseBody
      	public  String manageResource(TeachingResourcesMenu teachingResourcesMenu){
          	int result= teachingResourcesService.addTeachingResourceMenuInfo((T)teachingResourcesMenu);
      		return result+"";
      	}
       
       //部门发布新信息
       @SuppressWarnings("unchecked")
   	@RequestMapping("/department")
       @ResponseBody
   	public  String addDepartment(String typeFlag,DepartmentLinkContent departmentLinkContent){
       	//由typeFlag获取typeid
       	int typeId =departmentService.findDepartmentTypeIdByTypeFlag(typeFlag);
       	//赋值
       	departmentLinkContent.setTypeId(typeId);
       	
       	int result= departmentService.addDepartmentContent((T)departmentLinkContent);
   		return result+"";
   	}
       
       /**添加教学资源类别Menu**/
       @SuppressWarnings("unchecked")
      	@RequestMapping("/manageDepartment")
       @ResponseBody
      	public  String manageDepartment(String resourceName,DepartmentLinkNameList departmentLinkNameList){
       	departmentLinkNameList.setDepartmentName(resourceName);
          	int result= departmentService.addDepartmentName((T)departmentLinkNameList);
      		return result+"";
      	}
   	
       @SuppressWarnings("unchecked")
   	@RequestMapping("/labclassinfo")
       @ResponseBody
   	public  String addLabclassinfo(String typeFlag,StudentLabMenuContent studentLabMenuContent){
       	
       	//由typeFlag获取typeid
       	int typeId =typeFlagToTypeIdService.findLabClassMenuIdByTypeFlag(typeFlag);
       	//赋值
       	studentLabMenuContent.setMenuId(typeId);
       	
       	int result= labClassService.addLabClassInfo((T)studentLabMenuContent);
   		return result+"";
   	}
       
       
       @SuppressWarnings("unchecked")
   	@RequestMapping("/sclassHomePage")
       @ResponseBody
   	public  String addLabclassinfo(int labId,String typeFlag,String author,ClassHomePage classHomePage){
       	
       	//由typeFlag获取typeid
       	int typeId=sclassService.findPageTypeIdByTypeFlag(typeFlag);
       	//赋值
       	classHomePage.setClassId(labId);
       	classHomePage.setTypeId(typeId);
       	classHomePage.setItemAuthor(author);
       	
       	int result= sclassService.addSclassInfo((T)classHomePage);
   		return result+"";
   	}
       
       
       /**添加班级简介**/
       @SuppressWarnings("unchecked")
   	@RequestMapping("/sclassintro")
       @ResponseBody
   	public  String sclassintro(String intro,int foreignId,ClassSynopsis classSynopsis){
       	classSynopsis.setClassSynopsis(intro);
       	classSynopsis.setClassId(foreignId);
       	int result= sclassService.addSclassIntro((T)classSynopsis);
   		return result+"";
   	}
       
       
       /**添加社团简介**/
       @SuppressWarnings("unchecked")
   	@RequestMapping("/labintro")
       @ResponseBody
   	public  String labintro(String intro,int foreignId,StudentLabMenuIntroduce studentLabMenuIntroduce){
       	studentLabMenuIntroduce.setIntroduce(intro);
       	studentLabMenuIntroduce.setMenuId(foreignId);
       	int result= labClassService.addLabClassInfo((T)studentLabMenuIntroduce);
   		return result+"";
   	}
       
       //添加社团
       @SuppressWarnings("unchecked")
   	@RequestMapping("/managelablist")
       @ResponseBody
   	public  String managelablist(StudentLab studentLab){
       	int result= labClassService.addLabInfo((T)studentLab);
   		return result+"";
   	}
       
    //添加班级
    @SuppressWarnings("unchecked")
   	@RequestMapping("/manageSclass")
    @ResponseBody
   	public  String manageSclass(int gradeCode,Sclass sclass){
       	sclassService.addGradeInfo();
       	//根据gradeCode获取id
       	int gradeId=sclassService.findGradeIdByCode(gradeCode);
       	sclass.setGradeId(gradeId);
       	
       	int result= sclassService.addSclass((T)sclass);
   		return result+"";
   	}
    
    /**
     * 
    * @Title: headMaster
    * @Description: TODO 添加校长信息
    * @param @param headMaster
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/headMaster")
    @ResponseBody
	public String headMaster(HeadMaster headMaster){
    
    	int result=headMasterService.saveHeadMaster((T) headMaster);
    	return result+"";
    }
    
}
