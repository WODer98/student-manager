<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员界面</title>
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
</head>
<body>
<h2>欢迎管理员登录</h2>
<div class="box">
<input type="button" id="selectAllStudent-btn" name="selectAllStudent-btn" value="查询所有学生信息"><br><br>
<input type="button" id="selectAllTeacher-btn" name="selectAllTeacher-btn" value="查询所有教师信息">
</div>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        //点击查询按钮时，发送Ajax请求
        $("#selectAllStudent-btn").click(function () {
            window.location = "studentList.jsp";
        });
        $("#selectAllTeacher-btn").click(function () {
            window.location = "teacherList.jsp";
        })
    })
</script>
</body>
</html>