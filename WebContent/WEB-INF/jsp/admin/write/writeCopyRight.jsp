<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<title>撰写版权说明</title>
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
	 var CTP_ADMIN=CTPPATH+"/resources/admin";
	 
	 function check(val,obj){
		    obj.style.backgroundColor="#E9E9E6";
			if(val=='f'){
				    $('#f').css("visibility","visible");
				    $('#s').css("visibility",'hidden')
					sb.style.backgroundColor="#F6F6F3";
		    }else if(val=='s'){
		    	    $('#f').css("visibility","hidden");
				    $('#s').css("visibility",'visible')
					fb.style.backgroundColor="#F6F6F3";
		    }
	}
		

</script>
</head>
	<body>
	<!-- S header -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<!-- S body -->
	<div class="main">

	<!--S 编辑区域-->
	<div class="edit-div"> 
		<span class="edit-span">撰写版权说明
		
	     <c:if test="${copyRight.isPublish eq 0}">
           <b>草稿</b>
         </c:if>    
		</span>
		<span class="content-span">版权说明内容</span><br>
		 <!--S 编辑器 -->              
              <div id="editor-container" class="answercontainer"><div id="editor-trigger">${copyRight.content}</div></div>
          <!--E 编辑器  -->
          
        <input type="hidden" class="hide-id" value="${copyRight.id}">
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="draft-btn draft-copyRight-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-copyRight-btn" onClick="ChangeState();">发布内容</a>
        </div>
	</div>
	<!--S 编辑区域-->
	
	<!--S 附件选择区-->
	<div class="check-zone">
		<div class="check-btn">
			<ul>
				<li ><a href="javascript:void(0);" onclick="check('s',this)" id='sb'>选项</a></li>
				<li ><a href="javascript:void(0);" onclick="check('f',this)" id="fb">附件</a></li>
			</ul>
		</div>
		<!--clear-->
		<div class="clear"></div>
		<!--clear-->
		<div class="options-checked-div" id="s">
			<span class="publish-dept-span">发布者</span>
			<input type="text" name="publish_dept" class="publish-dept" value="万科小学">
		    <br>
		    <span class="publish-dept-span">发布时间</span>
		    <div id="date-div">
		    <input type="text"  class="date_picker" value="">
		    </div>
		     <span class="publish-dept-span">分类</span>
		    <select name="publish_style" id="publish-style">
		    	<option>版权说明</option>
		    
		    </select>
		</div>
		<div class="draft-cheched-div" id="f">
			<span class="draft-cheched-tag">*不支持附件上传</span>
		    
		</div>
	</div>
	<!--E 附件选择区-->
	
	<!--clear-->
	<div class="clear"></div>
	<!--clear-->
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

$('.date_picker').date_input();



//获得信息
$(function(){
	
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
      'location',
      '|',
      'undo',
      'redo',
      'fullscreen'
   ];
    

  
  //创建编辑器
  editor.create();
  
  /**************发布信息******************/

  $('.publish-copyRight-btn').bind('click',function(){

		
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取发布时间
		var date_picker=$('.date_picker').val(); 
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		
		var html_content=editor.$txt.html();
		//获取id
		var id=$(".hide-id").val();
	
		if(id==""){
			id=0;
		}
		
		//判断标题和内容是否为空
		if( text_content=="" ||publish_dept==""){
			layer.msg("标题,内容和发布部门不能为空");
		}else{
		
  		var is_publish=1; //意味着要发表1，不是存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/admin/dealEditCopyRight',
				data:{"id":id,"content":html_content,"author":publish_dept,"isPublish":is_publish,"addTime":date_picker},
			
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
						layer.msg('发布成功，您可以在列表中查看', {icon: 1,time:2000});
							//跳转界面
							window.location.href=CTPPATH+"/admin/copyright";
						

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
		}
	});
  /**************保存草稿******************/
  $('.draft-copyRight-btn').bind('click',function(){

		
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取发布时间
		var date_picker=$('.date_picker').val(); 
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		
		var html_content=editor.$txt.html();
		//获取id
		var id=$(".hide-id").val();
	
		if(id==""){
			id=0;
		}
		
		//判断标题和内容是否为空
		if( text_content=="" ||publish_dept==""){
			layer.msg("标题,内容和发布部门不能为空");
		}else{
		
		var is_publish=0; //意味着要发表1，不是存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/admin/dealEditCopyRight',
				data:{"id":id,"content":html_content,"author":publish_dept,"isPublish":is_publish,"addTime":date_picker},
			
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
						layer.msg('发布成功，您可以在列表中查看', {icon: 1,time:2000});
							//跳转界面
							window.location.href=CTPPATH+"/admin/copyright";
						

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
		}
	});
});

</script>

