<%--
  Created by IntelliJ IDEA.
  User: 12037
  Date: 2020/6/23
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人成绩</title>
    <style>
        table {
            width: 600px;
            height: 150px;
            border: solid #FFD700;
            font-weight: normal;
            text-align: center;
            margin-left: 295px;
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
            margin-left: 575px;
        }
    </style>

</head>
<body>
<h2>成绩</h2>
<table border="solid">
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名称</th>
        <th>成  绩</th>
    </tr>
    </thead>
    <tbody id="tb">
    </tbody>
</table>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url : "/wod/student/scores/personal",
            method : "GET",
            success : function (response) {
                let personalScores = response.objectMap.scores;
                console.log(personalScores);
                let str = '';
                for (let i=0;i<personalScores.length;i++){
                    str += '<tr><td>' + personalScores[i].courseId +
                        '</td><td>' + personalScores[i].courseName +
                        '</td><td>' + personalScores[i].score + '</td></tr>';
                }
                tb.innerHTML = str;
            },
            error : function () {
                console.log("请求迷路了");
            }
        });
    });
</script>
</body>
</html>
