<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${SCHOOL_STUDENT_LAB}-${WEBSITE_NAME}</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/beforelist.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${CTP_HOME}/css/classmain.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>

</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>
<div id="location"><span>您现在的位置: 后台管理 ></span><span>${SCHOOL_STUDENT_INFOMATION }</span>
</div>
	
    <!--S CONETNT-->
    <div class="scontent">
    
    <!--S CONETNT-->
    <div class="class-content">
    	<!--s class-info-->
    	<c:forEach items="${grade}" var="grade">
    	<c:set var="grades" value="${year-grade.gradeCode+1}"></c:set>
    	<div class="class-content-only">
    		<div class="only-nav"><span class="only-navi-year">${grade.gradeCode }年</span></div>
    		<div class="only-info">
    		<c:forEach items="${sclass }" var="sclass">
    		<c:if test="${sclass.gradeCode==grade.gradeCode }">
    			<c:set var="fullName" value="${grades}年级${sclass.className }班"></c:set>
    			<span><a href="${CTP }/admin/list/scoreInfo?classId=${sclass.id }&fullName=${fullName }&p=1">${fullName }</a></span>
    		</c:if>
    		</c:forEach>
    		</div>
    	</div>
    	</c:forEach>
    	<!--e class-info-->
    </div>
    
    <!--E CONTENT-->
</div>
    
    <!--E CONTENT-->




<%--引入footer --%>
<jsp:include page="../common/footer.jsp" />
</body>
</html>