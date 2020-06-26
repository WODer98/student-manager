<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link href="css/login_css.css" type="text/css" rel="stylesheet">
    <style type="text/css">
        .login-box {
            position: relative;
            height: 700px;
            width: 100%;
            background: url("image/login1.png") no-repeat left top;
            background-size: 100%, 100%;
            z-index: 10;
        }
    </style>
</head>
<body>

<div class="wrap">
    <div class="login-box">
        <h1>欢迎使用学生成绩管理系统</h1>
        <div id="login-form" class="login-form">
            登录账号：<label for="login-account"></label><input type="text" id="login-account" name="login-account"><br>
            <span id="error-mess"></span><br>
            密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<label for="password"></label><input type="password"
                                                                                              id="password"
                                                                                              name="password"><br><br>
            身&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份：
            管理员<label for="manager-radio"></label><input type="radio" id="manager-radio" name="identity">&nbsp;
            教师<label for="teacher-radio"></label><input type="radio" id="teacher-radio" name="identity">
            &nbsp;学生<label for="student-radio"></label><input type="radio" id="student-radio" name="identity"><br><br>
            <input type="submit" id="login-btn" class="login-btn" value="登  录">
        </div>
    </div>
</div>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script>
    const radios = document.getElementsByName('identity');
    $(function () {
        //点击登录按钮时，发送Ajax请求
        $("#login-btn").click(function () {
            //根据单选按钮发送不同的Ajax请求
            if (radios[0].checked) {
                //管理员界面，发送Ajax请求
                $.ajax({
                    url: "/wod/manager/login/auth",
                    method: "post",
                    data: {
                        "username": $("#login-account").val(),
                        "password": $("#password").val()
                    },
                    success: function (response) {
                        console.log("请求发送成功！");
                        console.log(response);
                        if (response.errorCode === "100") {
                            alert("登录成功！");
                            window.location = "/wod/manager.jsp";
                        } else {
                            //登录失败
                            $("#error-mess").text("账号或密码有误，请重新登录！").css({"color": "red"});
                        }
                    },
                    error: function () {
                        console.log("请求发送失败！");
                    }
                });
            } else if (radios[1].checked) {
                //教师界面
                $.ajax({
                    url: "/wod/teacher/login/auth",
                    method: "post",
                    data: {
                        "username": $("#login-account").val(),
                        "password": $("#password").val()
                    },
                    success: function (response) {
                        console.log("请求发送成功！");
                        console.log(response);
                        if (response.errorCode === "100") {
                            alert("登录成功！");
                            window.location = "/wod/teacher.jsp";
                        } else {
                            //登录失败
                            $("#error-mess").text("账号或密码有误，请重新登录！").css({"color": "red"});
                        }
                    },
                    error: function () {
                        console.log("请求发送失败！");
                    }
                });
            } else if (radios[2].checked) {
                //学生界面
                $.ajax({
                    url: "/wod/student/login/auth",
                    method: "post",
                    data: {
                        "username": $("#login-account").val(),
                        "password": $("#password").val()
                    },
                    success: function (response) {
                        console.log("请求发送成功！");
                        console.log(response);
                        if (response.errorCode === "100") {
                            alert("登录成功！");
                            window.location = "/wod/student.jsp";
                        } else {
                            //登录失败
                            $("#error-mess").text("账号或密码有误，请重新登录！").css({"color": "red"});
                        }
                    },
                    error: function () {
                        console.log("请求发送失败！");
                    }
                });
            }
        });
    });
</script>
</body>
</html>