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
<title>新生报名状态信息</title>

<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_APPLY}/css/common.css"/>
<link rel="stylesheet" href="${CTP_APPLY}/css/applyStatus.css"/>
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
<div class="apply-status-content">
			<!--
            	作者：offline
            	时间：2017-04-27
            	描述：报名信息状态
           -->
			<div class="apply-status-show">
				<div class="status-submit-show">
					<img src="${CTP_APPLY}/img/已提交.png" /><span class="status-submit-show-hint">信息已提交</span></div>
				<div class="status-show-arrows"><img src="${CTP_APPLY}/img/箭头.png"/></div>
				<div class="status-checking-show">
					<img src="${CTP_APPLY}/img/审核中.png" /><span class="status-checking-show-hint">正在审核中</span></div>
				<div class="status-show-arrows"><img src="${CTP_APPLY}/img/箭头.png"/></div>
				<div class="status-checked-show">
					<img src="${CTP_APPLY}/img/审核未通过.png" /><span class="status-checked-show-hint">审核通过</span></div>
			</div>	
			
			<div class="apply-info-tips">
			
			<span><img alt="" src="${CTP_APPLY}/img/complete-tips.png">您已完成学生报名</span>
			</div>
			<div class="student-info">
			
			
			<div class="stu-info-left">
			  <img alt="" src="${CTP_APPLY}/img/学生填报.png" class="stu-info-mm">
			  <img alt="" src="${CTP_APPLY}/img/认证.png" class="stu-info-ren">
			  
			  <span class="notice">提示：报名成功显示为 <img alt="" src="${CTP_APPLY}/img/认证.png" >，正在审核显示为<img alt="" src="${CTP_APPLY}/img/未认证.png" >,报名失败显示为：<img alt="" src="${CTP_APPLY}/img/失败.png" ></span>
			  
			  <div class="reason">
			  <span class="reason-navi"><img src="${CTP_APPLY}/img/reason-tips.png"/>报名失败原因：</span>
			  
			  <div class="info">DIV是层叠样式表中的定位技术，全称DIVision，即为划分。DIV在编程中又叫做整除，即只得商的整数。DIV是一个块级元素。这意味着它的内容自动地开始一个新行。实际上，换行是固有的唯一格式表现。可以通过class或id应用额外的样式。DIV元素是用来为HTML文档内大块（block-level）的内容提供结构和背景的元素。DIV的起始标签和结束标签之间的所有内容都是用来构成这个块的，其中所包含元素的特性由DIV标签的属性来控制，或者是通过使用样式表格式化这个块来进行控制。
			  </div>
			  </div>
			</div>
			
			<!-- 学生信息 -->
			<div class="stu-info-right">
			  <%-- <div class="no-message">
			   <center><img src="${CTP_APPLY}/img/no-message.png"><span>暂无学生信息</span></center>
			 </div> --%> 
			 
			  <div class="stu-info-display">
			      <span class="tips">学生基本信息</span><br>
			      <div><span>姓名：</span><span>韩俊涛</span></div>
			      <div><span>性别：</span><span>男</span></div>
			      <div><span>民族：</span><span>汉</span></div>
			      <div><span>身份证号：</span><span>412821199506086011</span></div>
			      <div><span>原学校名称：</span><span>韩俊涛</span></div>
			      <div><span>现地址：</span><span>河南省郑州市河南省郑州市</span></div>
			      <div><span>所在户籍：</span><span>韩俊涛</span></div>
			 </div>
			 <br>
			 <div class="stu-info-display">
			      <span class="tips">监护人信息</span><br>
			      <div><span>父亲姓名：</span><span>zzz</span></div>
			      <div><span>父亲身份证：</span><span>412432344243423</span></div>
			      <div><span>父亲电话：</span><span>12345678</span></div>
			      <div><span>母亲姓名：</span><span>ccc</span></div>
			      <div><span>母亲身份证：</span><span>231231231331212</span></div>
			      <div><span>母亲电话：</span><span>12334444</span></div>
			 </div> 
			 
			 
			</div>
			</div>
</div>

<div class="clear"></div>

<%--E 主体 --%>


<%--引入footer --%>
<jsp:include page="../home/common/footer.jsp"></jsp:include>	
	
</body>
</html>