<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园风光</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/list.css" />
<link rel="stylesheet" href="${CTP_HOME}/js/extends/zoomify/zoomify.min.css"/>
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/zoomify/zoomify.min.js" ></script>


</head>
<body>

<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>
<div class="content">
			<!--S list-->
			<div class="list">
				<div class="list-navi  img-navi"><span>校园风光<img src="${CTP_HOME}/img/jiantou.png"/></span></div>
				<div class="list-content img-content">
					
				<div class="img-list-div">
				<img src="${CTP_HOME}/img/h.jpg">
				</div>
					
				<div class="img-list-div">
				<img src="${CTP_HOME}/img/h.jpg">
				</div>
					
				<div class="img-list-div">
				<img src="${CTP_HOME}/img/h.jpg">
				</div>
						
						
					
					
				</div>
				
				
			</div>
			<!--E list-->	
			
		</div>
		 <div class="clear"></div>
<%--E 主体 --%>

<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

<script type="text/javascript">



$(function(){
	
	$(".img-list-div img").zoomify();
});

</script>