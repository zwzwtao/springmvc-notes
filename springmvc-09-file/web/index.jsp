<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>文件上传</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
  <input type="file" name="file">
  <input type="submit" value="提交上传">
</form>

<a href="">下载图片</a>

</body>
</html>
