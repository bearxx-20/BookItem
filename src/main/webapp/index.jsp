<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<center>
    <div id="login">
        <div id="from">
            <form action="LoginCheck" method="post">
                <legend class="show" style="">———用户登录———</legend>
                <div id="loginBorder">
                    <span id="textID"><label class="laberValue" style="margin-bottom: 5px;">账&nbsp;&nbsp;号: </label><input type="text" name="userName" id="userName"/></span><br />
                    <span id="Password"><label class="laberValue" >密&nbsp;&nbsp;码: </label><input type="password" name="userPwd" id="userPwd" /></span><br />
                    &nbsp;&nbsp;<input type="submit" id="loginButton" value="登录" style="margin-right: 18px;"/>
                    <input type="reset" id="resetButton" value="重置" /><br /><br />
                    <legend>没有账号?<a href="register.jsp" style="text-decoration:none;">注册一个吧！</a></legend>
                </div>
            </form>
        </div>
    </div>
</center>
</body>
</html>
