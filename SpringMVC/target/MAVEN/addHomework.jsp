<%--
  Created by IntelliJ IDEA.
  User: 张影
  Date: 2020/3/11
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布新作业</title>
</head>
<body>
<form action="/addHomework2" id="form">
    <h2>发布作业</h2>
    作业ID:<input type="text" name="homework_id"><br>
    作业要求:<input type="text" name="homework_requirement"><br>
    作业截止日期:<input type="datetime-local" name="homework_endtime"><br>
    <input type="submit" id="submit" value="提交" onclick="a()"><input type="reset" value="重置">
</form>
</body>
</html>
