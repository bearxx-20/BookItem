package com.example.BookSystem;


import java.sql.*;
public class DButil{

    ResultSet rs = null;
    PreparedStatement ps  = null;
    Statement stat = null;
    Connection conn = null;
    public DButil(){}

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanager?useUnicode=true&characterEncoding=UTF-8","root","");
        return conn;
    }

    public ResultSet getResult(String sql,String cast){
        rs = null;
        if (conn==null){
            try {
                conn=this.getConnect();
                ps = conn.prepareStatement(sql);
                ps.setString(1,cast);
                rs= ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public ResultSet getResult(String sql,int number){
        rs = null;
        if (conn==null){
            try {
                conn=this.getConnect();
                ps = conn.prepareStatement(sql);
                ps.setInt(1,number);
                rs= ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public ResultSet getResult(String sql){
        rs = null;
        if (conn==null){
            try {
                conn=this.getConnect();
                stat = conn.createStatement();
                rs=stat.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public void close(){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}