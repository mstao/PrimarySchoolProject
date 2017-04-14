package com.primaryschool.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * 
* @ClassName: AdminUploadController
* @Description: TODO 后台上传控制器
* @author Mingshan
* @date 2017年4月14日 下午10:26:07
*
 */

@Controller
@RequestMapping("/admin/upload")
public class AdminUploadController {

	/**
	 * 
	* @Title: uploadpic
	* @Description: TODO 编辑器上传图片
	* @param @param myEditorImgName
	* @param @param request
	* @param @param response
	* @param @throws ServletException
	* @param @throws IOException    设定文件
	* @return void    返回类型
	* @throws
	 */
	@RequestMapping("/uploadpic")
	public void uploadpic(MultipartFile myEditorImgName,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	        response.setContentType("textml;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
		    String fi = myEditorImgName.getOriginalFilename();
	        // 提取文件拓展名
	        String fileNameExtension = fi.substring(fi.lastIndexOf("."), fi.length());
	       //  文件类型限制
	        String[] allowedType = { ".bmp", ".gif", ".jpeg", ".png",".jpg"};
	        boolean allowed = Arrays.asList(allowedType).contains(fileNameExtension);
	        if (!allowed) {
	            response.getWriter().write("error|不支持的类型,仅支持{bmp,gif,jpeg,png,jpg}类型图片");
	            return;
	        }
	        // 生成实际存储的真实文件名
	        String realName = UUID.randomUUID().toString() + fileNameExtension;
	        // 图片存放的真实路径
	        String realPath = request.getServletContext().getRealPath("/resources/Uploads/images") + "/" + realName;
	        System.out.println(realPath);
	        // 将文件写入指定路径下
	        myEditorImgName.transferTo(new File(realPath));
	        // 返回图片的URL地址
	        response.getWriter().write(request.getContextPath() + "/resources/Uploads/images/" + realName);
      
	}
	
	/**
	 * 
	* @Title: uploadFile
	* @Description: TODO 插件上传文件
	* @param @param request
	* @param @param response
	* @param @throws ServletException
	* @param @throws IOException    设定文件
	* @return void    返回类型
	* @throws
	 */
	@RequestMapping(value="/uploadfile",method=RequestMethod.POST)
	public void  uploadFile( HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException{
		    // 从request中取时, 以UTF-8编码解析
			request.setCharacterEncoding( "UTF-8" );
			String fileName = null;
	     
	
			// 获取上传文件存放的 目录 , 无则创建
			String path = request.getServletContext().getRealPath( "/resources/Uploads/files" );
			System.out.println("path : " + path);

			new java.io.File( path ).mkdir();
		
	        MultipartHttpServletRequest multipartRequest =(MultipartHttpServletRequest) request;
	        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap(); 
	        
	        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {    
                // 上传文件名    
                System.out.println("key: " + entity.getKey());    
                MultipartFile mf = entity.getValue();    
                
                //获取原始文件名
                fileName = mf.getOriginalFilename();  
                // 返回一个随机UUID
                String uuid = UUID.randomUUID().toString().replaceAll("\\-", "");
                String suffix = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf("."), fileName.length()) : null;
                // 构成新文件名
                String newFileName =uuid + (suffix!=null?suffix:"");
                File uploadFile = new File(path, newFileName); 
                
	            try {  
	                    FileCopyUtils.copy(mf.getBytes(), uploadFile); 
	                    String filePath =path+newFileName;
	                    System.out.println(filePath);
	                    //将信息写到数据库
	            } catch (IOException e) {  
	            	System.out.println("上传失败");
	                e.printStackTrace();  
	            }    
            }   
	       
	}
	
	
	
}
