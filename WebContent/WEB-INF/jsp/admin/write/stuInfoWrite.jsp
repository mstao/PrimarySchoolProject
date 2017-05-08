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
		<link href="${CTP_ADMIN }/css/stuInfo.css" rel="stylesheet" type="text/css" />
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
		<span>${fullName } > 添加学生</span><br>
		<div class="edit-left">
			<label>姓名：</label>
			<input type="text" class="stuName" placeholder="与户口本一致" onblur="change(this)">
	
			<label>民族：</label>
			<input type="text" class="stuNation" onblur="change(this)">
	
	        <label>监护人：</label>
			<input type="text" class="stuParent" onblur="change(this)">
		</div>
		<div class="edit-right">
			<label>学号：</label>
			<input type="text" class="stuId" onblur="change(this)">
	
			<label>性别：</label>
			<div class="select-one">
			<input type="radio" class="stuSex" checked="checked" name="stuSex" value="男"><b>男生</b>
			<input type="radio" class="stuSex" name="stuSex" value="女"><b>女生</b>
			</div>
	        <label>联系电话：</label>
			<input type="text" class="stuPhone" onblur="change(this)">
		</div>
		<div class="edit-bottom">
			<br/><label>身份证号码：</label>
			<input type="text" class="stuCardId" placeholder="18位" onblur="change(this)">
	
	        <label>家庭住址：</label>
			<input type="text" class="stuAddress" placeholder="详细地址" onblur="change(this)">
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
		    <span class="publish-dept-span">出生时间</span>
		    <div id="date-div">
		    <input type="text"  class="date_picker" value="" onblur="change(this)">
		    </div>
		</div>
	</div>
	
	<!--clear-->
	<div class="clear"></div>
	<!--clear-->
</div>
		<div class="edit-boot">
        	<a href="${CTP }/admin/list/stuInfo?classId=${classId}&fullName=${fullName }&p=1" class="draft-btn draft-trends-btn">返回</a>
			<a href="javascript:void(0);" class="publish-btn publish-trends-btn">添加</a>
   </div>
<!--E main-->
<!--S footer-->
<div class="footer">
			<center><span>Copyright &copy;万科城小学  版权所有 2016 All Rights Reserved.</span></center>
<br><br>
</div>
<!--E footer-->
	</body>
</html>

<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";

$('.date_picker').date_input();
//空值校验
var t=false;
function change(obj){
	if($(obj).val().length== 0){
		layer.tips('不能为空',obj);
		}
};
//验证身份证号
$('.stuCardId').bind('blur',function(){
	var stuCardId=$('.stuCardId').val();
	if($(this).val().length != 18){
		
		layer.tips('身份证号码为18位,请确认是否出错','.stuCardId');
    }
    if(stuCardId.length ==18){
	$.ajax({
		type:'post',
		dataType:'text',
		url:CTPPATH+'/admin/add/testCardId',
		data:{'cardId':stuCardId},
		beforeSend:function(){
			//显示正在加载
			layer.load(2);
		},
		success:function(data){
			//关闭正在加载
			setTimeout(function(){
				  layer.closeAll('loading');
			}, 1000);

			 if(data>0){
				layer.tips('抱歉，该身份证号已被使用','.stuCardId');
			}else{
				layer.tips('该身份证号可用','.stuCardId');
			//	cid=true;
				}
		},
		error:function(){
			//关闭正在加载
			setTimeout(function(){
				  layer.closeAll('loading');
			}, 1000);
			layer.msg("出错了,请完善信息", {icon: 2,time:2000});
		}
		}); 
    }
}); 
//验证学号
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

			 if(data=="1"){
				layer.tips('抱歉，该学号已被使用','.stuId');
			}else{
				layer.tips('该学号可用','.stuId');
				//sid=true;
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

  $('.publish-btn').bind('click',function(){
		//获取姓名
		var stuName=$('.stuName').val();
		//获取学号
		var stuId=$('.stuId').val();
		//获取民族
		var stuNation=$('.stuNation').val();
		//获取性别
		var stuSex=$("input[type='radio']:checked").val();
		//获取监护人
		var stuParent=$('.stuParent').val();
		//获取联系方式
		var stuPhone=$('.stuPhone').val();
		//获取身份证号码
		var stuCardId=$('.stuCardId').val();
		//获取家庭地址
		var stuAddress=$('.stuAddress').val();
		//获取出生时间
		var stuBirthday=$('.date_picker').val(); 
		//获取录人人员
		var stuAuthor=$('.publish-dept').val();
		if(stuName.length!=0 &&stuId.length!=0 &&stuNation.length!=0 &&stuSex.length!=0 &&
				stuParent.length!=0 &&stuPhone.length!=0 &&stuCardId.length!=0 &&stuAddress.length!=0 &&
				stuBirthday.length!=0 &&stuAuthor.length!=0){
			t=true;
			}
		if(t){
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/admin/add/${durl }',
				data:{"stuId":stuId,"stuName":stuName,"classId":"${classId}","stuNation":stuNation,"stuSex":stuSex,"stuBirthday":stuBirthday,"stuAuthor":stuAuthor,"stuAddress":stuAddress,"stuPhone":stuPhone,"stuParent":stuParent,"stuCardId":stuCardId},
			
				beforeSend:function(){
					//显示正在加载
					layer.load(2);
				},
				success:function(data){

					//关闭正在加载
					setTimeout(function(){
						  layer.closeAll('loading');
					}, 1000);
		
					 if(data>0){
						layer.msg('保存成功，您可以继续添加', {icon: 1,time:2000});
						//清空数值
						$('.stuName').val("");
						$('.stuId').val("");
						$('.stuNation').val("");
						$('.stuSex').val("");
						$('.stuParent').val("");
						$('.stuPhone').val("");
						$('.stuCardId').val("");
						$('.stuAddress').val("");
						$('.date_picker').val(""); 
						
						
					}else{
						layer.msg("保存出错了", {icon: 2,time:2000});
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
		 }else{
			layer.msg("信息不完善,请检查",{icon: 0,time:2000});
			 }
		});
  
});

</script>


 