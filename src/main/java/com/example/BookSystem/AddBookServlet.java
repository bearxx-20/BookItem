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

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        System.out.println("init:测试运行!!!");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet:测试运行!!!");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost:测试运行!!!");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DButil db = new DButil();

        //获取页面的属性
        String BookName = request.getParameter("BookName");
        //System.out.println(BookName);
        String writerName = request.getParameter("writerName");
        //System.out.println(writerName);
        String publisher = request.getParameter("publisher");
        //System.out.println(publisher);
        String price = request.getParameter("price");
        //System.out.println(price);
        String number = request.getParameter("number");
        //System.out.println(number);
        HttpSession session = request.getSession();

        if(BookName==null||BookName==""||writerName==null||writerName==""||publisher==null||publisher==""||price==null||price==""||number==null||number==""){
            request.setAttribute("message","填入的内容不能为空!!!");
            request.getRequestDispatcher("AddBook.jsp").forward(request,response);
        }else{
            int result = 0;
            try {
                conn = db.getConnect();
                String sql = "insert into bookmessage(BookName,WriterName,Publisher,Price,Number) values(?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setString(1,BookName);
                ps.setString(2,writerName);
                ps.setString(3,publisher);
                ps.setString(4,price);
                ps.setString(5,number);
                result = ps.executeUpdate();
                System.out.println(result);
                if (result > 0) {
                    System.out.println("success:数据添加成功!!!");
                    request.getRequestDispatcher("show.jsp").forward(request,response);
                }else{
                    System.out.println("error:数据添加失败!!!");
                    request.getRequestDispatcher("AddBook.jsp").forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (db!=null){
                    db.close();
                }
            }
        }
    }
}
