<%--
  Created by IntelliJ IDEA.
  User: 熊爸爸的电脑
  Date: 2022/5/27
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="css/MDpassword.css"/>
</head>
<body>
<center>
    <div id="Modify">
        <form action="ModifyPasswordServlet" method="post">
            <legend id="ModifyPassword">————修改密码————</legend>
            <div id="textOne" style="margin-bottom: 4px;">
                <label class="laberValue">当前用户:</label><input type="text" name="userName" id="userName" value="<%=session.getAttribute("userName")%>" style="margin-left: 4px;" disabled="disabled"/>
            </div>
            <div id="textTwo" style="margin-bottom: 4px;">
                <label class="laberValue">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label><input type="password" id="Modifypw" style="margin-left: 4px;"/>
            </div>
            <div id="textThree">
                <label class="laberValue">确认密码:</label><input type="password" id="resolvePassword" name="resolvePassword" onmouseleave="decide()" style="margin-left: 4px;"/>
            </div>
            <p id="showMassage"></p><br />
            <div id="Button" style="margin-top: 6px;margin-right: 32px;">
                <input type="submit" id="submitButton" value="提交"/>
                <input type="reset" id="resetButton" value="重置" />
                <a href="show.jsp" id="RetureToHome">回主页</a>
            </div>

        </form>
    </div>
</center>
<script>
    var Pwd1 = document.getElementById("Modifypw");
    var Pwd2 = document.getElementById("resolvePassword");
    var account = document.getElementById("userName");
    function decide(){
        if(Pwd1.value!=Pwd2.value){
            document.getElementById("showMassage").innerHTML="密码不匹配";
            document.getElementById("submitButton").setAttribute('style','pointer-events:none');
        }
        if(Pwd1.value==Pwd2.value){
            document.getElementById("showMassage").innerHTML="";
            document.getElementById("submitButton").setAttribute('style','pointer-events:auto');
        }
        if(account.value==null||Pwd1.value==null||Pwd2.value==null){
            document.getElementById("submitButton").setAttribute('style','pointer-events:none');
        }
    }
</script>
</body>
</html>

