$(document).ready(function(){

    $("#input-id").fileinput({


        uploadUrl : 'fileinputAjax',
        uploadAsync : true,//true异步,false同步
        maxFileCount : 1,
        maxFileSize : 51200,
        //maxFilePreviewSize : 102400,//预览的最大文件大小，超过不预览
        allowedFileExtensions : [ 'jpg', 'png' ],// 接收的文件后缀
        language : 'zh',
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',
        /*uploadExtraData: {
            "id": document.getElementByID('userId').value
        }*/
        uploadExtraData:{id:$("#id").val()}
    }).on("fileuploaded", function(event, data, previewId, index) {
        alert("文件大小为"+data.response.fileSize);
    });


    $("#back").click(function (e) {
        window.location="userQueryMethod";
    });


});