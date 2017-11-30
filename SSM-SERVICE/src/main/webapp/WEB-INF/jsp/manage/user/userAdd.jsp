<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>编辑用户</title>

    <script src="<c:url value="/jquery/jquery-3.2.0.js"/>" type="text/javascript"></script>

    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <script src="<c:url value="/js/manage/user/userEdit.js"/>" type="text/javascript"></script>

    <link href="<c:url value="/bootstrap-fileinput/css/fileinput.css"/>" media="all" rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/bootstrap-fileinput/js/fileinput.js"/>"></script>
    <script src="<c:url value="/bootstrap-fileinput/themes/fa/theme.js"/>"></script>
    <script src="<c:url value="/bootstrap-fileinput/js/locales/zh.js"/>"></script>


</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/bar.jsp"/>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <h3>用户信息</h3>
            <form class="form-signin" action="<c:url value="/user/insertUser"/>" method="POST">
                <table class="table table-hover table-bordered">
                    <tr>
                        <td>姓名</td>
                        <td>
                            <input name="username"  id="username" class="form-control" placeholder="string"
                                   required autofocus>
                        </td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><input name="password"  id="password" class="form-control" placeholder="string" required autofocus></td>
                    </tr>
                    <tr>
                        <td>邮箱地址</td>
                        <td><input name="emailAddress"  id="emailAddress" class="form-control" placeholder="string" autofocus></td>
                    </tr>
                    <tr>
                        <td>积分</td>
                        <td><input name="credits" type="credits" id="credits" class="form-control" placeholder="number "
                                    autofocus></td>
                    </tr>

                    <button type="submit" class="btn btn-submit">提交</button>
                    <button type="button" class="btn btn-back" id="back">返回</button>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>