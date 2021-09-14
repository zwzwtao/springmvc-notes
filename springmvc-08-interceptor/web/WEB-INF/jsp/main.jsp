<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>

<h1>首页</h1>

<span>当前登陆用户: ${username}</span>

<p>
    <a href="${pageContext.request.contextPath}/user/goOut">注销</a>

</p>

</body>
</html>
