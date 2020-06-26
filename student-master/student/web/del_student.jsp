<%--
  Created by IntelliJ IDEA.
  User: 12037
  Date: 2020/6/20
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生</title>
</head>
<body>
<script src="js/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    $(function () {
        let $account = window.location.search.split("=")[1];
        $.ajax({
            url : "/wod/u/student/delete/" + $account,
            method : "GET",
            success : function () {
                alert("删除成功！");
                window.location = "/wod/studentList.jsp";
            },
            error : function () {
                console.log("请求迷路了...");
            }
        })
    })

</script>
</body>
</html>
