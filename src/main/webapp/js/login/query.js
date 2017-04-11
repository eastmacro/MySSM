$(document).ready(function(){
	$("#input-id").fileinput({
		
		
		uploadUrl : '/MyDemo/login/fileinputAjax',
		uploadAsync : true,//true异步,false同步
		maxFileCount : 5,
		maxFileSize : 51200,
		//maxFilePreviewSize : 102400,//预览的最大文件大小，超过不预览
		//allowedFileExtensions : [ 'jpg', 'png', 'xlsx','txt' ],// 接收的文件后缀
		language : 'zh',
		msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"
	}).on("fileuploaded", function(event, data, previewId, index) {
		alert("文件大小为"+data.response.fileSize);
	}).on("");
	
	

  $(".edit").click(function(){
	  alert("delete");
  });
  
  $(".delete").click(function(){
	  alert("delete");
  });
});