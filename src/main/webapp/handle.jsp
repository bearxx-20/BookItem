<%--
  Created by IntelliJ IDEA.
  User: 熊爸爸的电脑
  Date: 2022/6/14
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.*,java.sql.*,com.example.BookSystem.DButil" contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"
            + request.getServerName()+":"+request.getServerPort()
            + path + "/";
%>
<%
    String username = request.getParameter("username");
    String sql = "select * from user where userName=?";
    DButil db = new DButil();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    PrintWriter s = response.getWriter();
    try {
        conn = db.getConnect();
        ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        rs = ps.executeQuery();
        if(rs.next()){
            s.println("账号被注册!");
        }else{
            s.println("可以注册");
        }
    }catch (SQLException e){
        e.printStackTrace();
    }finally {
        if(db!=null){
            db.close();
        }
    }
%>

