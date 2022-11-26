<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查询图书</title>
    <link rel="stylesheet" type="text/css" href="css/show.css"/>
</head>
<body>
<div id="userDisplay">
    <span>当前用户：<%=session.getAttribute("userName")%></span>
    &nbsp;&nbsp;&nbsp;<a href="index.jsp" class="userButton" style="margin-left: -6px;">退出登录</a>&nbsp;
    <a href="ModifyPassword.jsp" class="userButton">修改密码</a>&nbsp;
</div>
<div class="query">
    <div id="BookQuery">
        <legend id="QueryWord">—图书查询—————</legend>
        <form action="QueryBookServlet" method="post">
            <div id="notKnow" style="margin-bottom: 8px;">
                <label class="QueryBookName">查询的书名:</label>&nbsp;<input id="retureBookName" name="retureBookName" type="text" /><br />
            </div>
            <input type="submit" id="QueryButton" value="查询"/>
            <input type="button" onclick="AddBook_Page()" id="AdditionButton" value="添加" />
            <a href="GetAllBookServlet" id="ShowAllBook">所有图书</a>
        </form>
    </div>
</div>
<script>
    function AddBook_Page(){
        window.location.href="AddBook.jsp";
    }
</script>
</body>
</html>

