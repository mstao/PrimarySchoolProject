<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
<!DOCTYPE html>
<html>
<head>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="common/meta.jsp" flush="true"/>
<title>${WEBSITE_NAME} </title>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/slider/themes/default/default.css" type="text/css" media="screen" />

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


$(function() {
	$('.current-new-info').each(function() {
		var a = 21;
		var b = $(this).find('a').text();
		if (b.length > a) {
			$(this).find('a').text(b.substring(0, a) + '...')
		}
		var c = $("> span", this).text();
		var d = c.substr(6, 5);
		d = "[" + d + "]";
		$("> span", this).text(d);
	});
	
	
});
</script>
</head>
<body>
<%--检测浏览器 --%>
<jsp:include page="../common/browsehappy.jsp"></jsp:include>

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
						<li ><a href="${CTP}/details/trends?id=${s_list.id}&flag=${s_list.itemTypeFlag}" target="_blank" ><img src="${s_list.imagePath }" alt="${s_list.itemTitle}"  /></a></li>
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
						<li class="slider-li"><a href="${CTP}/details/education?id=${s_list.id}&flag=${s_list.itemTypeFlag}" target="_blank" ><img src="${s_list.imagePath}" alt="${s_list.itemTitle}"  /></a></li>
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
									<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/education?id=${education_list.id}&flag=${educationFlag}">${myTag:substr(education_list.itemTitle,0,35,true)}</a><span class="pub-data sub-time">[${education_list.addTime}]</span></li>
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
				     
						<c:forEach items="${slideStudent}" var="s_list">  
							<li class="slider-li"><a href="${CTP}/details/${CTP}/details/student?id=${s_list.id}&flag=${s_list.itemTypeFlag}" target="_blank" ><img src="${s_list.imagePath}" alt="${s_list.itemTitle}"  /></a></li>
						</c:forEach>	
					     <c:if test="${empty slideStudent}">
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
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/student?id=${student_list.id}&flag=${studentFlag}">${myTag:substr(student_list.itemTitle,0,35,true)}</a><span class="pub-data sub-time">[${student_list.addTime}]</span></li>
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
				     
						<c:forEach items="${slideTeacher}" var="s_list">  
							<li class="slider-li"><a href="${CTP}/details/${CTP}/details/teacher?id=${s_list.id}&flag=teachers" target="_blank" ><img src="${s_list.imagePath}" alt="${s_list.itemTitle}"  /></a></li>
						</c:forEach>	
					     <c:if test="${empty slideTeacher}">
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
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/teachingResources?menuId=${teacher_list.menuId}&classId=${teacher_list.classId}&tid=${teacher_list.id}&flag=${teacher_list.itemTypeFlag}">${myTag:substr(teacher_list.itemTitle,0,35,true)}</a><span class="pub-data sub-time">[${teacher_list.addTime}]</span></li>
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
				<div class="trends-top school-trends-top"><img src="${CTP_HOME}/img/school.png"/> <span class="tag-ch">学校管理</span><span class="tag-en">Administration</span> <a class="link-tag" href="${CTP}/category/manage">进入>></a></div>
			  <!--tab-->
			    <div class="tab-container school-container">
					 <div class="tab">
				       <ul class="tab-card tab-card-manage">
				         <li>部门链接</li>
				         <li>评职评优</li>
				         <li>教师会议</li>
				         <li>规章制度</li>
				   
				       </ul>
				       <dl class="tab-paper short-papaer">
				         <dd class="tp" >
				           <div>
				           	<ul>
						      <c:forEach items="${deptContent}" var="deptContent">
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/departmentLink?contentId=${deptContent.id}&departmentId=${deptContent.departmentId}&contentFlag=${deptContent.typeId}">${myTag:substr(deptContent.itemTitle,0,27,true)}</a><span class="pub-data sub-time">[${myTag:datesub(deptContent.addTime)}]</span></li>
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
				<div class="trends-top dang-trends-top"><img src="${CTP_HOME}/img/dang.png"/> <span class="tag-ch">党务工会</span><span class="tag-en">The Party Union</span> <a class="link-tag" href="${CTP}/category/party">进入>></a></div>
			    <!--tab-->
			    <div class="tab-container school-container">
					 <div class="tab">
				       <ul class="tab-card tab-card-party">
				         <li>支部活动</li>
				         <li>工会活动</li>
				        
				       </ul>
				       <dl class="tab-paper short-papaer">
				         <dd class="tp" >
				           <div>
				           	<ul>
						      <c:forEach items="${party}" var="party_list"> 
								<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/party?id=${party_list.id}&flag=${partyFlag}">${myTag:substr(party_list.itemTitle,0,32,true)}</a><span class="pub-data sub-time">[${myTag:datesub(party_list.addTime)}]</span></li>
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
eval(function(p,a,c,k,e,r){e=function(c){return c.toString(a)};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('$(j).g(7(){$(\'#0\').h({\'i\':1})});$(7(){$(\'.k-l-m-o\').p({q:\'r\',s:f});$(".0-v").4({5:6,2:8,9:n,a:b,c:d,e:1});$(".0-t").4({5:6,2:8,9:u,a:b,c:d,e:1});$(".3").3()});',32,32,'slider|false|height|tab|YuxiSlider|width|420|function|300|during|speed|800|mousewheel|true|direkey|30|load|nivoSlider|controlNav|window|roll|new|info|3000|list|liMarquee|direction|up|scrollamount|sunshine|4000|news'.split('|'),0,{}))

</script>