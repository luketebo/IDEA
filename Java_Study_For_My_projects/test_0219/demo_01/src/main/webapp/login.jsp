<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2022/2/20
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    window.onload = function (){
        document.getElementById("img").onclick = function (){
            this.src = "${pageContext.request.contextPath}/CheckCodeDemo01?time="+new Date().getTime();
        }
    }
</script>
<body>
    <form action="${pageContext.request.contextPath}/CheckCodeCase" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="CheckCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="${pageContext.request.contextPath}/CheckCodeDemo01"></td>

            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
<div><%=request.getAttribute("cc_error")%></div>
<div><%=request.getAttribute("login_error")%></div>
</body>
</html>
