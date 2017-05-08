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
<jsp:include page="common/meta.jsp" flush="true"/>	
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
<%--检测浏览器 --%>
<jsp:include page="../common/browsehappy.jsp"></jsp:include>

<!-- 导入header -->
<jsp:include page="common/header.jsp"></jsp:include>
	<!--S main-->
<div class="main">
<shiro:lacksRole name="superadmin">  
<div class="common-div"><img src="${CTP_ADMIN}/img/hi.png"/><span>欢迎访问后台管理系统<br>您的角色是：<b>${sessionScope.role}</b><br>用户名是：<b><shiro:principal/></b></span><span class="tips">Tips:后台系统会根据您的角色来为您生成不同的界面，权限也随之分配。</span></div>
</shiro:lacksRole>
<%--只有管理可见  --%>   
  <shiro:hasRole name="superadmin">
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
		
		
        
        
		<a href="${CTP}/admin/write/trends?typeName=校内新闻&typeFlag=news&fileType=ftrends">撰写新闻</a>
		<a href="${CTP}/admin/write/trends?typeName=通知公告&typeFlag=notice&fileType=ftrends">撰写通知公告</a>
		<a href="${CTP}/admin/write/culture?typeName=校务公开&typeFlag=affairs&fileType=fculture">撰写校务公开</a>
		
		<a href="${CTP}/admin/authority/allocation?p=1">角色分配</a>
		
		</div>
		<br><br><hr style="color:#CCCCCC;border:0.5px solid #CCCCCC" >
	    
	    <!--S 最近更新-->
	    <div class="last-update"> 
	    	<div class="last-update-news">
	    		<span class="last-update-span">最近更新学校新闻：</span>
	    		<div class="last-update-content">
	    			<ul>
	    			  <c:forEach items="${news}" var="news_list">
	    				<li><span>${news_list.addTime}</span><a href="${CTP}/admin/distribute/trends?id=${news_list.id}">${news_list.itemTitle}</a></li>
	    			  </c:forEach>
	    			</ul>
	    		</div>
	    	</div>
	    	<div class="last-update-notices">
	    		<span class="last-update-span">最近更新公告通知：</span>
	    		<div class="last-update-content">
	    			<ul>
	    			  <c:forEach items="${notice}" var="notice_list">
	    				<li><span>${notice_list.addTime}</span><a href="${CTP}/admin/distribute/trends?id=${notice_list.id}">${notice_list.itemTitle}</a></li>
	    			  </c:forEach>
	    			</ul>
	    		</div>
	    	</div>
	    	<div class="last-update-research">
	    		<span class="last-update-span">最近更新校务公开：</span>
	    		<div class="last-update-content">
	    			<ul>
	    			
	    			<c:forEach  items="${affairs}" var="affairs_list">
	    				<li><span>${affairs_list.addTime}</span><a href="${CTP}/admin/distribute/culture?id=${affairs_list.id}">${affairs_list.itemTitle}</a></li>
	    			</c:forEach>
	    			</ul>
	    		</div>
	    	</div>
	    </div>
	    <!--E 最近更新-->
	    
	   
	    
	</div>
	
</shiro:hasRole>
</div>
 
<!--E main-->
	<shiro:hasRole name="guest">
	<div class="guest-tip">
	<img alt="" src="${CTP_ADMIN}/img/tip.png"><br>
	<span>
	
	欢迎您访问后台管理系统，您目前的角色是游客，后台功能对您不可用，请联系超级管理员为您分配角色。
	</span>
	
	</div>
	</shiro:hasRole>
<!-- 引入footer -->
<jsp:include page="common/footer.jsp"></jsp:include>

	</body>
</html>
