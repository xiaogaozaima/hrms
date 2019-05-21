<%--
  Created by IntelliJ IDEA.
  User: xiaogao
  Date: 2019/5/15
  Time: 17:43
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
    <legend>员工注册</legend>
    <form action="staffregiste" method="post">
        账户：<input type="text" name="user_name" required><br/>
        密码：<input type="text" name="user_password" required><br/>
        <input type="submit" value="注册"><br/>
    </form>
</fieldset>
<fieldset>
    <legend>员工登录</legend>
    <form action="stafflogin" method="post">
        账户：<input type="text" name="staff_name" required><br/>
        密码：<input type="text" name="staff_password" required><br/>
        <input type="submit" value="登录"><br/>
    </form>
</fieldset>
</body>
</html>
