<%--
  Created by IntelliJ IDEA.
  User: 12037
  Date: 2020/6/24
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改老师登录密码</title>
</head>
<body>
<input type="text" id="new_password"><br>
<button id="up_btn">修改</button>
</body>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $("#up_btn").click(function () {
        let $new_pass = $("#new_password").val();
        let $account = window.location.search.split("=")[1];
        let params ={
            "teacherAccount" : $account,
            "password" : $new_pass
        };
        $.ajax({
            type: 'GET',
            async: 'false',
            url: "/wod/u/teacher/update",
            dataType: 'json',
            contentType: 'application/json',
            data: params,
            success : function () {
                alert("修改成功！");
                window.location = "/wod/teacherList.jsp";
            },
            error : function () {
                console.log("请求迷路了...");
            }
        });
    });
</script>
</html>
