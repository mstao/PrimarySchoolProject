<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>Insert title here</title>
		<link rel="stylesheet" href="${CTP_HOME}/css/classdetails.css" />
		<link rel="stylesheet" href="${CTP_HOME}/css/liMarqueeImg.css" />
		<link rel="stylesheet" href="${CTP_HOME}/css/list.css" />
	</head>
	<body >
		
		<jsp:include page="../common/classHeader.jsp"></jsp:include>

<div id="mianBag">
	<!--详细新闻-->
	<div id="mainBag-left">
		<div class="container-bottom-lift">
		<c:set var="newsinfo" value="${newsinfo }"></c:set>
					<!--描述：新闻标题 -->
					<div class="news-title">
						<span> ${newsinfo.itemTitle }</span>
					</div>
					<!--描述：新闻作者，发布时间 -->
					<div class="new-attribute">
						<span class="new-attribute-span">作者：</span>
						<span class="new-attribute-name">${newsinfo.itemAuthor }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="new-attribute-span">发布时间：</span>
						<span class="new-attribute-time"> ${newsinfo.addTime }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="new-attribute-span">浏览次数：</span>
						<span class="new-attribute-times">${newsinfo.viewCount }</span>
					</div>
					<!--描述：新闻具体内容 -->
					<div class="new-details">
						<span>${newsinfo.itemContent }</span>
					
					</div>
				</div>
	</div>
	<!--详细新闻end-->
	<div id="mainBag-right">
		<div class="hot">
				<div class="hot-tops"><img src="${CTP_HOME}/img/newTrends.png"/><span class="span">近期热点</span></div>
				
				<div class="hot-content">
					<div class="hot-content-sum"><img src="${CTP_HOME}/img/time.png" /><span>2017.01.01</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${CTP_HOME}/img/look.png" /><span>111</span></div>
					<span class="hot-news-detail">2017年华师附小春季学期开学典礼隆重举行！</span>
				</div>
				
				
			</div>
	</div>
    
</div>
		<div id="footer">
    	<center>Copyright&copy;2017 www.xxxx.com .All Rights Reserved<br>地址:郑州高新技术开发区xxx&nbsp;邮编:450000</center>
    </div>
	</body>
</html>
