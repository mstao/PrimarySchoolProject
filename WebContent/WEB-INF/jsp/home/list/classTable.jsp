<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级课表下载</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/classmain.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>


</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>

<div class="content-location">
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="#">班级课表</a></span>
</div>

<div class="content">
    <div class="trends-top"><img src="${CTP_HOME}/img/课表.png"/> <span class="tag-ch">班级课表下载</span> </div>
    <!--S CONETNT-->
    <div class="class-content">
    	<!--s class-info-->
    	<c:forEach items="${grade}" var="grade">
    	<c:set var="grades" value="${year-grade.gradeCode+1}"></c:set>
    	<div class="class-content-only">
    		<div class="only-navi"><img src="${CTP_HOME}/img/class-nvai.png"/><span>${grade.gradeCode }年</span></div>
    		<div class="only-info">
    		<br>
    		<c:forEach items="${sclass }" var="sclass">
    		<c:if test="${sclass.gradeCode==grade.gradeCode }">
    		<span><img src="${CTP_HOME}/img/j_do.png" class="dot"/> 
    		 <a href="${CTP}/download/fileById?id=${sclass.id}&belongType=${fileType}" class="only-info-dot">${myTag:numToChinese(grades)}(${sclass.className })班</a></span>
    		</c:if>
    		</c:forEach>
    		</div>
    	</div>
    	</c:forEach>
    	<!--e class-info-->
    </div>
    
    <!--E CONTENT-->
</div>
<div class="clear"></div>
<%--E 主体 --%>

<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>