<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<!--S content-->
		<div class="content">
			<!--S list-->
			<div class="list">
				<div class="list-navi"><span>校内新闻<img src="img/jiantou.png"/></span></div>
				<div class="list-content">
					<ul>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
						<li><span><img src="img/time.png" /> 2017-01-07</span><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></li>
					</ul>
				</div>
			</div>
			<!--E list-->
			
			<!--S right-->
			<div class="hot">
				<div class="hot-navi"><span class="img-span"><img src="img/trends.png"/></span><span class="span">近期热点</span></div>
				
				<div class="hot-content">
					<div class="hot-content-sum"><img src="img/time.png" /><span>2017.01.01</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/look.png" /><span>111</span></div>
					<span class="hot-news-detail"><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></span>
				</div>
				<div class="hot-content">
					<div class="hot-content-sum"><img src="img/time.png" /><span>2017.01.01</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/look.png" /><span>111</span></div>
					<span class="hot-news-detail"><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></span>
				</div>
				<div class="hot-content">
					<div class="hot-content-sum"><img src="img/time.png" /><span>2017.01.01</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="img/look.png" /><span>111</span></div>
					<span class="hot-news-detail"><a href="#">2017年华师附小春季学期开学典礼隆重举行！</a></span>
				</div>
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