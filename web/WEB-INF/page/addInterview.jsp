<%@ page import="com.iotek.model.Resume" %><%--
  Created by IntelliJ IDEA.
  User: xiaogao
  Date: 2019/5/16
  Time: 23:44
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
    Resume resume = (Resume) session.getAttribute("resume");
%>
<form action="addInterview" method="post" >
    <table border="1">
        <tr><td colspan="4" align="center"><input type="text" value="个人简历"></td></tr>
        <tr>
            <td>姓名:</td>
            <td><input type="text" maxlength="8" name="res_name" style="border: 0px" value="<%=resume.getRes_name()%>"></td>
            <td>性别:</td>
            <td><input type="text" name="res_sex" value="<%=resume.getRes_sex()%>" ></td>
        </tr>
        <tr>
            <td>出生年月日：</td>
            <td><input required style="border: 0px" type="date" name="res_bothday" value="<%=resume.getRes_bothday()%>"></td>
            <td>民族：</td>
            <td><input required style="border: 0px" type="text" name="res_nation" maxlength="8"  value="<%=resume.getRes_nation()%>"></td>
        </tr>
        <tr>
            <td>籍贯：</td>
            <td><input required style="border: 0px" type="text" maxlength='8' name='res_native' value="<%=resume.getRes_native()%>" ></td>
        </tr>
        <tr>
            <td>毕业院校：</td>
            <td><input style='border: 0px' type='text' maxlength='20' name='res_graduate' value="<%=resume.getRes_graduate()%>" ></td>
            <td>学历：</td>
            <td><input style='border: 0px' type='text' maxlength='20' name='res_education' value="<%=resume.getRes_education()%>" ></td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td><input style='border: 0px' type='text' maxlength='20' name='res_phone' value="<%=resume.getRes_phone()%>" ></td>
            <td>邮箱：</td>
            <td><input style='border: 0px' type='text' maxlength='20' placeholder='最多输入20个字符' name='res_email' value="<%=resume.getRes_email()%>" ></td>
        </tr>
        <tr>
            <td>现住址：</td>
            <td colspan='3'><input style='border: 0px' type='text' maxlength='50' name='res_address' value="<%=resume.getRes_address()%>" ></td>
        </tr>
        <tr><td colspan='4' align='center'>专业技能</td></tr>
        <tr>
            <td colspan='4'><input style='border: 0px' type='text' maxlength='255' name='res_skill' value="<%=resume.getRes_skill()%>" ></td>
        </tr>
        <tr><td colspan='4' align='center'>个性介绍</td></tr>
        <tr>
            <td colspan='4'><input required style='border: 0px' type='text' maxlength='255' name='res_evaluation' value="<%=resume.getRes_evaluation()%>"></td>
        </tr>
        <tr>
            <td><input type='hidden' id='r_tid' name='res_user_id' value="<%=resume.getRes_user_id()%>"></td>
            <td colspan='3' align='center' ><input type='submit' value='邀请面试'></td>
        </tr>
    </table></form>

</body>
</html>
