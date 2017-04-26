<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<script type="text/javascript">

$(function(){
	//退出系统处理
	$('.logout').bind('click',function(){
		layer.confirm('是否退出后台管理？', {
			  btn: ['退出','取消'] 
			}, function(){
				window.location.href="${pageContext.request.contextPath}/admin/loginRegister/logout";
			}, function(){
			  
			});
	});
});

</script>
<!--S header-->

 <%--后台必须登陆后才可见  --%>
 <shiro:authenticated>	
		<div class="header">
			
       
			<div class="page-menu-wrapper clearfix" >
				<ul class="menu-function">
					<li>
						<a href="${pageContext.request.contextPath}/admin/index" title="" class="home" >后台管理</a>                                       
					</li>
				</ul>
			 <%--超级管理员拥有所有权限  --%>	

				<ul class="menu-share">
                
               <%--撰写，管理，设置，校园文化，校园动态只有管理可见  --%>   
               <shiro:hasRole name="superadmin">
                 <li><a href="#">撰写</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="edit.html" >小学新闻</a></li>
							<li><a href="edit.html" >公告通知</a></li>		
			                <li><a href="${pageContext.request.contextPath}/admin/write/indexImages" >首页轮播图</a></li>		
					</ul>
                 </li>
                 <li><a href="#">管理</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/admin/authority/roleList" >角色管理</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/authority/allocation?p=1" >角色分配</a></li>
							<li><a href="#">用户管理</a></li>
			                <li><a href="${pageContext.request.contextPath}/admin/list/indexImages">首页轮播图</a></li>
					        <li><a href="${pageContext.request.contextPath}/admin/contact" >联系我们</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/copyright">版权声明</a></li>
					</ul>
                 </li>
                 <li><a href="#">设置</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/admin/list/trends?flag=news&p=1" >小学新闻</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/trends?flag=notice&p=1" >公告通知</a></li>		
			
					</ul>
                 </li>
                 <li><a href="#">${SCHOOL_CULTURE}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/admin/list/culture?flag=introduce&p=1">${SCHOOL_CULTURE_INTRODUCE}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/culture?flag=affairs&p=1">${SCHOOL_CULTURE_AFFAIRS}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/campusScenery">${SCHOOL_CULTURE_SIGHT}</a></li>
					</ul>
                 	
                 </li>
                 
                 <li><a href="#">${SCHOOL_TRENDS}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/admin/list/trends?flag=news&p=1">${SCHOOL_TRENDS_NEWS}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/trends?flag=notice&p=1">${SCHOOL_TRENDS_NOTICE}</a></li>
					</ul>
                 </li>
          </shiro:hasRole>
          
           <%--阳光德育 只有  管理员  ，德育处可见  --%>  
           <shiro:hasAnyRoles name="superadmin,education">
                 <li><a href="#">${SCHOOL_EDUCATION}</a>
                 	  <ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/admin/list/education?flag=education&p=1">${SCHOOL_EDUCATION_MAIN}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/education?flag=speak&p=1">${SCHOOL_EDUCATION_SPEAK}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/education?flag=active&p=1">${SCHOOL_EDUCATION_ACTIVE}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/education?flag=parents&p=1#">${SCHOOL_EDUCATION_PARENTS}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/education?flag=stagent&p=1">${SCHOOL_EDUACTION_STAGENT}</a></li>
					</ul>
                 </li>
           </shiro:hasAnyRoles>       
            <shiro:hasAnyRoles name="superadmin,education">
                 <li><a href="#">${SCHOOL_STUDENT}</a>
                 	 <ul class="dropdown-menu follow">
						
						<%--学生天地中的  沐浴书香 ，活动风采 只有  管理员  ，德育处可见  --%>  	
						<shiro:hasAnyRoles name="superadmin,education">	
							<li><a href="${pageContext.request.contextPath}/admin/list/student?flag=book&p=1">${SCHOOL_STUDENT_BOOK}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/student?flag=activity&p=1">${SCHOOL_STUDENT_ACTIVITY}</a></li>
						</shiro:hasAnyRoles>	
						
							
							<li><a href="${pageContext.request.contextPath}/admin/list/sclass">${SCHOLL_STUDENT_CLASS}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/labclass">${SCHOOL_STUDENT_LAB}</a></li>
					</ul>
                 	
                 </li>
           </shiro:hasAnyRoles>
            
            <%--教师园地  只有  管理员  ，教研组长，教导处  可见  --%>  
            <shiro:hasAnyRoles name="superadmin,supervisor,deanoffice">  
                 <li><a href="#">${SCHOOL_TEACHER}</a>
                 	<ul class="dropdown-menu follow">
                 	   
                 	   <%--教学资源 只有  管理员  ，教研组长  可见  --%> 
                 	   <shiro:hasAnyRoles name="superadmin,supervisor">  
							<li><a href="${pageContext.request.contextPath}/admin/list/teachingResource">${SCHOOL_TEACHER_RESOURCES}</a></li>
	                   </shiro:hasAnyRoles>
	                    
	                   <%--教学资源 只有  管理员  ，教导处  可见  --%>      
	                    <shiro:hasAnyRoles name="superadmin,deanoffice">      
	                        <li><a href="${pageContext.request.contextPath}/admin/list/teacher?flag=teachers&p=1">${SCHOOL_TEACHER_TEACHERS}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/admin/list/teacher?flag=train&p=1">${SCHOOL_TEACHER_TRAIN}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/admin/list/teacher?flag=prize&p=1">${SCHOOL_TEACHER_PRIZE}</a></li>	
					    </shiro:hasAnyRoles>
					</ul>
                 </li>
             </shiro:hasAnyRoles>    
              
             <%--党务工会 只有  管理员  可见  --%> 
             <shiro:hasRole name="superadmin">   
                 <li><a href="#">${SCHOOL_PARTY}</a>
                 	<ul class="dropdown-menu follow">
							<li><a href="${pageContext.request.contextPath}/admin/list/party?flag=branch&p=1">${SCHOOL_PARTY_BRANCH}</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/list/party?flag=trade_union&p=1">${SCHOOL_PARTY_TRADE_UNION}</a></li>
					</ul>
                 </li>
             </shiro:hasRole>
             
             <%--学校管理 只有  管理员 ，教导处，办公室  可见  --%> 
              <shiro:hasAnyRoles name="superadmin,deanoffice,office">   
                 <li><a href="#">${SCHOOL_MANAGE}</a>
                 	<ul class="dropdown-menu follow">
                 	
                 	 <%--学校管理 只有  管理员 ，教导处 可见  --%> 
                 	  <shiro:hasAnyRoles name="superadmin,deanoffice">   
							<li><a href="${pageContext.request.contextPath}/admin/list/manageDepartment">${SCHOOL_MANAGE_DEPARTMENT}</a></li>
	                 </shiro:hasAnyRoles>  
	                 
	                  <%--学校管理 只有  管理员 ，办公室 可见  --%> 
	                  <shiro:hasAnyRoles name="superadmin,office">   
	                        <li><a href="${pageContext.request.contextPath}/admin/list/manage?flag=recommendation&p=1">${SCHOOL_MANAGE_RECOMMENDATION}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/admin/list/manage?flag=notice&p=1">${SCHOOL_MANAGE_NOTICE}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/admin/list/manage?flag=rules&p=1">${SCHOOL_MANAGE_RULES}</a></li>
	                        <li><a href="${pageContext.request.contextPath}/admin/list/manage?flag=email&p=1">${SCHOOL_MANAGE_EMAIL}</a></li>
					  </shiro:hasAnyRoles>
					</ul>
                 </li>
                 
			 </shiro:hasAnyRoles>	
			 
				</ul>	
	
				<ul class="menu-function user">
					<li>
						<a href="${pageContext.request.contextPath}/admin/user/showUpdatePassword" title="点击修改密码" class="home" >${sessionScope.role}<shiro:principal/></a>                                       
					</li>
					<li>
						<a href="javascript:void(0);" title="" class="logout" class="home" >退出</a>                                       
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/main/index" title="" class="home" target="_blank" >网站</a>                                       
					</li>
				</ul>
			</div>
	
</div>
</shiro:authenticated>
<!--E header-->