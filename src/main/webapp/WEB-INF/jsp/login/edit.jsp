<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>编辑用户</title>

    <script src="<c:url value="/jquery/jquery-3.2.0.js"/>" type="text/javascript"></script>

    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <script src="<c:url value="/js/login/edit.js"/>" type="text/javascript"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <h3>用户信息</h3>
            <form class="form-signin" action="<c:url value="/login/submitUser"/>" method="POST">
                <table class="table table-hover table-bordered">
                    <tr>
                        <td>姓名</td>
                        <td>${user.username }</td>
                    </tr>
                    <tr>
                        <td>邮箱地址</td>
                        <td>${user.emailAddress }</td>
                    </tr>
                    <tr>
                        <td>积分</td>
                        <td><input name="credits" type="credits" id="credits" class="form-control" placeholder="number "
                                   required autofocus></td>
                    </tr>
                    <tr>
                        <td>附件</td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>