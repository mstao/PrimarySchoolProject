<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>Insert title here</title>
<link rel="stylesheet" href="${CTP_HOME}/css/classSynopsis.css" />
</head>
<body>
    <jsp:include page="../common/classHeader.jsp"></jsp:include>
    
    <div id="mianBag">
        <!--详细新闻-->
        <div id="mainBag-left">
            <div class="container-bottom-lift">
                <c:set var="synopsis" value="${synopsis }"></c:set>
                <!--描述：新闻标题 -->
                <div class="news-title">
                    <span> 班级简介</span>
                </div>
                <!--描述：新闻具体内容 -->
                <div class="synopsis">
                ${synopsis.classSynopsis }
                </div>
            </div>
        </div>
        <!--详细新闻end-->
    </div>
    <div id="footer">
        <jsp:include page="../common/classFooter.jsp"></jsp:include>
    </div>
</body>
</html>
