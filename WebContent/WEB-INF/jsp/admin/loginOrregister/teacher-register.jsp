<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>

<link rel="stylesheet" type="text/css" href="${CTP_ADMIN}/css/login.css" />
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
				<form action="">
					<h1>注册</h1>
				<div>
					<input type="text" placeholder="请输入教师真实姓名" required="" id="username" />
				</div>
				<div>
					<input type="text" placeholder="请输入教师工号" required="" id="number" />
				</div>
				<div>
					<input type="password" placeholder="请输入密码" required="" id="password" />
				</div>
				<div>
					<input type="password" placeholder="请再次输入密码" required="" id="passwords" />
				</div>
					<div>
						<input type="submit" value="注册" />
						<span class="hasusername-span">已有账号，点击</span>
						<a href="${CTP}/admin/loginRegister/showTeaLogin">登录</a>
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