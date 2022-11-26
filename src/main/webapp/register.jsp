<%--
  Created by IntelliJ IDEA.
  User: 熊爸爸的电脑
  Date: 2022/5/12
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>用户注册</title>
</head>
<link rel="stylesheet" type="text/css" href="css/register.css"/>
<script type="text/javascript">
  var xmlHttpReq = null;
  function createRequest(){
    if(window.XMLHttpRequest){
      xmlHttpReq = new XMLHttpRequest();
    }else if(window.ActiveXObject){
      xmlHttpReq = new ActiveXObject("Microsft.XMLHTTP");
    }
  }
  function getBackInfo(){
    createRequest();
    var username = document.getElementById('userName').value;
    if(username.trim().length==0){
      document.getElementById("userShow").innerHTML = "用户名为空";
      document.getElementById("userName").focus();
      return false;
    }
    if(xmlHttpReq!=null){
      var url = "handle.jsp?username="+username;
      xmlHttpReq.open("get",url,true);
      xmlHttpReq.onreadystatechange = disResult;
      xmlHttpReq.send(null);
    }else{
      alert(":no!!!!");
    }
  }
  function disResult(){
    if(xmlHttpReq.readyState==4){
      if(xmlHttpReq.status==200){
        alert(xmlHttpReq.responseText);
        document.getElementById("userShow").innerHTML=xmlHttpReq.responseText;
      }else{
        alert("error!");
      }
    }
  }
</script>
<body>
<center>
  <div class="registerDiv">
    <legend class="show">———用户注册———</legend>
    <form action="RegisterCheck" method="post">
      <div id="registerInput">
        <label class="laberValue" style="margin-bottom: 6px;">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label><input onblur="getBackInfo()"  type="text" id="userName" name="userName"/><br />
        <p id="userShow"></p>
        <label class="laberValue" style="margin-bottom: 6px;">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label><input type="password" id="userPwdOne" /><br />
        <label class="laberValue">确认密码:</label><input type="password" id="userPwdTwo" name="userPwd" onmouseleave="decide()"/><br />
        <p id="showMassage"></p><br />
        <input type="submit" id="registerSubmit" value="立即注册"/>
        <a href="index.jsp" id="RetureToHome">回主页</a>
      </div>
    </form>
  </div>
</center>
<script>
  var Pwd1 = document.getElementById("userPwdOne");
  var Pwd2 = document.getElementById("userPwdTwo");
  var account = document.getElementById("userName");
  function decide(){
    if(Pwd1.value!=Pwd2.value){
      document.getElementById("showMassage").innerHTML="密码不匹配";
      document.getElementById("registerSubmit").setAttribute('style','pointer-events:none');
    }
    if(Pwd1.value==Pwd2.value){
      document.getElementById("showMassage").innerHTML="";
      document.getElementById("registerSubmit").setAttribute('style','pointer-events:auto');
    }
    if(account.value==null||Pwd1.value==null||Pwd2.value==null){
      document.getElementById("registerSubmit").setAttribute('style','pointer-events:none');
    }
  }
</script>
</body>
</html>

