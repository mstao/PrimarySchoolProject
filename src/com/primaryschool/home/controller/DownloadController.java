package com.primaryschool.home.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.primaryschool.admin.entity.FileBean;
import com.primaryschool.home.service.IBaseFileService;

/**
 * 
* @ClassName: DownloadController
* @Description: TODO 文件下载控制器
* @author Mingshan
* @date 2017年4月21日 下午4:36:44
*
 */

@Controller
@RequestMapping("/download")
public class DownloadController<T> {
	
    @Autowired
    private IBaseFileService<T> baseFileServcie;
	/**
	 * 
	* @Title: download
	* @Description: TODO 下载文件处理
	* @param @param fileName 原始文件名
	* @param @param realName 处理过后文件名
	* @return void    返回类型
	* @throws
	 */
	@RequestMapping("/file")
	public void download(String fileName,String realName,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException,ServletException, IOException{

        request.setCharacterEncoding("UTF-8");

		String userAgent = request.getHeader("User-Agent");
		System.out.println(fileName);
		//上传的文件都是保存在/Uploads/files
		String fileSaveRootPath=request.getServletContext().getRealPath( "/resources/Uploads/files" );
        System.out.println(fileSaveRootPath);
		//得到要下载的文件
		File file = new File(fileSaveRootPath +"/"+ realName);
		//如果文件不存在
		if(!file.exists()){
			
			System.out.println("文件找不到");
			return;
		}
		//针对IE或者以IE为内核的浏览器：
		if (userAgent.contains("MSIE")||userAgent.contains("Trident")) {
		 fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		 fileName = fileName.replace("+", "%20");// 处理空格变“+”的问题
		} else {
		//非IE浏览器的处理：
		fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		}
	
		/*URLEncoder.encode(fileName, "UTF-8")*/
		//设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename=\"" + fileName + "\"");
		response.setContentType( "application/x-msdownload");
		//读取要下载的文件，保存到文件输入流
		FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + realName);
		//创建输出流
		OutputStream out = response.getOutputStream();
		//创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		//循环将输入流中的内容读取到缓冲区当中
		while((len=in.read(buffer))>0){
			//输出缓冲区的内容到浏览器，实现文件下载
			out.write(buffer, 0, len);
		}
		//关闭文件输入流
		in.close();
		//关闭输出流
		out.close();
	}
	
	@RequestMapping("/fileById")
	public String downLoadById(int id,String belongType,RedirectAttributes attr,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		//request.setCharacterEncoding("UTF-8");
		
		FileBean filelist=(FileBean) baseFileServcie.findFileById(belongType,id);
		//String fileName=java.net.URLEncoder.encode(filelist.getFileName());
		String fileName=filelist.getFileName();
		String realName=filelist.getRealName();
		attr.addAttribute("fileName",fileName);
		attr.addAttribute("realName",realName);
		return "redirect:/download/file";
		//return "redirect:/download/file?fileName="+fileName+"&realName="+realName+"";
	}
}
