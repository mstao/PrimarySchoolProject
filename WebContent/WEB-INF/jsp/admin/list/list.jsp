<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		
		<title>${typeName }列表</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="../common/meta.jsp" flush="true"/>	
		
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/list.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${CTP}/resources/common/css/page.css"/>
		<script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${CTP_ADMIN }/js/module/common.js"></script>
		<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
		
<script type="text/javascript">
	$(function(){
		var CTPPATH="${pageContext.request.contextPath}";
	   
	   //批量删除信息
       $('.deleteInfo-btn').bind('click',function(){
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
								window.location.href="${pageContext.request.contextPath}/admin/list/${durl }?flag=${typeFlag}&p=1";
							
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
	
		<!-- S header -->
	<jsp:include page="../common/header.jsp" />
	<!--S main-->
			<div id="location">您现在的位置: 后台管理 ><span>${typeName }</span></div>
            <div class="new_div1"><span class="new_div1_span">${typeName }列表</span><a href="${CTP }/admin/write/${durl }?typeName=${typeName}&typeFlag=${typeFlag}&fileType=${fileType}" class="add_list">新增</a></div>
            <div class="new_div2">
            	
                <input type="checkbox" class="new_div2_input"/>
                <ul>
                    <li>
		                 <a href="javascript:void(0);">已选定</a>
		                 <ul>
		                     <li><a href="javascript:void(0);" class="deleteInfo-btn">删除</a></li>
		                 </ul>
		             </li>
                </ul>
                <input type="button" class="new_button" value="筛选"/>
                <input type="text" class="new_text" placeholder="请输入关键字" value="" name="keywords" />  
                
                
                <div class="clear"></div>
            </div>
        <div class="new_div3">            
            <table>
                <tr>
                    <th></th>
                    <th>标题</th>
                    <th>作者</th>
                    <th>类别</th>
                    <th>发布日期</th>
                </tr>
                <c:forEach var="list" items="${item }">
                <tr>
                    <td width="5%" align="center"><input type="checkbox" name="info_id" value="${list.id}"/></td>
                    <td width="35%"><a href="${CTP}/admin/distribute/${durl }?id=${list.id}" class="item_title">${list.itemTitle }</a>
                     <c:if test="${list.isPublish eq 0}">
		              <span class="draft-span">草稿</span>
		             </c:if>
                    </td>
                    <td width="20%"><a href="">${list.author }</a></td>
                    <td width="20%"><a href="">${typeName }</a></td>
                    <td width="20%">${list.addTime }</td>
                </tr>
                </c:forEach>
            </table>
             <!-- 分页导航引入 -->
			    ${toolBar}
        </div>
        <div> 
</div>
<!--E main-->

<!--S footer-->
<jsp:include page="../common/footer.jsp" />
<!--E footer-->
	</body>
</html>
