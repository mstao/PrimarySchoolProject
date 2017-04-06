<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/classmain.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>


</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>
<div class="content-wrapper">
	<img src="${CTP_HOME}/img/school-f.jpg" />
	<span>班级主页</span>
</div>
<div class="content-location">
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="#">${SCHOLL_STUDENT_CLASS}</a></span>
</div>

<div class="content">
	<div class="trends-top"><img src="${CTP_HOME}/img/class2.png"/> <span class="tag-ch">${SCHOLL_STUDENT_CLASS}</span> </div>
    
    <!--S CONETNT-->
    <div class="class-content">
    	<!--s class-info-->
    	
    	<div class="class-content-only">
    		<div class="only-navi"><img src="${CTP_HOME}/img/class-nvai.png"/><span>2016级</span></div>
    		<div class="only-info">
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(1)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(2)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(3)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(4)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(5)班</a></span>
    		</div>
    	</div>
    	
    	<div class="class-content-only">
    		<div class="only-navi"><img src="${CTP_HOME}/img/class-nvai.png"/><span>2015级</span></div>
    		
    		
    		<div class="only-info">
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(1)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(2)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(3)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(4)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(5)班</a></span>
    		</div>
    	</div>
    	
    	<div class="class-content-only">
    		<div class="only-navi"><img src="${CTP_HOME}/img/class-nvai.png"/><span>2014级</span></div>
    		<div class="only-info">
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(1)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(2)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(3)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(4)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(5)班</a></span>
    		</div>
    	</div>
    	
    	<div class="class-content-only">
    		<div class="only-navi"><img src="${CTP_HOME}/img/class-nvai.png"/><span>2013级</span></div>
    		<div class="only-info">
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(1)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(2)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(3)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(4)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(5)班</a></span>
    		</div>
    	</div>
    	
    	
    	<div class="class-content-only">
    		<div class="only-navi"><img src="${CTP_HOME}/img/class-nvai.png"/><span>2012级</span></div>
    		<div class="only-info">
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(1)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(2)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(3)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(4)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(5)班</a></span>
    		</div>
    	</div>
    	
    	<div class="class-content-only">
    		<div class="only-navi"><img src="${CTP_HOME}/img/class-nvai.png"/><span>2011级</span></div>
    		<div class="only-info">
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(1)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(2)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(3)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(4)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(5)班</a></span>
    		</div>
    	</div>
    	
    	<div class="class-content-only">
    		<div class="only-navi"><img src="${CTP_HOME}/img/class-nvai.png"/><span>2011级</span></div>
    		<div class="only-info">
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(1)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(2)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(3)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(4)班</a></span>
    			<span><img src="${CTP_HOME}/img/class-dot.png"/><a href="#">一(5)班</a></span>
    		</div>
    	</div>
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