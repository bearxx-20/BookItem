<%--
  Created by IntelliJ IDEA.
  User: 熊爸爸的电脑
  Date: 2022/5/29
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/ModifyBook.css"/>
</head>
<body>
<div id="userDisplay">
    <span>当前用户：<%=session.getAttribute("userName")%></span>
    &nbsp;&nbsp;&nbsp;<a href="index.jsp" class="userButton" style="margin-left: -6px;">退出登录</a>&nbsp;
    <a href="ModifyPassword.jsp" class="userButton">修改密码</a>&nbsp;
</div>
<div class="Addition">
    <div id="BookAddition">
        <legend id="AdditionWord">—图书修改—————</legend>
        <form action="ModifyBookServlet" method="post">
            <div id="notKnow" style="margin-bottom: 8px;">
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;书&nbsp;&nbsp;&nbsp;&nbsp;名:</label>&nbsp;<input id="BookName" name="BookName" type="text" value="${bookmessage.bookName}"/><br />
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;者:</label>&nbsp;<input id="writerName" name="writerName" type="text" value="${bookmessage.writerName}" /><br />
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;出版社:</label>&nbsp;<input id="publisher" name="publisher" type="text" value="${bookmessage.publisher}"/><br />
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;价&nbsp;&nbsp;&nbsp;&nbsp;格:</label>&nbsp;<input id="price" name="price" type="text"  value="${bookmessage.price}"/><br />
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;数&nbsp;&nbsp;&nbsp;&nbsp;量:</label>&nbsp;<input id="number" name="number" type="text"  value="${bookmessage.number}"/><br />
            </div>
            <input type="submit" id="AddBook" value="修改"/>
            <input type="reset" id="resetButton" value="重置" />
            <a href="show.jsp" id="RetureToHome">回主页</a>
        </form>
    </div>
</div>
<script>
    window.onload = function () {
        var bookName = document.getElementById("BookName");
        var writerName = document.getElementById("writerName");
        var publisher = document.getElementById("publisher");
        var price = document.getElementById("price");
        var number = document.getElementById("number");

        function decide2() {
            if (bookName.value == null || bookName.value == "" || writerName.value == null || writerName.value == "" || publisher.value == null || publisher.value == "" || number.value == null || number.value == "" || price.value == null || price.value == "") {
                document.getElementById("AddBook").setAttribute('style', 'pointer-events:none');
                alert("有输入框内容为空!!!");
            }else{
                document.getElementById("AddBook").setAttribute('style', 'pointer-events:auto');
            }
        }
    }
</script>
</body>
</html>

