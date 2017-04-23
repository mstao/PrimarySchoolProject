<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		
		<title>角色列表</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/auth.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
		<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
		
<script type="text/javascript">
		
$(function(){
			var CTPPATH="${pageContext.request.contextPath}";
			var CTP_HOME=CTPPATH+"/resources/admin";
			//批量删除
			$(".delete").bind("click",function(){
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
							url:CTPPATH+"/admin/delete/role",
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
									window.location.href="${pageContext.request.contextPath}/admin/authority/roleList";
								
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
			
			
			
			//单项删除
			
			$(".only-delete").bind("click",function(){
				//获取id的值
				var id=$(this).parent().parent().children().eq(0).find("input").val();
				if(id==""){
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
								url:CTPPATH+"/admin/delete/role",
								data:{"ids":id},
							
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
										window.location.href="${pageContext.request.contextPath}/admin/authority/roleList";
									
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
			
			
			//新增弹出
			
			$('.add').on('click', function(){
				 layer.open({
				        type: 2,
				      //  skin: 'layui-layer-lan',
				        title: '新增角色',
				        fix: false,
				        shadeClose: true,
				        maxmin: true,
				        area: ['600px', '300px'],
				        content: '${pageContext.request.contextPath}/admin/authority/showAddRole',
				       
				 });
			});
			
			
			//模糊查询获取角色信息
			
			$(".find").bind("click",function(){
				
				//获取token
				var token=$(".role-input").val();
				
				if(token.replace(/\s/g , '')!="" ){
					
					//start
					$.ajax({
						type:'post',
						dataType:'json',
						url:CTPPATH+'/admin/authority/findRoleByName',
						data:{"token":token},
					
						beforeSend:function(){
							//显示正在加载
							layer.load(2);
						},
						success:function(data){

							//关闭正在加载
							setTimeout(function(){
								  layer.closeAll('loading');
							}, 1000);
				
							 
					        var xhtml="";
					        xhtml+="<table><tr><th><input type='checkbox' class='new_div2_input'/></th><th>角色名称</th><th>角色code</th><th>操作</th></tr>";
					        if(data.length>0){
					        	
					        		$.each(data,function(idx,item){ 
					        			
					        			xhtml+="<tr><td> <input type='checkbox' name='info_id' value="+item.id+"></td><td>"+item.roleName+"</td><td>"+item.roleCode+"</td><td><img src='"+CTP_HOME+"/img/delete.png'/><a href='javascript:void(0);' class='only-delete'>删除</a></td></tr>";
					        		   
					        		}); 
					        	
					        	
					        	
					        }else{
					        	xhtml+="<tr><td colspan='4' style='background:#F2DEDE; color:#444444;'>没有找到角色</td></tr>";
					        }
					        
					        xhtml+="</table>";
					        $(".a-content").html(xhtml);
								
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
				}else{
					layer.msg("请输入您要查询的内容！");
				}
				
			});

		
			
});
		
</script>
	</head>
	<body>
		<!-- S header -->
	<jsp:include page="../common/header.jsp" />
	<!--S main-->
			
            <div class="new_div1"><span class="new_div1_span">角色列表</span>              
            </div>
            <!-- S 权限内容 -->
            
            <div class="auth-div">
			<div class="auth-operation-list">
				<ul>
					<li><a href="javascript:void(0);" class="checked-a"> >角色列表</a></li>
					<li><a href="javascript:void(0);"> >角色分配</a></li>
					<li><a href="javascript:void(0);"> >权限列表</a></li>
					<li><a href="javascript:void(0);"> >权限分配</a></li>
				</ul>
			</div>
			
			<div class="auth-content">
				<div class="title">
					<span>角色列表</span>
					
				</div>
				<div class="search">
					<input  type="text" placeholder="请输入角色名称或者角色code" class="role-input"/>
					<button class="find">查询</button>
					<button class="add">增加角色</button>
					<button class="delete">删除</button>
				</div>
				
				<div class="a-content">
					<table>
						<tr>
							<th><input type="checkbox" class="new_div2_input"/></th>
							<th>角色名称</th>
							<th>角色code</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${roles}" var="role_list"> 
						<tr>
							<td> <input type="checkbox" name="info_id" value="${role_list.id}"></td>
							<td>${role_list.roleName}</td>
							<td>${role_list.roleCode}</td>
							<td><img src="${CTP_ADMIN }/img/delete.png"/><a href="javascript:void(0);" class="only-delete">删除</a></td>
						</tr>
						</c:forEach>
					</table>
					
				</div>
				
			</div>
		</div>
            <!-- E 权限内容 -->
        <div> 
</div>
<!--E main-->

<!--S footer-->
<jsp:include page="../common/footer.jsp" />
<!--E footer-->
	</body>
</html>
