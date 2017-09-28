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
<title>班级主页</title>
<link rel="stylesheet" href="${CTP_HOME}/css/classdetails.css" />
<link rel="stylesheet" href="${CTP_HOME}/css/liMarqueeImg.css" />
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
                        <c:forEach items="${sildeInfo}" var="s_list">
                            <li class="slider-li"><a href="${CTP}/details/newsinfo?id=${s_list.id}&gradeFlag=${grade}&classFlag=${s_list.className}&classId=${s_list.classId}" target="_blank" ><img src="" alt="${s_list.itemTitle}"  /></a><div class="hide-content-slider" style="visibility: hidden;">${s_list.itemContent}</div></li>
                        </c:forEach>
                        <c:if test="${empty sildeInfo}">
                           <li class="slider-li"><img src="${CTP_HOME}/img/noimage.gif" alt="暂无图片"  /></li>
                        </c:if>
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
                <div id="bjjianjieB"></div>
            </div>
            <!--班级简介 end-->
        </div>
        <div id="mianDiv2">
            <div id="mianDiv2L">
                <!--班级动态-->
                <div id="banjidt">
                    <div id="banjidtT" class="navi">
                        <div><img src="${CTP_HOME}/img/class-dongtai.png"/><span>${CLASS_ACIVITY }</span></div>
                        <span><a href="${CTP }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=dynamic&p=1">更多>></a></span>
                    </div>
                    <div class="banjidtM">
                        <ul>
                               <c:forEach items="${dynamic}" var="dynamic_list">
                                <li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/newsinfo?id=${dynamic_list.id}&gradeFlag=${grade}&classFlag=${className }&classId=${classId }">${myTag:substr(dynamic_list.itemTitle,0,13,true)}</a><span>[${dynamic_list.addTime}]</span></li>
                              </c:forEach>
                        </ul>
                    </div>
                </div>
                <!--班级动态 end-->
                <!--学生文章-->
                <div id="xswenzhang">
                    <div id="xswenzhangT" class="navi">
                        <div><img src="${CTP_HOME}/img/wenzhang.png" /><span>${CLASS_ARTICLE }</span></div>
                        <span><a href="${CTP }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=article&p=1">更多>></a></span>
                    </div>
                    <div class="xswenzhangM">
                        <ul>
                              <c:forEach items="${article}" var="article_list">
                                <li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP}/details/newsinfo?id=${article_list.id}&gradeFlag=${grade}&classFlag=${className }&classId=${classId }">${myTag:substr(article_list.itemTitle,0,13,true)} </a><span>[${article_list.addTime}]</span></li>
                              </c:forEach>
                        </ul>
                    </div>
                </div>
                <!--学生文章 end-->
            </div>
            <!--成长故事-->
            <div id="banjixc">
                <div id="banjixcT">
                    <div><img src="${CTP_HOME}/img/green.png"/> <span>${CLASS_STORY }</span></div>
                    <span><a href="${CTP }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=growthstory&p=1">更多>></a></span>
                </div>
                <div id="banjixcM">
                    <ul>
                        <c:forEach items="${growthstory}" var="growthstory_list">
                            <li><img src="${CTP_HOME}/img/sjiantou.png"/><a href="${CTP }/details/newsinfo?id=${growthstory_list.id }&gradeFlag=${grade}&classFlag=${className }&classId=${classId}">${myTag:substr(growthstory_list.itemTitle,0,30,true)}</a><span>[${growthstory_list.addTime}]</span></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!--成长故事 end-->
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
                            <a href="javascript:void(0);"><img src="${style_list.imgPath}" title="${style_list.imgName}"/><span></span></a>
                    </c:forEach>
                </div>
            </div>
            <div id="banjifcDivB"></div>
        </div>
        <!--班级风采 end-->
        <div class="footer" style="background: #F5F2E3;">
            <jsp:include page="../common/classFooter.jsp"></jsp:include>
        </div>
    </div>
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
            //
            $('#banjifcDivMul').liMarquee({
                  direction: 'left'//向右滚动
            });
        });
    </script>
</body>
</html>