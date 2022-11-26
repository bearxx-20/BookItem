<%--
  Created by IntelliJ IDEA.
  User: 熊爸爸的电脑
  Date: 2022/6/1
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>测试JSTL是否配置成功!</h2>
<hr>
<% int i =3;%>
<c:out value="连接成功" /><br>
<c:choose>
    <c:when test="${i==3}">
        <b>i==3</b>
        <c:otherwise>
            <b>i!=3</b>
        </c:otherwise>
    </c:when>
</c:choose>
</body>
</html>
