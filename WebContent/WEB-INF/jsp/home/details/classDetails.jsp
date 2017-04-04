<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<title>Insert title here</title>
<link rel="stylesheet" href="${CTP_HOME}/css/classdetails.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/liMarqueeImg.css" />
<script type="text/javascript" src="${CTP_HOME}/js/jquery-1.10.2.min.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/common.js" ></script>
<script type="text/javascript" src="${CTP_HOME}/js/YuxiSlider.jQuery.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/jquery.liMarquee.js" ></script>
</head>
<body>
<div id="topBag" >
	<div id="topBagL">六年级（X）班</div>
    <div id="topBagR"><a href="#">设为首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">加入收藏</a></div>
</div>
<div id="navDiv">
    <ul>
        <li><a href="">网站首页</a></li>
        <li><a href="">班级主页</a></li>
          
        <li><a href="">班级简介</a></li>
                   
        <li><a href="">班级风采</a></li>
                   
        <li><a href="">班级相册</a></li>
                   
        <li><a href="">班级动态</a></li>
                 
    </ul>
</div>


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
            	<div>班级简介</div>
                <span><a href="">更多>></a></span>
            </div>
            <div id="bjjianjieM">
            	<img src="${CTP_HOME}/img/bg1.jpg" />
                <span id="Lab_about">暂无内容</span>
            </div>
            <div id="bjjianjieB"></div>
        </div>
        <!--班级简介 end-->
    </div>
    <div id="mianDiv2">
    	<div id="mianDiv2L">
            <!--班级动态-->
            <div id="banjidt">
                <div id="banjidtT" class="navi">
                	<div><img src="${CTP_HOME}/img/class-dongtai.png"/><span>班级动态</span></div>
                	<span><a href="#">更多>></a></span>
                </div>
                <div class="banjidtM">
                    <ul>
                   
                    </ul>
                </div>
            </div>
            <!--班级动态 end-->
            <!--学生文章-->
            <div id="xswenzhang">
                <div id="xswenzhangT" class="navi">
                	<div><img src="${CTP_HOME}/img/wenzhang.png" /><span>学生文章</span></div>
                	<span><a href="">更多>></a></span>
                </div>
                <div class="xswenzhangM">
                    <ul>
                   
                    </ul>
                </div>
            </div>
            <!--学生文章 end-->
        </div>
        <!--班级相册-->
        <div id="banjixc">
        	<div id="banjixcT">
            	<div><img src="${CTP_HOME}/img/green.png"/> <span>成长故事</span></div>
                <span><a href="#">更多>></a></span>
            </div>
            <div id="banjixcM">
            	<ul>
                		
                </ul>
            </div>
            <div id="banjixcB"></div>
        </div>
        <!--班级相册 end-->
    </div>
    <!--班级风采-->
    <div id="banjifcDiv">
    	<div id="banjifcDivT">
        	<div><img src="${CTP_HOME}/img/fengcai.png"/><span>班级风采</span></div>
            <span><a href="">更多>></a></span>
        </div>
        <div id="banjifcDivM">
        	<div id="banjifcDivMul">
            	<a href=""><img src="${CTP_HOME}/img/bg1.jpg"  title="ddddd"/><span></span></a>
                <a href=""><img src="${CTP_HOME}/img/bg1.jpg"  title="ddddd"/><span></span></a>
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