<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${SCHOOL_STUDENT_LAB}-${WEBSITE_NAME}</title>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<c:set var="CTP_HOME" value="${pageContext.request.contextPath}/resources/home"></c:set>
<c:set var="CTP_ADMIN" value="${pageContext.request.contextPath}/resources/admin"></c:set>
<link href="${CTP_ADMIN }/css/admin_header.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/css/beforelist.css" rel="stylesheet" type="text/css" />
<link href="${CTP_ADMIN }/js/extends/uploadify/css/uploadify.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="${CTP_HOME}/css/classmain.css" />
<script type="text/javascript" src="${CTP_HOME}/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${CTP_HOME}/js/module/common.js" ></script>
<script type="text/javascript" src="${CTP}/resources/common/js/extends/layer-2.4/layer.js"></script>
<script type="text/javascript" src="${CTP_ADMIN }/js/extends/uploadify/js/jquery.uploadify.min.js" ></script>

<script type="text/javascript">
var CTPPATH="${pageContext.request.contextPath}";
var CTP_ADMIN=CTPPATH+"/resources/admin";
var sid;
	
$(function() {
    
	$(".rest-select").bind("click",function(){
		
		$(".mark").show();
		$(".dialog").show();
		
		//获取id的值
		sid=$(".rest-select").attr('data-id');
		//$("input[type='radio']:checked").val();
	});
$(".rest-selects").bind("click",function(){
		
		$(".mark").show();
		$(".dialog").show();
		
		//获取id的值
		sid=$(".rest-selects").attr('data-id');
		//$("input[type='radio']:checked").val();
	});
	
	/*************setting***************/  
	var definedData = [];  
	definedData.fileSizeLimit = "20MB";  //上传大小  
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
		fileSizeLimit	: '20MB'	,		// 文件大小限制, 10000 KB
		fileTypeDesc	: 'any'	,	//文件类型说明 any(*.*)
		fileTypeExts	: '*.*;*.txt',		// 允许的文件类型,分号分隔
		//formData		: {'id':'1', 'type':'myFile'} , //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
	
		auto            : false,    //选择完文件是否自动上传
		multi			: true ,	// 多文件上传
		progressData	: 'speed,percentage',	// 进度显示, speed-上传速度,percentage-百分比	
		queueID			: 'fileQueue',//上传队列的DOM元素的ID号
		queueSizeLimit	: 10	,	// 队列长度
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
						},
		
		// 选择文件对话框打开时触发
		onDialogOpen : function () { /*alert( 'please select files' ) */ },
	
		// 没有兼容的FLASH时触发
		onFallback : function(){ alert( '您未安装FLASH控件,无法上传文件!请安装FLASH控件后再试。' ) },
		
		// 上传文件失败触发
		onUploadError : function(file, errorCode, errorMsg, errorString){ 
                         
			 layer.msg(file.name + ' 上传未完成！ ' );
                   
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
            		$('.mark,.dialog').hide();
               	layer.msg("课表上传成功",{icon: 1,time:3000});
               
               	//此时可以进行跳转页面
               	//跳转界面
					window.location.href=CTPPATH+"/admin/list/restTime";
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
	
	$("#" + id).uploadify("settings", "formData",{'item_id':sid,'item_type':"${fileType}"});
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
<%--引入header --%>

<jsp:include page="../common/header.jsp"></jsp:include>
<div id="location"><span>您现在的位置: 后台管理 ></span><span>作息时间表管理</span></div>
<!-- 作息时间表 -->
  <div class="rest">
  		<div class="rest-spring">
	  		<div class="rest-title">
	  		<span>春期作息时间表</span>
	  		<c:choose>
	  			<c:when test="${empty Spring}">
	  				<a href="#" class="rest-select" data-id="1">新增</a>
	  			</c:when>
	  			<c:otherwise>
	  				<a href="#" class="rest-select" data-id="1">更新</a>
	  				<div class="rest-content">
	  				<ol>
	  				<c:forEach var="spring" items="${Spring}">  
	  				<li><img src="${CTP_HOME}/img/j_do.png" class="dot"/>
	  				<a href="javascript:location.href='${CTP}/download/file?fileName='+encodeURIComponent('${spring.fileName}')+'&realName='+encodeURIComponent('${spring.realName}');">${spring.fileName}</a><span>${spring.addTime}</span></li>
	  				</c:forEach>
	  				</ol>
	  				</div>
	  			</c:otherwise>
	  		</c:choose>
	  		</div>
  		</div>
  		<div class="rest-autumn">
	  		<div class="rest-title">
	  		<span>秋期作息时间表</span>
	  		<c:choose>
	  			<c:when test="${empty Autumn}">
	  				<a href="#" class="rest-selects" data-id="2">新增</a>
	  			</c:when>
	  			<c:otherwise>
	  				<a href="#" class="rest-selects" data-id="2">更新</a>
	  				<div class="rest-content">
	  				<ol>
	  				<c:forEach var="autumn" items="${Autumn}">  
	  				<li><img src="${CTP_HOME}/img/j_do.png" class="dot"/>
	  				<a href="javascript:location.href='${CTP}/download/file?fileName='+encodeURIComponent('${autumn.fileName}')+'&realName='+encodeURIComponent('${autumn.realName}');">${autumn.fileName}</a><span>${autumn.addTime}</span></li>
	  				</c:forEach>
	  				</ol>
	  				</div>
	  			</c:otherwise>
	  		</c:choose>
	  		</div>
  		</div>
  </div>
    <!-- 弹窗 -->
<div class="mark"></div>
<div class="dialog">
     
        <div class="dialog-close" onclick="$('.mark,.dialog').hide();"></div> 
        <div class="dialog-title">课表上传</div> 
        <div class="dialog-content"> 
            <input type="hidden" class="hide-checked-id" value="">
            <div class="opt-div">
            <div align="center">
            <h4>选择文件后请点击手动上传</h4>
            <h5>可以重复上传，以最后一次为准</h5>
            </div>
			
			<div class="dialog-content">
		    <div align="center"><span id="uploadify"></span></div>
			<div id="fileQueue"></div>     
			 <br>
			 <div class="dialog-link">
		    <a href="javascript:upload('uploadify')"  class="start-upload">手动上传</a>&nbsp; 

	       	<a href="javascript:clean('uploadify')" class="clean-queue">清空列表</a>
		  </div>
		  </div>
           
        </div>
</div> 
</div>
    



<%--引入footer --%>
<jsp:include page="../common/footer.jsp" />
</body>
</html>
