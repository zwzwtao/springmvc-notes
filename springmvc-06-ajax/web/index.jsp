<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>

    <script>
      function a() {
        $.post({
          url : "${pageContext.request.contextPath}/a1",
          // data 必须以键值对(key:value)的形式定义
          data : {"name" : $("#username").val()},
          success : function (data) {
            alert(data);
          },
          error : function () {

          }
        })
      }
    </script>
  </head>
  <body>
    <%-- 失去焦点(就是鼠标停点击后移出去点击一下，就是撤销选中)的时候，发起一个请求(携带信息)到后台 --%>
    用户名: <input type="text" id="username" onblur="a()">
  </body>
</html>
