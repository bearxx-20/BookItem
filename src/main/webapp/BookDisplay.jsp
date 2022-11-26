<%--
  Created by IntelliJ IDEA.
  User: 熊爸爸的电脑
  Date: 2022/5/29
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/ShowAllBooks.css"/>
</head>
<body>
<div id="userDisplay">
    <span>当前用户：<%=session.getAttribute("userName")%></span>
    &nbsp;&nbsp;&nbsp;<a href="index.jsp" class="userButton" style="margin-left: -6px;">退出登录</a>&nbsp;
    <a href="ModifyPassword.jsp" class="userButton">修改密码</a>&nbsp;
</div>
<div id="Display">
    <div id="BookDisplay">
        <legend id="BookDisplayWord">—图书展示—————</legend>
    </div>
    <div id="DisplayTable">
        <form action="#" method="post">
            <table border="1" cellspacing="0" cellpadding="1">
                <colgroup>
                    <col width="60" />
                    <col width="150" />
                    <col width="95" />
                    <col width="150" />
                    <col width="80" />
                    <col width="60" />
                    <col width="90" />
                </colgroup>
                <thead>
                <tr>
                    <th style="text-align: center;">序号</th>
                    <th style="text-align: center;">书名</th>
                    <th style="text-align: center;">作者</th>
                    <th style="text-align: center;">出版社</th>
                    <th style="text-align: center;">价格</th>
                    <th style="text-align: center">数量</th>
                    <th style="text-align: center;">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${BookList}" var="Book">
                    <tr>
                        <td style="padding-left: 24px;">${Book.bookID}</td>
                        <td style="padding-left: 17px;">${Book.bookName}</td>
                        <td style="padding-left: 15px;">${Book.writerName}</td>
                        <td style="padding-left: 15px;">${Book.publisher}</td>
                        <td style="padding-left: 22px;">${Book.price}</td>
                        <td style="padding-left: 24px;">${Book.number}</td>
                        <td style="padding-left: 18px;">
                            <div id ="imgTag">
                                <a id="change" name="" href="${pageContext.request.contextPath}/SetModifyBookServlet?bookID=${Book.bookID}" target="_blank">
                                    <img src="img/change.png" width="20px" height="20px"/>
                                </a>
                                <a id="deleteTag" href="${pageContext.request.contextPath}/DeleteBookServlet?bookID=${Book.bookID}" target="_blank">
                                    <img src="img/delete.jpg" width="20px" height="20px"/>
                                </a>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

            <!--<div id="operationButton">
                <input type="button" class="Operation" value="全选" id="AllSelection">
                <input type="button" class="Operation" value="反选" id="ReverseSelection">
                <input type="submit" class="Operation" value="删除选择" id="DeleteSelection"/>
            </div>-->
        </form>
    <div id="AddOrBack">
        <a href="AddBook.jsp" id="Add">添加</a>
        <a href="show.jsp" id="back">回主页</a>
    </div>
</div>
<!--<script>
    window.onload = function(){
        var allSelect = document.getElementById("AllSelection");
        var reverseSelect = document.getElementById("ReverseSelection");
        var CheckButton = document.getElementById("checkButton");
        allSelect.onclick = function(){
            if(CheckButton.checked!=true){
                CheckButton.checked=true;
            }
        }
        reverseSelect.onclick = function(){
            if(CheckButton.checked==true){
                CheckButton.checked=false;
            }else{
                CheckButton.checked=true;
            }
        }
    }
</script>-->
</body>
</html>

