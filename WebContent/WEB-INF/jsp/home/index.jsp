<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zhuye </title>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/slider/themes/default/default.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${CTP_HOME}/slider/themes/light/light.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${CTP_HOME}/slider/themes/dark/dark.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${CTP_HOME}/slider/themes/bar/bar.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${CTP_HOME}/slider/nivo-slider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${CTP_HOME}/css/liMarquee.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/index.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
</head>
<body>
<%--引入header --%>

<jsp:include page="common/header.jsp"></jsp:include>

<%--S 主体 --%>
<!--S 幻灯图片-->
			<div id="wrapper">

		
		        <div class="slider-wrapper theme-default">
		            <div id="slider" class="nivoSlider">
		                <img src="${CTP_HOME}/slider/images/toystory.jpg" data-thumb="${CTP_HOME}/slider/images/toystory.jpg" alt="" />
		                <a href="#"><img src="${CTP_HOME}/slider/images/up.jpg" data-thumb="${CTP_HOME}/slider/images/up.jpg" alt="" title="This is an example of a caption" /></a>
		                <img src="${CTP_HOME}/slider/images/walle.jpg" data-thumb="${CTP_HOME}/slider/images/walle.jpg" alt="" data-transition="slideInLeft" />
		                <img src="${CTP_HOME}/slider/images/nemo.jpg" data-thumb="${CTP_HOME}/slider/images/nemo.jpg" alt="" title="#htmlcaption" />
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
				<div class="trends-top campus-trends-top"><img src="${CTP_HOME}/img/dongtai.png"/> <span class="tag-ch">校园动态</span><span class="tag-en">Trends and Activities</span> <a class="link-tag" href="#">进入>></a></div>
			    
			     <!--S 校园动态内容-->
			     <div class="campus-nav-tag"><span class="news-tag">校内新闻</span><span class="jiantou"><img src="${CTP_HOME}/img/jiantou.png"/></span> <span class="notice-tag">通知公告</span><span class="jiantou-notice"><img src="${CTP_HOME}/img/jiantou.png"/></span> </div>
			        <!--S 轮播图-->
					<div class="slider-news">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/nemo.jpg" alt="aaaaaa"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/toystory.jpg" alt="aaaaaa"  /></a></li>
				   	
					</ul>
				    </div>
				  
					<!--E 轮播图-->
					
					<!--S 右侧新闻-->
					<div class="news">
						<div class="current-new">
					   
					    <c:forEach items="${news}" var="news_list">
			             <div class="current-new-info"><img src="${CTP_HOME}/img/dot.png"/><a href="" target="_blank">${news_list.itemTitle}</a><span class="data-sub pub-data">[${news_list.addTime}]</span><img src="${CTP_HOME}/img/hot.gif" /></div>
						</c:forEach>	
							
					    <div class="look-more-news"><span><a href="#">更多新闻<img src="${CTP_HOME}/img/more.png"/></a></span></div>
						</div>
						
					<!--S 滚动-->
						<div class="roll-new-info-list">
										
						<ul>
						
						<li><img src="${CTP_HOME}/img/dot.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span><img src="${CTP_HOME}/img/hot.gif"/></li>
						<li><img src="${CTP_HOME}/img/dot.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span><img src="${CTP_HOME}/img/hot.gif"/></li>
						<li><img src="${CTP_HOME}/img/dot.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span><img src="${CTP_HOME}/img/hot.gif"/></li>
						</ul>
						
						
						</div>
						<a class="look-more-notice" href="#">更多<img src="${CTP_HOME}/img/more.png"/></a>
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
				<div class="trends-top sunshine-trends-top"><img src="${CTP_HOME}/img/sun.png"/> <span class="tag-ch">阳光德育</span><span class="tag-en">Sunshine moral education</span> <a class="link-tag" href="#">进入>></a></div>
			  
			    	 <!--S 轮播图-->
					<div class="slider-sunshine">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/nemo.jpg" alt="zzz"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/toystory.jpg" alt="dsdfa"  /></a></li>
				   	
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp">
				           <div >
						          <ul>
								
										<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
										<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
										<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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
			<div class="trends-top student-trends-top"><img src="${CTP_HOME}/img/stu-site.png"/> <span class="tag-ch">学生天地</span><span class="tag-en">The world of students</span> <a class="link-tag" href="#">进入>></a></div>
		
					<!--S 轮播图-->
					<div class="slider-sunshine">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/nemo.jpg" alt="aaaaaa"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/toystory.jpg" alt="aaaaaa"  /></a></li>
				   	
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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
				<div class="trends-top sunshine-trends-top"><img src="${CTP_HOME}/img/teacher.png"/> <span class="tag-ch">教师园地</span><span class="tag-en">The teachers' corner</span> <a class="link-tag" href="#">进入>></a></div>
			  
			    	 <!--S 轮播图-->
					<div class="slider-sunshine">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/nemo.jpg" alt="aaaaaa"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/toystory.jpg" alt="aaaaaa"  /></a></li>
				   	
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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
				<div class="trends-top school-trends-top"><img src="${CTP_HOME}/img/school.png"/> <span class="tag-ch">学校管理</span><span class="tag-en">Administration</span> <a class="link-tag" href="#">进入>></a></div>
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp">
				           <div >
						          <ul>
								
										<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
										<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
										<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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
				<div class="trends-top dang-trends-top"><img src="${CTP_HOME}/img/dang.png"/> <span class="tag-ch">党务工会</span><span class="tag-en">The Party Union</span> <a class="link-tag" href="#">进入>></a></div>
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
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				             <ul>
						
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="">只是打打打啊倒是</a><span class="pub-data sub-time">[2017-01-01]</span></li>
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

<script type="text/javascript" src="${CTP_HOME}/slider/jquery.nivo.slider.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/jquery.liMarquee.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/YuxiSlider.jQuery.min.js"></script>
<script type="text/javascript" src="//cdn.gbtags.com/jquery-easing/1.3/jquery.easing.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/tab.js" ></script>
<script type="text/javascript">
$(window).load(function() {
    $('#slider').nivoSlider({
    	'controlNav' :false
    });
});

$(function(){
	
    $('.roll-new-info-list').liMarquee({
        direction: 'up',//向上滚动
        scrollamount: 30//滚动速度
    });
    
    //新闻轮播
    $(".slider-news").YuxiSlider({
		width:420, //容器宽度
		height:300, //容器高度
		during:3000, //间隔3秒自动滑动
		speed:800, //移动速度0.8秒
		mousewheel:true, //是否开启鼠标滚轮控制
		direkey:false//是否开启左右箭头方向控制
	});
	$(".slider-sunshine").YuxiSlider({
		width:420, //容器宽度
		height:300, //容器高度
		during:4000, //间隔3秒自动滑动
		speed:800, //移动速度0.8秒
		mousewheel:true, //是否开启鼠标滚轮控制
		direkey:false//是否开启左右箭头方向控制
	});
	$(".tab").tab();
});


</script>