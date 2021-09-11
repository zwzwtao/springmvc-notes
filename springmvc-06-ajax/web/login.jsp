<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        function a1() {
            $.post({
                url : "${pageContext.request.contextPath}/a3",
                data : {"name" : $("name").val()},
                success : function (data) {
                    console.log(data);

                }
            })
        }
        function a2() {
            $.post({
                url : "${pageContext.request.contextPath}/a3",
                data : {"name" : $("name").val()},
                success : function (data) {
                    console.log(data);

                }
            })
        }
    </script>
</head>
<body>

<p>
    用户名: <input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>
<p>
    密码: <input type="text" id="pwd" onblur="a2()">
    <span id="pwdInfo"></span>
</p>

</body>
</html>
