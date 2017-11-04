<html>
<body>
<h2>Hello World!</h2>

<%
    request.getRequestDispatcher("/WEB-INF/jsp/manage/login/login.jsp").forward(request, response);

%>
</body>
</html>
