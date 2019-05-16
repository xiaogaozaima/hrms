<%--
  Created by IntelliJ IDEA.
  User: xiaogao
  Date: 2019/5/15
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">返回入口</a>
<fieldset>
    <legend>管理员注册</legend>
    <form action="adminregiste" method="post">
        账户：<input type="text" name="admin_name" required><br/>
        密码：<input type="text" name="admin_password" required><br/>
        <input type="submit" value="注册"><br/>
    </form>
</fieldset>
<fieldset>
    <legend>管理员登录</legend>
    <form action="adminlogin" method="post">
        账户：<input type="text" name="admin_name" required><br/>
        密码：<input type="text" name="admin_password" required><br/>
        <input type="submit" value="登录"><br/>
    </form>
</fieldset>
</body>
</html>
