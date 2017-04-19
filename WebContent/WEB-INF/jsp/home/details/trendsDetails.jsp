<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>${item.itemTitle}</title>
<link rel="stylesheet" href="${CTP_HOME}/css/header.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/footer.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/detailstype.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/time-axis.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/timeline/jquery.mousewheel.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/timeline/jquery.easing.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/timeline/history.js"></script>

<script type="text/javascript">

//将时间信息填充到具体显示区域中
$(function(){
	
	$(".date").each(function(){
		var _y_m_d=$("> .y-m-d",this).text();
	
		//将年份取出来
		var _y=_y_m_d.substring(0,4);
	    //将月份取出来
	    var _m=_y_m_d.substring(5,7);
        //将日期取出来
        var _d=_y_m_d.substring(8,10);
	    //将月份与日期拼接一下
	    var _m_d=_m+_d;
		$("> .year",this).text(_y);
		$("> .md",this).text(_m_d);
	});
});

</script>
</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<%--S 主体 --%>
<div class="content-wrapper">
			<img src="${CTP_HOME}/img/school-f.jpg" />
			<span>${item.itemTypeName}</span>
</div>
		<div class="content-location">
		<img src="${CTP_HOME}/img/home.png"/><span> 您现在的位置: <a href="${CTP}/main/index">万科城小学</a> > <a href="${CTP}/list/${url}?flag=${item.itemTypeFlag}&p=1">${item.itemTypeName}</a> > <a href="javascript:void(0);">详细内容</a></span>
		</div>
		<!--描述：此div包含新闻页面位置导航，新闻详细内容和新闻时间轴 -->
		<div class="container-bottom">
		
			<!--描述：此div中包含新闻详细内容和时间轴 -->
			<div class="container-bottom-center">
				
			<!--描述：新闻页面的加载，显示新闻的详细内容。 -->
				<div class="container-bottom-lift">
					<!--描述：新闻标题 -->
					<div class="news-title">
						<span> ${item.itemTitle}</span>
					</div>
					<!--描述：新闻作者，发布时间 -->
					<div class="new-attribute">
						<span class="new-attribute-span">作者：</span>
						<span class="new-attribute-name">小学网站</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="new-attribute-span">发布时间：</span>
						<span class="new-attribute-time">${item.addTime}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span class="new-attribute-span">浏览次数：</span>
						<span class="new-attribute-times">${item.viewCount}</span>
					</div>
					<!--描述：新闻具体内容 -->
					<div class="new-details">
						${item.itemContent}
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

    									<span class="numf">${WEB_CURRENT_YEAR}</span>
									</div>
								<div class="timeyear">YEAR</div>
							</div>
							<a href="#" class="clock"></a>
						</div>
					</div>
	
	<div id="content">
		<ul class="list">
		
		   <c:forEach items="${latestItem}" var="latestItem">
		 	<li >
				<div class="liwrap">
					<div class="lileft">
						<div class="date">
							<span class="md"></span>
							<span class="year"></span>
							
							<span class="y-m-d" style="display: none">${latestItem.addTime}</span>
						</div>
					</div>
					
					<div class="point"><b></b></div>
					
					<div class="liright">
					   
					   
					   <c:choose>
					     <c:when test="${empty cid}">
					         <div class="histt"><a href="${CTP}/details/${url}?id=${latestItem.id}&flag=${item.itemTypeFlag}">${latestItem.itemTitle}</a></div>
					     </c:when>
					     <c:otherwise>
					     	 <div class="histt"><a href="${CTP}/details/${url}?cid=${cid}&id=${latestItem.id}&flag=${item.itemTypeFlag}">${latestItem.itemTitle}</a></div>
					     </c:otherwise>
					   </c:choose>
						
						<div class="hisct">${latestItem.itemContent}</div>
					</div>
				</div>
			</li>
			</c:forEach>
			
			
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