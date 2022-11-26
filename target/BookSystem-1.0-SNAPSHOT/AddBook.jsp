<%--
  Created by IntelliJ IDEA.
  User: 熊爸爸的电脑
  Date: 2022/5/27
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加图书</title>
    <link rel="stylesheet" type="text/css" href="css/AddBook.css"/>
</head>
<body>
<div id="userDisplay">
    <span>当前用户：<%=session.getAttribute("userName")%></span>
    &nbsp;&nbsp;&nbsp;<a href="index.jsp" class="userButton" style="margin-left: -6px;">退出登录</a>&nbsp;
    <a href="ModifyPassword.jsp" class="userButton">修改密码</a>&nbsp;
</div>
<div class="Addition">
    <div id="BookAddition">
        <legend id="AdditionWord">—图书添加—————</legend>
        <form action="AddBookServlet" method="post">
            <div id="notKnow" style="margin-bottom: 8px;">
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;书&nbsp;&nbsp;&nbsp;&nbsp;名:</label>&nbsp;<input id="BookName" name="BookName" type="text" /><br />
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;者:</label>&nbsp;<input id="writerName" name="writerName" type="text" /><br />
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;出版社:</label>&nbsp;<input id="publisher" name="publisher" type="text" /><br />
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;价&nbsp;&nbsp;&nbsp;&nbsp;格:</label>&nbsp;<input id="price" name="price" type="text" /><br />
                <label class="laberValue" style="margin-bottom: 6px;">&nbsp;数&nbsp;&nbsp;&nbsp;&nbsp;量:</label>&nbsp;<input id="number" name="number" type="text" /><br />
            </div>
            <input type="submit" id="AddBook" value="添加"/>
            <input type="reset" id="resetButton" value="重置" />
            <a href="show.jsp" id="RetureToHome">回主页</a>
        </form>
    </div>
</div>
</body>
</html>

