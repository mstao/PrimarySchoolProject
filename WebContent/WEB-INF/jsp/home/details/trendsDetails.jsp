<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>Insert title here</title>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/detailstype.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/time-axis.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/timeline/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/timeline/jquery.easing.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/timeline/history.js"></script>
</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>
<div class="content-wrapper">
			<img src="${CTP_HOME}/img/school-f.jpg" />
			<span>阳光德育</span>
		</div>
		<div class="content-location">
		<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="#">万科城小学</a> > <a href="#">阳光德育</a> > <a href="#">详细内容</a></span>
		</div>
		<!--描述：此div包含新闻页面位置导航，新闻详细内容和新闻时间轴 -->
		<div class="container-bottom">
		
			<!--描述：此div中包含新闻详细内容和时间轴 -->
			<div class="container-bottom-center">
				
			<!--描述：新闻页面的加载，显示新闻的详细内容。 -->
				<div class="container-bottom-lift">
					<!--描述：新闻标题 -->
					<div class="news-title">
						<span> ${trends.itemTitle}</span>
					</div>
					<!--描述：新闻作者，发布时间 -->
					<div class="new-attribute">
						<span class="new-attribute-span">作者：</span>
						<span class="new-attribute-name">小学网站</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="new-attribute-span">发布时间：</span>
						<span class="new-attribute-time">${trends.addTime}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="new-attribute-span">浏览次数：</span>
						<span class="new-attribute-times">${trends.viewCount}</span>
					</div>
					<!--描述：新闻具体内容 -->
					<div class="new-details">
						${trends.itemContent}
					</div>
				</div>
				<!--描述：时间轴-->
           	<div class="container-bottom-right">
					<div id="arrow">
						<ul>
							<li class="arrowup"></li>
							<li class="arrowdown"></li>
						</ul>
					</div>

				<div id="history">

					<div class="title">
	
						<div id="circle">
							<div class="cmsk"></div>
								<div class="circlecontent">
									<div class="timeblock">

    									<span class="numf">123</span>
									</div>
								<div class="timeyear">YEAR</div>
							</div>
							<a href="#" class="clock"></a>
						</div>
					</div>
	
	<div id="content">
		<ul class="list">
			<li style="margin-top:-110px;">
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span>
							<span class="md">0809</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
						<div class="histt"><a href="#">HTML5 CSS3 发展历程 发布</a></div>
						<div class="hisct">修正了上一版本中的错误，欢迎大家测试，如果发现问题请联系我们,谢谢。我是一个很长很长的文章。我是一个很长很长的文章。我是一个很长很长的文章。我是一个很长很长的文章。我是一个很长很长的文章。我是一个很长很长的文章。
						我是一个很长很长的文章。我是一个很长很长的文章。我是一个很长很长的文章。我是一个很长很长的文章。我是一个很长很长的文章。我是一个很长很长的文章5。
						我是一个很长很长的文章4。我是一个很长很长的文章3。我是一个很长很长的文章2。我是一个很长很长的文章1。</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span>
							<span class="md">0807</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
						<div class="histt"><a href="#">HTML5 CSS3 发展历程 发布</a></div>
						<div class="hisct">随着用户的访问量增大,功能不能满足需求，我们进行了重大更新，对设计和功能都进行大幅度的升级,增加了原创，欣赏版块</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span>
							<span class="md">0528</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
						<div class="histt"><a href="#">官方微博</a></div>
						<div class="hisct">推出了HTML5 CSS3 官方微博</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
				
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span>
							<span class="md">0524</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
						<div class="histt"><a href="#">HTML5 CSS3 发展历程 上线</a></div>
						<div class="hisct">虽然功能还未健全，但是我们已迫不及待的让它去接受广大用户的火眼金睛</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span>
							<span class="md">0508</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
						<div class="histt"><a href="#">初期讨论</a></div>
						<div class="hisct">在集体探讨下，发现目前的HTML5 CSS3 发展历程已经不能满足需求，集体讨论=，这时候，韩老师之前的设计稿被端上了会议桌。</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2012</span>
							<span class="md">0701</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
						<div class="histt"><a href="#">灵感迸发</a></div>
						<div class="hisct">某天晚上的凌晨三点一刻，预想建立这样一个功能的网站，专为网页设计师。</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
				
					<div class="lileft">
						<div class="date">
							<span class="year">2012</span>
							<span class="md">0524</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
						<div class="histt"><a href="#">HTML5 CSS3 发展历程 上线</a></div>
						<div class="hisct">虽然功能还未健全，但是我们已迫不及待的让它去接受广大用户的火眼金睛</div>
					</div>
				</div>
			</li>
			<li>
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="year">2013</span>
							<span class="md">3月1日</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
						<div class="histt"><a href="#">初见成效</a></div>
						<div class="hisct">代码笔记第一版上线</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
</div>
			
            	</div>
			</div>
		</div>
		
		
		
		
		<div class="clear"></div>
		
<%--E 主体 --%>

<%--引入footer --%>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>