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
    List<Interview> interviewList = (List<Interview>) session.getAttribute("interviewList");
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
<%
    List<HiringTable> hiringTables = (List<HiringTable>) session.getAttribute("hiringTables");
    if(hiringTables!=null){
        for(HiringTable h : hiringTables){
%>
<h5>
<%=h%>
</h5><br/>
<%
        }
    }
%>
<hr>
<h2>接收的简历</h2>
<table>
    <%
        if(recruitList!=null){
    %>
    <tr><th>编号</th><th>招聘ID</th><th>简历ID</th><th>简历详情</th></tr>
        <%
            for(Recruit recruit : recruitList){
        %>


<%--
    <tr><td><%=recruit.getRec_id()%></td><td><%=recruit.getRec_hir_id()%></td><%=recruit.getRec_res_id()%><td><a>简历详情</a></td></tr>
--%>




    <tr><td><%=recruit.getRec_id()%></td><td><%=recruit.getRec_hir_id()%></td><td><%=recruit.getRec_res_id()%></td><td><a href="beforeInterview?method=<%=recruit.getRec_res_id()%>&method1=<%=recruit.getRec_hir_id()%>">简历详情</a></td></tr>



    <%
            }
        }
    %>

</table>

<hr>

<h1>面试</h1>
<table>
<%
    if(interviewList!=null){
%>
    <th>面试id</th><th>用户id</th><th>录用</th><th>拒绝</th>
<%
        for(Interview interview : interviewList){
%>
            <tr><td><%=interview.getInt_id()%></td><td><%=interview.getInt_user_id()%></td><td><a href="addStaff?method=<%=interview.getInt_id()%>&method1=<%=interview.getInt_user_id()%>">录用</a></td><td>拒绝</td></tr>
<%
        }
    }

%>
</table>
</body>
</html>
