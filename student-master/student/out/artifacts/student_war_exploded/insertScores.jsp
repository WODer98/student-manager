<%--
  Created by IntelliJ IDEA.
  User: 12037
  Date: 2020/6/20
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生成绩</title>
</head>
<body>
<div class="box">
    <form action="#" id="add">
        成&nbsp;&nbsp;&nbsp;绩：<input type="text" id="score"><br>
        学&nbsp;&nbsp;&nbsp;号：<input type="text" id="studentAccount"><br>
        课程号：<input type="text" id="courseId"><br>
        <div class="info" id="errorMsg">同一学生的同一课程只能插入一项数据</div>
        <input type="button" value="添加" id="sub">
    </form>
</div>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#sub").click(function () {
            $.ajax({
                url: "/wod/u/teacher/scores/add",
                method: "POST",
                data: {
                    "score": $("#score").val(),
                    "studentAccount": $("#studentAccount").val(),
                    "courseId": $("#courseId").val()
                },
                success: function (response) {
                    if (response.errorCode === "100") {
                        alert("插入成功！");
                        window.location = "/wod/studentScoresList.jsp";
                    } else {
                        $("#errorMsg").text(response.objectMap.msg).css({"color": "red"});
                       setTimeout(" window.location = \"/wod/insertScores.jsp\"",3000);
                    }
                },
                error: function () {
                    console.log("请求迷路...")
                }
            });
        });
    });
</script>
</body>
</html>
