<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		
		<title>用户列表</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="../common/meta.jsp" flush="true"/>	
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/auth.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/magic-check.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${CTP}/resources/common/css/page.css"/>
		<script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
		<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
		

</head>
<body>

<%--检测浏览器 --%>
<jsp:include page="../../common/browsehappy.jsp"></jsp:include>
	

<!-- S header -->
<jsp:include page="../common/header.jsp" />
	<!--S main-->
			
            <div class="new_div1"><span class="new_div1_span">角色分配</span>              
            </div>
            <!-- S 权限内容 -->
            
            <div class="auth-div">
			<div class="auth-operation-list">
				<ul>
					<li><a href="${CTP}/admin/authority/roleList" > >角色列表</a></li>
					<li><a href="${CTP}/admin/authority/allocation?p=1"> >角色分配</a></li>
					<li><a href="${CTP}/admin/authority/resources" class="checked-a"> >权限列表</a></li>
					
				</ul>
			</div>
			
			<div class="auth-content">
				<div class="title">
					<span>权限资源列表</span>
					
				</div>
			
				
				<div class="a-content">
					<table>
						<tr>
							<th>序号</th>
							<th>value</th>
							<th>permission</th>
						 
						</tr>
						<c:forEach items="${resources}" var="list" varStatus="xh"> 
						<tr>
							<td>${xh.count}</td>
							<td>${list.value}</td>
							<td>${list.permission }</td>
							
							
						</tr>
						
				        </c:forEach>
					</table>

				</div>
				
			</div>
		</div>
            <!-- E 权限内容 -->
        <div> 
</div>
<!--E main-->

<!--S footer-->
<jsp:include page="../common/footer.jsp" />
<!--E footer-->



	</body>
</html>
