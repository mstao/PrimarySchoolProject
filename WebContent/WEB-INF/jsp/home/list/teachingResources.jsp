<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>
<title>${SCHOOL_TEACHER_RESOURCES}-${WEBSITE_NAME}</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>

<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/teaching-resources.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>

<script type="text/javascript">

$(function(){
	
	//第一个选项默认css
	$(".tab-container > div >a:first-child").addClass("js-load-a");
	
	$(".tab-container > div >a").bind("click",function(){
		
		//获取点击的第几个选项
		var index=$(this).index();
		
	
		//添加css
		$(this).addClass("js-load-a");
		
		
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
			$(this).parent().children("a").eq(i).removeClass("js-load-a");
			}
			
		} 
		if(index!=0){
			$(this).parent().children("a").eq(0).removeClass("js-load-a");
		}
		
	});
});

</script>

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
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="#">${SCHOOL_TEACHER_RESOURCES}</a></span>
</div>

<div class="content">
	<div class="trends-top"><img src="${CTP_HOME}/img/teaching-resources.png"/> <span class="tag-ch">${SCHOOL_TEACHER_RESOURCES}列表</span> </div>
    
    <!--S CONETNT-->
    <div class="content">
    	<!--s class-info-->
    	
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
<span class="grade-span"><img alt="" src="${CTP_HOME}/img/grade.png"><b>一年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><img alt="" src="${CTP_HOME}/img/course-dot.png"> <a href="${CTP}/category/teachingResources?classId=1&menuId=${menu_list.id}">${menu_list.resourceName}</a></span>
</c:forEach>
</div>

</div>

<!-- 二 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><img alt="" src="${CTP_HOME}/img/grade.png"><b>二年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><img alt="" src="${CTP_HOME}/img/course-dot.png"> <a href="${CTP}/category/teachingResources?classId=2&menuId=${menu_list.id}">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

<!-- 三 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><img alt="" src="${CTP_HOME}/img/grade.png"><b>三年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><img alt="" src="${CTP_HOME}/img/course-dot.png"> <a href="${CTP}/category/teachingResources?classId=3&menuId=${menu_list.id}">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

<!-- 四 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><img alt="" src="${CTP_HOME}/img/grade.png"><b>四年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><img alt="" src="${CTP_HOME}/img/course-dot.png"> <a href="${CTP}/category/teachingResources?classId=4&menuId=${menu_list.id}">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

<!-- 五 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><img alt="" src="${CTP_HOME}/img/grade.png"><b>五年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><img alt="" src="${CTP_HOME}/img/course-dot.png"> <a href="${CTP}/category/teachingResources?classId=5&menuId=${menu_list.id}">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

<!-- 六 -->
<div class="tab-content"  style="display: none;">
<span class="grade-span"><img alt="" src="${CTP_HOME}/img/grade.png"><b>六年级</b></span>

<div class="content-list">
<c:forEach items="${menu}" var="menu_list">
<span><img alt="" src="${CTP_HOME}/img/course-dot.png"> <a href="${CTP}/category/teachingResources?classId=6&menuId=${menu_list.id}">${menu_list.resourceName}</a></span>
</c:forEach>
</div>
</div>

</div>

<!--E DIV   对应内容-->


    	<!--e class-info-->
    </div>
    
    <!--E CONTENT-->
</div>
<div class="clear"></div>
<%--E 主体 --%>


<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>