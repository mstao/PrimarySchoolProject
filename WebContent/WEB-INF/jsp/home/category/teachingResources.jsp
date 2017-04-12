<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>${SCHOOL_TEACHER_RESOURCES}- ${WEBSITE_NAME}</title>
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
			<span>${SCHOOL_TEACHER_RESOURCES}</span>
		</div>
		<div class="content-location">
		<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href>${SCHOOL_TEACHER_RESOURCES} </a> > <a href="#">${className}</a> > <a href="javascript:void(0);">${menuName}</a></span>
		</div>
		<div class="content-bottom">
		
			
			<div class="top-contaner-left">	
			<!-- LIEBIAO -->
			<div class="top-left">
				<div class="top-left-bottom"><b>${menuName}</b><img src="${CTP_HOME}/img/jiantou.png"/></div>
				<ul>
					<li><a href="#">${TEACHER_RESOURCES_DISCUSS}</a></li>
					<li><a href="#">${TEACHER_RESOURCES_DESIGN}</a></li>
					<li><a href="#">${TEACHER_RESOURCES_COURSEWARE}</a></li>
					<li><a href="#">${TEACHER_RESOURCES_MICROLECTURE}</a></li>
					<li><a href="#">${TEACHER_RESOURCES_QUESTION_BANK}</a></li>
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
			<!--教学研讨-->
			<div class="float-div right">
				<div class="top-left-bottom"><b>${TEACHER_RESOURCES_DISCUSS}</b> <img src="${CTP_HOME}/img/jiantou.png"/><span><a href="${CTP}/list/teachingResourcesContent?menuId=${menuId}&classId=${classId}&flag=${discussFlag}&p=1">更多>></a></span></div>
				<ul>
				   <c:forEach items="${discuss}" var="discuss_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${education_list.id}&flag=${educationFlag}"> ${discuss_list.itemTitle}</a><span>[${discuss_list.addTime}]</span></li>
				   </c:forEach>
				</ul>
				<c:if test="${empty discuss}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /><span>暂无内容</span></div>
				</c:if>
				
			</div>
			
            <div class="clear"></div>
			<!--教学设计-->
			<div class="float-div">
				<div class="top-left-bottom"><b>${TEACHER_RESOURCES_DESIGN}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
				<ul>
				   <c:forEach items="${design}" var="design_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${speak_list.id}&flag=${speakFlag}"> ${design_list.itemTitle}</a><span>[${design_list.addTime}]</span></li>
				   </c:forEach>
				</ul>
				<c:if test="${empty design}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /><span>暂无内容</span></div>
				</c:if>
				
			</div>
			
			<!-- 课件 -->
			<div class="float-div right">
				<div class="top-left-bottom"><b>${TEACHER_RESOURCES_COURSEWARE}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
				<ul>
				   <c:forEach items="${courseware}" var="courseware_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${courseware_list.id}&flag=${activeFlag}"> ${courseware_list.itemTitle}</a><span>[${courseware_list.addTime}]</span></li>
				   </c:forEach>
				</ul>
				
				<c:if test="${empty courseware}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /><span>暂无内容</span></div>
				</c:if>
			</div>
			<div class="clear"></div>
			
			<!-- 微课 -->
			<div class="float-div ">
				<div class="top-left-bottom"><b>${TEACHER_RESOURCES_MICROLECTURE}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
				<ul>
				  <c:forEach items="${microlecture}" var="microlecture_list">
					<li><img src="${CTP_PATH}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${parents_list.id}&flag=${parentsFlag}"> ${microlecture_list.itemTitle}</a><span>[${microlecture_list.addTime}]</span></li>
				  </c:forEach>
				</ul>
				<c:if test="${empty microlecture}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /><span>暂无内容</span></div>
				</c:if>
				
			</div>
			
			<!-- 题库 -->
			<div class="float-div right">
				<div class="top-left-bottom"><b>${TEACHER_RESOURCES_QUESTION_BANK}</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
				<ul>
				
				  <c:forEach items="${questionBank}" var="questionBank_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${stagent_list.id}&flag=${stagentFlag}"> ${questionBank_list.itemTitle}</a><span>[${questionBank_list.addTime}]</span></li>
				  </c:forEach>
				</ul>
				
				<c:if test="${empty questionBank}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /><span>暂无内容</span></div>
				</c:if>
			</div>
			
			
	       </div>
	
		
		</div>
			
		
		<div class="clear"></div>
<%--E 主体 --%>

<%--引入 footer --%>
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