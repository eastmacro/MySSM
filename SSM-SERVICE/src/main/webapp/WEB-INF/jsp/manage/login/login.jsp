<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Login Page</title>

    <script src="<c:url value="/jquery/jquery-3.2.0.js"/>" type="text/javascript"></script>

    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/jquery/jquery-ui.css"/>" rel="stylesheet">
    <link href="<c:url value="/js/bootTest/signin.css"/>" rel="stylesheet">
</head>

<body>

<div class="container">
    <form class="form-signin" action="<c:url value="/login/loginCheck"/>" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <c:if test="${!empty error }">
            <label class="error"><em><c:out value="${error }"/></em></label>
        </c:if>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input name="inputEmail" type="email" id="inputEmail" class="form-control" placeholder="Email address" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="inputPassword" type="password" id="inputPassword" class="form-control" placeholder="Password"
               required>
        <div class="checkbox">
          <label>
            <input name="rememberMe" type="checkbox" id="rememberMe" > Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->


</body>
</html>