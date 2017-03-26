<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%--引入通用静态资源 --%>
<jsp:include page="common/common_css.jsp"></jsp:include>
<jsp:include page="common/common_js.jsp"></jsp:include>
</head>
<body>
<%--引入header --%>

<jsp:include page="common/header.jsp"></jsp:include>

<%--S 主体 --%>
<!--S 幻灯图片-->
			<div id="wrapper">

		
		        <div class="slider-wrapper theme-default">
		            <div id="slider" class="nivoSlider">
		                <img src="slider/images/toystory.jpg" data-thumb="slider/images/toystory.jpg" alt="" />
		                <a href="http://dev7studios.com"><img src="slider/images/up.jpg" data-thumb="slider/images/up.jpg" alt="" title="This is an example of a caption" /></a>
		                <img src="slider/images/walle.jpg" data-thumb="slider/images/walle.jpg" alt="" data-transition="slideInLeft" />
		                <img src="slider/images/nemo.jpg" data-thumb="slider/images/nemo.jpg" alt="" title="#htmlcaption" />
		            </div>
		            <div id="htmlcaption" class="nivo-html-caption">
		                <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>. 
		            </div>
		        </div>

             </div>
		<!--E 幻灯图片-->
		
		<div class="content">
			
			<!--S 校园动态-->
			<div class="content-div campus-trends">
				<div class="trends-top campus-trends-top"><img src="img/dongtai.png"/> <span class="tag-ch">校园动态</span><span class="tag-en">Trends and Activities</span> <a class="link-tag" href="#">进入>></a></div>
			    
			     <!--S 校园动态内容-->
			     <div class="campus-nav-tag"><span class="news-tag">校内新闻</span><span class="jiantou"><img src="img/jiantou.png"/></span> <span class="notice-tag">通知公告</span><span class="jiantou-notice"><img src="img/jiantou.png"/></span> </div>
			        <!--S 轮播图-->
					<div class="slider-news">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="slider/images/nemo.jpg" alt="aaaaaa"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="slider/images/toystory.jpg" alt="aaaaaa"  /></a></li>
				   	
					</ul>
				    </div>
				  
					<!--E 轮播图-->
					
					<!--S 右侧新闻-->
					<div class="news">
						<div class="current-new">
						
			           <div class="current-new-info"><img src="img/dot.png"/><a href="" target="_blank">新闻222222222是dfdfs</a><span class="data-sub pub-data">[12-01]</span><img src="img/hot.gif" /></div>
			           <div class="current-new-info"><img src="img/dot.png"/><a href="" target="_blank">新闻222222222是dfdfs</a><span class="data-sub pub-data">[12-01]</span><img src="img/hot.gif" /></div>
			           <div class="current-new-info"><img src="img/dot.png"/><a href="" target="_blank">新闻222222222是dfdfs</a><span class="data-sub pub-data">[12-01]</span><img src="img/hot.gif" /></div>
							
					    <div class="look-more-news"><span><a href="${pageContext.request.contextPath}/news.do?type=xsx&p=1">更多新闻<img src="img/more.png"/></a></span></div>
						</div>
						
					<!--S 滚动-->
						<div class="roll-new-info-list">
										
						<ul>
						
						<li><img src="img/dot.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span><img src="img/hot.gif"/></li>
						<li><img src="img/dot.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span><img src="img/hot.gif"/></li>
						<li><img src="img/dot.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span><img src="img/hot.gif"/></li>
						</ul>
						
						
						</div>
						<a class="look-more-notice" href="#">更多<img src="img/more.png"/></a>
				   <!--E 滚动-->			
					</div>
					<!--E 右侧新闻-->
			    <!--E 校园动态内容-->
			</div>
			<!--E 校园动态-->
			
			<div class="clear"></div>
			
				
				
			<!--S 阳光德育-->
			<div class="even-bg sunshine-bg">
			<div class="content-div sunshine">
				<div class="trends-top sunshine-trends-top"><img src="img/sun.png"/> <span class="tag-ch">阳光德育</span><span class="tag-en">Sunshine moral education</span> <a class="link-tag" href="#">进入>></a></div>
			  
			    	 <!--S 轮播图-->
					<div class="slider-sunshine">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="slider/images/nemo.jpg" alt="zzz"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="slider/images/toystory.jpg" alt="dsdfa"  /></a></li>
				   	
					</ul>
				    </div>
				  
					<!--E 轮播图-->
			   
			    
			    <!--tab-->
			    <div class="tab-container">
					 <div class="tab">
				       <ul class="tab-card">
				         <li>主题教育</li>
				         <li>国旗下讲话</li>
				         <li>少先队活动</li>
				         <li>家长委员会</li>
				         <li>心灵驿站</li>
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				             
				           </div>
				         </dd>
				         <dd class="tp">
				              <div >
				             <p>标签三</p>
				             <p>标签三</p>
				             
				           </div>       
				         </dd>
				         <dd class="tp">
				           <div >
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp">
				           <div >
						          <ul>
								
										<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
										<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
										<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
									</ul>
				           </div>
				         </dd>
				       </dl>
				  </div>
				</div>
			    <!--tab-->
			</div>
			
		</div>
		<!--E 阳光德育-->
		
		<!--S 学生天地-->
		<div class="student-site">
			<div class="trends-top student-trends-top"><img src="img/stu-site.png"/> <span class="tag-ch">学生天地</span><span class="tag-en">The world of students</span> <a class="link-tag" href="#">进入>></a></div>
		
					<!--S 轮播图-->
					<div class="slider-sunshine">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="slider/images/nemo.jpg" alt="aaaaaa"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="slider/images/toystory.jpg" alt="aaaaaa"  /></a></li>
				   	
					</ul>
				    </div>
				  
					<!--E 轮播图-->
			   
			    
			    <!--tab-->
			    <div class="tab-container stu-container" >
					 <div class="tab">
				       <ul class="tab-card">
				         <li>沐浴书香</li>
				         <li>活动风采</li>
				         <li>班级主页</li>
				         <li>综合实验课</li>
				        
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				             
				           </div>
				         </dd>
				         <dd class="tp">
				              <div >
				             <p>标签三</p>
				             <p>标签三</p>
				             
				           </div>       
				         </dd>
				         <dd class="tp">
				           <div >
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         
				       </dl>
				  </div>
				</div>
			    <!--tab-->
		
		</div>
		<!--E 学生天地-->
		
		<div class="clear"></div>
		
		  <!--S 教师园地-->
		
			<div class="even-bg teacher-bg">
			<div class="content-div sunshine">
				<div class="trends-top sunshine-trends-top"><img src="img/teacher.png"/> <span class="tag-ch">教师园地</span><span class="tag-en">The teachers' corner</span> <a class="link-tag" href="#">进入>></a></div>
			  
			    	 <!--S 轮播图-->
					<div class="slider-sunshine">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="slider/images/nemo.jpg" alt="aaaaaa"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="slider/images/toystory.jpg" alt="aaaaaa"  /></a></li>
				   	
					</ul>
				    </div>
				  
					<!--E 轮播图-->
			   
			    
			    <!--tab-->
			    <div class="tab-container teacher-container">
					 <div class="tab">
				       <ul class="tab-card">
				         <li>教学资源</li>
				         <li>教师风采</li>
				         <li>教师培训</li>
				         <li>获奖登记</li>
				         
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				             
				           </div>
				         </dd>
				         <dd class="tp">
				              <div >
				             <p>标签三</p>
				             <p>标签三</p>
				             
				           </div>       
				         </dd>
				         <dd class="tp">
				           <div >
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         
				       </dl>
				  </div>
				</div>
			    <!--tab-->
			</div>
			
		</div>
		<!--E 教师园地-->	
	
		<!--S 学校管理   党务工会-->
		<div class="school-dang">
			<!--S 学校管理  -->
			<div class="school-div">
				<div class="trends-top school-trends-top"><img src="img/school.png"/> <span class="tag-ch">学校管理</span><span class="tag-en">Administration</span> <a class="link-tag" href="#">进入>></a></div>
			  <!--tab-->
			    <div class="tab-container school-container">
					 <div class="tab">
				       <ul class="tab-card">
				         <li>部门链接</li>
				         <li>评职评优</li>
				         <li>教师会议</li>
				         <li>规章制度</li>
				         <li>校长信箱</li>
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				             
				           </div>
				         </dd>
				         <dd class="tp">
				              <div >
				             <p>标签三</p>
				             <p>标签三</p>
				             
				           </div>       
				         </dd>
				         <dd class="tp">
				           <div >
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp">
				           <div >
						          <ul>
								
										<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
										<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
										<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
									</ul>
				           </div>
				         </dd>
				       </dl>
				  </div>
				</div>
			    <!--tab-->
				
			</div>
			<!--E 学校管理  -->
			
			<!--S 党务工会-->
			<div class="dang-div">
				<div class="trends-top dang-trends-top"><img src="img/dang.png"/> <span class="tag-ch">党务工会</span><span class="tag-en">The Party Union</span> <a class="link-tag" href="#">进入>></a></div>
			    <!--tab-->
			    <div class="tab-container school-container">
					 <div class="tab">
				       <ul class="tab-card">
				         <li>支部活动</li>
				         <li>工会活动</li>
				        
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				             
				           </div>
				         </dd>
				         
				  </div>
				</div>
			    <!--tab-->
			</div>
			<!--E 党务工会-->
			
		</div>
		
		<!--E 学校管理   党务工会-->
		
	</div>
		

       <div class="clear"></div>

<%--E 主体 --%>


<%--引入footer --%>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>