<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>	
<title>更新密码</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>

<link rel="stylesheet" type="text/css" href="${CTP_ADMIN}/css/login.css" />
<script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>

<c:set var="rurl" value="showTeaLogin"></c:set>
<c:choose>
	<c:when test="${durl eq rurl}">
		<c:set var="surl" value="/admin/loginRegister/showTeaLogin"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="surl" value="/apply/show/stuLogin"></c:set>
	</c:otherwise>
</c:choose> 
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
					<h1>更新 密码</h1>
				<div>
					<input type="password" placeholder="请输入密码"  autocomplete="off"  id="password" />
				</div>
				<div>
					<input type="password" placeholder="请再次输入密码" autocomplete="off" id="passwords" />
				</div>
				
					<div>
					<input type="button" id="link" value="确认修改"/>
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
$(function(){
	var ok_message=false;
	var ok_password=false;
	var ok_re_password=false;
	var message="${message}";
	if(message.length!=0&&message!=null){
		layer.msg(message,{offset: 0,time:2000});
		}else{
			ok_message=true;
			}
	 /**
     * 对密码进行校验
     */
    
    $("#password").bind("blur",function(){
    	var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*密码不能为空', '#password');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				layer.tips('密码格式正确', '#password');
				ok_password=true;
			}else{
				layer.tips('*密码5-18字符 ,不能有特殊字符!', '#password');
				$(this).focus();
			}
		}
    });
    
    /**
     * 对重复密码校验
     */
    $("#passwords").bind("blur",function(){
    	var filter=/^[a-zA-Z0-9_]{5,18}$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('*重复密码不能为空', '#passwords');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				 
				if($(this).val()!=$("#password").val()){
					layer.tips('*两次填写的密码不一致!', '#passwords');
					$(this).focus();
				}else{
					layer.tips('重复密码正确!', '#passwords');
					ok_re_password=true;
				}
			 
			}else{
				layer.tips('*重复密码5-18字符 ,不能有特殊字符!', '#passwords');
				$(this).focus();
			}
		}
    	
    });
    $('#link').bind('click',function(){
			var password=$('#passwords').val();
			var username="${user.userName}";
			var id="${user.id}";
			if(ok_message&&ok_password&&ok_re_password){
				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/applyHelp/${nurl}",
					data:{"id":id,"password":password,"userName":username},
					beforeSend:function(){
						//显示正在加载
						layer.msg('正在修改密码',{offset: 0,time:2000});
					},
					success:function(data){

						//关闭正在加载
						setTimeout(function(){
							  layer.closeAll('loading');
						}, 1000);
						
						//代表用户名可用
						if(data==1){
							layer.msg('恭喜！修改密码成功',{time:4000});
						/* 	if("${nurl}"=="showTeaLogin"){
								//跳转界面
								window.location.href=CTPPATH+"/admin/loginRegister/showTeaLogin";
							}else{
								//跳转界面
								window.location.href=CTPPATH+"/apply/show/stuLogin";
								}  */
							window.location.href=CTPPATH+"${surl}"; 
						}else if(data==0){
							//代表用户名不可用
							layer.msg('*抱歉，修改密码失败，请仔细核对信息！',{time:4000});
							
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
			}else{
				layer.msg("*用户信息验证失败，请仔细核对无误后进行提交！");
			}
        });
});
</script>