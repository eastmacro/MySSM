
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">导航</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <%--<li class="active"><a href="#">菜单一</a></li>
                <li><a href="#">菜单二</a></li>--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">后台管理<b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/user/userQueryMethod"/>">用户管理</a></li>
                        <li><a href="<c:url value="/role/roleQueryMethod"/>">角色管理</a></li>
                       <%-- <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>--%>
                    </ul>
                </li>
                <li class="active"><a href="<c:url value="/login/logout"/>">登出</a></li>
</ul>

</div>
</div>
</nav>
