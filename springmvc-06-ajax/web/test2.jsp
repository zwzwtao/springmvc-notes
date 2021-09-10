<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test2</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>

    <script>
        // 加这个$(function {})是为了让dom结构加载完后再执行代码
        // 否则是先加载js脚本，而由于此时还没有加载下面的btn，所以不会给btn注册点击事件
        // 另外一种方法是把script写在网页最后
        $(function () {
            $("#btn").click(function () {
                $.post(
                    /*
                        简写的方式
                        $.post(url, param[可以省略], success)
                        下面例子里我们就只写里一个url和回调函数
                     */
                    "${pageContext.request.contextPath}/a2",
                    function(data) {
                        // console.log(data);
                        let html = "";

                        for (let i = 0; i < data.length; i ++) {
                            html += "<tr>" +
                                "<td>" + data[i].name + "</td>" +
                                "<td>" + data[i].age + "</td>" +
                                "<td>" + data[i].sex + "</td>" +
                                "</tr>";
                        }

                        $("#content").html(html);
                    }
                )
            })
        })
    </script>
</head>
<body>
<input type="button" id="btn" value="加载数据">
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
        <%-- 数据: 后台获取 --%>

    </tbody>
</table>
</body>
</html>
