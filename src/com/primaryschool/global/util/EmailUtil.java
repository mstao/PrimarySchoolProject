package com.primaryschool.global.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.primaryschool.admin.entity.SecurityUser;
import com.primaryschool.apply.entity.ApplyUser;
import com.primaryschool.global.config.mailAccountConfig;

public class EmailUtil<T> extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  <T> String sendEmail(SecurityUser t,String email,String key,HttpServletRequest request){
		  String account=mailAccountConfig.account;
	      String password=mailAccountConfig.passWord;
          // 指定发送邮件的主机为 localhost
	      //String host = "smtp.qq.com";  //QQ 邮件服务器
	      String host="smtp.163.com";  //163 邮件服务器
	      // 获取系统属性
	      Properties properties = System.getProperties();

	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);

	      properties.put("mail.smtp.auth", "true");
	      //加入ssl验证
	      properties.put("mail.smtp.ssl.enable", "true");
          //验证写信者邮箱,此处使用第三方授权码登陆
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
		    public PasswordAuthentication getPasswordAuthentication()
		    {
		     return new PasswordAuthentication(account, password); //发件人邮件用户名、密码
		    }
		   });
         try{
            //填写信封写信    
            Message msg = new MimeMessage(session);    
            //设置发邮件的原地址    
            msg.setFrom(new InternetAddress(account));    
            //设置接收人    
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
            msg.setSubject("找回密码!");    
            msg.setText(createLink(t,key,request));    
            //验证用户名密码发送邮件    
             
            Transport.send(msg);    
            return "1";    
                   
           }catch(Exception e){    
            e.printStackTrace(); 
            return "0";
           }    
	}
	
	public   String createLink(SecurityUser t,String key,HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{    
		   
	      
	   //    String key = "$" + date + "$" + secretKey;  
	/*	 //生成密钥    
	    String secretKey=UUID.randomUUID().toString();    
	    //设置过期时间    
	    Date outDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);// 30分钟后过期    
	    System.out.println(System.currentTimeMillis()); 
	    
	    long date =outDate.getTime() / 1000 * 1000;// 忽略毫秒数  mySql 取出时间是忽略毫秒数的    
	    System.out.println(date);   
	     //此处应该更新Studentinfo表中的过期时间、密钥信息    
	    user.setOutDate(date);    
	    user.setValidataCode(secretKey);   
	    
	    
	    userService.updateUser(user);
	    //将用户名、过期时间、密钥生成链接密钥    
	    String key =user.getId() + "$" + date + "$" + secretKey; */
	    
	    String digitalSignature=MD5Util.getEncryptedPwd(key);// 数字签名    
	   
	        
	    String path=request.getContextPath();    
	        
	    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;    

	    //System.out.println("scheme  "+request.getScheme()+"   serverName  "+request.getServerName()+"    port  "+request.getServerPort()+"    path   "+request.getContextPath());
	    
	    String resetPassHref = basePath + "/applyHelp/findTeacherPass?sid="+ digitalSignature +"&id="+t.getId();    
	    //  String resetPassHref = basePath + "/toFindPassword3.action?sid="+ digitalSignature +"&userName=";    

	    
	    String emailContent = "请勿回复本邮件.点击下面的链接,重设密码,本邮件超过30分钟,链接将会失效，需要重新申请找回密码." + resetPassHref;    
	        
	    return emailContent;    
	}


	public  <T> String sendStuEmail(ApplyUser t,String email,String key,HttpServletRequest request){
		  String account=mailAccountConfig.account;
	      String password=mailAccountConfig.passWord;
          // 指定发送邮件的主机为 localhost
	      String host = "smtp.qq.com";  //QQ 邮件服务器

	      // 获取系统属性
	      Properties properties = System.getProperties();

	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);

	      properties.put("mail.smtp.auth", "true");
	      //加入ssl验证
	      properties.put("mail.smtp.ssl.enable", "true");
          //验证写信者邮箱,此处使用第三方授权码登陆
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
		    public PasswordAuthentication getPasswordAuthentication()
		    {
		     return new PasswordAuthentication(account, password); //发件人邮件用户名、密码
		    }
		   });
         try{
            //填写信封写信    
            Message msg = new MimeMessage(session);    
            //设置发邮件的原地址    
            msg.setFrom(new InternetAddress(account));    
            //设置接收人    
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(email));    
            msg.setSubject("找回密码!");    
            msg.setText(createStuLink(t,key,request));    
            //验证用户名密码发送邮件    
             
            Transport.send(msg);    
            return "1";    
                   
           }catch(Exception e){    
            e.printStackTrace(); 
            return "0";
           }    
	}
	
	public   String createStuLink(ApplyUser t,String key,HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{    
		    
		    String digitalSignature=MD5Util.getEncryptedPwd(key);// 数字签名    
		   
		        
		    String path=request.getContextPath();    
		        
		    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;    

		    //System.out.println("scheme  "+request.getScheme()+"   serverName  "+request.getServerName()+"    port  "+request.getServerPort()+"    path   "+request.getContextPath());
		    
		    String resetPassHref = basePath + "/applyHelp/findStudentPass?sid="+ digitalSignature +"&id="+t.getId();    
		    //  String resetPassHref = basePath + "/toFindPassword3.action?sid="+ digitalSignature +"&userName=";    

		    
		    String emailContent = "请勿回复本邮件.点击下面的链接,重设密码,本邮件超过30分钟,链接将会失效，需要重新申请找回密码." + resetPassHref;    
		        
		    return emailContent;    
		}
	
}
