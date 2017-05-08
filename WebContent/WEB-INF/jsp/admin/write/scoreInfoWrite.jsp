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
		<span>添加学生成绩</span><br>
		<div class="edit-left">
		
			<label>学号：</label>
			<input type="text" class="stuId">
			
			<label>姓名：</label>
			<input type="text" class="stuName">
	 
			<c:forEach var="list" items="${courseType }">
				<label>${list.courseName }：</label>
				<input type="text" name="scoreInfo" data-id="${list.id }">
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
			<input type="text" name="publish_dept" class="publish-dept" value="万科小学">
		    <br>
		    <span class="publish-dept-span">考试时间</span>
		    <div id="date-div">
		    <input type="text"  class="date_picker">
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
			<a href="#" class="publish-btn publish-trends-btn">添加</a>
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

$('.stuId').bind('blur',function(){
	var stuId=$('.stuId').val();
	if(stuId.length!=0){
	$.ajax({
		type:'post',
		dataType:'text',
		url:CTPPATH+'/admin/add/testId',
		data:{'id':stuId},
		beforeSend:function(){
			//显示正在加载
			layer.load(2);
		},
		success:function(data){
			//关闭正在加载
			setTimeout(function(){
				  layer.closeAll('loading');
			}, 1000);

			 if(data!="1"){
				layer.tips('抱歉，该学生不存在','.stuId');
			}else{
				layer.tips('可用','.stuId');
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
	}
}); 


$(function(){
	//设置默认时间
var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    $('.date_picker').val(currentdate);

$('.publish-btn').bind('click',function(){
		//获取学号
		var stuId=$('.stuId').val();
		//获取学生name
		var stuName=$('.stuName').val();
		//获取录入人员
		var author=$('.publish-dept').val();
		//获取添加时间
		var addTime=$('.date_picker').val();
	  //获取所有成绩
		var t=$("input[name='scoreInfo']");
		var scores="";
		var course="";
		for(var i=0;i<t.length;i++){
			course+=$(t[i]).attr("data-id")+',';
			scores+=$(t[i]).val()+',';
			}
     $.ajax({
         type:'post',
         dataType:'json',
         url:CTPPATH+'/admin/add/${durl}',
         data:{"stuId":stuId,"classId":"${classId}","author":author,"addTime":addTime,"scores":scores,"course":course},
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
     			layer.msg('添加成功,您可以继续添加', {icon: 1,time:2000});
     			$('.stuId').val("");
     			//获取学生name
     			$('.stuName').val("");
     		  //获取所有成绩
     			for(var i=0;i<t.length;i++){
     					$(t[i]).val("");
     				};
                 	
     		}else{
     			layer.msg("该学生本次考试成绩已被录入", {icon: 2,time:2000});
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
