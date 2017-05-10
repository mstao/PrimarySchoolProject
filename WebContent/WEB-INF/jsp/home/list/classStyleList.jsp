<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>
<title>校园风光</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<link rel="stylesheet" href="${CTP_HOME}/css/classStyle.css">
<link rel="stylesheet" href="${CTP_HOME}/js/extends/zoomify/zoomify.min.css"/>
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/zoomify/zoomify.min.js" ></script>


</head>
<body>

<%--引入header --%>

<jsp:include page="../common/classHeader.jsp"></jsp:include>

<%--S 主体 --%>
<div class="content">
			<!--S list-->
			<div class="list">
				<div class="list-navi  img-navi"><span>班级风采<img src="${CTP_HOME}/img/jiantou.png"/></span></div>
				<div class="list-content img-content">
			
			   	<c:forEach items="${style}" var="classStyle_list">	
					<div class="img-list-div">
					<img src="${classStyle_list.imgPath}"/>
					</div>
			    </c:forEach>
				</div>
				
				
			</div>
			<!--E list-->	
			
		</div>
		 <div class="clear"></div>
<%--E 主体 --%>

<div class="footer" style="background: #F5F2E3;">
    	<center>Copyright&copy;2017 www.xxxx.com .All Rights Reserved<br>地址:郑州高新技术开发区xxx&nbsp;邮编:450000</center>
    </div>
</body>
</html>

<script type="text/javascript">



$(function(){
	
	$(".img-list-div img").zoomify();
});

</script>