package com.example.BookSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/ModifyBookServlet")
public class ModifyBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取页面的name属性
        String BookName = request.getParameter("BookName");
        String writerName = request.getParameter("writerName");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        //设置数据库工具对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DButil db = new DButil();
        int result = 0;

        try {
            conn = db.getConnect();
            //String sql = "insert into bookmessage(BookName,WriterName,Publisher,Price,Number) values(?,?,?,?,?)";
            String sql = "update bookmessage set WriterName=?,Publisher=?,Price=?,Number=? where BookName=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,writerName);
            ps.setString(2,publisher);
            ps.setString(3,price);
            ps.setString(4,number);
            ps.setString(5,BookName);
            result = ps.executeUpdate();
            if(result>0){
                request.getRequestDispatcher("show.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("ModifyBookServlet.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(db!=null){
                db.close();
            }
        }
    }
}
