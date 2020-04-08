
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
><%--
  Created by IntelliJ IDEA.
  User: 张影
  Date: 2020/3/11
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看学生</title>
</head>
<body>
<%
    List<Student> list=(List <Student>)request.getAttribute("list");

    if(null==list||list.size()<=0){
        out.println("No data");
    }else {

%>
<table align="center" width="960" border="0.5" bgcolor="black" cellspacing="1">
    <tr align="center"  height="40" bgcolor="#b3ffc2">
        <td>序号</td>
        <td>学生ID</td>
        <td>学生姓名</td>
    </tr>

    <%
        for(Student student:list){
    %>

    <tr align="center" bgcolor="white">
        <td><%=student.getId()%></td>
        <td><%=student.getStudent_id()%></td>
        <td><%=student.getStudent_name()%></td>
    </tr>

    <%
            }
        }
    %>
</table>
</body>
</html>
