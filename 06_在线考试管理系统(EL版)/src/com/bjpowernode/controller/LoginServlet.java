package com.bjpowernode.controller;

import com.bjpowernode.Dao.JDBCDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JDBCDao dao = new JDBCDao();
        String userName,password;
        int result = 0;

        response.setContentType("text/html;charset=utf-8");

        userName = request.getParameter("userName");
        password = request.getParameter("password");

        result = dao.login(userName,password);

        if(result == 1){
            HttpSession session = request.getSession();
            response.sendRedirect("/myWeb/index.html");
        }else{
            response.sendRedirect("/myWeb/login_error.html");
        }


    }
}
