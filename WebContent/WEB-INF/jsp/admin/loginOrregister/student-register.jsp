<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>	
<title>注册-万科小学新生报名系统</title>
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

<jsp:include page="../common/student-login-header.jsp"></jsp:include>

<!-- S 内容 -->

	<div class="boss">
	<div id="lefts">
		
			<!--图片-->
		<div class="photos">
			<img src="${CTP_ADMIN}/img/wk1.jpg">
		</div>
	</div>
	<div id="rights">

			<div class="container">
			<section id="content">
				<form action="">
					<h1>注册</h1>
				<div>
					<input type="text" placeholder="请输入学生真实姓名" required="required" id="username" />
				</div>
				<div>
					<input type="text" placeholder="请输入学生身份证号" required="required" id="number" />
				</div>
				<div>
					<input type="password" placeholder="请输入密码" required="required" id="password" />
				</div>
				<div>
					<input type="password" placeholder="请再次输入密码" required="required" id="passwords" />
				</div>
					<div>
						<input type="submit" value="注册" />
						<span class="hasusername-span">已有账号，点击</span>
						<a href="${pageContext.request.contextPath}/apply/show/stuLogin">登录</a>
					</div>
				</form><!-- form -->
				<div class="button">
					<a href="#">返回主页</a>
				</div><!-- button -->
			</section><!-- content -->
		</div><!-- container -->
	</div>

</div>
<!-- E 内容 -->

<!-- 引入footer -->
<jsp:include page="../common/login-footer.jsp"></jsp:include>
</body>
</html>

<script type="text/javascript">
$(function(){
	var ok_username=false;
	var ok_card=false;
	var ok_password=false;
	var ok_re_password=false;
	
	//校验  数据
	//检验不能为空和数字
	 function check(className,tips){
		    var str = $(className).val();
			str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
	     	if( str ==""|| str==null ){
	   		layer.tips("*"+tips+"不能为空", $(className));
			$(className).focus();
				return false;
			}else{
				var filter=/^\d*$/;
				if(filter.test(str) || str.length >5){
					layer.tips("*"+tips+"不能为数字",$(className));
					return false;
				}else {
					
					return true;
				}
			}
	   }
	
	
	//校验用户名
	$("#username").bind("blur",function(){
		if( check($(this),"学生姓名")){
			ok_username=true;	
		}
	});
	
	//验证密码 
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
	
	
	//校检身份证
	
	 //定义地区数组  
    var CityArray = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外" }  
  
    //验证身份证及返回地区、出生年月、性别  
    function CheckIdCard(sId) {  
        if (sId.length == 15) {  
            sId = sId.replace(/([\d]{6})(\d{9})/, "$119$2x");  
        }  
        var iSum = 0  
        var info = ""  
        if (!/^\d{17}(\d|x)$/i.test(sId)) return "Error:非法的身份证号";  
        sId = sId.replace(/x$/i, "a");  
        if (CityArray[parseInt(sId.substr(0, 2))] == null) return "Error:非法地区";  
        sBirthday = sId.substr(6, 4) + "-" + Number(sId.substr(10, 2)) + "-" + Number(sId.substr(12, 2));  
        var d = new Date(sBirthday.replace(/-/g, "/"))  
        if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate())) return "Error:非法生日";  
        for (var i = 17; i >= 0; i--) iSum += (Math.pow(2, i) % 11) * parseInt(sId.charAt(17 - i), 11)  
        if (iSum % 11 != 1) return "Error:非法证号";  
        return CityArray[parseInt(sId.substr(0, 2))] + "," + sBirthday + "," + (sId.substr(16, 1) % 2 ? "男" : "女")  
    }  
	
    //校验身份证
    $("#number").bind("blur",function(){
 	   var str = $(this).val();
 		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
 	   	if( str ==""|| str==null ){
 	   		layer.tips('*身份证不能为空', $(this));
 	   		$(this).focus();
 				
 		}else{
 			layer.tips(CheckIdCard(str), $(this));
 		
 			if(CheckIdCard(str).match("Error") ==null){
 				
 				//ok_card=true;
 				//检测身份证是否被注册
 				//start
				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/apply/checkUser",
					data:{"card":str},
				
					beforeSend:function(){
						//显示正在加载
						layer.load(2,{offset: 10,time:2000});
					},
					success:function(data){
	
						//关闭正在加载
						setTimeout(function(){
							  layer.closeAll('loading');
						}, 1000);
						
						//代表用户名可用
						if(data==1){
							layer.tips('恭喜！身份证可以被注册', '#number');
							ok_card=true;
						}else if(data==0){
							//代表用户名不可用
							layer.tips('*抱歉，身份证已被使用', '#number');
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
    
    
    
    //注册
    
    /**
     * 调用ajax注册
     */
    $('form').eq(0).bind('submit',function(e){
    	
    	//阻止自动提交
    	e.preventDefault();
    	
    	if(ok_username==true && ok_card==true   && ok_password==true  && ok_re_password==true){
        	var userName=$("#username").val();
        	var number=$("#number").val();

        	var password=$("#password").val();
            //注册
    		$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+"/apply/saveUser",
				data:{"userName":userName,"cardCode":number,"password":password},
			
				beforeSend:function(){
					//显示正在加载
					layer.msg('正在注册',{offset: 0,time:2000});
				},
				success:function(data){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					
					//代表用户名可用
					if(data==1){
						layer.msg('恭喜！用户注册成功',{time:4000});
						
					}else if(data==0){
						//代表用户名不可用
						layer.msg('*抱歉，用户注册失败，请仔细核对信息！',{time:4000});
						
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