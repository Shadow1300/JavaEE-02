
<%@ page import="java.util.List" %>
<%@ page import="model.SubmitHomework" %>
<%--
  Created by IntelliJ IDEA.
  User: 张影
  Date: 2020/3/11
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看作业提交情况</title>
</head>
<body>
<%
    List<SubmitHomework> list=(List <SubmitHomework>)request.getAttribute("list");

    if(null==list||list.size()<=0){
        out.println("No data");
    }else {

%>
<table align="center" width="960" border="0.5" bgcolor="black" cellspacing="1">
    <tr align="center"  height="40" bgcolor="#b3ffc2">
        <td>序号</td>
        <td>学生学号</td>
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>提交时间</td>
        <td>截止时间</td>
    </tr>

    <%
        for(SubmitHomework submitHomework:list){
    %>

    <tr align="center" bgcolor="white">
        <td><%=submitHomework.getId()%></td>
        <td><%=submitHomework.getStudent_id()%></td>
        <td><%=submitHomework.getHomework_id()%></td>
        <td><%=submitHomework.getHomework_title()%></td>
        <td><%=submitHomework.getHomework_content()%></td>
        <td><%=submitHomework.getSubmit_time()%></td>
        <td><%=submitHomework.getHomework_endtime()%></td>
    </tr>

    <%
            }
        }
    %>
</table>

</body>
</html>
