<%--
  Created by IntelliJ IDEA.
  User: 张影
  Date: 2020/3/11
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="addStudentServlet" id="form" method="post">
    <h2>添加学生</h2>
    学生ID:<input type="text" name="student_id"><br>
    学生姓名:<input type="text" name="student_name"><br>
    <input type="submit" id="submit" value="提交" onclick="a()"><input type="reset" value="重置">
</form>

</body>
</html>
