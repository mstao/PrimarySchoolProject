<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>
<title>联系我们</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/copyright.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
</head>
<body>
<%--检测浏览器 --%>
<jsp:include page="../../common/browsehappy.jsp"></jsp:include>

<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<div class="content-wrapper">
	<img src="${CTP_HOME}/img/school-f.jpg" />
	<span>联系我们</span>
</div>
<div class="content-location">
<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="javascript:void(0);">联系我们</a></span>
</div>

<%--S 主体 --%>
<!--S content-->
		<div class="content">
		<div class="trends-top"><img src="${CTP_HOME}/img/contact.png"/> <span class="tag-ch">联系我们</span> </div>
			<!--左  -->
			<div class="contact-copyright-left">
			  	<!-- Start Tabs !-->

				<div class="tab-container">
					<div id="c1">
					    
						    <a href="${CTP}/contact" class="default-check">联系我们</a>
			  				<a href="${CTP}/copyright" >版权声明</a>
					</div>	
				</div>
			</div>
			<!--右  -->
			<div class="contact-copyright-right">
			${contact.content}
			</div>
			
		</div>
		<!--E content-->
		 <div class="clear"></div>
<%--E 主体--%>

<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>