<%--
  Created by IntelliJ IDEA.
  User: Le'novo
  Date: 2022/6/27
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>添加图书</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h3>表单提交</h3>
<form action="test/add" method="post">
    <p>图书名称：<label>
        <input type="text" name="bookName"/>
    </label></p>
    <p>图书作者：<label>
        <input type="text" name="bookAuthor"/>
    </label></p>
    <p>图书价格：<label>
        <input type="text" name="bookPrice"/>
    </label></p>
    <p>出版时间：<label>
        <input type="text" name="publishTime"/>
    </label></p>
    <p><input type="submit" value="提交"/></p>
</form>

<h3>超链接提交</h3>
<a href="book/add1?bookName=java">URL提交</a>

<h3>AJAX提交</h3>
<input type="button" value="ajax提交" id="btn1"/>
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    $("#btn1").click(function () {
        var obj = {};
        obj.bookName = "java";
        obj.bookAuthor = "夏明";
        obj.bookPrice = "3.33";

        var s = JSON.stringify(obj);
        console.log(s);
        $.ajax({
            url: "book/update",
            type: "post",
            //headers:{token:"wahaha"},
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(obj),
            success: function (res) {
                console.log(res);
            }
        });
    });
</script>

</body>
</html>
