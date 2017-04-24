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
<title>${SCHOOL_MANAGE}</title>
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
	<span>${SCHOOL_MANAGE}</span>
</div>
<div class="content-location">
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="${CTP}/main/index">万科城小学</a> > <a href="javascript:void(0);">${SCHOOL_MANAGE}</a></span>
</div>
<div class="content-bottom">

	
	<div class="top-contaner-left">	
	<!-- 校园动态-->
	<div class="top-left">
		<div class="top-left-bottom"><b>${SCHOOL_MANAGE}</b><img src="${CTP_HOME}/img/jiantou.png"/></div>
		<ul>
			 <li><a href="${pageContext.request.contextPath}/list/manage?flag=department&p=1">${SCHOOL_MANAGE_DEPARTMENT}</a></li>
             <li><a href="${pageContext.request.contextPath}/list/manage?flag=recommendation&p=1">${SCHOOL_MANAGE_RECOMMENDATION}</a></li>
             <li><a href="${pageContext.request.contextPath}/list/manage?flag=notice&p=1">${SCHOOL_MANAGE_NOTICE}</a></li>
             <li><a href="${pageContext.request.contextPath}/list/manage?flag=rules&p=1">${SCHOOL_MANAGE_RULES}</a></li>
             <li><a href="${pageContext.request.contextPath}/list/headmaster-email">${SCHOOL_MANAGE_EMAIL}</a></li>
		</ul>
	</div>
	<!--作息表-->
	<!--引入作息表-->
	<jsp:include page="../common/timetable.jsp"></jsp:include>
		
 </div>	
	
<div class="top-contaner-right clearfix">
	<!--图片新闻-->
	<div class="top-center">
		
		 <!--S 轮播图-->
			<div class="slider-news">
			<ul>
		     
				<c:forEach items="${sliderManage}" var="s_list">  
					<li class="slider-li"><a href="${CTP}/details/manage?id=${s_list.id}&flag=${s_list.itemTypeFlag}" target="_blank" ><img src="" alt="${s_list.itemTitle}"  /></a><div class="hide-content-slider" style="visibility: hidden;">${s_list.itemContent}</div></li>
				</c:forEach>	
			     <c:if test="${empty sliderManage}">
			       <li class="slider-li"><img src="${CTP_HOME}/img/noimage.gif" alt="暂无图片"  /></li>
			     </c:if>
			</ul>
		    </div>
		  
			<!--E 轮播图-->
	</div>
	<!---->
	<div class="float-div right">
		<div class="top-left-bottom"><b>${SCHOOL_MANAGE_DEPARTMENT}</b> <img src="${CTP_HOME}/img/jiantou.png"/><span><a href="#">更多>></a></span></div>
		<ul class="sub-ul-category">
		  <c:forEach items="${department}" var="department_list">
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/manage?id=${department_list.id}&flag=${departmentFlag}"> ${department_list.itemTitle}</a><span>[${department_list.addTime}]</span></li>
		  </c:forEach>
		</ul>
		<c:if test="${empty department}">
		 <div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
		</c:if>
	</div>
	
          <div class="clear"></div>
	<!---->
	<div class="float-div">
		<div class="top-left-bottom"><b>${SCHOOL_MANAGE_RECOMMENDATION}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
		<ul class="sub-ul-category">
		 <c:forEach items="${recommendation}" var="recommendation_list">
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/manage?id=${recommendation_list.id}&flag=${recommendationFlag}"> ${recommendation_list.itemTitle}</a><span>[recommendation_list.addTime]</span></li>
		 </c:forEach>
		</ul>
		<c:if test="${empty recommendation}">
		 <div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
		</c:if>
	</div>
	
	<div class="float-div right">
		<div class="top-left-bottom"><b>${SCHOOL_MANAGE_NOTICE}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
		<ul class="sub-ul-category">
		  <c:forEach items="${notice}" var="notice_list">
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/manage?id=${notice_list.id}&flag=${noticeFlag}"> ${notice_list.itemTitle}</a><span>[${notice_list.addTime}]</span></li>
		  </c:forEach>
		</ul>
		<c:if test="${empty notice}">
		 <div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
		</c:if>
		
		
	</div>
	<div class="clear"></div>
	<div class="float-div ">
		<div class="top-left-bottom"><b>${SCHOOL_MANAGE_RULES}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
		<ul class="sub-ul-category">
		  <c:forEach items="${rules}" var="rules_list">
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/manage?id=${rules_list.id}&flag=${rulesFlag}"> ${rules_list.itemTitle}</a><span>[${rules_list.addTime}]</span></li>
		  </c:forEach>
		</ul>
		<c:if test="${empty rules}">
		 <div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
		</c:if>
		
	</div>

	
	
      </div>


</div>
	

<!--S FOOTER-->
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