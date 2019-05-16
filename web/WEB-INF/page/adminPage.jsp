<%@ page import="com.iotek.model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: xiaogao
  Date: 2019/5/16
  Time: 15:09
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
    <title>adminPage</title>
</head>
<body>
<%
    Admin admin = (Admin) session.getAttribute("ad");
%>
欢迎<%=admin.getAdmin_name()%><br/>
<a href="backToEnter">返回入口</a>

</body>
</html>
