
<%@ page import="java.util.List" %>
<%@ page import="model.Homework" %>
<%--
  Created by IntelliJ IDEA.
  User: 张影
  Date: 2020/3/11
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询作业发布情况</title>
</head>
<body>
<%
    List<Homework> list=(List <Homework>)request.getAttribute("list");

    if(null==list||list.size()<=0){
        out.println("No data");
    }else {

%>
<table align="center" width="960" border="0.5" bgcolor="black" cellspacing="1">
    <tr align="center"  height="40" bgcolor="#b3ffc2">
        <td>序号</td>
        <td>作业ID</td>
        <td>作业要求</td>
        <td>作业截止时间</td>
    </tr>

    <%
        for(Homework homework:list){
    %>

    <tr align="center" bgcolor="white">
        <td><%=homework.getId()%></td>
        <td><%=homework.getHomework_id()%></td>
        <td><%=homework.getHomework_requirement()%></td>
        <td><%=homework.getHomework_endtime()%></td>
    </tr>

    <%
            }
        }
    %>
</table>


</body>
</html>
