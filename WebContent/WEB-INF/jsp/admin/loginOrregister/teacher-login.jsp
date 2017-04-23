<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录-后台管理系统</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>

<link rel="stylesheet" type="text/css" href="${CTP_ADMIN}/css/login.css" />
<script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>

<script type="text/javascript" src="${CTP_ADMIN }/js/module/loginVa.js"></script>
</head>
<body>
<!-- 引入header -->

<jsp:include page="../common/teacher-login-header.jsp"></jsp:include>

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
				<form action="${CTP}/admin/loginRegister/login" method="post">
					<h1>登录</h1>
					<div>
						<input type="text" placeholder="用户名" autocomplete="off" name="userName" id="userName" />
					</div>
					<div>
						<input type="password" placeholder="用户密码" autocomplete="off" name="password" id="password" />
					</div>
					<div>
						<input type="submit" value="登录" />
						<a href="#">忘记密码?</a>
						<a href="${CTP}/admin/loginRegister/showTeaRegister">注册</a>
					</div>
					
				</form><!-- form -->
				<span style="color:#EF9722;">${error}</span>
				<div class="button">
					<a href="${CTP}/main/index">返回主页</a>
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