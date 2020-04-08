<%--
  Created by IntelliJ IDEA.
  User: 张影
  Date: 2020/3/10
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>学生作业管理系统登录</title>

    <STYLE type="text/css">
        body{
            background-repeat: repeat;
        }
        body{
            background-image: url(images/timg.jpg);
        }
        #form{
            width:250px;
            height:160px;
            position:relative;
            left:50%;
            top:50%;
            margin-left:-150px;
            margin-top:-80px;

        }

    </STYLE>
</head>
<body>

<form action="/load" id="form" margin="100px" >
    学生学号:    <input type="text" name="student_id" value="" align="center"><br>
    学生姓名:    <input type="text" name="student_name" align="center"><br>
    <br>
    <input type="submit" id="submit" value="登录" onclick="a()" align="center">              <input type="reset" value="重置">
    <p align="center"></p>
</form>


</body>
</html>
