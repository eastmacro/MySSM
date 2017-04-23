<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>用户列表</title>

    <script src="<c:url value="/jquery/jquery-3.2.0.js"/>" type="text/javascript"></script>

    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/bootstrap-fileinput/css/fileinput.css"/>" media="all" rel="stylesheet" type="text/css"/>

    <!-- the main fileinput plugin file -->
    <script src="<c:url value="/bootstrap-fileinput/js/fileinput.js"/>"></script>
    <!-- bootstrap.js below is needed if you wish to zoom and view file content
         in a larger detailed modal dialog -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- optionally if you need a theme like font awesome theme you can include
        it as mentioned below -->
    <script src="<c:url value="/bootstrap-fileinput/themes/fa/theme.js"/>"></script>
    <!-- optionally if you need translation for your language then include
        locale file as mentioned below -->
    <script src="<c:url value="/bootstrap-fileinput/js/locales/zh.js"/>"></script>


    <script src="<c:url value="/js/backStageManage/user/userQuery.js"/>" type="text/javascript"></script>


</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/bar.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <c:if test="${!empty loginUser }">
                <label><em><c:out value="${loginUser } welcome!"/></em></label>
            </c:if>
            <%-- <form enctype="multipart/form-data" class="form-signin" action="<c:url value="/backStageManage/fileinput"/>" method="POST"> --%>
            <%--<fieldset>
                <legend>表单项</legend>
                <label>表签名</label>
                <input id="input-id" type="file" multiple name="file"/>
            </fieldset>--%>
            <!-- 	</form> -->
            <h3>
                用户列表
            </h3>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>
                        序号
                    </th>
                    <th>
                        名称
                    </th>
                    <th>
                        邮箱
                    </th>
                    <th>
                        上次登陆时间
                    </th>
                    <th>
                        积分
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>


                <c:forEach var="item" items="${userList }" varStatus="status">
                    <tr class="<c:if test="${status.count%2 ne 0 }">info</c:if>">
                        <!--success error warning info-->
                        <td>
                                ${status.count }
                        </td>
                        <td>
                                ${item.username }
                        </td>
                        <td>
                                ${item.emailAddress }
                        </td>
                        <td>
                                ${item.lastVisitTime }
                        </td>
                        <td>
                                ${item.credits }
                        </td>
                        <td>
                            <button class="btn edit" id="${item.id}" type="button" href="/backStageManage/edit">修改</button>
                            <button class="btn delete" type="button" param="${item.id }">删除</button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>
</div>
</body>
</html>