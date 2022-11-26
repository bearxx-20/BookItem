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

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int bookID = Integer.parseInt(request.getParameter("bookID"));

        DButil db = new DButil();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = db.getConnect();
            String sql = "delete from bookmessage where BookId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,bookID);
            int count = ps.executeUpdate();
            if(count>0){
                //request.getRequestDispatcher("GetAllBookServlet").forward(request,response);
                response.sendRedirect("GetAllBookServlet");
            }else{
                //request.getRequestDispatcher("GetAllBookServlet").forward(request,response);
                response.sendRedirect("GetAllBookServlet");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
