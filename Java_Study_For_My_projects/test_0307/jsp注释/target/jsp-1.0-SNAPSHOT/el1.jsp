<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2022/3/7
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>测试el表达式功能</h1>
    <%
        request.setAttribute("msg","hello");
        session.setAttribute("name","gun");

    %>
    <h5>${requestScope.msg}</h5><br>
    <h5>${sessionScope.name}</h5><br>



</body>
</html>
