<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>
<title>校长信箱</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/list.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
</head>
<body>

<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>
<div class="content">
			<!--S list-->
			<div class="list">
				<div class="list-navi  headmaster-navi"><span>校长信箱<img src="${CTP_HOME}/img/jiantou.png"/></span></div>
				<div class="list-content headmaster-content">
					
				 <c:forEach items="${headMasterInfo}" var="headMasterInfo">
					<div  class="headmaster-info">
					<img alt="" src="${headMasterInfo.avatar}">
					<div class="headmaster-info-right">
				    
				     <div>${headMasterInfo.name}&nbsp; ${headMasterInfo.postName}</div>
				     <div><span>具体工作:</span><span>${headMasterInfo.work}</span></div>
				     <div><a href="mailto:${headMasterInfo.email}" title="给校长写信" target="_blank"><img src="${CTP_HOME}/img/email.png">给校长写信</a></div>
					</div>
					</div>
				</c:forEach>
					
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