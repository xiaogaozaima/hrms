<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.*" %><%--
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
    List<Recruit> recruitList = (List<Recruit>) session.getAttribute("recruitList");

    //List<Resume> resumeList = (List<Resume>) session.getAttribute("resumeList");
%>
欢迎<%=admin.getAdmin_name()%><br/>
<a href="backToEnter">返回入口</a>
<hr>
<a href="toAddDeptPos">添加部门。职位</a>
<hr>
<h2>发布简历</h2>
<form action="addHiring" method="post">
    <table>
        <tr><td>招聘部门：</td><td><input type="text" name="dept_id"></td></tr>
        <tr><td>招聘职位：</td><td><input type="text" name="pos_id"></td></tr>
        <tr><td>招聘详情：</td><td><input type="text" name="hir_disc"></td></tr>
        <input type="submit" value="发布招聘信息">
    </table>
</form>

<h2>所有招聘</h2>
<table>
<%
    List<HiringTable> hiringTables = (List<HiringTable>) session.getAttribute("hiringTables");
    if(hiringTables!=null){
        %><tr><th>Hir_id</th><th>Hir_dept_id</th><th>Hir_pos_id</th></tr>
    <%
        for(HiringTable h : hiringTables){
%>
            <tr>
                <td><%=h.getHir_id()%></td>
                <td><%=h.getHir_dept_id()%></td>
                <td><%=h.getHir_pos_id()%></td>
                <td><a href="receivedResume?hir_id=<%=h.getHir_id()%>&dept_id=<%=h.getHir_dept_id()%>&pos_id=<%=h.getHir_pos_id()%>">详情</a></td>
            </tr>
<%
        }
    }
%>
</table>
<hr>


<h1>面试相关</h1>
<hr>
<%
    List<Interview> interviews0 = (List<Interview>) session.getAttribute("interviews0");
    List<Interview> interviews1 = (List<Interview>) session.getAttribute("interviews1");
    List<Interview> interviews2 = (List<Interview>) session.getAttribute("interviews2");
    List<Interview> interviews3 = (List<Interview>) session.getAttribute("interviews3");
%>
<h3>发送面试</h3>
<table border="1">
    <%
        if(interviews0!=null){
    %>
    <th>面试id</th><th>用户id</th><th>部门id</th><th>职位id</th><th>面试时间</th><th>面试地址</th><th>联系人</th><th>联系人电话</th>

    <%
        for(Interview interview : interviews0){
    %>
    <tr>
        <td><%=interview.getInt_id()%></td>
        <td><%=interview.getInt_user_id()%></td>
        <td><%=interview.getInt_dept_id()%></td>
        <td><%=interview.getInt_pos_id()%></td>
        <td><%=interview.getInt_time()%></td>
        <td><%=interview.getInt_address()%></td>
        <td><%=interview.getInt_contact()%></td>
        <td><%=interview.getInt_conphone()%></td>
    </tr>
    <%
            }
        }

    %>
</table>
<hr>
<h3>同意面试</h3>
<table border="1">
<%
    if(interviews1!=null){
%>
    <th>面试id</th><th>用户id</th><th>部门id</th><th>职位id</th><th>面试时间</th><th>面试地址</th><th>联系人</th><th>联系人电话</th>
<%
        for(Interview interview : interviews1){
%>
            <tr>
                <td><%=interview.getInt_id()%></td>
                <td><%=interview.getInt_user_id()%></td>
                <td><%=interview.getInt_dept_id()%></td>
                <td><%=interview.getInt_pos_id()%></td>
                <td><%=interview.getInt_time()%></td>
                <td><%=interview.getInt_address()%></td>
                <td><%=interview.getInt_contact()%></td>
                <td><%=interview.getInt_conphone()%></td>
                <td><a href="addStaff?method=<%=interview.getInt_id()%>&method1=<%=interview.getInt_user_id()%>">录用</a></td>
                <td><a href="refuseInterview?method=<%=interview.getInt_id()%>&method1=<%=interview.getInt_user_id()%>">拒绝</a></td>
            </tr>
<%
        }
    }

%>
</table>
<hr>
<h3>拒绝面试</h3>
<table border="1">
    <%
        if(interviews2!=null){
    %>
    <th>面试id</th><th>用户id</th><th>部门id</th><th>职位id</th><th>面试时间</th><th>面试地址</th><th>联系人</th><th>联系人电话</th>
    <%
        for(Interview interview : interviews2){
    %>
    <tr>
        <td><%=interview.getInt_id()%></td>
        <td><%=interview.getInt_user_id()%></td>
        <td><%=interview.getInt_dept_id()%></td>
        <td><%=interview.getInt_pos_id()%></td>
        <td><%=interview.getInt_time()%></td>
        <td><%=interview.getInt_address()%></td>
        <td><%=interview.getInt_contact()%></td>
        <td><%=interview.getInt_conphone()%></td>
    </tr>
    <%
            }
        }

    %>
</table>
<h3>已录用面试</h3>
<table border="1">
    <%
        if(interviews3!=null){
    %>
    <th>面试id</th><th>用户id</th><th>部门id</th><th>职位id</th><th>面试时间</th><th>面试地址</th><th>联系人</th><th>联系人电话</th>
    <%
        for(Interview interview : interviews3){
    %>
    <tr>
        <td><%=interview.getInt_id()%></td>
        <td><%=interview.getInt_user_id()%></td>
        <td><%=interview.getInt_dept_id()%></td>
        <td><%=interview.getInt_pos_id()%></td>
        <td><%=interview.getInt_time()%></td>
        <td><%=interview.getInt_address()%></td>
        <td><%=interview.getInt_contact()%></td>
        <td><%=interview.getInt_conphone()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
