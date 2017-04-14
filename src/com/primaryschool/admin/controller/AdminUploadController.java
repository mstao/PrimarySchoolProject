package com.primaryschool.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	
	
}
