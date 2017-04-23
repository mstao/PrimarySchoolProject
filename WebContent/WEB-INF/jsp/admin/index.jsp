<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html>
<html>
<head>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台主页</title>
<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";

</script>
</head>
<body>
	<!-- 导入header -->
	<jsp:include page="common/header.jsp"></jsp:include>
	<!--S main-->
<div class="main">
	<span class="web_summary_span">网站概要</span>
	<div class="web_summary_content">
		<span class="current_tag">目前网站有</span>
		<table>
			<tr>
				<td>${SCHOOL_TRENDS }:</td><td><span><em>20</em></span> 条新闻</td>
				<td>${SCHOOL_EDUCATION }:</td><td><span><em>20</em></span> 条公告</td>
				<td>${SCHOOL_STUDENT }:</td><td><span><em>20</em></span> 条新闻</td>
			</tr>
			<tr>
				<td>${SCHOOL_TEACHER }:</td><td><span><em>20</em></span> 条规章</td>
				<td>${SCHOOL_PARTY }:</td><td><span><em>20</em></span> 条项目</td>
				<td>${SCHOOL_MANAGE }:</td><td><span><em>20</em></span> 条新闻</td>
			</tr>

		</table>
		<span class="link_operation_span">点击下面的链接快速操作</span>
		<div class="operate_div">
		<a href="edit.html">撰写新闻</a><a href="edit.html">撰写公告通知</a><a href="edit.html">撰写在研项目</a><a href="list.html">查看文档</a>
		</div>
		<br><br><hr style="color:#CCCCCC;border:0.5px solid #CCCCCC" >
	    
	    <!--S 最近更新-->
	    <div class="last-update"> 
	    	<div class="last-update-news">
	    		<span class="last-update-span">最近更新中心新闻：</span>
	    		<div class="last-update-content">
	    			<ul>
	    				<li><span>12.5</span><a href="edit_details.html">国家重大科研仪器设备研制项目《新一代高衬度低剂量X射线相位衬度CT装置》项目研讨会成功召开</a></li>
	    				<li><span>12.5</span><a href="edit_details.html">国家重大科研仪器设备研制项目《新一代高衬度低剂量X射线相位衬度CT装置》项目研讨会成功召开</a></li>
	    			</ul>
	    		</div>
	    	</div>
	    	<div class="last-update-notices">
	    		<span class="last-update-span">最近更新公告通知：</span>
	    		<div class="last-update-content">
	    			<ul>
	    				<li><span>12.5</span><a href="edit_details.html">国家重大科研仪器设备研制项目《新一代高衬度低剂量X射线相位衬度CT装置》项目研讨会成功召开</a></li>
	    				<li><span>12.5</span><a href="edit_details.html">国家重大科研仪器设备研制项目《新一代高衬度低剂量X射线相位衬度CT装置》项目研讨会成功召开</a></li>
	    			</ul>
	    		</div>
	    	</div>
	    	<div class="last-update-research">
	    		<span class="last-update-span">最近的研究亮点：</span>
	    		<div class="last-update-content">
	    			<ul>
	    				<li><span>12.5</span><a href="edit_details.html">国家重大科研仪器设备研制项目《新一代高衬度低剂量X射线相位衬度CT装置》项目研讨会成功召开</a></li>
	    				<li><span>12.5</span><a href="edit_details.html">国家重大科研仪器设备研制项目《新一代高衬度低剂量X射线相位衬度CT装置》项目研讨会成功召开</a></li>
	    			</ul>
	    		</div>
	    	</div>
	    </div>
	    <!--E 最近更新-->
	</div>
	
</div>
<!--E main-->

<!--S footer-->
<div class="footer">
			<center><span>Copyright &copy;万科城小学  版权所有 2016 All Rights Reserved.</span></center>
<br><br>
</div>
<!--E footer-->
	</body>
</html>
