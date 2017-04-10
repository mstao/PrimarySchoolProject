<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="topBag" >
	<div id="topBagL">${grade }年级${className }</div>
    <div id="topBagR"><a href="#">设为首页</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">加入收藏</a></div>
</div>
<div id="navDiv">
    <ul>
         <li><a href="${pageContext.request.contextPath}/main/index">网站首页</a></li>
      	 <li><a href="${pageContext.request.contextPath }/details/classhomepage?classId=${classId }&gradeFlag=${grade}&classFlag=${className }">${CLASS_MAINPAGE }</a></li>
          
          <li><a href="${pageContext.request.contextPath }/details/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&type=${CLASS_SYNOPSIS }">${CLASS_SYNOPSIS }</a></li>
                   
     <!--   <li><a href="${pageContext.request.contextPath }/details/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&type=${CLASS_PHOTO }">${CLASS_PHOTO }</a></li>
                   
        <li><a href="${pageContext.request.contextPath }/details/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&type=${CLASS_ACIVITY }">${CLASS_ACIVITY }</a></li>
                   
        <li><a href="${pageContext.request.contextPath }/details/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&type=${CLASS_STORY }">${CLASS_STORY }</a></li>
         -->
          
                   
        <li><a href="${pageContext.request.contextPath }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=style&p=1">${CLASS_PHOTO }</a></li>
                   
        <li><a href="${pageContext.request.contextPath }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=dynamic&p=1">${CLASS_ACIVITY }</a></li>
                   
        <li><a href="${pageContext.request.contextPath }/list/mainClass?classId=${classId }&gradeFlag=${grade}&classFlag=${className }&flag=growthstory&p=1">${CLASS_STORY }</a></li>
    </ul>
</div>
