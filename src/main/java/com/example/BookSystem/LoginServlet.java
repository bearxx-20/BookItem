package com.example.BookSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginCheck")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName_1 = request.getParameter("userName");  //获取网页传回的账号
        String userPwd_1 = request.getParameter("userPwd"); //获取网页传回的密码
        HttpSession session = request.getSession(); //设置session
        DButil db = new DButil(); //调用数据库工具类
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            PrintWriter out = response.getWriter();
            conn = db.getConnect();
            String sql = "select userName,password from User where userName = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName_1);
            ps.setString(2,userPwd_1);
            rs = ps.executeQuery();
            String userName_2 = null;
            String userPwd_2  = null;
            if(rs.next()){
                userName_2 = rs.getString("userName");
                userPwd_2 = rs.getString("password");
            }
            if(userName_1==null&&userPwd_1==null){
                System.out.println("<h1>密码错误</h1>");
                response.sendRedirect("index.jsp");
            }else if (userName_1.equals(userName_2)&&userPwd_1.equals(userPwd_2)){
                session.setAttribute("userName",userName_2);
                session.setAttribute("userPwd",userPwd_2);
                response.sendRedirect("show.jsp");
            }else {
                response.sendRedirect("index.jsp");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            db.close();
        }
    }
}
