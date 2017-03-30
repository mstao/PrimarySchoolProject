<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>Insert title here</title>
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
			<span>阳光德育</span>
		</div>
		<div class="content-location">
		<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="#">阳光德育</a></span>
		</div>
		<div class="content-bottom">
		
			
			<div class="top-contaner-left">	
			<!-- 校园动态-->
			<div class="top-left">
				<div class="top-left-bottom"><b>校园动态</b><img src="${CTP_HOME}/img/jiantou.png"/></div>
				<ul>
					<li><a href="#">主题教育</a></li>
					<li><a href="#">国旗下讲话</a></li>
					<li><a href="#">少先队活动</a></li>
					<li><a href="#">家长委员会</a></li>
					<li><a href="#">心灵驿站</a></li>
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
			<!--热门排行-->
			<div class="float-div right">
				<div class="top-left-bottom"><b>主题教育</b> <img src="${CTP_HOME}/img/jiantou.png"/><span><a href="#">更多>></a></span></div>
				<ul>
				   <c:forEach items="${education}" var="education_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${education_list.id}&flag=${educationFlag}"> ${education_list.itemTitle}</a><span>[${education_list.addTime}]</span></li>
				   </c:forEach>
				</ul>
				<c:if test="${empty education}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
				</c:if>
				
			</div>
			
            <div class="clear"></div>
			<!--校内新闻-->
			<div class="float-div">
				<div class="top-left-bottom"><b>国旗下讲话</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
				<ul>
				   <c:forEach items="${speak}" var="speak_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${speak_list.id}&flag=${speakFlag}"> ${speak_list.itemTitle}</a><span>[${speak_list.addTime}]</span></li>
				   </c:forEach>
				</ul>
				<c:if test="${empty speak}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
				</c:if>
				
			</div>
			
			<div class="float-div right">
				<div class="top-left-bottom"><b>少先队活动</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
				<ul>
				   <c:forEach items="${active}" var="active_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${active_list.id}&flag=${activeFlag}"> ${active_list.itemTitle}</a><span>[${active_list.addTime}]</span></li>
				   </c:forEach>
				</ul>
				
				<c:if test="${empty active}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
				</c:if>
			</div>
			<div class="clear"></div>
			<div class="float-div ">
				<div class="top-left-bottom"><b>家长委员会</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
				<ul>
				  <c:forEach items="${parents}" var="parents_list">
					<li><img src="${CTP_PATH}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${parents_list.id}&flag=${parentsFlag}"> ${parents_list.itemTitle}</a><span>[${parents_list.addTime}]</span></li>
				  </c:forEach>
				</ul>
				<c:if test="${empty parents}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
				</c:if>
				
			</div>
			<div class="float-div right">
				<div class="top-left-bottom"><b>心灵驿站</b><img src="${CTP_HOME}/img/jiantou.png"/> <span><a href="#">更多>></a></span></div>
				<ul>
				
				  <c:forEach items="${stagent}" var="stagent_list">
					<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${stagent_list.id}&flag=${stagentFlag}"> ${stagent_list.itemTitle}</a><span>[${stagent_list.addTime}]</span></li>
				  </c:forEach>
				</ul>
				
				<c:if test="${empty stagent}">
				<div class='no-message'><img src='${CTP_HOME}/img/nomessage.png' /></div>
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