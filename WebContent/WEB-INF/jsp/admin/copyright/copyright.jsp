<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		
		<title>版权说明</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
		<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
		
	</head>
	<body>
		<!-- S header -->
	<jsp:include page="../common/header.jsp" />
	<!--S main-->
			<div id="location">您现在的位置: 后台管理 ><span>版权说明</span></div>
            <div class="new_div1"><span class="new_div1_span">版权说明</span><a href="${CTP}/admin/editCopyRight" class="add_list">
            <c:choose>
                <c:when test="${empty copyRight}">新增</c:when>
                <c:otherwise>修改</c:otherwise>
            </c:choose> 
                 
            </a>
            
              <c:if test="${copyRight.isPublish eq 0}">
            <b>草稿</b>
            </c:if>   
            </div>
            <div class="new_div2">
            	
                ${copyRight.content}
            </div>
       
        <div> 
</div>
<!--E main-->

<!--S footer-->
<div class="footer">
			<center><span>Copyright &copy;万科城小学  版权所有 2016 All Rights Reserved.</span></center>
<br><br>
</div>
<!--E footer-->
	</body>
</html>
