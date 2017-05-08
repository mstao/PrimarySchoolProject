<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<title>撰写${typeName}</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/scoreInfo.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/date.css" rel="stylesheet" type="text/css" />
		
	    <script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
	    <script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
	   
	    <script type="text/javascript" src="${CTP_ADMIN }/js/extends/jquery.date_input.pack.js"></script> 
	
</head>
	<body>
	<!-- S header -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<!-- S body -->
	<div class="main">

	<!--S 编辑区域-->
	<div class="edit-div"> 
		<span>修改学生成绩</span><br>
		<div class="edit-left">
		
			<label>学号：</label>
			<input type="text" class="stuId" readonly="readonly"  value="${list[0].stuId }">
			
			<label>姓名：</label>
			<input type="text" class="stuName" readonly="readonly" value="${list[0].stuName }">
	 
			<c:forEach var="list" items="${list }">
				<label>${list.courseName }：</label>
				<input type="text" name="scoreInfo" value="${list.score }">
				<span hidden="true" class="id">${list.id}</span>
				<span hidden="true" class="stuinfoId">${list.stuinfoId}</span>
				<span hidden="true" class="courseId">${list.courseId}</span>
				<span hidden="true" class="author">${list.author }</span>
			</c:forEach>
		</div>
	   
	</div>
	<!--S 编辑区域-->
	
	 <div class="check-zone">
		<!--clear-->
		<div class="clear"></div>
		<!--clear-->
		<div class="options-checked-div" id="s">
			<span class="publish-dept-span">录入人员</span>
			<input type="text" name="publish_dept" class="publish-dept" value="${list[0].author }">
		    <br>
		    <span class="publish-dept-span">考试时间</span>
		    <div id="date-div">
		    <input type="text"  class="date_picker" value="${list[0].addTime }">
		    </div>
		</div>
	</div> 
	
	<!--clear-->
	<div class="clear"></div>
	<!--clear-->
</div>
<!--E main-->
	<div class="edit-boot">
		<div class="edit-bottom">
        	<a href="${CTP }/admin/list/${durl }?classId=${classId}&fullName=${fullName }&p=1" class="draft-btn draft-trends-btn">返回</a>
			<a href="javascript:void(0);" class="publish-btn publish-trends-btn">修改</a>
      </div>
      </div>
<!--S footer-->
<div class="footer">
			<center><span>Copyright &copy;万科城小学  版权所有 2016 All Rights Reserved.</span><center>
<br><br>
</div>
<!--E footer-->
	</body>
</html>

<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";
$('.date_picker').date_input();

$(function(){

$('.stuId').focus(function(){
	layer.tips('学号不允许修改','.stuId');
}); 
$('.stuName').focus(function(){
	layer.tips('学生姓名不允许修改','.stuName');
}); 

$('.publish-btn').bind('click',function(){
		//获取学生Id
		var stuinfoId=document.getElementsByClassName("stuinfoId")[0].innerHTML;
		//获取录入人员
		var author=document.getElementsByClassName("author")[0].innerHTML;
		//获取添加时间
		var addTime=$('.date_picker').val();
	  //获取所有成绩
		var t=document.getElementsByName("scoreInfo");
		var scores="";
		for(var i=0;i<t.length;i++){
			scores+=t[i].value+',';
			}
		//获取所有成绩记录id
		var l=document.getElementsByClassName("id");
		var ids="";
		for(var i=0;i<l.length;i++){
			ids+=l[i].innerHTML+',';
			}
		//获取考试科目编号ID
		var c=document.getElementsByClassName("courseId");
		var courseIds="";
		for(var i=0;i<c.length;i++){
			courseIds+=c[i].innerHTML+',';
			}
		 $.ajax({
				type:'post',
				dataType:'json',
				url:CTPPATH+'/admin/update/${durl}',
				data:{"ids":ids,"stuinfoId":stuinfoId,"classId":"${classId}","courseIds":courseIds,"scores":scores,"addTime":addTime,"author":author},
			
				beforeSend:function(){
					//显示正在加载
					layer.load(2);
				},
				success:function(data){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					
					if(data==1){
						layer.msg('修改成功', {icon: 1,time:2000});
						
							window.location.href="${pageContext.request.contextPath}/admin/list/${durl }?classId=${classId}&fullName=${fullName }&p=1";
	                    	
					}else{
						layer.msg("修改出错了", {icon: 2,time:2000});
					}
				},
				error:function(){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
					layer.msg("出错了", {icon: 2,time:2000});
				}
			}); 
	}); 
});

</script>


 