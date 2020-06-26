<%--
  Created by IntelliJ IDEA.
  User: 12037
  Date: 2020/6/20
  Time: 14:33
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
    <title>教师界面</title>
</head>
<body>
<h2>欢迎老师登录</h2>
<div class="box">
    <input type="button" id="selectAllStudentScores-btn" name="selectAllStudent-btn" value="查询所有学生成绩"><br><br>
    <input type="button" id="insertStudent-btn" name="insertStudent-btn" value="添加学生成绩"><br><br>
    <input type="button" id="selectAvgScoresSubject-btn" name="selectAvgScoresSubject-btn" value="查询所有科目的平均成绩">
</div>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#selectAllStudentScores-btn").click(function () {
            window.location = "studentScoresList.jsp";
        });
        $("#insertStudent-btn").click(function () {
            window.location = "insertScores.jsp";
        });
        $("#selectAvgScoresSubject-btn").click(function () {
            window.location = "avgScoresSubjectList.jsp"
        })
    })
</script>
</body>
</html>
