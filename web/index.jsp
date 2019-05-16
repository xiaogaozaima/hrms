<%--
  Created by IntelliJ IDEA.
  User: xiaogao
  Date: 2019/5/15
  Time: 17:44
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
<a href="userlogin.jsp">用户</a><a href="stafflogin.jsp">员工</a><a href="adminlogin.jsp">管理员</a>
</body>
</html>
