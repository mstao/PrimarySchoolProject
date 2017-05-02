<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		
		<title>${title }</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="../common/meta.jsp" flush="true"/>	
		
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/list.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${CTP}/resources/common/css/page.css"/>
		<link rel="stylesheet" href="${CTP}/resources/home/js/extends/zoomify/zoomify.min.css"/>
		<script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
		<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
		<script type="text/javascript" src="${CTP}/resources/home/js/extends/zoomify/zoomify.min.js" ></script>
<script type="text/javascript">
	$(function(){
		var CTPPATH="${pageContext.request.contextPath}";
	   
		//鼠标移到图片上显示删除按钮
		$(".imgtext").hide();
		 $(".index-image-div").hover(function(){
		  $(".imgtext",this).slideToggle(500);
		 });
		 
		 $(".index-image-div img").zoomify();
		 
		 //根据选择的图片进行删除
		 $(".deletebtn").bind("click",function(){
			
			 var id=$(this).attr("data-id");
	
			 if(id==""){
				 layer.msg("暂未选择图片");
			 }else{
				 //begin
				 layer.confirm('确定删除所选择的记录？', {
      			  btn: ['确定','取消'] 
      			}, function(){
      				//已选定，可以进行批量删除操作
      				//调用Ajax向后台发送请求 ，删除所选项
      				
      				$.ajax({
						type:'post',
						dataType:'json',
						url:CTPPATH+"/admin/delete/${url}",
						data:{"id":id},
					
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
								window.location.href="${pageContext.request.contextPath}/admin/list/${url}";
							
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
           	
				 //end
			 }
			 
		 });
	   
	 });
	  
	</script>
	</head>
	<body>
		<!-- S header -->
	<jsp:include page="../common/header.jsp" />
	<!--S main-->
            <div class="new_div1"><span class="new_div1_span">${title}列表</span><a href="${CTP}/admin/write/${url}" class="add_list">新增</a></div>
            <div class="main-div">
           
            <c:forEach items="${list}" var="list">
              <div class="index-image-div">
                <a href="javascript:void(0);" ><img src="${list.imgPath}"></a>
               
                <div class="imgtext"> <button  data-id="${list.id}" class="deletebtn">删除</button></div>
               
              </div>
            </c:forEach>
           
              
   
            </div>
<!--E main-->

<!--S footer-->
<jsp:include page="../common/footer.jsp" />
<!--E footer-->
	</body>
</html>
