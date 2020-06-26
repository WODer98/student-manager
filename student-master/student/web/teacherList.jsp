<%--
  Created by IntelliJ IDEA.
  User: 12037
  Date: 2020/6/20
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table {
            width: 200px;
            height: 150px;
            border: solid #019BE5;
            font-weight: normal;
            text-align: center;
            margin-left: 500px;
        }

        th {
            font-Size: 20px;
            font-Weight: bold;
            width: auto;
            height: auto
        }

        td {
            font-Size: 16px;
            font-Weight: normal;
        }

        h2 {
            margin-left: 545px;
        }

        form {
            margin-left: 500px;
        }

       #back_manager{
           margin-left: 545px;
       }
    </style>
    <title>教师列表</title>

</head>
<body>
<h2>教师信息</h2>
<form action="#" id="update">
<input type="text" placeholder="请输入需要修改密码的教师帐号">
    <button>修改教师密码</button>
</form>
<button id="back_manager">返回到管理员界面</button><br><br>
<table border="solid">
    <thead>
    <tr>

        <th>教师账号</th>
        <th>密码</th>
    </tr>
    </thead>
    <tbody id="tb">
    </tbody>
</table>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "/wod/u/teacher/all",
            method: "GET",
            success: function (response) {
                //展示搜索到的学生信息
                let teacherList = response.objectMap.teacherList;
                console.log($.type(teacherList));
                console.log(teacherList);
                let str = '';
                for (let i = 0; i < teacherList.length; i++) {
                    str += '<tr><td>' + teacherList[i].teacherAccount +
                        '</td>' + '<td>' + teacherList[i].teacherPassword + '</td></tr>';
                }
                tb.innerHTML = str;
            },
            error: function () {
                console.log("请求迷路了");
            }
        });
    });
    $("#back_manager").click(function () {
        window.location = "/wod/manager.jsp"
    });
    $("#update button").click(function () {
        let $account = $("#update input").val();
        console.log($account);
        window.location = "/wod/update_teacher.jsp?wd=" + $account;
        window.event.returnValue = false;
    });
</script>
</body>
</html>
