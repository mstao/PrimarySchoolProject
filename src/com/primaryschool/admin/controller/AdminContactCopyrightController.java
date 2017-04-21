package com.primaryschool.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primaryschool.admin.service.IContactService;
import com.primaryschool.admin.service.ICopyRightService;
import com.primaryschool.home.entity.Contact;
import com.primaryschool.home.entity.CopyRight;

/**
 * 
* @ClassName: AdminContactCopyrightController
* @Description: TODO 
* @author Mingshan
* @date 2017年4月20日 下午10:51:58
*
 */

@Controller
@RequestMapping("/admin")
public class AdminContactCopyrightController<T> {

	@Autowired
	private IContactService<T> contactServcie;
	
	@Autowired
	private ICopyRightService<T> copyRightService;
	
	/**
	 * 
	* @Title: contact
	* @Description: TODO 显示 联系我们
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/contact")
	public String contact(ModelMap map){
		Contact contact=(Contact) contactServcie.findContactInfo();
		
		map.put("contact", contact);
		return "admin/contact/contact";
	}
	
	/**
	 * 
	* @Title: copyright
	* @Description: TODO 显示版权说明
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/copyright")
	public String copyright(ModelMap map){
		
		CopyRight  copyRight=(CopyRight)copyRightService.findCopyRightInfo();
		
		map.put("copyRight", copyRight);
		return "admin/copyright/copyright";
	}
	
	/**
	 * 
	* @Title: editContact
	* @Description: TODO  编辑联系我们
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/editContact")
	public String editContact(ModelMap map){
        Contact contact=(Contact) contactServcie.findContactInfo();
		
		map.put("contact", contact);
		return "admin/write/writeContact";
	}
	
	
	/**
	 * 
	* @Title: dealEditContact
	* @Description: TODO 处理修改  ，添加联系我们
	* @param @param contact
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/dealEditContact")
	@ResponseBody
	public String dealEditContact(Contact contact){
		//判断id是否有值
		int id=contact.getId();
		String sid=id+"";
		
		int result;
		//如果没有值，代表将要进行添加操作
		if(sid.equals("0")){
			result=contactServcie.saveContactInfo((T)contact);	
		}else{
			//进行修改操作
			boolean r=contactServcie.updateContactInfo((T)contact);
			if(r==true){
				result=1;
			}else{
				result=0;
			}
		}
		
	
		
		return result+"";
	}
	/**
	 * 
	* @Title: editCopyright
	* @Description: TODO 编辑版权说明
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@RequestMapping("/editCopyRight")
	public String editCopyright(ModelMap map){
		CopyRight  copyRight=(CopyRight)copyRightService.findCopyRightInfo();
		
		map.put("copyRight", copyRight);
		return "admin/write/writeCopyRight";
	}
	
	/**
	 * 
	* @Title: dealEditCopyRight
	* @Description: TODO 处理添加与修改
	* @param @param copyRight
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/dealEditCopyRight")
	@ResponseBody
	public String dealEditCopyRight(CopyRight copyRight){
		//判断id是否有值
		int id=copyRight.getId();
		String sid=id+"";
		
		int result;
		//如果没有值，代表将要进行添加操作
		if(sid.equals("0")){
			result=copyRightService.saveCopyRightInfo((T) copyRight);
		}else{
			//进行修改操作
			boolean r=copyRightService.updateCopyRightInfo((T) copyRight);
			if(r==true){
				result=1;
			}else{
				result=0;
			}
		}
					
		return result+"";
	}
}
