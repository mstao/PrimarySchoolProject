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

<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/teaching-resources.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>

<script type="text/javascript">

$(function(){
	
	$(".tab-container > div >a").bind("click",function(){
		
		//获取点击的第几个选项
		var index=$(this).index();
	 
		//将该选项的对应的div显示
		$(".table-content-div").children().eq(index).show();
		//其他div的隐藏
		 for(var i=0;i<6;i++){
			if(i!=index){
			 $(".table-content-div").children().eq(i).hide();
			}
		} 
		
		$(this).addClass("js-load-a");
		//其他选项移除css
		for(var i=1;i<=6;i++){
			if(i!=(index+1)){
			$(this).parent().children("a").removeClass("js-load-a");
			}
			
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
	<span>${SCHOOL_STUDENT_LAB}</span>
</div>
<div class="content-location">
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="#">${SCHOOL_STUDENT_LAB}</a></span>
</div>

<div class="content">
	<div class="trends-top"><img src="${CTP_HOME}/img/teaching-resources.png"/> <span class="tag-ch">实验课列表</span> </div>
    
    <!--S CONETNT-->
    <div class="content">
    	<!--s class-info-->
    	
    	<!-- Start Tabs !-->

<div class="tab-container">


	<div id="c1">
		    <a href="javascript:void(0);" class="js-load-a">一年级</a>
		    <a href="javascript:void(0);" >二年级</a> 
			<a href="javascript:void(0);" >三年级</a> 
			<a href="javascript:void(0);" >四年级</a> 
			<a href="javascript:void(0);" >五年级</a> 
			<a href="javascript:void(0);" >六年级</a>
	</div>


</div><!-- Tab Container !-->

<!--S  DIV  对应内容 -->
<div class="table-content-div">

<div class="tab-content">
          1
</div>
<div class="tab-content"  style="display: none;">
          2
</div>
<div class="tab-content"  style="display: none;">
          3
</div>
<div class="tab-content"  style="display: none;">
          4
</div>
<div class="tab-content"  style="display: none;">
          5
</div>

<div class="tab-content"  style="display: none;">
          6
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