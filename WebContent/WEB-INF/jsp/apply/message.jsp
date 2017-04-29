<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
<!DOCTYPE html>
<html>
<head>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_APPLY" value="${pageContext.request.contextPath}/resources/apply"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../home/common/meta.jsp" flush="true"/>
<title>新生报名信息填写</title>

<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_APPLY}/css/applyMessage.css"/>
<link rel="stylesheet" href="${CTP_APPLY}/css/common.css"/>
<link href="${CTP}/resources/admin/css/magic-check.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
</head>
<body>
<%--引入header --%>

<jsp:include page="../home/common/header.jsp"></jsp:include>

<!-- 主体 -->
<div class="navi-info">
<img alt="" src="${CTP_APPLY}/img/navi.png">
<a href="${CTP}/apply/show/message">新生报名</a>
<a href="${CTP}/apply/show/status">报名进度</a>
</div>
<!--描述：需要填写的报名内容主要包括学生基本信息，监护人基本信息-->
		<div class="applybody-content-tab">
			<span class="applybody-content-tab-top">招生信息表</span>
			<!--描述：报名内容中的学生基本信息模块-->
			<div class="applybody-content-tab-basicMes">
				<span class="tab-basicMes-top">学生基本信息</span>
				
				<span class="tab-basicMes-stuname"><img src="${CTP_APPLY}/img/RequireField.png" />姓名</span>
				<input type="text" class="tab-basicMes-stuname-input"/>
				
				<span class="tab-basicMes-stusex"><img src="${CTP_APPLY}/img/RequireField.png" />性别</span>
				
			
				<input type="radio" id="male" name="radio" value="男" class="tab-basicMes-stusex-input1 "/><label for="male" class="tab-basicMes-stusex-men">男</label>
				<input type="radio" id="female" name="radio" value="女" class="tab-basicMes-stusex-input2 "/><label for="female" class="tab-basicMes-stusex-women">女</label>
				
				<span class="tab-basicMes-nation"><img src="${CTP_APPLY}/img/RequireField.png" />民族</span>
				<input type="text" class="tab-basicMes-nation-input"/>
				
				<span class="tab-basicMes-idnum"><img src="${CTP_APPLY}/img/RequireField.png" />身份证号</span>
				<input type="text" class="tab-basicMes-idnum-input"/>
				
				<span class="tab-basicMes-originalsch">原学校名称</span>
				<input type="text" class="tab-basicMes-originalsch-input"/>
				
				<span class="tab-basicMes-address"><img src="${CTP_APPLY}/img/RequireField.png" />现住址</span>
				<input type="text" class="tab-basicMes-address-input"/>
				
				<span class="tab-basicMes-register"><img src="${CTP_APPLY}/img/RequireField.png" />所在户籍</span>
				<input type="text" class="tab-basicMes-register-input"/>
			</div>
			<!--描述：报名内容中监护人信息-->
			<div class="applybody-contentn-tab-guardianMes">
				<span class="tab-guardianMes-top">监护人信息</span>
				
				<span class="tab-guardianMes-father-name"><img src="${CTP_APPLY}/img/RequireField.png" />父亲姓名</span>
				<input type="text" class="tab-guardianMes-father-name-input"/>
				
				<span class="tab-guardianMes-father-idnum"><img src="${CTP_APPLY}/img/RequireField.png" />父亲身份证</span>
				<input type="text" class="tab-guardianMes-father-idnum-input"/>
				
				<span class="tab-guardianMes-father-phonenum">父亲电话</span>
				<input type="text" class="tab-guardianMes-father-phonenum-input"/>
				
				<span class="tab-guardianMes-mother-name"><img src="${CTP_APPLY}/img/RequireField.png" />母亲姓名</span>
				<input type="text" class="tab-guardianMes-mother-name-input"/>
				
				<span class="tab-guardianMes-mother-idnum"><img src="${CTP_APPLY}/img/RequireField.png" />母亲身份证</span>
				<input type="text" class="tab-guardianMes-mother-idnum-input"/>
				
				<span class="tab-guardianMes-mother-phonenum">母亲电话</span>
				<input type="text" class="tab-guardianMes-mother-phonenum-input"/>
			</div>
			<div class="tab-message">填写注意：带<img src="${CTP_APPLY}/img/RequireField.png"/>为必填选项，请认真填写，检查无误后再提交，一经提交无法修改。</div>
			<div class="applybody-content-tab-submit">
				<a href="#">提交报名</a>
			</div>
	</div>

<div class="clear"></div>

<%--E 主体 --%>


<%--引入footer --%>
<jsp:include page="../home/common/footer.jsp"></jsp:include>	
	
</body>
</html>