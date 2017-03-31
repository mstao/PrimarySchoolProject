<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- S header -->
<div class="header">
		   <div class="header-top-bg">
				<div class="header-top" >
					
						<a href="#">成绩查询</a>|<a href="">课表查询</a>|<a href="#">在线报名</a>
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
					
                 <li><a href="学校文化/学校简介.html">学校文化</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="#">学校简介</a></li>
							<li><a href="#">校务公开</a></li>
							<li><a href="#">校园风光</a></li>
					</ul>
                 </li>
                 
                 <li><a href="${pageContext.request.contextPath}/category/trends">校园动态</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/trends?flag=news&p=1">校内新闻</a></li>
							<li><a href="${pageContext.request.contextPath}/list/trends?flag=notice&p=1">通知公告</a></li>
					</ul>
                 </li>
                 
                  
                 
                 <li><a href="${pageContext.request.contextPath}/category/education">阳光德育</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/education?flag=education&p=1">主题教育</a></li>
							<li><a href="${pageContext.request.contextPath}/list/education?flag=speak&p=1">国旗下讲话</a></li>
							<li><a href="${pageContext.request.contextPath}/list/education?flag=active&p=1">少先队活动</a></li>
							<li><a href="${pageContext.request.contextPath}/list/education?flag=parents&p=1">家长委员会</a></li>
							<li><a href="${pageContext.request.contextPath}/list/education?flag=stagent&p=1">心灵驿站</a></li>
							
					</ul>
                 </li>
                 
                 <li><a href="${pageContext.request.contextPath}/category/student">学生天地</a>
                 	<ul class="dropdown-menu follow">
                 		    <li><a href="${pageContext.request.contextPath}/list/student?flag=book&p=1">沐浴书香</a></li>
							<li><a href="${pageContext.request.contextPath}/list/student?flag=activity&p=1">活动风采</a></li>
							<li><a href="#">班级主页</a></li>
							<li><a href="${pageContext.request.contextPath}/list/student?flag=lab&p=1">综合实验课</a></li>
							
					</ul>
                 </li>
                 
                 <li><a href="${pageContext.request.contextPath}/category/teacher">教师园地</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/teacher?flag=resources&p=1">教学资源</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/teacher?flag=teachers&p=1">教师风采</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/teacher?flag=train&p=1">教师培训</a></li>
	                        <li><a href="${pageContext.request.contextPath}/list/teacher?flag=prize&p=1">获奖登记</a></li>
					</ul>
                 </li>
                 
                 
                 <li><a href="${pageContext.request.contextPath}/category/party">党务工会</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/list/party?flag=branch&p=1">支部活动</a></li>
							<li><a href="${pageContext.request.contextPath}/list/party?flag=trade_union&p=1">工会活动</a></li>
					</ul>
                 </li>
                 
                  <li><a href="学校管理/学校管理.html">学校管理</a>
                 	<ul class="dropdown-menu follow">
							
	                        <li><a href="#">部门链接</a></li>
	                        <li><a href="#">评职评优</a></li>
	                        <li><a href="#">教师会议</a></li>
	                        <li><a href="#">规章制度</a></li>
	                        <li><a href="#">校长信箱</a></li>
					</ul>
                 </li>
                 
				</ul>	
	
			
				</div>
			</div>
		
		</div>
<!-- E header -->	