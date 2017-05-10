<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>Insert title here</title>
<link rel="stylesheet" href="${CTP_HOME}/css/classdetails.css" />
		<link rel="stylesheet" href="${CTP_HOME}/css/liMarqueeImg.css" />
		<link rel="stylesheet" href="${CTP}/resources/common/css/page.css"/>
		<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/YuxiSlider.jQuery.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/extends/jquery.liMarquee.js" ></script>
	</head>
<body>
<jsp:include page="../common/classHeader.jsp"></jsp:include>

<div id="mianBag">
	<div id="mianDiv1">
    	<!--图片切换-->
        <div id="tpthDiv">
          <!--S 轮播图-->
					<div class="slider-news">
					<ul>
				     
						<li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/nemo.jpg" alt="aaaaaa"  /></a></li>
					    <li class="slider-li"><a href="" target="_blank" ><img src="${CTP_HOME}/slider/images/toystory.jpg" alt="aaaaaa"  /></a></li>
				   	
					</ul>
				    </div>
				  
			<!--E 轮播图-->
        </div>
        <!--图片切换 end-->
        <!--班级简介-->
        <div id="bjjianjie">
        	<div id="bjjianjieT">
            	<div>${CLASS_SYNOPSIS }</div>
                <span><a href="${CTP }/details/classSynopsis?classId=${classId }&gradeFlag=${grade}&classFlag=${className }">更多>></a></span>
            </div>
            <div id="bjjianjieM">
            	<img src="${CTP_HOME}/img/bg1.jpg" />
                <span id="Lab_about">${myTag:substr(synopsis.classSynopsis,0,120,true)}</span>
            </div>
            
        </div>
        <!--班级简介 end-->
    </div>
    <div id="mianDiv2">
    	<!--导航栏-->
    	<div id="mianDiv2-nav">
    		<div id="mianDiv2-navT">
    			<img src="${CTP_HOME}/img/navs.png"/><span>班级导航</span>
    		</div>
    		<div id="mianDiv2-navB">
	            <ul>
          			
				        <li><a href="${CTP }/details/classSynopsis?classId=${classId }&gradeFlag=${grade}&classFlag=${className }">${CLASS_SYNOPSIS }</a></li>    
                   		<li><a href="${CTP }/list/classStyleList?classId=${classId }&gradeFlag=${grade}&classFlag=${className }">${CLASS_PHOTO }</a></li>
                   
      					<li><a href="${CTP }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=dynamic&p=1">${CLASS_ACIVITY }</a></li>
                   
      					<li><a href="${CTP }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=growthstory&p=1">${CLASS_STORY }</a></li>
     					<li><a href="${CTP }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=article&p=1">${CLASS_ARTICLE }</a></li>
	            </ul>
            </div>
        </div>
        <!--导航栏end-->
        <div id="mianDiv2-det">
        	<div id="mianDiv2-detT">
            	<div><img src="${CTP_HOME}/img/green.png"/> <span>${typeName }</span></div>
            </div>
            <div id="mianDiv2-detB">
            	<ul>
            	<c:if test="${classtype==CLASS_SYNOPSIS }">
            		<span>${synopsis.classSynopsis }</span>
            	</c:if>
            	<c:forEach var="tongyi" items="${item }">
                 	<li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/newsinfo?id=${tongyi.id}&gradeFlag=${grade}&classFlag=${className }&classId=${classId }"> ${myTag:substr(tongyi.itemTitle,0,30,true)}</a><span>[${tongyi.addTime }]</span></li>
                </c:forEach>
                </ul>
                
            </div>
            <!-- 分页导航引入 -->
			    ${toolBar}
        </div>
        
    </div>
    <!--班级风采-->
    <div id="banjifcDiv">
    	<div id="banjifcDivT">
        	<div><img src="${CTP_HOME}/img/fengcai.png"/><span>${CLASS_PHOTO }</span></div>
            <span><a href="${CTP }/list/classStyleList?classId=${classId }&gradeFlag=${grade}&classFlag=${className }">更多>></a></span>
        </div>
        <div id="banjifcDivM">
        	<div id="banjifcDivMul">
            	<c:forEach items="${style}" var="style_list">
						<a href=""><img src="${style_list.imgPath}" title="${style_list.imgName}"/><span></span></a>
					  </c:forEach>	
        	</div>
        </div>
        <div id="banjifcDivB"></div>
    </div>
    <!--班级风采 end-->
    <div class="footer" style="background: #F5F2E3;">
    	<center>Copyright&copy;2017 www.xxxx.com .All Rights Reserved<br>地址:郑州高新技术开发区xxx&nbsp;邮编:450000</center>
    </div>
</div>
		
	</body>
</html>
<script type="text/javascript">
	$(function(){
		 //新闻轮播
	    $(".slider-news").YuxiSlider({
			width:560, //容器宽度
			height:250, //容器高度
			during:3000, //间隔3秒自动滑动
			speed:800, //移动速度0.8秒
			mousewheel:true, //是否开启鼠标滚轮控制
			direkey:false//是否开启左右箭头方向控制
		});
		 //仪器展示
        $('#banjifcDivMul').liMarquee({
        	  direction: 'left'//向右滚动
        });
	});
		
</script>