<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/14 0014
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2 style="color: red">${msg}</h2>
<form method="post">
    Username:<input name="username"/><br/>
    Password:<input type="password" name="password"/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
