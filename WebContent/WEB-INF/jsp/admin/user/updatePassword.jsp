<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>	
<title>修改密码-后台管理</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>				


<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";
var uid="${sessionScope.uid}";
var defaultUserName="<shiro:principal/>";
$(function(){
	
	
	//用户名
	var ok_username=false;
	
	//旧密码
	var ok_oldpw=false;
	//新密码
	var ok_newpw=false;
	//重复新密码
	var ok_re_newpw=false;
	
	//修改密码
	if($(".username").val().replace(/\s/g , '')==defaultUserName){
		ok_username=true;
	   
	}
	//先检测用户名是否已用
	$(".username").bind("blur",function(){
		
		var filter=/^[a-zA-Z\u4e00-\u9fa5]{1}[a-zA-Z0-9_\u4e00-\u9fa5]{1,8}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		
    	if( str ==""|| str==null ){
    		layer.tips('*用户名不能为空', '.username');
    		$(this).focus();
			
		}else{
			if(str==defaultUserName){
				ok_username=true;
			   
			}else{
			   if(filter.test( $(this).val() )  ){
				//调用ajax验证用户是否已被注册
				
				//start
				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/admin/loginRegister/checkUser",
					data:{"userName":str},
				
					beforeSend:function(){
						//显示正在加载
						layer.load(2,{offset: 400,time:2000});
					},
					success:function(data){
	
						//关闭正在加载
						setTimeout(function(){
							  layer.closeAll('loading');
						}, 1000);
						
						//代表用户名可用
						if(data==1){
							layer.tips('恭喜！用户名可用', '.username');
							ok_usrename=true;
						}else if(data==0){
							//代表用户名不可用
							layer.tips('*抱歉，用户名已被使用', '.username');
							$(this).focus();
						}
					},
					error:function(){
	
						//关闭正在加载
						setTimeout(function(){
							  layer.closeAll('loading');
						}, 1000);
						layer.msg("出错了", {icon: 2,time:2000});
					}
				});
				
				//end
			}else{
				layer.tips('*用户名为2-9字符,首字不为数字,无特殊字符 !', '.username');
				$(this).focus();
			}
			
		}
			
			
	  }
	});
	
	
	
	/**
	* 对旧密码进行校验
	*/
	$(".oldpassword").bind("blur",function(){
		var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*密码不能为空', '.oldpassword');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				layer.tips('密码格式正确', '.oldpassword');
				ok_oldpw=true;
			}else{
				layer.tips('*密码5-18字符 ,不能有特殊字符!', '.oldpassword');
				$(this).focus();
			}
		}
	});
	
	
	
	
	 /**
     * 对新密码进行校验
     */
    
    $(".newpassword").bind("blur",function(){
    	var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*密码不能为空', '.newpassword');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				layer.tips('密码格式正确', '.newpassword');
				ok_newpw=true;
			}else{
				layer.tips('*密码5-18字符 ,不能有特殊字符!', '.newpassword');
				$(this).focus();
			}
		}
    });
    
    /**
     * 对重复密码校验
     */
    $(".repeatpassword").bind("blur",function(){
    	var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*重复密码不能为空', '.repeatpassword');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				 
				if($(this).val()!=$(".newpassword").val()){
					layer.tips('*两次填写的密码不一致!', '.repeatpassword');
					$(this).focus();
				}else{
					layer.tips('重复密码正确!', '.repeatpassword');
					ok_re_newpw=true;
				}
			 
			}else{
				layer.tips('*重复密码5-18字符 ,不能有特殊字符!', '.repeatpassword');
				$(this).focus();
			}
		}
    	
    });
    
    
    //全部验证成果后
    
    $(".update-password-btn").bind("click",function(){
    	
    	var userName=$(".username").val();
    	var oldpassword=$(".oldpassword").val();
    	var newpassword=$(".newpassword").val();
    	//判断是否全部验证成功
  
    	if(ok_username==true && ok_oldpw==true && ok_newpw==true && ok_re_newpw==true){
    		
    		//start
    		$.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+"/admin/user/updatePassword",
				data:{"uid":uid,"userName":userName,"oldPassword":oldpassword,"newPassword":newpassword},
			
				beforeSend:function(){
					//显示正在加载
					layer.msg('正在修改密码');
				},
				success:function(data){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					
					//代表用户名可用
					if(data==1){
						layer.msg('恭喜！用户信息修改成功',{time:4000});
						
					}else if(data==0){
						//代表用户名不可用
						layer.msg('*抱歉，用户的原始密码输入错误，请核对后再输入！',{time:4000});
						
					}else{
						layer.msg('*抱歉，用户信息修改失败！',{time:4000});
					}
				},
				error:function(){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					layer.msg("出错了", {icon: 2,time:2000});
				}
			});
    		//end
    		
    	}else{
    		layer.msg("*用户信息验证失败，请仔细核对无误后进行提交！");
    	}
    })
});
</script>

</head>
<body onbeforeunload="return CheckUnsave();">
<!--S header-->
<jsp:include page="../common/header.jsp" flush="true"/>	
<!--E header-->
     
<!--S main-->
 <div class="new_div1"><span class="new_div1_span">修改密码</span>

 </div>
 
	 <div class="new_div2  update-userpassword-div">

		<label>用户名</label><br>
		<input type="text" name="username" class="username" value="<shiro:principal/>" /><br>
        <label>输入旧密码 </label><br>
        <input type="password" name="oldpassword" class="oldpassword" placeholder="请输入旧密码"/><br>
        <label>输入新密码 </label><br>
        <input type="password" name="newpassword" class="newpassword" placeholder="输入新密码"/><br>
        <label>重复新密码 </label><br>
        <input type="password" name="repeatpassword" class="repeatpassword" placeholder="重复新密码"/>
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="update-password-btn" onClick="ChangeState();">确认修改</a>
        </div>
       
	 </div>

<!--E main-->

<!--S footer-->
<jsp:include page="../common/footer.jsp" flush="true"/> 	
<!--E footer-->
</body>
</html>
