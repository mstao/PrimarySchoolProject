<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<title>撰写${labName}</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<jsp:include page="../common/meta.jsp" flush="true"/>	
		
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/edit.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/date.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/js/extends/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
	
	    <script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
	    <script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
	
	    <script type="text/javascript" src="${CTP_ADMIN }/js/extends/jquery.date_input.pack.js"></script> 
	
<script type="text/javascript">

var CTPPATH="${pageContext.request.contextPath}";
</script>
</head>
	<body>
	<!-- S header -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<!-- S body -->
	<div class="main">

	<!--S 编辑区域-->
	<div class="edit-div"> 
		<span class="edit-span">撰写${labName}</span>
		<span class="content-span">${labName}简介</span><br>
		<c:set var="intro" value="labintro"></c:set>
		 <!--S 编辑器 -->              
              <div id="editor-container" class="answercontainer"><div id="editor-trigger"></div></div>
          <!--E 编辑器  -->
          
        <input type="hidden" name="hidden-item-id" class="hidden-item-id" value="">
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="publish-btn">发布内容</a>
        </div>
	</div>
	<!--S 编辑区域-->
	
	
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
<script type="text/javascript" src="${CTP_ADMIN }/js/extends/wangEditor/dist/js/wangEditor.js"></script>

<script type="text/javascript">





//获得信息
$(function(){

	// 阻止输出log
  // wangEditor.config.printLog = false;

  var editor = new wangEditor('editor-trigger');
  editor.config.pasteFilter=true;
  editor.config.pasteText = true;
  // 上传图片
  editor.config.uploadImgUrl = CTPPATH+'/admin/upload/uploadpic';
  editor.config.uploadParams = {
      // token1: 'abcde',
      // token2: '12345'	
  };
  editor.config.uploadHeaders = {
      // 'Accept' : 'text/x-json'
  }
   editor.config.uploadImgFileName = 'myEditorImgName';

  // 普通的自定义菜单
  editor.config.menus = [
      'source',
      '|',     // '|' 是菜单组的分割线
      'bold',
      'underline',
      'italic',
      'eraser',
      '|',
      'head',
      'quote',
      'unorderlist',
      'orderlist',
      'alignleft',
      'aligncenter',
      'alignright',
      '|',
      'table',
      'link',
      'unlink',
      'img',
      '|',
      'undo',
      'redo',
      'fullscreen'
   ];
    

  
  //创建编辑器
  editor.create();
  
  /**************修改信息******************/

  $('.publish-btn').bind('click',function(){
		//获取内容
		
		var content=editor.$txt.html();
		var foreignId;
		var intro;
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/admin/add/${introurl }',
				data:{intro:content,foreignId:"${labId}"},
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
						layer.msg('发布成功了', {icon: 1,time:2000});
					
						if("${introurl}" == "${intro}"){
							//跳转界面
							window.location.href=CTPPATH+"/admin/list/${durl}?labId=${labId}&p=1";
							}else{
								//跳转界面
								window.location.href=CTPPATH+"/admin/list/${durl}?classId=${labId}&grade=${grade}&className=${className}&p=1";
								}

					}else{
						layer.msg("发布出错了", {icon: 2,time:2000});
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
