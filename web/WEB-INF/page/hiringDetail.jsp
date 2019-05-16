<%@ page import="com.iotek.model.HiringTable" %>
<%@ page import="com.iotek.model.User" %><%--
  Created by IntelliJ IDEA.
  User: xiaogao
  Date: 2019/5/16
  Time: 15:48
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
<%
    HiringTable hiringTable = (HiringTable) session.getAttribute("hiringTable");
    User user = (User) session.getAttribute("user");
%>
<form action="postResume" method="post">
    <table>
        <tr hidden><td><input type="text" name="hir_id" value="<%=hiringTable.getHir_id()%>"><input type="text" name="user_id" value="<%=user.getUser_id()%>"></td></tr>
        <tr hidden><td><input type="text" name="hir_dept" value="<%=hiringTable.getHir_dept_id()%>"></td></tr>
        <tr><td>招聘职位：</td><td><input type="text" name="hir_pos_id" value="<%=hiringTable.getHir_pos_id()%>"></td></tr>
        <tr><td>详情：</td><td><input type="text" name="hir_disc" value="<%=hiringTable.getHir_disc()%>"></td></tr>
    </table>
    <input type="submit" value="投递简历">
</form>

</body>
</html>
