<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>
<title>${typeName}列表</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/list.css" />
<link rel="stylesheet" href="${CTP}/resources/common/css/page.css"/>
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>
<!--S content-->
		<div class="content">
			<!--S list-->
			<div class="list">
				<div class="list-navi"><span>${typeName}<img src="${CTP_HOME}/img/jiantou.png"/></span></div>
				<div class="list-content">
					<ul>
					  <c:forEach items="${item}" var="trends_list">
						<li><span><img src="${CTP_HOME}/img/time.png" /> ${trends_list.addTime}</span><a href="${CTP}/details/${durl}?cid=${cid}&id=${trends_list.id}&flag=${typeFlag}" title="${trends_list.itemTitle}">${trends_list.itemTitle}</a></li>
					  </c:forEach>
					</ul>
				</div>
				
				<!-- 分页导航引入 -->
			    ${toolBar}
				
			</div>
			<!--E list-->
			
			<!--S right-->
			<div class="hot">
				<div class="hot-navi"><span class="img-span"><img src="${CTP_HOME}/img/trends.png"/></span><span class="span">近期热点</span></div>
				
				<c:forEach items="${hotItem}" var="hotTrends">
					<div class="hot-content">
						<div class="hot-content-sum"><img src="${CTP_HOME}/img/time.png" /><span>${hotTrends.addTime}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${CTP_HOME}/img/look.png" /><span>${hotTrends.viewCount}</span></div>
						<span class="hot-news-detail"><a href="${CTP}/details/${durl}?id=${hotTrends.id}&flag=${typeFlag}">${hotTrends.itemTitle}</a></span>
					</div>
				</c:forEach>
			</div>
			
			<!--E right-->
			
			
			
		</div>
		<!--E content-->
		 <div class="clear"></div>
<%--E 主体--%>

<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>