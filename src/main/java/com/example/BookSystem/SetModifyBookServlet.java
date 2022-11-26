package com.example.BookSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/SetModifyBookServlet")
public class SetModifyBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int bookID = Integer.parseInt(request.getParameter("bookID"));

        BookMessage bookMessage;
        DButil db = new DButil();
        ResultSet rs = null;


        try {
            db.getConnect();
            String sql = "select BookName,WriterName,Publisher,Price,Number from bookmessage where BookID=?";
            rs= db.getResult(sql,bookID);
            if(rs.next()){
                bookMessage = new BookMessage();
                bookMessage.setBookName(rs.getString("BookName"));
                bookMessage.setWriterName(rs.getString("WriterName"));
                bookMessage.setPublisher(rs.getString("Publisher"));
                bookMessage.setPrice(rs.getDouble("Price"));
                bookMessage.setNumber(rs.getInt("Number"));
                request.setAttribute("bookmessage",bookMessage);
                request.getRequestDispatcher("ModifyBook.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(db!=null) {
                db.close();
            }
        }
    }
}
