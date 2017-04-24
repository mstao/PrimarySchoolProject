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
		<jsp:include page="../common/meta.jsp" flush="true"/>	
		
		<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/edit.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/css/date.css" rel="stylesheet" type="text/css" />
		<link href="${CTP_ADMIN }/js/extends/wangEditor/dist/css/wangEditor.min.css" rel="stylesheet" type="text/css"/>
		<link href="${CTP_ADMIN }/js/extends/uploadify/css/uploadify.css" rel="stylesheet" type="text/css"/>
	    <script type="text/javascript" src="${CTP_ADMIN }/js/lib/jquery-1.8.3.js"></script>
	    <script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
	    <script type="text/javascript" src="${CTP_ADMIN }/js/extends/uploadify/js/jquery.uploadify.min.js" ></script>
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
		
$(function() {
		
		  /*************setting***************/  
	    var definedData = [];  
	    definedData.fileSizeLimit = "10MB";  //上传大小  
	    definedData.queueSizeLimit = 5;      //允许上传个数文件  
	
	    var errorData = [];  
	    errorData.err100 = "文件个数超出系统限制，只允许上传" + definedData.queueSizeLimit + "个文件！";  
	    errorData.err110 = "文件超出系统限制的大小，限制文件大小" + definedData.fileSizeLimit + "！";  
	    errorData.err120 = "文件大小异常！";  

	
		$("#uploadify").uploadify({
			debug			: false, 

			swf 			:  CTP_ADMIN+'/js/extends/uploadify/js/uploadify.swf',	//swf文件路径
			method			: 'get',	// 提交方式
			uploader		:  CTPPATH+'/admin/upload/uploadfile;jsessionid=${pageContext.session.id}', // 服务器端处理该上传请求的程序(controller)

			preventCaching	: true,		// 加随机数到URL后,防止缓存

			buttonCursor	: 'hand',	// 上传按钮Hover时的鼠标形状
		//	buttonImage		: 'img/.....png',	// 按钮的背景图片,会覆盖文字
			buttonText		: '选择文件'	, //按钮上显示的文字，默认”SELECTFILES”
			height			: 30	, // 30 px
			width			: 120	, // 120 px
			
			fileObjName		: 'filedata',	//文件对象名称, 即属性名
			fileSizeLimit	: '10MB'	,		// 文件大小限制, 10000 KB
			fileTypeDesc	: 'any'	,	//文件类型说明 any(*.*)
			fileTypeExts	: '*.*;*.txt',		// 允许的文件类型,分号分隔
			//formData		: {'id':'1', 'type':'myFile'} , //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
		
			auto            : false,    //选择完文件是否自动上传
			multi			: true ,	// 多文件上传
			progressData	: 'speed,percentage',	// 进度显示, speed-上传速度,percentage-百分比	
			queueID			: 'fileQueue',//上传队列的DOM元素的ID号
			queueSizeLimit	: 99	,	// 队列长度
			removeCompleted : false	,	// 上传完成后是否删除队列中的对应元素
			removeTimeout	: 10	,	//上传完成后多少秒后删除队列中的进度条, 
			requeueErrors	: true,	// 上传失败后重新加入队列
			uploadLimit		: 10,	// 最多上传文件数量

			successTimeout	: 30	,//表示文件上传完成后等待服务器响应的时间。超过该时间，那么将认为上传成功。
			// 在文件被移除出队列时触发	
			onCancel : function(file) { layer.msg(file.name + '从上传列队中移除!' ); },
			
			// 在调用cancel方法且传入参数’*’时触发
			onClearQueue : function (queueItemCount) {
					if(queueItemCount>0){
					layer.msg(queueItemCount + ' 文件将从上传列队中移除'); 
					}
				},

			// 打开文件对话框 关闭时触发
			onDialogClose : function (queueData) {
							/*	alert(
									"文件对话窗口中选了几个文件:" + queueData.filesSelected + "---" +
									"队列中加了几个文件:" + queueData.filesQueued + "---" +
									"队列中被替换掉的文件数:" + queueData.filesReplaced + "---" +
									"取消掉的文件数:" + queueData.filesCancelled + "---" + 
									"上传出错的文件数:" + queueData.filesErrored
								); */
							},
			
			// 选择文件对话框打开时触发
			onDialogOpen : function () { /*alert( 'please select files' ) */ },
		
			// 没有兼容的FLASH时触发
			onFallback : function(){ alert( '您未安装FLASH控件,无法上传文件!请安装FLASH控件后再试。' ) },
			
			// 每次初始化一个队列时触发, 即浏览文件后, 加入一个队列
			//onInit : function (instance) { alert( 'The queue ID is ' + instance.settings.queueID ) },
		
			// 上传文件处理完成后触发（每一个文件都触发一次）, 无论成功失败
			//onUploadComplete : function(file){ alert( 'The file ' + file.name + ' uploaded finished!' ) },

			// 上传文件失败触发
			onUploadError : function(file, errorCode, errorMsg, errorString){ 
                              
				 layer.msg(file.name + ' 上传未完成！ ' );
                        
                               /*  alert(
                                    file.name + ' upload failed! ' + 
                                    'errorCode: ' + errorCode +
                                    'errorMsg:' + errorMsg +
                                    'errorString:' + errorString
                                );*/
                                

				}, 
            
            // 在每一个文件上传成功后触发
            onUploadSuccess : function(file, data, response) {
                              
            	layer.msg(  file.name + ' 上传成功！  ' +
                        '  server-side returned data:' + data +
                        '  response: ' + response,{icon: 1,time:3000});
           
                 },
                 
            //所有文件上传成功后触发
            onQueueComplete : function(queueData) {
                     //上传队列全部完成后执行的回调函数    
                    if(queueData.uploadsErrored==0){
                    	layer.msg("全部文件上传完成了",{icon: 1,time:3000});
                    	//此时可以进行跳转页面
                    	//跳转界面
						window.location.href=CTPPATH+"/admin/list/${durl}?classId=${classId}&menuId=${menuId}&p=1";
                    }else{
                    	layer.msg("文件上传成功的有"+queueData.uploadsSuccessful+"个-|-文件上传失败的有"+queueData.uploadsErrored+"个,请您点击开始上传按钮手动上传文件");
                        
                    	//显示手动上传按钮，将失败的重新上传
                    	$(".start-upload").show();
                    }
                     
                 },
             //返回一个错误，选择文件的时候触发  
 	         'onSelectError': function (file, errorCode, errorMsg) {  
 	              switch (errorCode) {  
 	                  case -100:  
 	                      alert(errorData.err100);  
 	                      break;  
 	                  case -110:  
 	                      alert(errorData.err110);  
 	                      break;  
 	                  case -120:  
 	                      alert(errorData.err120);  
 	                      break;  
 	              
 	              }  
 	          }
                 

		});
		
		
	});
	
	//上传文件
	function upload(id){
		$("#" + id).uploadify("settings", "formData",{'item_id':$('.hidden-item-id').val(),'item_type':"${fileType}"});
	    $("#" + id).uploadify("upload", "*");
	}
	
	//清空列队
    function clean(id){
    	$("#" + id).uploadify('cancel', '*');
    }
	//获取上传文件总个数
	function getQueueSize(id){
		return $("#"+id).data('uploadify').queueData.queueLength; 
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
		<span class="edit-span">撰写${menuName}</span>
		<span class="title-span">标题</span>
		<input type="text" name="eidt_title" class="edit-title" placeholder="标题" >
		<span class="content-span">${menuName}内容</span><br>
		 <!--S 编辑器 -->              
              <div id="editor-container" class="answercontainer"><div id="editor-trigger"></div></div>
          <!--E 编辑器  -->
          
        <%--隐藏id  供上传文件用 --%>
        <input type="hidden" name="hidden-item-id" class="hidden-item-id" value="">
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="draft-btn draft-trends-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-trends-btn" onClick="ChangeState();">发布内容</a>
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
		    <c:forEach var="type" items="${resouceType }">
		    	<option value="${type.itemTypeFlag}">${type.itemTypeName}</option>
		    </c:forEach>
		    </select>
		</div>
		<div class="draft-cheched-div" id="f">
			<span class="draft-cheched-tag">*可以选择多个附件,选择完后随发布内容一起提交<br>*内容发布前附件可以撤销<br>*内容发布完后附件不可撤销<br>*清空列表将所有上传的文件清除上传列队<br>*如果进行多文件上传时如果文件上传失败，请点击"手动上传"手动上传</span>
		    <span id="uploadify"></span>
			<div id="fileQueue"></div>     
			 <br>
		    <a href="javascript:upload('uploadify')"  class="start-upload" style="display:none;" >手动上传</a>&nbsp; 

	       	<a href="javascript:clean('uploadify')" class="clean-queue">清空列表</a>
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
      '|',
      'undo',
      'redo',
      'fullscreen'
   ];
    

  
  //创建编辑器
  editor.create();
  
  /**************修改信息******************/

  $('.publish-trends-btn').bind('click',function(){

		//获取发表类型
		var type=$('#publish-style').val();
		
		//获取标题
		var title=$('.edit-title').val();
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取发布时间
		var date_picker=$('.date_picker').val(); 
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		//判断标题和内容是否为空
		if(title=="" || text_content=="" ||publish_dept==""){
			layer.msg("标题,内容和发布部门不能为空");
		}else{
			//判断内容里面是否含有图片 ,有图片设为1，无图片设为0
  		var is_image;
  		if(editor.$txt.find("img[src!='']").length>0){
  			is_image=1;
  		}else{
  			is_image=0;
  		}
  		var is_publish=1; //意味着要发表1，不是存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/admin/add/${durl }',
				data:{"itemTitle":title,"itemContent":content,"menuId":"${menuId}","classId":"${classId}","typeFlag":type,"author":publish_dept,"isImage":is_image,"isPublish":is_publish,"addTime":date_picker},
			
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
					
					    //将id写入到隐藏域,供上传文件使用
					    $('.hidden-item-id').val(data);
						//判断有无上传文件列队
						if(getQueueSize("uploadify")>0){
							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
							upload("uploadify");
						}else{
							//跳转界面
							window.location.href=CTPPATH+"/admin/list/${durl}?classId=${classId}&menuId=${menuId}&p=1";
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
		}
	});
  /**************保存草稿******************/
  $('.draft-trends-btn').bind('click',function(){
		//获取id
		var nid=$('.hidden-item-id').val();
		//获取发表类型
		var type=$('#publish-style').val();
		//获取标题
		var title=$('.edit-title').val();
		//获取内容
		var content=editor.$txt.html();
		//获取发布部门
		var publish_dept=$('.publish-dept').val();
		//获取发布时间
		var date_picker=$('.date_picker').val();
		//获取内容的纯文本  
		var text_content=editor.$txt.text();
		//判断标题和内容是否为空
		if(title=="" || text_content=="" ||publish_dept==""){
			layer.msg("标题,内容和发布部门不能为空");
		}else{
			//判断内容里面是否含有图片 ,有图片设为1，无图片设为0
		var is_image;
		if(editor.$txt.find("img[src!='']").length>0){
			is_image=1;
		}else{
			is_image=0;
		}
		var is_publish=0; //意味着要发表1，不是存为草稿0
			$.ajax({
				type:'post',
				dataType:'text',
				url:CTPPATH+'/admin/add/${durl}',
				data:{"itemTitle":title,"itemContent":content,"menuId":"${menuId}","classId":"${classId}","typeFlag":type,"author":publish_dept,"isImage":is_image,"isPublish":is_publish,"addTime":date_picker},
			
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
						layer.msg('保存草稿成功，您可以在列表中查看', {icon: 1,time:2000});
						//将id写入到隐藏域,供上传文件使用
					    $('.hidden-item-id').val(data);
						//判断有无上传文件列队
						if(getQueueSize("uploadify")>0){
							//此时开始上传文件 ，前提是有文件  这时在文件处理那块将id值写到隐藏域
							upload("uploadify");
						}else{
							//跳转界面
							window.location.href=CTPPATH+"/admin/list/${durl}?classId=${classId}&menuId=${menuId}&p=1";
						}

					}else{
						layer.msg("保存草稿出错了", {icon: 2,time:2000});
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
