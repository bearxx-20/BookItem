package com.example.BookSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/QueryBookServlet")
public class QueryBookServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String BookName = request.getParameter("retureBookName");
        List<BookMessage> BookList = new ArrayList<BookMessage>();
        BookMessage bookMessage;
        DButil db = new DButil();
        ResultSet rs = null;
        try {
            db.getConnect();
            rs= db.getResult("select * from bookmessage where BookName=?",BookName);
                while (rs.next()) {
                    bookMessage = new BookMessage();
                    bookMessage.setBookID(rs.getInt("BookID"));
                    bookMessage.setBookName(rs.getString("BookName"));
                    bookMessage.setWriterName(rs.getString("WriterName"));
                    bookMessage.setPublisher(rs.getString("Publisher"));
                    bookMessage.setPrice(rs.getDouble("Price"));
                    bookMessage.setNumber(rs.getInt("Number"));
                    BookList.add(bookMessage);
                }
            request.setAttribute("BookList",BookList);
            request.getRequestDispatcher("BookDisplay.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(db!=null){
                db.close();
            }
        }
    }
}
