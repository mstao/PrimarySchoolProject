<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>	
<title>修改管理员密码-后台管理</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>				


</head>
<body onbeforeunload="return CheckUnsave();">
<!--S header-->
<jsp:include page="../common/header.jsp" flush="true"/>	
<!--E header-->
     
<!--S main-->
 <div class="new_div1"><span class="new_div1_span">修改管理员密码</span>

 </div>
 
	 <div class="new_div2  update-userpassword-div">

		<label>用户名</label><br>
		<input type="text" name="username" class="username" value="<shiro:principal/>" disabled="true"/><br>
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
