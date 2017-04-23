<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${SCHOOL_TEACHER_RESOURCES}-${WEBSITE_NAME}</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>

<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/beforelist.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${CTP_HOME}/css/teaching-resources.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript">

$(function(){
	
	//第一个选项默认css
	$(".tab-container > div >a:first-child").addClass("newstyle");
	
	$(".tab-container > div >a").bind("click",function(){
		
		//获取点击的第几个选项
		var index=$(this).index();
		
	
		//添加css
		$(this).addClass("newstyle");
		
		
		//将该选项的对应的div显示
		$(".table-content-div").children().eq(index).show();
		//其他div的隐藏
		 for(var i=0;i<6;i++){
			if(i!=index){
			 $(".table-content-div").children().eq(i).hide();
			}
		} 
		
		
		//其他选项移除css
		for(var i=1;i<=6;i++){
			if(i!=index){
			$(this).parent().children("a").eq(i).removeClass("newstyle");
			}
			
		} 
		if(index!=0){
			$(this).parent().children("a").eq(0).removeClass("newstyle");
		}
		
	});
	
});


</script>

</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<div id="location"><span>您现在的位置: 后台管理 ></span><span>${SCHOOL_TEACHER_RESOURCES }></span>
		<a href="${CTP}/admin/list/manageResource">进入${SCHOOL_TEACHER_RESOURCES }管理</a>
</div>

    <!--S CONETNT-->
    <div class="tresource">
    <div class="content">
    	
    	<!-- Start Tabs !-->

	<div class="tab-container">
	<div id="c1">
	     <c:forEach items="${classlist}"  var="class_list">
		    <a href="javascript:void(0);" data-cid="${class_list.id}">${class_list.className}</a>
		 </c:forEach>   
	</div>


</div><!-- Tab Container !-->

<!--S  DIV  对应内容 -->
<div class="table-content-div">

<!-- 一 -->
<div class="tab-content">
<span class="grade-span"><b>一年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><a href="${CTP}/admin/list/resource?classId=1&menuId=${menu_list.id}&p=1">${menu_list.resourceName}</a></span>
</c:forEach>
</div>

</div>

<!-- 二 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><b>二年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><a href="${CTP}/admin/list/resource?classId=2&menuId=${menu_list.id}&p=1">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

<!-- 三 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><b>三年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><a href="${CTP}/admin/list/resource?classId=3&menuId=${menu_list.id}&p=1">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

<!-- 四 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><b>四年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><a href="${CTP}/admin/list/resource?classId=4&menuId=${menu_list.id}&p=1">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

<!-- 五 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><b>五年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><a href="${CTP}/admin/list/resource?classId=5&menuId=${menu_list.id}&p=1">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

<!-- 六 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><b>六年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><a href="${CTP}/admin/list/resource?classId=6&menuId=${menu_list.id}&p=1">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>
</div>
</div>

<!--E DIV   对应内容-->


    	<!--e class-info-->
    </div>
    
    <!--E CONTENT-->

<div class="clear"></div>
<%--E 主体 --%>

<div class="footer">
			<center><span>Copyright &copy;万科城小学  版权所有 2016 All Rights Reserved.</span></center>
<br><br>
</div>
<%--引入footer --%>
</body>
</html>