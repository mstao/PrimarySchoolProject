<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>	
<title>找回密码</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>

<link rel="stylesheet" type="text/css" href="${CTP_ADMIN}/css/login.css" />
<script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>

<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";

</script>

</head>
<body>
<!-- 引入header -->

<jsp:include page="../common/apply-header.jsp"></jsp:include>

<!-- S 内容 -->

			<div class="container-pass">
			<section id="content">
				<form action="">
					<h1>找回密码</h1>
				<div>
					<input type="text" placeholder="请输入用户名"   autocomplete="off" id="username" />
				</div>
				<div>
					<input type="text" placeholder="请输入邮箱"   autocomplete="off" id="email" />
				</div>
				
					<div>
					<input type="button" id="link" value="发送邮件"/>
					</div>
				</form><!-- form -->
				<div class="button" align="center">
					<a href="${CTP}/main/index">返回主页</a>
				</div><!-- button -->
			</section><!-- content -->
		</div><!-- container -->
<!-- E 内容 -->

<!-- 引入footer -->
<jsp:include page="../common/login-footer.jsp"></jsp:include>
</body>
</html>
<script type="text/javascript">
/**验证教师注册表单**/
$(function(){
	
	/**
	 * 验证教师注册表单
	 */
	var ok_username=false;
	var ok_email=false;
	
    /**
     * 对用户名校验
     */
    $("#username").bind("blur",function(){
    	
    	var filter=/^[a-zA-Z\u4e00-\u9fa5]{1}[a-zA-Z0-9_\u4e00-\u9fa5]{1,8}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
    	if( str ==""|| str==null ){
    		layer.tips('*用户名不能为空', '#username');
    		$(this).focus();
			
		}else{
			
			if(filter.test( $(this).val() )){
				//调用ajax验证用户是否已被注册
				
				//start
				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/applyHelp/${durl}",
					data:{"userName":str},
				
					success:function(data){
	
						//代表用户名可用
						if(data==1){
							layer.tips('*抱歉，该用户不存在', '#username');
							
						}else if(data==0){
							ok_username=true;
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
				layer.tips('*用户名为2-9字符,首字不为数字,无特殊字符 !', '#username');
				$(this).focus();
			}
		}
    });
    
    /**
     * 对邮箱校验
     */
    $("#email").bind("blur",function(){
    	var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    	var user = $("#username").val();
    	user = user.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('邮箱不能为空', '#email');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				//ajax验证邮箱是否被使用
				//start
				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/applyHelp/${murl}",
					data:{"email":str,"userName":user},
					success:function(data){
						//代表不存在
						if(data==1){
							layer.tips('*抱歉，邮箱与账号不匹配', '#email');
						}else if(data==0){
							//代表用户名不可用
							ok_email=true;
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
				layer.tips('*邮箱格式不正确', '#email');
				$(this).focus();
			}
		}
    });
    
  //发送邮件
    $('#link').bind('click',function(){
        if(ok_username&&ok_email){
        	var email=$("#email").val();
        	var userName=$("#username").val();
        	$.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+"/applyHelp/${surl}",
				data:{"email":email,"userName":userName},
				beforeSend:function(){
					//显示正在加载
					layer.msg('正在发送邮件',{offset: 0,time:2000});
				},
				success:function(data){
					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					layer.msg(data);
					if(data==1){
						layer.msg('邮件发送成功，请前往注册邮箱，按照提示操作',{time:2000});
					}else{
						layer.msg('抱歉，邮件发送失败！',{time:2000})	
					}
				},
            	});
            }else{
            	layer.msg("*用户信息验证失败，请仔细核对无误后进行提交！");
                }
        });
   $('.container-pass').keydown(function(event){
		if(event.keyCode==13){
			$('#link').click();
			}
	   });
 /*   $('.new_text').keydown(function(event){  
 	    if(event.keyCode==13){  
 	       $(".new_button").click();  
 	    }  
 	 }); */
    
});
</script>