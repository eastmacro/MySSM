$(document).ready(function () {

    $("#input-id").fileinput({
        uploadUrl: '../fileinputAjax',
        uploadAsync: true,//true异步,false同步
        maxFileCount: 1,
        maxFileSize: 51200,
        //maxFilePreviewSize : 102400,//预览的最大文件大小，超过不预览
        allowedFileExtensions: ['jpg', 'png', 'img'],// 接收的文件后缀
        language: 'zh',
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',
        uploadExtraData: {id: $("#id").val()} //附加参数
    }).on("fileuploaded", function (event, data, previewId, index) {
        alert("文件大小为" + data.response.fileSize);
    });


    $("#back").click(function (e) {

        var curWwwPath = window.document.location.href;
        //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8083
        var localhostPaht = curWwwPath.substring(0, pos);
        //获取带"/"的项目名，如：/uimcardprj
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        var baseRoot = localhostPaht + projectName;

        window.location="/MySSM/user/userQueryMethod/";
    });


});