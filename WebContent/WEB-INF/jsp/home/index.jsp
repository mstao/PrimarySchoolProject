<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${WEBSITE_NAME} </title>
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
<script type="text/javascript" src="${CTP_HOME}/js/module/loadinfo.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript">

var CTPPATH="${pageContext.request.contextPath}";
var CTP_HOME=CTPPATH+"/resources/home";


$(function(){
	
	//新闻标题超出字数控制
	$('.current-new-info').each(function(){
		var maxwidth=21;
        var text=$(this).find('a').text();
		if(text.length>maxwidth){
			$(this).find('a').text(text.substring(0,maxwidth)+'...');
		}
		//将日期整理一下，不要年份
		var _date=$("> span",this).text();
		var _date_c=_date.substr(6,5);
		
		_date_c="["+_date_c+"]";
		$("> span",this).text(_date_c);	
	});
	

});

</script>
</head>
<body>
<%--引入header --%>

<jsp:include page="common/header.jsp"></jsp:include>

<%--S 主体 --%>
<!--S 幻灯图片-->
			<div id="wrapper">

		
		        <div class="slider-wrapper theme-default">
		            <div id="slider" class="nivoSlider">
		            <c:forEach items="${indexImages}" var="indexImages"> 
		                <img src="${indexImages.imgPath}" data-thumb="${indexImages.imgPath}" alt="" />
		            </c:forEach>  
		            </div>
		          <!--   <div id="htmlcaption" class="nivo-html-caption">
		                <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>. 
		            </div> -->
		        </div>

             </div>
		<!--E 幻灯图片-->
		
		<div class="content">
			
			<!--S 校园动态-->
			<div class="content-div campus-trends">
				<div class="trends-top campus-trends-top"><img src="${CTP_HOME}/img/dongtai.png"/> <span class="tag-ch">校园动态</span><span class="tag-en">Trends and Activities</span> <a class="link-tag" href="${CTP}/category/trends">进入>></a></div>
			    
			     <!--S 校园动态内容-->
			     <div class="campus-nav-tag"><span class="news-tag">校内新闻</span><span class="jiantou"><img src="${CTP_HOME}/img/jiantou.png"/></span> <span class="notice-tag">通知公告</span><span class="jiantou-notice"><img src="${CTP_HOME}/img/jiantou.png"/></span> </div>
			        <!--S 轮播图-->
					<div class="slider-news slide-s">
					<ul>
				    <c:forEach items="${sildeNews}" var="s_list">  
						<li class="slider-li"><a href="${CTP}/details/trends?id=${s_list.id}&flag=${s_list.itemTypeFlag}" target="_blank" ><img src="" alt="${s_list.itemTitle}"  /></a><div class="hide-content-slider" style="visibility: hidden;">${s_list.itemContent}</div></li>
					</c:forEach>	
				     <c:if test="${empty sildeNews}">
				       <li class="slider-li"><img src="${CTP_HOME}/img/noimage.gif" alt="暂无图片"  /></li>
				     </c:if>
					</ul>
				    </div>
				  
					<!--E 轮播图-->
					
					<!--S 右侧新闻-->
					<div class="news">
						<div class="current-new">
					   
					    <c:forEach items="${news}" var="news_list">
			               <div class="current-new-info"><img src="${CTP_HOME}/img/dot.png"/><a href="${CTP}/details/trends?id=${news_list.id}&flag=${newsFlag}" target="_blank">${news_list.itemTitle}</a><span class="data-sub pub-data">[${news_list.addTime}]</span><img src="${CTP_HOME}/img/hot.gif" /></div>
						</c:forEach>	
							
					    <div class="look-more-news"><span><a href="${CTP}/list/trends?flag=${newsFlag}&p=1">更多新闻<img src="${CTP_HOME}/img/more.png"/></a></span></div>
						</div>
						
					   <!--S 滚动-->
						<div class="roll-new-info-list">
										
						<ul>
						<c:forEach items="${notice}" var="notice">
						<li><img src="${CTP_HOME}/img/dot.png"/><a href="${CTP}/details/trends?id=${notice.id}&flag=${noticeFlag}">${notice.itemTitle}</a><span class="pub-data sub-time">[${notice.addTime}]</span><img src="${CTP_HOME}/img/hot.gif"/></li>
						</c:forEach>
						</ul>
						
						
						</div>
						<a class="look-more-notice" href="${CTP}/list/trends?flag=${noticeFlag}&p=1">更多<img src="${CTP_HOME}/img/more.png"/></a>
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
				<div class="trends-top sunshine-trends-top"><img src="${CTP_HOME}/img/sun.png"/> <span class="tag-ch">阳光德育</span><span class="tag-en">Sunshine moral education</span> <a class="link-tag" href="${CTP}/category/education">进入>></a></div>
			  
			    	 <!--S 轮播图-->
					<div class="slider-sunshine slide-s">
					<ul>
				     
				     <c:forEach items="${sildeEdu}" var="s_list">  
						<li class="slider-li"><a href="${CTP}/details/education?id=${s_list.id}&flag=${s_list.itemTypeFlag}" target="_blank" ><img src="" alt="${s_list.itemTitle}"  /></a><div class="hide-content-slider" style="visibility: hidden;">${s_list.itemContent}</div></li>
					</c:forEach>	
				     <c:if test="${empty sildeEdu}">
				       <li class="slider-li"><img src="${CTP_HOME}/img/noimage.gif" alt="暂无图片"  /></li>
				     </c:if>
				   	
					</ul>
				    </div>
				  
					<!--E 轮播图-->
			   
			    
			    <!--tab-->
			    <div class="tab-container">
					 <div class="tab">
				       <ul class="tab-card  tab-card-education">
				         <li>主题教育</li>
				         <li>国旗下讲话</li>
				         <li>少先队活动</li>
				         <li>家长委员会</li>
				         <li>心灵驿站</li>
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp">
				           <div>
				           	<ul>
						        <c:forEach items="${education}"  var="education_list">
									<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${education_list.id}&flag=${educationFlag}">${education_list.itemTitle}</a><span class="pub-data sub-time">[${education_list.addTime}]</span></li>
								</c:forEach>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div></div>
				         </dd>
				         <dd class="tp">
				              <div></div>       
				         </dd>
				         <dd class="tp">
				           <div></div>
				         </dd>
				         <dd class="tp">
				           <div></div>
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
			<div class="trends-top student-trends-top"><img src="${CTP_HOME}/img/stu-site.png"/> <span class="tag-ch">学生天地</span><span class="tag-en">The world of students</span> <a class="link-tag" href="${CTP}/category/student">进入>></a></div>
		
					<!--S 轮播图-->
					<div class="slider-sunshine slide-s">
					<ul>
				     
						<c:forEach items="${sildeStudent}" var="s_list">  
							<li class="slider-li"><a href="${CTP}/details/${CTP}/details/student?id=${s_list.id}&flag=${s_list.itemTypeFlag}" target="_blank" ><img src="" alt="${s_list.itemTitle}"  /></a><div class="hide-content-slider" style="visibility: hidden;">${s_list.itemContent}</div></li>
						</c:forEach>	
					     <c:if test="${empty sildeStudent}">
					       <li class="slider-li"><img src="${CTP_HOME}/img/noimage.gif" alt="暂无图片"  /></li>
					     </c:if>
					</ul>
				    </div>
				  
					<!--E 轮播图-->
			   
			    
			    <!--tab-->
			    <div class="tab-container stu-container" >
					 <div class="tab">
				       <ul class="tab-card tab-card-student">
				         <li>沐浴书香</li>
				         <li>活动风采</li>
				         <li>班级主页</li>
				         <li>综合实验课</li>
				        
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						        
						      <c:forEach items="${student}" var="student_list">
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/student?id=${student_list.id}&flag=${studentFlag}">${student_list.itemTitle}</a><span class="pub-data sub-time">[${student_list.addTime}]</span></li>
							  </c:forEach>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div></div>
				         </dd>
				         <dd class="tp">
				           <div></div>       
				         </dd>
				         <dd class="tp">
				           <div></div>
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
				<div class="trends-top sunshine-trends-top"><img src="${CTP_HOME}/img/teacher.png"/> <span class="tag-ch">教师园地</span><span class="tag-en">The teachers' corner</span> <a class="link-tag" href="${CTP}/category/teacher">进入>></a></div>
			  
			    	 <!--S 轮播图-->
					<div class="slider-sunshine slide-s">
					<ul>
				     
						<c:forEach items="${sliderTeacher}" var="s_list">  
							<li class="slider-li"><a href="${CTP}/details/${CTP}/details/teacher?id=${s_list.id}&flag=teachers" target="_blank" ><img src="" alt="${s_list.itemTitle}"  /></a><div class="hide-content-slider" style="visibility: hidden;">${s_list.itemContent}</div></li>
						</c:forEach>	
					     <c:if test="${empty sliderTeacher}">
					       <li class="slider-li"><img src="${CTP_HOME}/img/noimage.gif" alt="暂无图片"  /></li>
					     </c:if>
					</ul>
				    </div>
				  
					<!--E 轮播图-->
			   
			    
			    <!--tab-->
			    <div class="tab-container teacher-container">
					 <div class="tab">
				       <ul class="tab-card tab-card-teacher">
				         <li>教学资源</li>
				         <li>教师风采</li>
				         <li>教师培训</li>
				         <li>获奖登记</li>
				         
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						       <c:forEach items="${teacher}" var ="teacher_list">
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/teachingResources?menuId=${teacher_list.menuId}&classId=${teacher_list.classId}&tid=${teacher_list.id}&flag=${teacher_list.itemTypeFlag}">${teacher_list.itemTitle}</a><span class="pub-data sub-time">[${teacher_list.addTime}]</span></li>
							   </c:forEach>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>				             
				           </div>
				         </dd>
				         <dd class="tp">
				              <div >
				              </div>       
				         </dd>
				         <dd class="tp">
				           <div>
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
				       <ul class="tab-card tab-card-manage">
				         <li>部门链接</li>
				         <li>评职评优</li>
				         <li>教师会议</li>
				         <li>规章制度</li>
				   
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						      <c:forEach items="${manage}" var="manage_list">
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/manage?id=${manage_list.id}&flag=${manageFlag}">${manage_list.itemTitle}</a><span class="pub-data sub-time">[${manage_list.addTime}]</span></li>
							  </c:forEach>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>				             
				           </div>
				         </dd>
				         <dd class="tp">
				              <div >

				           </div>       
				         </dd>
				         <dd class="tp">
				           <div >
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
				       <ul class="tab-card tab-card-party">
				         <li>支部活动</li>
				         <li>工会活动</li>
				        
				       </ul>
				       <dl class="tab-paper">
				         <dd class="tp" >
				           <div>
				           	<ul>
						      <c:forEach items="${party}" var="party_list"> 
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/party?id=${party_list.id}&flag=${partyFlag}">${party_list.itemTitle}</a><span class="pub-data sub-time">[${party_list.addTime}]</span></li>
							  </c:forEach>
							</ul>
				           </div>
				         </dd>
				         <dd class="tp" >
				           <div>
				           </div>
				         </dd>
				         </dl>
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
    	//'effect':'slideInLeft'
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