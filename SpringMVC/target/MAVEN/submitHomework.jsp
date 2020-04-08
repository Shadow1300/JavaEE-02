<%--
  Created by IntelliJ IDEA.
  User: 张影
  Date: 2020/3/11
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业提交</title>
</head>
<body>
<form action="/submitHomework2" id="form" method="post">
    <h2>提交作业</h2>
    学生ID:<input type="text" name="student_id" value="" id="123"><br>
    作业ID:<input type="text" name="homework_id"><br>
    作业标题:<input type="text" name="homework_title"><br>
    作业内容:<input type="text" name="homework_content"><br>
    <input type="submit" id="submit" value="提交" onclick="a()"><input type="reset" value="重置">
</form>
</body>
</html>
