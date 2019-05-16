<%@ page import="com.iotek.model.User" %>
<%@ page import="com.iotek.model.Resume" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.HiringTable" %><%--
  Created by IntelliJ IDEA.
  User: xiaogao
  Date: 2019/5/15
  Time: 14:18
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
    <title>mainPage</title>
    <script src="js/jquery-3.1.0.js"></script>
    <% User user = (User) session.getAttribute("u");
    session.setAttribute("user1",user);%>
    <script>
        $(function () {
            $("#addResume").click(function () {
                $("body").append(
                    "<form action='addResume' method='post'><table border='1'>" +
                    "<tr><td colspan='4' align='center'><input type='text' value='个人简历'></td></tr>" +
                    "<tr>" +
                        "<td>姓名:</td>" +
                        "<td><input type='text' maxlength='8' placeholder='最多输入八个字符' name='res_name' required style='border: 0px' ></td>" +
                        "<td>性别:</td>" +
                        "<td><input type='radio' name='res_sex' value='男' required>男<input type='radio' name='r_sex' value='女' required>女</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>出生年月日：</td>" +
                        "<td><input required style='border: 0px' type='date' name='res_bothday' required></td>" +
                        "<td>民族：</td>" +
                        "<td><input required style='border: 0px' type='text' name='res_nation' maxlength='8' placeholder='最多输入八个字符' required></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>籍贯：</td>" +
                        "<td><input required style='border: 0px' type='text' maxlength='8' placeholder='最多输入八个字符' name='res_native' required></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>毕业院校：</td>" +
                        "<td><input required style='border: 0px' type='text' maxlength='20' placeholder='最多输入20个字符' name='res_graduate' required></td>" +
                        "<td>学历：</td>" +
                        "<td><input required style='border: 0px' type='text' maxlength='20' placeholder='最多输入20个字符' name='res_education' required></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>电话号码：</td>" +
                        "<td><input required style='border: 0px' type='text' maxlength='20' placeholder='输入11位数字' name='res_phone' required></td>" +
                        "<td>邮箱：</td>" +
                        "<td><input required style='border: 0px' type='text' maxlength='20' placeholder='最多输入20个字符' name='res_email' required></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>现住址：</td>" +
                        "<td colspan='3'><input required style='border: 0px' type='text' maxlength='50' placeholder='最多50个字符' name='res_address' required></td>" +
                    "</tr>" +
                    "<tr><td colspan='4' align='center'>专业技能</td></tr>" +
                    "<tr>" +
                        "<td colspan='4'><input required style='border: 0px' type='text' maxlength='255' placeholder='最多255个字符' name='res_skill' required></td>" +
                    "</tr>" +
                    "<tr><td colspan='4' align='center'>个性介绍</td></tr>" +
                    "<tr>"+
                        "<td colspan='4'><input required style='border: 0px' type='text' maxlength='255' placeholder='最多255个字符' name='res_evaluation' required></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td><input type='hidden' id='r_tid' name='res_user_id'></td>"+
                        "<td colspan='3' align='center' ><input type='submit' value='提交'></td>" +
                    "</tr>" +
                    "</table></form>"
                )
            })
        })
    </script>
</head>
<body>
欢迎您!<%out.print(user.getUser_name());%><br>
<a href="../../userlogin.jsp">返回用户登录</a><a href="../../index.jsp">返回入口</a>
<hr>
<%
    List<HiringTable> hiringList = (List<HiringTable>) session.getAttribute("hiringList");
    if(hiringList==null){
%>
<h1>尚未发布招聘信息</h1>


<%
    }else {
%>

<table>
        <tr><th>职位</th><th>薪资</th><th>福利</th><th>投递</th></tr>
<%
        for(int i = 0;i<hiringList.size();i++){
%>
    <tr><td><%=hiringList.get(i).getHir_pos_id()%></td><td><%="薪资还没加上去"%></td><td><%="福利还没加"%></td><td><button>投递</button></td></tr>
<%
        }
    }
%>
</table>
<hr>
<% Resume resume = (Resume) session.getAttribute("resume");%>

<%
    if(resume==null){
%>
<a id="addResume">创建简历</a>
<%--<input type="text" name="tid<%=user.getUser_id()%>" value="<%=user.getUser_id()%>">--%>
<%
    }else {
%>
<button onclick="showResume()">我的简历</button>
<form id="showMyResume" action="updateResume" method="post" style="display: none">
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
        <td colspan='3' align='center' ><input type='submit' value='更改'></td>
        </tr>
    </table></form>
<%
    }
%>
<script>
    function showResume() {
         if(showMyResume.style.display=="none"){
             showMyResume.style.display="block";
         }else {
             showMyResume.style.display="none";
         }
    }
</script>

</body>
</html>
