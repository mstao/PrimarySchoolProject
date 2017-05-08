<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

$(function(){
	function tog(v){return v?'addClass':'removeClass';}   
	  
	$(document).on('input', '.searchinput', function() {  
	    $(this)[tog(this.value)]('x');  
	}).on('mousemove', '.x', function(e) {  
	    $(this)[tog(this.offsetWidth-24 < e.clientX-this.getBoundingClientRect().left)]('onX');     
	}).on('click', '.onX', function(){  
	   // $(this).removeClass('x onX').val('').change(); 
	   alert("zzzz");
	}); 
});
</script>    
<!-- S header -->
<div class="header">
		   <div class="header-top-bg">
				<div class="header-top" >
					
						<a href="${pageContext.request.contextPath}/list/findScore">成绩查询</a>|<a href="${pageContext.request.contextPath}/list/classTable">课表查询</a>|<a href="${pageContext.request.contextPath}/apply/show/stuLogin">在线报名</a>
						<div class="search">
						   <input type="text" name="" class="searchinput" placeholder="输入搜索关键词">
					    </div>
				    
				</div>
			</div>
		
			<div class="header-school-logo-bg">
				<div class="school-logo"><img src="${pageContext.request.contextPath}/resources/home/img/logo.png" width="120" height="120"> &nbsp; &nbsp;<img src="${pageContext.request.contextPath}/resources/home/img/school_name.png"/>
				</div>
				 
			</div>
			<div class="header-nav-bg">
				<div class="page-menu-wrapper">
					
			     <ul >
                 <li><a href="${pageContext.request.contextPath}/main/index">网站首页</a>
                 	
                 </li>

				</ul>
			    	
				<ul class="menu-show">
					
                 <li><a href="${pageContext.request.contextPath}/category/culture">${SCHOOL_CULTURE}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/culture?flag=introduce&p=1">${SCHOOL_CULTURE_INTRODUCE}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/culture?flag=affairs&p=1">${SCHOOL_CULTURE_AFFAIRS}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/imglist">${SCHOOL_CULTURE_SIGHT}</a></li>
					</ul>
                 </li>
                 
                 <li><a href="${pageContext.request.contextPath}/category/trends">${SCHOOL_TRENDS}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/trends?flag=news&p=1">${SCHOOL_TRENDS_NEWS}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/trends?flag=notice&p=1">${SCHOOL_TRENDS_NOTICE}</a></li>
					</ul>
                 </li>
                 
                  
                 
                 <li><a href="${pageContext.request.contextPath}/category/education">${SCHOOL_EDUCATION}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/education?flag=education&p=1">${SCHOOL_EDUCATION_MAIN}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/education?flag=speak&p=1">${SCHOOL_EDUCATION_SPEAK}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/education?flag=active&p=1">${SCHOOL_EDUCATION_ACTIVE}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/education?flag=parents&p=1">${SCHOOL_EDUCATION_PARENTS}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/education?flag=stagent&p=1">${SCHOOL_EDUACTION_STAGENT}</a></li>
							
					</ul>
                 </li>
                 
                 <li><a href="${pageContext.request.contextPath}/category/student">${SCHOOL_STUDENT}</a>
                 	<ul class="dropdown-menu follow">
                 		    <li><a href="${pageContext.request.contextPath}/list/student?flag=book&p=1">${SCHOOL_STUDENT_BOOK}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/student?flag=activity&p=1">${SCHOOL_STUDENT_BOOK}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/class">${SCHOLL_STUDENT_CLASS}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/labclass">${SCHOOL_STUDENT_LAB}</a></li>
							
					</ul>
                 </li>
                 
                 <li><a href="${pageContext.request.contextPath}/category/teacher">${SCHOOL_TEACHER}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/teachingResources">${SCHOOL_TEACHER_RESOURCES}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/teacher?flag=teachers&p=1">${SCHOOL_TEACHER_TEACHERS}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/teacher?flag=train&p=1">${SCHOOL_TEACHER_TRAIN}</a></li>
	                        <li><a href="#">${SCHOOL_TEACHER_PRIZE}</a></li>
					</ul>
                 </li>
                 
                 
                 <li><a href="${pageContext.request.contextPath}/category/party">${SCHOOL_PARTY}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/party?flag=branch&p=1">${SCHOOL_PARTY_BRANCH}</a></li>
							<li><a href="${pageContext.request.contextPath}/list/party?flag=trade_union&p=1">${SCHOOL_PARTY_TRADE_UNION}</a></li>
					</ul>
                 </li>
                 
                  <li><a href="${pageContext.request.contextPath}/category/manage">${SCHOOL_MANAGE}</a>
                 	<ul class="dropdown-menu follow">
							
	                        <li><a href="${pageContext.request.contextPath}/list/departmentLink?departmentId=1">${SCHOOL_MANAGE_DEPARTMENT}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/manage?flag=recommendation&p=1">${SCHOOL_MANAGE_RECOMMENDATION}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/manage?flag=notice&p=1">${SCHOOL_MANAGE_NOTICE}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/manage?flag=rules&p=1">${SCHOOL_MANAGE_RULES}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/headmaster-email">${SCHOOL_MANAGE_EMAIL}</a></li>
					</ul>
                 </li>
                 
				</ul>	
	
			
				</div>
			</div>
		
		</div>
<!-- E header -->	