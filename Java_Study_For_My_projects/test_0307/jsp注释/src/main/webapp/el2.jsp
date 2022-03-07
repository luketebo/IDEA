<%@ page import="com.example.jsp.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2022/3/7
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User u = new User();
        u.setName("张三");
        u.setAge(23);
        u.setBirthday(new Date());

        request.setAttribute("user",u);
    %>
    <h3>el 获取对象测试</h3>
    ${requestScope.user.name}
    ${requestScope.user.age}<br>
    ${requestScope.user.birthday}<br>
    ${requestScope.user.birStr}<br>





</body>
</html>
