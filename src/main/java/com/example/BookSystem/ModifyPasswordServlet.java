package com.example.BookSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/ModifyPasswordServlet")
public class ModifyPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        String userPwd = request.getParameter("resolvePassword");
        String userName = (String) session.getAttribute("userName");

        DButil db = new DButil(); //调用数据库工具类
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        try {
            conn = db.getConnect();
            String sql = "update user set password=? where userName=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userPwd);
            ps.setString(2,userName);
            int count = ps.executeUpdate();
            if(count>0){
                response.sendRedirect("show.jsp");
            }else {
                response.sendRedirect("ModifyPassword.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close();
        }
    }
}
