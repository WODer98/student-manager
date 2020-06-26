<%--
  Created by IntelliJ IDEA.
  User: 12037
  Date: 2020/6/23
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h2{
            margin-left: 500px;
            color: white;
        }
        body{
            position: relative;
            height: 700px;
            width: 100%;
            background: url("image/login1.png") no-repeat left top;
            background-size: 100%, 100%;
            z-index: 10;
        }
        .box{
            margin-left: 500px;

        }

    </style>
    <title>学生界面</title>
</head>
<body>
<h2>欢迎登录！</h2>
<div class="box">
    <input type="button" id="selectPersonalStudentScores-btn" name="selectPersonalStudent-btn" value="查询个人成绩"><br><br>
</div>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#selectPersonalStudentScores-btn").click(function () {
            window.location = "personalScores.jsp";
        });
    });
</script>
</body>
</html>
