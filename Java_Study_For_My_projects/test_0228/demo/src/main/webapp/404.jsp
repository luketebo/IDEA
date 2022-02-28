<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2022/2/28
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String message = exception.getMessage();
    out.print(message);
%>
</body>
</html>
