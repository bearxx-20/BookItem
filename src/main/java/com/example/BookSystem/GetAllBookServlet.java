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


@WebServlet("/GetAllBookServlet")
public class GetAllBookServlet extends HttpServlet {

    public GetAllBookServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        List<BookMessage> Booklist = new ArrayList<BookMessage>();
        BookMessage bookMessage;
        DButil db = new DButil();
        ResultSet rs = null;
        try {
            db.getConnect();
            rs= db.getResult("select * from bookmessage");
            while (rs.next()){
                bookMessage = new BookMessage();
                bookMessage.setBookID(rs.getInt("BookID"));
                bookMessage.setBookName(rs.getString("BookName"));
                bookMessage.setWriterName(rs.getString("writerName"));
                bookMessage.setPublisher(rs.getString("Publisher"));
                bookMessage.setPrice(rs.getDouble("Price"));
                bookMessage.setNumber(rs.getInt("Number"));
                Booklist.add(bookMessage);
            }
            request.setAttribute("Booklist",Booklist);
            request.getRequestDispatcher("ShowAllBooks.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(db!=null){
                db.close();
            }
        }
    }
}
