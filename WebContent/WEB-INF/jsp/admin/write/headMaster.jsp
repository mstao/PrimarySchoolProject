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
        definedData.fileSizeLimit = "20MB";  //上传大小  
        definedData.queueSizeLimit = 5;      //允许上传个数文件  
		
		 var errorData = [];  
         errorData.err100 = "文件个数超出系统限制，只允许上传" + definedData.queueSizeLimit + "个文件！";  
         errorData.err110 = "文件超出系统限制的大小，限制文件大小" + definedData.fileSizeLimit + "！";  
         errorData.err120 = "文件大小异常！";    
		
         //start uplaoding
		$("#uploadify").uploadify({
			debug			: false, 

			swf 			:  CTP_ADMIN+'/js/extends/uploadify/js/uploadify.swf',	//swf文件路径
			method			: 'post',	// 提交方式
			uploader		:  CTPPATH+'/admin/upload/uploadimage;jsessionid=${pageContext.session.id}', // 服务器端处理该上传请求的程序(controller)

			preventCaching	: true,		// 加随机数到URL后,防止缓存

			buttonCursor	: 'hand',	// 上传按钮Hover时的鼠标形状
		//	buttonImage		: 'img/.....png',	// 按钮的背景图片,会覆盖文字
			buttonText		: '选择图片'	, //按钮上显示的文字，默认”SELECTFILES”
			height			: 30	, // 30 px
			width			: 120	, // 120 px
			
			fileObjName		: 'filedata',	//文件对象名称, 即属性名
			fileSizeLimit	: '10MB'	,		// 文件大小限制, 10M
			fileTypeDesc	: '图片类型(.JPG,.GIF,.PNG)'	,	//文件类型说明 any(*.*)
			fileTypeExts	: '*.jpg;*.png;.gif',		// 允许的文件类型,分号分隔
			//formData		: {'id':'1', 'type':'myFile'} , //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
		
			auto            : true,    //选择完文件是否自动上传
			multi			: false,	// 多文件上传
			progressData	: 'speed,percentage',	// 进度显示, speed-上传速度,percentage-百分比	
			queueID			: 'fileQueue',//上传队列的DOM元素的ID号
			queueSizeLimit	: 99	,	// 队列长度
			removeCompleted : true	,	// 上传完成后是否删除队列中的对应元素
			removeTimeout	: 5	,	//上传完成后多少秒后删除队列中的进度条, 
			requeueErrors	: true,	// 上传失败后重新加入队列
			uploadLimit		: definedData.queueSizeLimit,	// 最多上传文件数量

			successTimeout	: 30	,//表示文件上传完成后等待服务器响应的时间。超过该时间，那么将认为上传成功。
			// 在文件被移除出队列时触发	
			//onCancel : function(file) { alert( 'The file ' + file.name + ' was cancelled!' ); },
			
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
                              
				 layer.msg(file.name + ' 上传失败！ ' + 
                        'errorCode: ' + errorCode +
                        'errorMsg:' + errorMsg +
                        'errorString:' + errorString,{icon: 2,time:2000}); 
                                /*  alert(
                                    file.name + ' upload failed! ' + 
                                    'errorCode: ' + errorCode +
                                    'errorMsg:' + errorMsg +
                                    'errorString:' + errorString
                                ); */
							}, 
            
            // 在每一个文件上传成功后触发
            onUploadSuccess : function(file, data, response) {
                              
            	layer.msg(  file.name + ' 上传成功！  ' +
                        '  --data:' + data +
                        '  --response: ' + response,{icon: 1,time:5000});
         
            	//将 图片信息写到图片展示 
                $('.person-image').attr("src",data);
            	//将图片路径写入隐藏域，后面还用
            	$('.hidden-item-image').val(data);
            	
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
		$("#" + id).uploadify("settings", "formData",{});
	    $("#" + id).uploadify("upload", "*");
	}
	//清空列队
    function clean(id){
    	$("#" + id).uploadify('cancel', '*');
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
		<span class="edit-span">撰写校长信息</span><br><br>
		<label>姓名：</label>
		<input type="text"  class="edit-input edit-com-name" placeholder="姓名">
		<br>
		<label>邮箱：</label>
		<input type="text" class="edit-input edit-com-email" placeholder="邮箱(保证可用)">
		<span class="content-span">上传照片</span><br>
		<!--图片上传和展示信息  -->
		<div class="image-div">
		<span id="uploadify"></span>
		<div id="fileQueue"></div> 
		 <img alt="" src="" class="person-image" > 
		</div>
		<br>
		<label>职务：</label>
		<select name="publish_style" id="post-check">
		<c:forEach items="${post}" var="post_list">
		    	<option value="${post_list.id}">${post_list.postName}</option>
		    	
		 </c:forEach>	
		 </select><br><br>
        
        <label>具体工作：</label>
		<input type="text" class="edit-input edit-com-work" placeholder="具体工作">
		
	    <br>
	    
	    <!-- 图片地址异常域 -->
	    <input type="hidden" class="hidden-item-image" value="">
	    
        <div class="edit-submit">
        	<a href="javascript:void(0);" class="draft-btn draft-h-btn" onClick="ChangeState();">保存草稿</a><a href="javascript:void(0);" class="publish-btn publish-h-btn" onClick="ChangeState();">发布内容</a>
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
		    	<option >校长信息</option>
		    
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
<jsp:include page="../common/footer.jsp"></jsp:include>
<!--E footer-->
	</body>
</html>

<script type="text/javascript">

$('.date_picker').date_input();
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
    
    var ok_email=false;
    
    //验证邮箱
    $(".edit-com-email").bind("blur",function(){
    	var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    	var str = $(this).val();
		str = str.replace(/\s/g , '');//输入空格时自动忽略，\s表示空格
		if( $(this).val() == "" || $(this).val==null ){
			layer.tips('邮箱不能为空', '.edit-com-email');
    		$(this).focus();
		}else{
			if(filter.test( $(this).val() )){
				ok_email=true;
			}else{
				layer.tips('邮箱格式不正确', '.edit-com-email');
			}
			
		}
    });
    
    /**********发布 **********/
    $(".publish-h-btn").bind("click",function(){
    	
    	var name=$(".edit-com-name").val();
    	var email=$(".edit-com-email").val();
    	var avatar=$(".hidden-item-image").val();
    	var post=$(".post-check").val();
    	var work=$(".edit-com-work").val();
    	
    	if(name.replace(/\s/g , '') !="" && ok_email==true && avatar!="" && post!="" && work.replace(/\s/g , '') !=""){
    	
    		$.ajax({
        		
        		
        	});
    	}else{
    		layer.msg("内容未填写完成，请仔细核对信息再进行提交！");
    	}
    	
    	
    });
    
});

</script>
