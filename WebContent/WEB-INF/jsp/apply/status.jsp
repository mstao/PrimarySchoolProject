<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
<%@ page import="java.util.Date"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
<script type="text/javascript">
<!--
$(function(){
	//退出系统处理
	$('.logout').bind('click',function(){
		layer.confirm('是否退出报名系统？', {
			  btn: ['退出','取消'] 
			}, function(){
				window.location.href="${pageContext.request.contextPath}/apply/show/stuLogin";
			}, function(){
			  
			});
	});
});
//-->
</script>
<%--检测浏览器 --%>
<jsp:include page="../common/browsehappy.jsp"></jsp:include>

<%--引入header --%>

<jsp:include page="../home/common/header.jsp"></jsp:include>

<!-- 主体 -->
<div class="navi-info">
<img alt="" src="${CTP_APPLY}/img/navi.png">

<a href="${CTP}/apply/index/status?id=${id}">报名进度</a>

<span class="time">报名时间:<b><fmt:formatDate value="${dateInfo.startDate}" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${dateInfo.endDate}" pattern="yyyy-MM-dd"/></b></span>

<a href="javascript:void(0);" class="logout">退出报名</a>
</div>

<%--S 设置时间 --%>
<c:set var="nowDate">  
    <fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" type="date"/>  
</c:set>  
<c:set var="XstartDate">  
    <fmt:formatDate value="${dateInfo.startDate}" pattern="yyyy-MM-dd" type="date"/>  
</c:set>  
<c:set var="XendDate">  
    <fmt:formatDate value="${dateInfo.endDate}" pattern="yyyy-MM-dd " type="date"/>  
</c:set>
  

<%--e 设置时间 --%>




<c:choose>

<%-- 后台不开启报名  ，页面提示报名未开始  --%>
<c:when test="${dateInfo.beginApply eq 0 || empty dateInfo}">
<div class="no-begin-apply">

<img alt="" src="${CTP_APPLY}/img/end.png">
<span class="no-begin-tips">暂未开始报名，请在开始时间之后开始报名</span>
</div>

</c:when>


<%-- 后台不开启报名  ，页面禁止显示渲染 --%>
<c:when test="${dateInfo.beginApply eq 1}">

<!-- S 时间段判断  -->
<c:choose>
<c:when test="${nowDate >= XstartDate && nowDate <= XendDate }">


<div class="apply-status-content">
			<!--
            	作者：offline
            	时间：2017-04-27
            	描述：报名信息状态
           -->
			<div class="apply-status-show">
				<div class="status-submit-show">
				 <c:choose>
				    <c:when test="${apply.status eq 3}">
				    	<img src="${CTP_APPLY}/img/未提交.png" /><span class="status-submit-show-hint" style="color:#666666;">信息未提交</span>
				    </c:when>
				    <c:otherwise>
				    	<img src="${CTP_APPLY}/img/已提交.png" /><span class="status-submit-show-hint">信息已提交</span>
				    </c:otherwise>
				 </c:choose>
				
					
				</div>
				
				
				<div class="status-show-arrows"><img src="${CTP_APPLY}/img/箭头.png"/></div>
				<div class="status-checking-show">
				<c:choose>
					  <c:when test="${apply.status eq 0}">
					  <img src="${CTP_APPLY}/img/审核中.png" /><span class="status-checking-show-hint">正在审核中</span>
				      </c:when>
				      <c:otherwise>
				      <img src="${CTP_APPLY}/img/审核中.png" /><span class="status-checking-show-hint">审核完成</span>
				      </c:otherwise>
				 </c:choose>	
						
					
					
				</div>
				
				<c:if test="${apply.status ne 0}"><div class="status-show-arrows"><img src="${CTP_APPLY}/img/箭头.png"/></div></c:if>

				<div class="status-checked-show">
					<c:choose>
							<c:when test="${apply.status eq 1}">
							  <img src="${CTP_APPLY}/img/审核通过.png" /><span class="status-checked-show-hint">审核通过</span>
							</c:when>
							<c:when test="${apply.status eq 2}">
							  <img src="${CTP_APPLY}/img/审核未通过.png" /><span class="status-checked-show-hint" style="color:#666666;">审核未通过</span>
							</c:when>
						
					</c:choose>
					
                </div>
			</div>	
			
			<div class="apply-info-tips">
			
			
			 <c:choose>
					<c:when test="${apply.status eq 1}">
					  <span><img alt="" src="${CTP_APPLY}/img/complete-tips.png">您已完成学生报名</span>
					</c:when>
					<c:when test="${apply.status eq 2}">
					  <span><img alt="" src="${CTP_APPLY}/img/feature-tips.png">学生报名失败,请在下面查看失败原因或者修改信息重新提交</span>
					  <a href="${CTP}/apply/show/update?id=${id}">修改信息</a>
					</c:when>
				    <c:when test="${apply.status eq 0}">
					  <span><img alt="" src="${CTP_APPLY}/img/shenhe-tips.png">学生报名信息正在审核中</span>
					</c:when>
			  </c:choose>
			  
			</div>
			<div class="student-info">
			
			
			<div class="stu-info-left">
			  <img alt="" src="${CTP_APPLY}/img/学生填报.png" class="stu-info-mm">
			  <c:choose>
					<c:when test="${apply.status eq 1}">
					  <img alt="" src="${CTP_APPLY}/img/认证.png" class="stu-info-ren">
					</c:when>
					<c:when test="${apply.status eq 2}">
					  <img alt="" src="${CTP_APPLY}/img/失败.png" class="stu-info-ren">
					</c:when>
				    <c:when test="${apply.status eq 0}">
					  <img alt="" src="${CTP_APPLY}/img/未认证.png" class="stu-info-ren">
					</c:when>
			  </c:choose>
			  
			  
			  
			  <span class="notice">提示：报名成功显示为 <img alt="" src="${CTP_APPLY}/img/认证.png" >，正在审核显示为<img alt="" src="${CTP_APPLY}/img/未认证.png" >,报名失败显示为：<img alt="" src="${CTP_APPLY}/img/失败.png" ></span>
			  
			  <c:if test="${apply.status eq 2}">
				  <div class="reason">
				  <span class="reason-navi"><img src="${CTP_APPLY}/img/reason-tips.png"/>报名失败原因：</span>
				  
				  <div class="info">
				  ${apply.reason}
				  </div>
				  </div>
			  </c:if>
			</div>
			
			<!-- 学生信息 -->
			<div class="stu-info-right">
			  <%-- <div class="no-message">
			   <center><img src="${CTP_APPLY}/img/no-message.png"><span>暂无学生信息</span></center>
			 </div> --%> 
			 
			  <div class="stu-info-display">
			      <span class="tips">学生基本信息</span><br>
			      <div><span>姓名：</span><span>${apply.stuName}</span></div>
			      <div><span>性别：</span><span>${apply.stuSex}</span></div>
			      <div><span>民族：</span><span>${apply.stuNation}</span></div>
			      <div><span>身份证号：</span><span>${apply.stuIdNum}</span></div>
			      <div><span>原学校名称：</span><span>${apply.originalSchool}</span></div>
			      <div><span>现地址：</span><span>${apply.address}</span></div>
			      <div><span>所在户籍：</span><span>${apply.register}</span></div>
			 </div>
			 <br>
			 <div class="stu-info-display">
			      <span class="tips">监护人信息</span><br>
			      <div><span>父亲姓名：</span><span>${apply.fatherName}</span></div>
			      <div><span>父亲身份证：</span><span>${apply.fatherIdNum}</span></div>
			      <div><span>父亲电话：</span><span>${apply.fatherPhone}</span></div>
			      <div><span>母亲姓名：</span><span>${apply.motherName}</span></div>
			      <div><span>母亲身份证：</span><span>${apply.motherIdNum}</span></div>
			      <div><span>母亲电话：</span><span>${apply.motherPhone}</span></div>
			 </div> 
			 
			 
			</div>
			</div>
</div>
</c:when>

<c:otherwise>
<div class="no-begin-apply">

<img alt="" src="${CTP_APPLY}/img/sys-close.png">
<span class="no-begin-tips">不在报名时间段，系统暂不开放</span>
</div>

</c:otherwise>
</c:choose>

<!--E 时间段判断   -->


</c:when>
</c:choose>
<div class="clear"></div>

<%--E 主体 --%>


<%--引入footer --%>
<jsp:include page="../home/common/footer.jsp"></jsp:include>	
	
</body>
</html>