<%--
  Created by IntelliJ IDEA.
  User: xiaogao
  Date: 2019/5/16
  Time: 1:39
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
<h2>应该是哪里出错了，或者逻辑不对</h2>
</body>
</html>
