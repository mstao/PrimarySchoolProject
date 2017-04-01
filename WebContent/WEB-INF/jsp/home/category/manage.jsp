<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>学校管理</title>
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
	<span>学校管理</span>
</div>
<div class="content-location">
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="#">学校管理</a></span>
</div>
<div class="content-bottom">

	
	<div class="top-contaner-left">	
	<!-- 校园动态-->
	<div class="top-left">
		<div class="top-left-bottom"><b>学校管理</b><img src="${CTP_HOME}/img/jiantou.png"/></div>
		<ul>
			<li><a href="#">部门链接</a></li>
			<li><a href="#">评职评优</a></li>
			<li><a href="#">教师会议</a></li>
			<li><a href="#">规章制度</a></li>
			<li><a href="#">校长信箱</a></li>
		</ul>
	</div>
	<!--作息表-->
	<div class="bottom-left">
		<div class="top-left-bottom"><b>万科小学作息时间表</b><img src="${CTP_HOME}/img/jiantou.png"/></div>
		<ul>
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="#"> 春期作息时间表</a></li>
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="#"> 秋期作息时间表</a></li>
		</ul>
	</div>
		
 </div>	
	
<div class="top-contaner-right clearfix">
	<!--图片新闻-->
	<div class="top-center">
		
		 <!--S 轮播图-->
			<div class="slider-news">
			<ul>
		     
				<li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/nemo.jpg" alt="aaaaaa"  /></a></li>
			    <li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/toystory.jpg" alt="aaaaaa"  /></a></li>
		   	
			</ul>
		    </div>
		  
			<!--E 轮播图-->
	</div>
	<!---->
	<div class="float-div right">
		<div class="top-left-bottom"><b>部门链接</b> <img src="${CTP_HOME}/img/jiantou.png"/><span><a href="#">更多>></a></span></div>
		<ul>
		  <c:forEach items="${department}" var="department_list">
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/manage?id=${department_list.id}&flag=${departmentFlag}"> ${department_list.itemTitle}</a><span>[${department_list.addTime}]</span></li>
		  </c:forEach>
		</ul>
		<c:if test="${empty department}">
		 <div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
		</c:if>
	</div>
	
          <div class="clear"></div>
	<!--校内新闻-->
	<div class="float-div">
		<div class="top-left-bottom"><b>评职评优</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
		<ul>
		 <c:forEach items="${recommendation}" var="recommendation_list">
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/manage?id=${recommendation_list.id}&flag=${recommendationFlag}"> ${recommendation_list.itemTitle}</a><span>[recommendation_list.addTime]</span></li>
		 </c:forEach>
		</ul>
		<c:if test="${empty recommendation}">
		 <div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
		</c:if>
	</div>
	
	<div class="float-div right">
		<div class="top-left-bottom"><b>教师会议</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
		<ul>
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
		<div class="top-left-bottom"><b>规章制度</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
		<ul>
		  <c:forEach items="${rules}" var="rules_list">
			<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/manage?id=${rules_list.id}&flag=${rulesFlag}"> ${rules_list.itemTitle}</a><span>[${rules_list.addTime}]</span></li>
		  </c:forEach>
		</ul>
		<c:if test="${empty rules}">
		 <div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
		</c:if>
		
	</div>
	<div class="float-div right">
		<div class="top-left-bottom"><b>校长信箱</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
		<ul>
			<li><img src="../img/sjiantou.png"/><a href="#"> 今天发生了一件大事</a><span>[03-07]</span></li>
			<li><img src="../img/sjiantou.png"/><a href="#"> 今天发生了一件大事</a><span>[03-07]</span></li>
			<li><img src="../img/sjiantou.png"/><a href="#"> 今天发生了一件大事</a><span>[03-07]</span></li>
			<li><img src="../img/sjiantou.png"/><a href="#"> 今天发生了一件大事</a><span>[03-07]</span></li>
			<li><img src="../img/sjiantou.png"/><a href="#"> 今天发生了一件大事</a><span>[03-07]</span></li>
			<li><img src="../img/sjiantou.png"/><a href="#"> 今天发生了一件大事</a><span>[03-07]</span></li>
			<li><img src="../img/sjiantou.png"/><a href="#"> 今天发生了一件大事</a><span>[03-07]</span></li>
			<li><img src="../img/sjiantou.png"/><a href="#"> 今天发生了一件大事</a><span>[03-07]</span></li>
		</ul>
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