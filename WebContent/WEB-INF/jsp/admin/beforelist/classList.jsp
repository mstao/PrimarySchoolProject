<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common/meta.jsp" flush="true"/>	
<title>${SCHOOL_STUDENT_LAB}-${WEBSITE_NAME}</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/beforelist.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${CTP_HOME}/css/classmain.css" />
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
						url:CTPPATH+"/admin/delete/${murl }",
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

<%--检测浏览器 --%>
<jsp:include page="../../common/browsehappy.jsp"></jsp:include>
	
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>
<div id="location"><span>您现在的位置: 后台管理 ></span><span>${SCHOOL_STUDENT_LAB }</span></div>

  
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
                <input type="text" class="new_text" placeholder="请输入您想添加的班级，如“1班”" value="" name="keywords" /> 
            	<select name="select-grade" id="select-grade">
            		<option value="${year}" >一年级</option>
            		<option value="${year-1}">二年级</option>
            		<option value="${year-2}">三年级</option>
            		<option value="${year-3}">四年级</option>
            		<option value="${year-4}">五年级</option>
            		<option value="${year-5}">六年级</option>
            	</select>
                </div>
 		 </div>
	
    <!--S CONETNT-->
    <div class="scontent">
    
    <!--S CONETNT-->
    <div class="class-content">
    	<!--s class-info-->
    	<c:forEach items="${grade}" var="grade">
    	<c:set var="grades" value="${year-grade.gradeCode+1}"></c:set>
    	<div class="class-content-only">
    		<div class="only-nav"><span class="only-navi-year">${grade.gradeCode }年</span></div>
    		<div class="only-info">
    		<c:forEach items="${sclass }" var="sclass">
    		<c:if test="${sclass.gradeCode==grade.gradeCode }">
    			<span><input type="checkbox" name="info_id" value="${sclass.id}"/><a href="${CTP }/admin/list/sclassHomePage?classId=${sclass.id }&grade=${grades}&className=${sclass.className }&p=1">${grades}年级${sclass.className }</a></span>
    		</c:if>
    		</c:forEach>
    		</div>
    	</div>
    	</c:forEach>
    	<!--e class-info-->
    </div>
    
    <!--E CONTENT-->
</div>
    
    <!--E CONTENT-->




<%--引入footer --%>
<jsp:include page="../common/footer.jsp" />
</body>
</html>
<script type="text/javascript">
$(function(){
	
$('.new_button').bind('click',function(){
	//获取内容
	var gradeCode=$('#select-grade').find("option:selected").attr('value');
	
	var content=$('.new_text').val();
	//获取内容的纯文本  
		$.ajax({
			type:'post',
			dataType:'text',
			url:CTPPATH+'/admin/add/${murl }',
			data:{"gradeCode":gradeCode,"className":content},
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