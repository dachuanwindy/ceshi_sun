package com.servlet_study;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class A implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = filterConfig.getServletContext();

        System.out.println("过滤任务开始了~ ");

        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session =((HttpServletRequest) request).getSession();

        String loginpage =filterConfig.getInitParameter("loginpage");

        req.getRequestDispatcher(loginpage).forward(request,response);



    }

    @Override
    public void destroy() {

    }
}
