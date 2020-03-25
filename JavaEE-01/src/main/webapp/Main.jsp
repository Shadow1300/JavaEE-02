<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr>
        <td>请选择操作项</td>
    </tr>
    <tr>
        <td><a href="<%=request.getContextPath() %>/addStudent.jsp" target="_blank">添加学生</a></td>
    </tr>
    <tr>
        <td><a href="<%=request.getContextPath() %>/selectstudent" target="_blank">查看学生</a></td>
    </tr>
    <tr>
        <td><a href="<%=request.getContextPath() %>/addHomework.jsp" target="_blank">发布作业</a></td>
    </tr>
    <tr>
        <td><a href="<%=request.getContextPath() %>/selectsubmit" target="_blank">查看作业提交情况</a></td>
    </tr>
    <tr>
        <td><a href="<%=request.getContextPath() %>/selecthomework" target="_blank">查看作业要求</a></td>
    </tr>
    <tr>
        <td><a href="<%=request.getContextPath() %>/submitHomework.jsp" target="_blank">提交作业</a></td>
    </tr>
</table>
</body>

</html>
