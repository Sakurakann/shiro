<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<h2>Hello World!</h2><br/>
<shiro:guest>
    <a href="<%=request.getContextPath() %>/login">登陆</a>
</shiro:guest>

<shiro:user>
    <shiro:hasRole name="admin">
        <a href="<%=request.getContextPath() %>/admin">管理员</a>
        <a href="<%=request.getContextPath() %>/user/add.jsp">添加用户</a>
    </shiro:hasRole>
    <shiro:hasPermission name="user:*">
        <a href="<%=request.getContextPath() %>/user/list.jsp">用户列表</a>
    </shiro:hasPermission>
    <a href="<%=request.getContextPath() %>/logout">登出</a>
</shiro:user>

</body>
</html>
