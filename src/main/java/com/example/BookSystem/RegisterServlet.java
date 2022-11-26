package com.example.BookSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


/*
用于处理注册功能。
 */
@WebServlet("/RegisterCheck")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        DButil db = new DButil(); //调用数据库工具类
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
            try {
                conn = db.getConnect();
                String sql = "insert into user set userName = ?,password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,userName);
                ps.setString(2,userPwd);
                int count = ps.executeUpdate();
                if(count<1){
                    response.sendRedirect("register.jsp");
                }else {
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                db.close();
        }
    }
}
