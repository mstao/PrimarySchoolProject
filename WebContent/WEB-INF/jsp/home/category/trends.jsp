<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>${SCHOOL_TRENDS}</title>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/alldetails.css"/>
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/YuxiSlider.jQuery.min.js"></script>
</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>

		<div class="content-wrapper">
			<img src="${CTP_HOME}/img/school-f.jpg" />
			<span>${SCHOOL_TRENDS}</span>
		</div>
		<div class="content-location">
		<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="${CTP}/main/index">万科城小学</a> > <a href="javascript:void(0);">${SCHOOL_TRENDS}</a></span>
		</div>
		<div class="content-bottom">
			
	      <div class="top-contaner-left">	
			<!-- 校园动态-->
			<div class="top-left">
				<div class="top-left-bottom"><b>${SCHOOL_TRENDS}</b><img src="${CTP_HOME}/img/jiantou.png"/></div>
				<ul>
					<li><a href="${pageContext.request.contextPath}/list/trends?flag=news&p=1">${SCHOOL_TRENDS_NEWS}</a></li>
					<li><a href="${pageContext.request.contextPath}/list/trends?flag=notice&p=1">${SCHOOL_TRENDS_NOTICE}</a></li>
					
				</ul>
			</div>
			<!--引入作息表-->
			<jsp:include page="../common/timetable.jsp"></jsp:include>
				
		 </div>	
			
		<div class="top-contaner-right clearfix">
			<!--图片新闻-->
			<div class="top-center">
				
				 <!--S 轮播图-->
					<div class="slider-news">
					<ul>
				     
					<c:forEach items="${sildeNews}" var="s_list">  
						<li class="slider-li"><a href="${CTP}/details/trends?id=${s_list.id}&flag=${s_list.itemTypeFlag}" target="_blank" ><img src="" alt="${s_list.itemTitle}"  /></a><div class="hide-content-slider" style="visibility: hidden;">${s_list.itemContent}</div></li>
					</c:forEach>	
				     <c:if test="${empty sildeNews}">
				       <li class="slider-li"><img src="${CTP_HOME}/img/noimage.gif" alt="暂无图片"  /></li>
				     </c:if>
					</ul>
				    </div>
				  
					<!--E 轮播图-->
			</div>
			<!--热门排行-->
			<div class="float-div right">
				<div class="top-left-bottom"><b>热门排行</b> <img src="${CTP_HOME}/img/jiantou.png"/><span><a href="${CTP}/list/trends?flag=${newsFlag}&p=1">更多>></a></span></div>
				<ul class="sub-ul-category">
				  <c:forEach items="${hotTrends}" var="hotTrends">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/trends?id=${hotTrends.id}&flag=${newsFlag}" title="${hotTrends.itemTitle}"> ${hotTrends.itemTitle}</a><span>[${hotTrends.addTime}]</span></li>
				  </c:forEach>
				</ul>
				<c:if test="${empty hotTrends}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
				</c:if>
				
			</div>
			
            <div class="clear"></div>
			<!--校内新闻-->
			<div class="float-div">
				<div class="top-left-bottom"><b>${SCHOOL_TRENDS_NEWS}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="${CTP}/list/trends?flag=${newsFlag}&p=1">更多>></a></span></div>
				<ul class="sub-ul-category">
				  <c:forEach items="${news}" var="news_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/trends?id=${news_list.id}&flag=${newsFlag}" title="${news_list.itemTitle}"> ${news_list.itemTitle}</a><span>[${news_list.addTime}]</span></li>
				  </c:forEach>
				</ul>
				<c:if test="${empty news}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
				</c:if>
			</div>
			
			<div class="float-div right">
				<div class="top-left-bottom"><b>${SCHOOL_TRENDS_NOTICE}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="${CTP}/list/trends?flag=${noticeFlag}&p=1">更多>></a></span></div>
				<ul class="sub-ul-category">
				  <c:forEach items="${notice}" var="notice_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/trends?id=${notice_list.id}&flag=${noticeFlag}" title="${notice_list.itemTitle}"> ${notice_list.itemTitle}</a><span>[${notice_list.addTime}]</span></li>
				  </c:forEach>
				</ul>
				<c:if test="${empty notice}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
				</c:if>
			</div>
			
	       </div>
	
			
	    </div>
	    <div class="clear"></div>
<%--E 主体 --%>

<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
<script type="text/javascript">
	$(function(){
		 //轮播
	    $(".slider-news").YuxiSlider({
			width:420, //容器宽度
			height:300, //容器高度
			during:3000, //间隔3秒自动滑动
			speed:800, //移动速度0.8秒
			mousewheel:true, //是否开启鼠标滚轮控制
			direkey:false//是否开启左右箭头方向控制
		});
	});
		
</script>