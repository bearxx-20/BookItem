package com.example.FilterClass;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddBookFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) servletRequest;
        HttpSession session = request1.getSession();

        if(session.getAttribute("userName")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }else {
            request1.setAttribute("message","你没有权限访问本网站,请先登录!!!");
            request1.getRequestDispatcher("index.jsp").forward(request1,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
