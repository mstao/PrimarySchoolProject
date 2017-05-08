<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${SCHOOL_TEACHER_RESOURCES}-${WEBSITE_NAME}</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>

<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/departmentlink.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/departmentlink.js"></script>
<script type="text/javascript">

var CTPPATH="${pageContext.request.contextPath}";
var CTP_HOME=CTPPATH+"/resources/home";



</script>
<title>部门链接主页</title>
</head>
<body>
<%--检测浏览器 --%>
<jsp:include page="../../common/browsehappy.jsp"></jsp:include>

<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>
<div class="content-wrapper">
	<img src="${CTP_HOME}/img/school-f.jpg" />
	<span>部门链接</span>
</div>
<div class="content-location">
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="#">部门链接</a></span>
</div>

<!--描述：主体div-->
		<div class="departmentlink-mainbody">
			<!--
            	作者：offline
            	时间：2017-04-19
            	描述：显示当前页面
            -->
			<div class="departmentlink-top"><img src="${CTP_HOME}/img/departmentLink.png"/> <span>部门链接列表</span> </div>
			<div class="departmentlink-departmentNameList">
				<ul class="departmentlink-dnl-ul">
						<c:forEach items="${departmentName}"  var="department_name">
		    				<li data-id="${department_name.id}">${department_name.departmentName}</li>
						 </c:forEach>   
				</ul>
			</div>
			<div class="departmentlink-mainbody-right">
			<!-- 用于显示部门链接中人员安排 -->
				<div class="departmentlink-sp">
					<div class="departmentlink-sp-top">
						<b>人员安排</b><img src="${CTP_HOME}/img/jiantou.png"/>
						<span><a href="${CTP}/list/departmentLinkContent?departmentId=${departmentId}&contentFlag=${staffFlag}&p=1">更多>></a></span>
					</div>
					<div class="departmentlink-sp-bottom">
						<c:forEach items="${departmentLinkStaff}"  var="departmentLink_Staff">
							<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/departmentLink?contentId=${departmentLink_Staff.id}&departmentId=${departmentId}&contentFlag=${departmentLink_Staff.typeId}">${myTag:substr(departmentLink_Staff.itemTitle,0,40,true)}   </a><span >[${departmentLink_Staff.addTime}]</span></li>
						</c:forEach>
					</div>
				</div>
			<!-- 部门链接链接中工作安排 -->
			
				<div class="departmentlink-jp">
					<div class="departmentlink-jp-top">
						<b>工作安排</b><img src="${CTP_HOME}/img/jiantou.png"/>
						<span><a href="${CTP}/list/departmentLinkContent?departmentId=${departmentId}&contentFlag=${jobFlag}&p=1">更多>></a></span>
					</div>
					<div class="departmentlink-jp-bottom">
							<c:forEach items="${departmentLinkJob}"  var="departmentLink_Job">
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/departmentLink?contentId=${departmentLink_Job.id}&departmentId=${departmentId}&contentFlag=${departmentLink_Job.typeId}">${myTag:substr(departmentLink_Job.itemTitle,0,40,true)}</a><span >[${departmentLink_Job.addTime}]</span></li>
							</c:forEach>
					</div>
				</div>
			</div>
		</div>
<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>