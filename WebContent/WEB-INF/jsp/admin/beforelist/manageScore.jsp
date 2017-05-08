<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${SCHOOL_TEACHER_RESOURCES}-${WEBSITE_NAME}</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>

<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/beforelist.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${CTP_HOME}/css/teaching-resources.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
 <script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>

<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";
$(function(){
	
	//全选和取消全选
	$('.operation_input').click(function(){
	  var is_check=$('.operation_input').is(':checked');
	  var info_check=document.getElementsByName('info_id');
	  if(is_check==true){

		for(var i=0;i<info_check.length;i++){
			info_check[i].checked=true;
		}
			  	   
	  }else{
	  	for(var i=0;i<info_check.length;i++){
		    info_check[i].checked=false;
		}
	  }
	});
   //批量删除信息
   $('.deletelist-btn').bind('click',function(){
   	var t=document.getElementsByName("info_id");
		var ids = "";
        for (var i = 0; i < t.length; i++) {
            if (t[i].checked) {
            	ids +=t[i].value+',';
            }
        }
        ids = ids.substring(0, ids.length - 1);
        if(ids==""){
       	 layer.msg("请选择您要删除的选项");
        }else{
          layer.confirm('确定删除所选择的记录？', {
  			  btn: ['确定','取消'] 
  			}, function(){
  				//已选定，可以进行批量删除操作
  				//调用Ajax向后台发送请求 ，删除所选项
  				
  				$.ajax({
					type:'post',
					dataType:'json',
					url:CTPPATH+"/admin/delete/${durl }",
					data:{"ids":ids},
				
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
							layer.msg('删除成功', {icon: 1,time:2000});
							window.location.href="${pageContext.request.contextPath}/admin/list/${durl }";
						
						}else{
							layer.msg("删除出错了", {icon: 2,time:2000});
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
  				
  			   //end
  			}, function(){
  			    //取消操作 ，这里可以为空
  			});
       	
        }
   });
});


</script>

</head>
<body>
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>

<div id="location"><span>您现在的位置: 后台管理 ></span><span>考试科目管理</span></div>

		<!--s 操作-->
    	<div class="operation">
            	
                <input type="checkbox" class="operation_input"/>
                <ul>
                    <li>
		                 <a href="javascript:void(0);">已选定</a>
		                 <ul>
		                     <li><a href="javascript:void(0);" class="deletelist-btn">删除</a></li>
		                 </ul>
		             </li>
                </ul>
       
                <div class="addlist"> 
                <input type="button" class="new_button" value="新增"/>
                <input type="text" class="new_text" placeholder="请输入您想添加的内容" value="" name="keywords" /> 
            
                </div>
 		 </div>

    <!--S CONETNT-->
    <div class="teachingresource">
		<c:forEach items="${menu}" var="menu_list">
		<span><input type="checkbox" name="info_id" value="${menu_list.id}"/><a href="#">${menu_list.courseName}</a></span>
		</c:forEach>

	</div>
    
    <!--E CONTENT-->

<div class="clear"></div>
<%--E 主体 --%>

<div class="footer">
			<center><span>Copyright &copy;万科城小学  版权所有 2016 All Rights Reserved.</span></center>
<br><br>
</div>
<%--引入footer --%>
</body>
</html>
<script type="text/javascript">
$(function(){
   $('.new_button').bind('click',function(){
	//获取内容
	var content=$('.new_text').val();

	//获取内容的纯文本  
		$.ajax({
			type:'post',
			dataType:'text',
			url:CTPPATH+'/admin/add/${durl}',
			data:{"courseName":content},
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
					layer.msg('添加成功了', {icon: 1,time:2000});
				
						//跳转界面
						window.location.href=CTPPATH+"/admin/list/${durl}";

				}else{
					layer.msg("添加出错了", {icon: 2,time:2000});
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