<%--
  Created by IntelliJ IDEA.
  User: 12037
  Date: 2020/6/8
  Time: 16:06
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

        #del-stuAccount {
            width: 150px;
        }

        #back_manager{
            margin-left: 545px;
        }
    </style>
    <title>学生管理界面</title>
</head>
<body>
<h2>学生信息</h2>
<form action="#" id="del">
    <input type="text" placeholder="请输入需要删除学生的学号"/>
    <button>删除</button>
</form>
<button id="back_manager">返回到管理员界面</button><br><br>
<table border="solid">
    <thead>
    <tr>

        <th>学 号</th>
        <th>姓 名</th>
    </tr>
    </thead>
    <tbody id="tb">
    </tbody>
</table>
</body>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "/wod/u/student/all",
            method: "GET",
            success: function (response) {
                //展示搜索到的学生信息
                let $studentList = response.objectMap.studentList;
                let $str = '';
                for (let i = 0; i < $studentList.length; i++) {
                    $str += '<tr><td>' + $studentList[i].studentAccount +
                        '</td><td>' + $studentList[i].studentName + '</td></tr>';
                }
                tb.innerHTML = $str;
            },
            error: function () {
                console.log("请求迷路了");
            }
        });
    });
    $("#del button").click(function () {
        let $account = $("#del input").val();
        window.location = "/wod/del_student.jsp?wd=" + $account;
        window.event.returnValue = false;
    });
    $("#back_manager").click(function () {
        window.location = "/wod/manager.jsp"
    });
</script>
</html>
